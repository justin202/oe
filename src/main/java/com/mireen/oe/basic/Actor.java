package com.mireen.oe.basic;

import java.awt.Graphics;

import com.mireen.oe.input.Keyboard;
import com.mireen.oe.input.KeyboardForSLG;

public class Actor {
	
	protected Keyboard keyboard;
	
	public void update() {
		
	}
	
	public void render(Graphics graphics) {
		
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = (KeyboardForSLG) keyboard;
	}

}
