package com.NotGarbage.engine.gfx;

public class ImageTile extends Image{
	private int tileW;
	private int tileH;
	
	public ImageTile(String path, int tileW, int tileH) {
		super(path);
		this.setTileW(tileW);
		this.setTileH(tileH);
	}
	
	public ImageTile(Image image, int tileW, int tileH) {
		super(image.getP(), image.getWidth(), image.getHeight());
		this.setTileW(tileW);
		this.setTileH(tileH);
	}
	
	public Image getTileImage(int tileX, int tileY) {
		int[] p = new int[tileW * tileH];
		
		for(int y = 0; y < tileH; y++) {
			for(int x = 0; x < tileW; x++) {
				p[x + y * tileW] = this.getP()[(x + tileX * tileW) + (y + tileY * tileH) * this.getWidth()];
			}
		}
		
		return new Image(p, tileW, tileH);
	}

	public int getTileW() {
		return tileW;
	}

	public void setTileW(int tileW) {
		this.tileW = tileW;
	}

	public int getTileH() {
		return tileH;
	}

	public void setTileH(int tileH) {
		this.tileH = tileH;
	}
}
