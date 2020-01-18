package com.NotGarbage.game;

import com.NotGarbage.engine.AbstractGame;
import com.NotGarbage.engine.GameContainer;
import com.NotGarbage.engine.Renderer;
import com.NotGarbage.game.gameStates.GameStateManager;
import gameStates.LoadingScreen;

public class GameManager extends AbstractGame {
	private GameStateManager gsm;

	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}

	public GameManager() {
		gsm = new GameStateManager();
		gsm.states.push(new LoadingScreen(gsm));
	}

	public void update(GameContainer gc, float dt) {
		gsm.update(gc, dt);
	}

	public void render(GameContainer gc, Renderer r) {
		gsm.render(gc, r);
	}

}
