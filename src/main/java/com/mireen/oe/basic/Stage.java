package com.mireen.oe.basic;

import java.awt.Graphics;

import com.mireen.oe.input.Keyboard;
import com.mireen.oe.input.KeyboardForGeneral;

/**
 * the super class of all kind of stage
 * @author hqs
 * @Date 2019年6月12日
 *
 */
public abstract class Stage {
	
	protected Keyboard keyboard;
	
	public void update() {
		
	}
	
	public void render(Graphics graphics) {
		
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

}
