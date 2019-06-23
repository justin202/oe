package com.mireen.oe.input;

import java.awt.event.KeyEvent;

public class KeyboardForSLG extends Keyboard {
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		isPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		lastPressedKey = String.valueOf(e.getKeyChar());
	}
}
