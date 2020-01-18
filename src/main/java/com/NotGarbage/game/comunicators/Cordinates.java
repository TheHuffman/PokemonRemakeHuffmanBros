package com.NotGarbage.game.comunicators;

public class Cordinates {
	private int x, y, z, w, h, l, facing;
	
	public Cordinates() {
		x = 0;
		y = 0;
		z = 0;
		w = 1;
		h = 1;
		l = 1;
		facing = 1;
	}

	public Cordinates(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		w = 1;
		h = 1;
		l = 1;
		facing = 1;
	}

	public Cordinates(int x, int y, int z, int facing) {
		this.x = x;
		this.y = y;
		this.z = z;
		w = 1;
		h = 1;
		l = 1;
		this.facing = facing;
	}
	
	public Cordinates(int x, int y, int z, int w, int l, int h) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.h = h;
		this.l = l;
		facing = 1;
	}

	public Cordinates(int x, int y, int z, int w, int l, int h, int facing) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.h = h;
		this.l = l;
		this.facing = facing;
	}
	
	public void updateCordinates(int xAdd, int yAdd, int zAdd) {
		x += xAdd;
		y += yAdd;
		z += zAdd;
	}
	
	public void updateSize(int wAdd, int lAdd, int hAdd) {
		w += wAdd;
		h += hAdd;
		l += lAdd;
	}
	
	public void setCordinates(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void changeFacing(int dir) {
		facing = dir;
		if(facing > 4) facing = facing - 4;
		if(facing < 1) facing = facing + 4;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getFacing() {
		return facing;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public int getL() {
		return l;
	}
}
