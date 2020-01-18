package com.NotGarbage.game.gameStates;

import java.awt.event.KeyEvent;

import com.NotGarbage.engine.GameContainer;
import com.NotGarbage.engine.Renderer;
import com.NotGarbage.engine.gfx.Image;
import com.NotGarbage.game.comunicators.Button;

public abstract class Menu extends GameState {
	private Image background;
	
	private Button[] buttons;
	private int selected;
	private int selectedX;
	private int selectedY;
	private int buttonOffset;

	public Menu(GameStateManager gsm, Button[] buttons, int x, int y, int offset, Image background) {
		super(gsm);
		selected = 0;
		selectedX = x;
		selectedY = y;
		buttonOffset = offset;
		this.buttons = buttons;
		this.background = background;
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if(gc.getInput().isKeyDown(KeyEvent.VK_S)) {
			selected++;
			if(selected >= buttons.length) {
				selected = 0;
			}
		}
		else if(gc.getInput().isKeyDown(KeyEvent.VK_W)) {
			selected--;
			if(selected < 0) {
				selected = buttons.length - 1;
			}
		}
		
		if(gc.getInput().isKeyDown(KeyEvent.VK_SPACE)) {
			buttonHandler(selected);
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(background, offX, offY);
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].paint(r, selected, selectedX, selectedY, buttonOffset);
		}
	}
	
	public abstract void buttonHandler(int signal);
}
