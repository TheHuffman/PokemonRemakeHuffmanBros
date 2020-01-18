package com.NotGarbage.game.gameStates;

import com.NotGarbage.engine.GameContainer;
import com.NotGarbage.engine.Renderer;

public abstract class GameState {
	protected GameStateManager gsm;

	public static final int BLOCKSIZE = 64;
	public static int mapW;
	public static int mapL;
	public static int mapH;

	public static int offX;
	public static int offY;
	public static int offZ;

	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		mapW = 0;
		mapL = 0;
		mapH = 0;
		offX = 0;
		offY = 0;
		offZ = 0;
		//init();
	}

	//public abstract void init();
	public abstract void update(GameContainer gc, float dt);
	public abstract void render(GameContainer gc, Renderer r);
	public abstract void updatePlayer();
	//public abstract void keepPlayer(GameState gameState);
}
