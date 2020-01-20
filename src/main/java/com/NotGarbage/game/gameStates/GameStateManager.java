package com.NotGarbage.game.gameStates;

import java.util.Stack;

import com.NotGarbage.engine.GameContainer;
import com.NotGarbage.engine.Renderer;
import com.pokemon.entities.Player;
import com.pokemon.gameStates.WorldState;

public class GameStateManager {
	public Stack<GameState> states;
	private Player player;
	private	WorldState[] levels;
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

	public void importLevel(WorldState level, int spot) {
		levels[spot] = level;
	}

	public void importMenu(Menu menu, int spot) {
		menus[spot] = menu;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public WorldState[] getLevels() {
		return levels;
	}

	public void setLevels(WorldState[] levels) {
		this.levels = levels;
	}

	public Menu[] getMenus() {
		return menus;
	}

	public void setMenus(Menu[] menus) {
		this.menus = menus;
	}
}
