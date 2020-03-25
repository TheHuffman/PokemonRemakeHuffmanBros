package com.NotGarbage.game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import com.NotGarbage.engine.Input;

public class InputController {
	public static final int BUTTON_RESPONSE_SAVE = 5;
	
	public static final int UNKNOWN_INPUT = 0;
	public static final int UP_PAD = 1;
	public static final int DOWN_PAD = 2;
	public static final int LEFT_PAD = 3;
	public static final int RIGHT_PAD = 4;
	public static final int SELECT = 5;
	public static final int DASH = 6;
	
	private static Map<Integer, Integer> keyMapping = new HashMap<Integer, Integer>();
	private static Map<Integer, ArrayList<Integer>> typeMapping = new HashMap<Integer, ArrayList<Integer>>();
	private static ArrayList<Integer> keyUps = new ArrayList<Integer>();
	private static ArrayList<Integer> keyDowns = new ArrayList<Integer>();
	private static ArrayList<Integer> keys = new ArrayList<Integer>();

	public InputController() {
		setMap();
		setDefaults();
	}

	public InputController(int[] newKeys, char[] features) {
		setMap();
		setDefaults();
		if(newKeys.length <= features.length) {
			for(int i = 0; i < newKeys.length; i++) {
				assignKey(newKeys[i], features[i]);
			}
		}
	}

	private void setMap() {
		typeMapping.put(UNKNOWN_INPUT, keys);
		typeMapping.put(UP_PAD, keys);
		typeMapping.put(DOWN_PAD, keys);
		typeMapping.put(LEFT_PAD, keys);
		typeMapping.put(RIGHT_PAD, keys);
		typeMapping.put(SELECT, keyDowns);
		typeMapping.put(DASH, keyDowns);
	}
	
	public void setDefaults() {
		keyMapping.put(KeyEvent.VK_W, UP_PAD);
		typeMapping.get(UP_PAD).add(KeyEvent.VK_W);
		keyMapping.put(KeyEvent.VK_S, DOWN_PAD);
		typeMapping.get(DOWN_PAD).add(KeyEvent.VK_S);
		keyMapping.put(KeyEvent.VK_A, LEFT_PAD);
		typeMapping.get(LEFT_PAD).add(KeyEvent.VK_A);
		keyMapping.put(KeyEvent.VK_D, RIGHT_PAD);
		typeMapping.get(RIGHT_PAD).add(KeyEvent.VK_D);
		keyMapping.put(KeyEvent.VK_SPACE, SELECT);
		typeMapping.get(SELECT).add(KeyEvent.VK_SPACE);
		keyMapping.put(KeyEvent.VK_SHIFT, DASH);
		typeMapping.get(DASH).add(KeyEvent.VK_SHIFT);
	}
	
	public void assignKey(int newBind, int gameFeature) {
		ArrayList<Integer> keysInUse = typeMapping.get(gameFeature);
		int len = keysInUse.size();
		int saveKey = 0;
		int remove = 0;
		int saveFeature = UNKNOWN_INPUT;
		for(int i = 0; i < len; i++) {
			if(keyMapping.get(keysInUse.get(i)) == gameFeature) {
				keyMapping.remove(keysInUse.get(i));
				saveKey = keysInUse.get(i);
				remove = i;
			}
		}
		keysInUse.remove(remove);
		//Check if in use in keys, if so replace with the binding just replaced
		checkBindings(keys, newBind, saveKey, saveFeature);
		//Check if in use in keyDowns, if so replace with the binding just replaced
		checkBindings(keyDowns, newBind, saveKey, saveFeature);
		//Check if in use in keyUps, if so replace with the binding just replaced
		checkBindings(keyUps, newBind, saveKey, saveFeature);

		keysInUse.add(newBind);
		keyMapping.put(newBind, gameFeature);
	}

	private void checkBindings(ArrayList<Integer> keysInUse, int newBind, int saveKey, int saveFeature) {
		int len = keysInUse.size();
		for(int i = 0; i < len; i++) {
			if(keysInUse.get(i) == newBind) {
				saveFeature = keyMapping.get(keysInUse.get(i));
				keyMapping.remove(keysInUse.get(i));
				keyMapping.put(saveKey, saveFeature);
				keysInUse.add(saveKey);
			}
		}
	}

	public void getResponse(Input in, Queue<Integer> buttonQueue) {
		int len = keys.size();
		for(int i = 0; i < len; i++) {
			if(in.isKey(keys.get(i))) {
				buttonQueue.add(keyMapping.get(keys.get(i)));
				if(buttonQueue.size() > BUTTON_RESPONSE_SAVE) buttonQueue.poll();
			}
		}
		len = keyUps.size();
		for(int i = 0; i < len; i++) {
			if(in.isKeyUp(keyUps.get(i))) {
				buttonQueue.add(keyMapping.get(keyUps.get(i)));
				if(buttonQueue.size() > BUTTON_RESPONSE_SAVE) buttonQueue.poll();
			}
		}
		len = keyDowns.size();
		for(int i = 0; i < len; i++) {
			if(in.isKeyDown(keyDowns.get(i))) {
				buttonQueue.add(keyMapping.get(keyDowns.get(i)));
				if(buttonQueue.size() > BUTTON_RESPONSE_SAVE) buttonQueue.poll();
			}
		}
	}

}
