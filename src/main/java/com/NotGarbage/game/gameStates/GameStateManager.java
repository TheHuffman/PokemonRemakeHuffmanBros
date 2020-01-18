package com.NotGarbage.game.gameStates;

import java.util.Stack;

import com.NotGarbage.engine.GameContainer;
import com.NotGarbage.engine.Renderer;
//import com.NotGarbage.game.entities.Player;

public class GameStateManager {
	public Stack<GameState> states;
	//private Player player;
	//private Dungeon[] levels;
	private Menu[] menus;

	public GameStateManager() {
		states = new Stack<GameState>();
	}

	public void update(GameContainer gc, float dt) {
		states.peek().update(gc, dt);
	}

	public void render(GameContainer gc, Renderer r) {
		states.peek().render(gc, r);
	}

	public void updatePlayer() {
		states.peek().updatePlayer();
	}
/*
	public void importLevel(Dungeon dungeon, int spot) {
		levels[spot] = dungeon;
	}
*/
	public void importMenu(Menu menu, int spot) {
		menus[spot] = menu;
	}
/*
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Dungeon[] getLevels() {
		return levels;
	}

	public void setLevels(Dungeon[] levels) {
		this.levels = levels;
	}
*/
	public Menu[] getMenus() {
		return menus;
	}

	public void setMenus(Menu[] menus) {
		this.menus = menus;
	}
}
