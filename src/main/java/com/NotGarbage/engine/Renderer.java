package com.NotGarbage.engine;

import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.NotGarbage.engine.gfx.Font;
import com.NotGarbage.engine.gfx.Image;
import com.NotGarbage.engine.gfx.ImageRequest;
import com.NotGarbage.engine.gfx.ImageTile;

public class Renderer {
	private int pW;
	private int pH;
	private int[] p;
	//Z axis
	private int[] zb;
	private int zDepth = 0;
	
	private Font font = Font.STANDARD;
	private ArrayList<ImageRequest> imageRequest = new ArrayList<ImageRequest>();
	
	private boolean processing = false;
	
	public Renderer(GameContainer gc) {
		pW = gc.getWidth();
		pH = gc.getHeight();
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
		zb = new int[p.length];
	}
	
	public void clear() {
		for(int i = 0; i < p.length; i++) {
			p[i] = 0;
			zb[i] = 0;
		}
	}
	
	public void process() {
		processing = true;
		
		Collections.sort(imageRequest, new Comparator<ImageRequest>() {
			public int compare(ImageRequest i0, ImageRequest i1) {
				if(i0.zDepth < i1.zDepth) {
					return -1;
				}
				if(i0.zDepth > i1.zDepth) {
					return 1;
				}
				return 0;
			}
		});
		
		for(int i = 0; i < imageRequest.size(); i++) {
			ImageRequest ir = imageRequest.get(i);
			setzDepth(ir.zDepth);
			drawImage(ir.image, ir.offX, ir.offY);
		}
		
		for(int i = 0; i < p.length; i++) {
			int R = ((p[i] >> 16) & 0xff);
			int G = ((p[i] >> 8) & 0xff);
			int B = (p[i] & 0xff);
			
			p[i] = (R << 16 | G << 8 | B);
		}
		
		imageRequest.clear();
		processing = false;
	}
	
	public void setPixal(int x, int y, int value) {
		int alpha = ((value >> 24) & 0xff);
		if((x < 0 || x >= pW || y < 0 || y >= pH) || alpha == 0) {
			return;
		}
		
		int index = x + y * pW;
		
		if(zb[index] > zDepth) {
			return;
		}
		zb[index] = zDepth;
		
		if(alpha == 255) {
			p[index] = value;
		}
		else {
			int pixalColor = p[index];
			
			int oldRed = ((pixalColor >> 16) & 0xff);
			int oldGreen = ((pixalColor >> 8) & 0xff);
			int oldBlue = (pixalColor & 0xff);
			float a = (alpha / 255f);

			int newRed = oldRed - (int)((oldRed - ((value >> 16) & 0xff)) * a);
			int newGreen = oldGreen - (int)((oldGreen - ((value >> 8) & 0xff)) * a);
			int newBlue = oldBlue - (int)((oldBlue - (value & 0xff)) * a);
			
			p[index] = (newRed << 16 | newGreen << 8 | newBlue);
		}
	}
	
	public void drawText(String text, int offX, int offY, int color) {
		text = text.toUpperCase();
		int offset = 0;
		
		for(int i = 0; i< text.length(); i++) {
			int unicode = text.codePointAt(i) - 32;
			
			for(int y = 0; y < font.getFontImage().getHeight(); y++) {
				for(int x = 0; x < font.getWidths()[unicode]; x++) {
					if(font.getFontImage().getP()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getWidth()] == 0xffffffff) {
						setPixal(x + offX + offset, y + offY, color);
					}
				}
			}
			
			offset += font.getWidths()[unicode];
		}
	}
	
	public void drawImage(Image image, int offX, int offY) {
		if(image.isAlpha() && !processing) {
			imageRequest.add(new ImageRequest(image, zDepth, offX, offY));
			return;
		}
		
		//Don't Render Code
		if(offX < -image.getWidth()) return;
		if(offY < -image.getHeight()) return;
		if(offX >= pW) return;
		if(offY >= pH) return;
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getWidth();
		int newHeight = image.getHeight();
		
		//Clipping Code
		if(offX < 0) newX -= offX;
		if(offY < 0) newY -= offY;
		if(newWidth + offX >= pW) newWidth -= (newWidth + offX - pW);
		if(newHeight + offY >= pH) newHeight -= (newHeight + offY - pH);
		
		//Render Code
		for(int y = newY; y < newHeight; y++) {
			
			for(int x = newX; x < newWidth; x++) {
				
				setPixal(x + offX, y + offY, image.getP()[x + y * image.getWidth()]);
				
			}
		}
	}
	
	public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) {
		if(image.isAlpha() && !processing) {
			imageRequest.add(new ImageRequest(image.getTileImage(tileX, tileY), zDepth, offX, offY));
			return;
		}
		
		//Don't Render Code
		if(offX < -image.getTileW()) return;
		if(offY < -image.getTileH()) return;
		if(offX >= pW) return;
		if(offY >= pH) return;
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getTileW();
		int newHeight = image.getTileH();
		
		//Clipping Code
		if(offX < 0) newX -= offX;
		if(offY < 0) newY -= offY;
		if(newWidth + offX >= pW) newWidth -= (newWidth + offX - pW);
		if(newHeight + offY >= pH) newHeight -= (newHeight + offY - pH);
		
		//Render Code
		for(int y = newY; y < newHeight; y++) {
			
			for(int x = newX; x < newWidth; x++) {
				
				setPixal(x + offX, y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + tileY * image.getTileH()) * image.getWidth()]);
				
			}
		}
	}
	
	public void drawRect(int offX, int offY, int width, int height, int color) {
		for(int y = 0; y <= height; y++) {
			setPixal(offX, y + offY, color);
			setPixal(offX + width, y + offY, color);
		}
		
		for(int x = 0; x <= width; x++) {
			setPixal(x + offX, offY, color);
			setPixal(x + offX + width, offY + height, color);
		}
	}
	
	public void drawFillRect(int offX, int offY, int width, int height, int color) {
		//Don't Render Code
		if(offX < -width) return;
		if(offY < -height) return;
		if(offX >= pW) return;
		if(offY >= pH) return;
				
		int newX = 0;
		int newY = 0;
		int newWidth = width;
		int newHeight = height;
				
		//Clipping Code
		if(offX < 0) newX -= offX;
		if(offY < 0) newY -= offY;
		if(newWidth + offX >= pW) newWidth -= (newWidth + offX - pW);
		if(newHeight + offY >= pH) newHeight -= (newHeight + offY - pH);
		
		for(int y = newY; y < newHeight; y++) {
			for(int x = newX; x < newWidth; x++) {
				setPixal(x + offX, y + offY, color);
			}
		}
	}

	public int getzDepth() {
		return zDepth;
	}

	public void setzDepth(int zDepth) {
		this.zDepth = zDepth;
	}
}
