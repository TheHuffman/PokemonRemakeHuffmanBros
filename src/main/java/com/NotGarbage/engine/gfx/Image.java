package com.NotGarbage.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	private int width;
	private int height;
	private int[] p;
	private boolean alpha = false;

	public Image(String path) {
		BufferedImage image = null;

		try {
			image = ImageIO.read(Image.class.getResourceAsStream(path));
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		width = image.getWidth();
		height = image.getHeight();
		p = image.getRGB(0, 0, width, height, null, 0, width);

		image.flush();
	}

	public Image(int[] p, int width, int height) {
		this.p = p;
		this.width = width;
		this.height = height;
	}

	//Getters and Setters
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public boolean isAlpha() {
		return alpha;
	}

	public void setAlpha(boolean alpha) {
		this.alpha = alpha;
	}
}
