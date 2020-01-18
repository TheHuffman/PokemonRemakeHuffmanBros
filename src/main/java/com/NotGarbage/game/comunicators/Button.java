package com.NotGarbage.game.comunicators;

import com.NotGarbage.engine.Renderer;
import com.NotGarbage.engine.gfx.Image;

public class Button {
	private Image texture;
	private Image selectedTexture;
	private int id;
	
	public Button(Image main, Image selected, int id) {
		texture = main;
		selectedTexture = selected;
		this.id = id;
	}
	
	public void paint(Renderer r, int current, int offX, int offY, int offset) {
		if(id == current) {
			r.drawImage(selectedTexture, offX, offY);
		}
		else if(id > current) {
			r.drawImage(texture, offX, offY - offset);
		}
		else {
			r.drawImage(texture, offX, offY + offset);
		}
	}
}
