package com.mireen.oe.tilebattle;

import java.awt.Color;
import java.awt.Graphics;

import com.mireen.oe.screen.ScreenUtils;
import com.mireen.oe.utils.StageUtil;

public class Battleground extends StageUtil {
	
	private int tileSize = 48;

	@Override
	public void update() {
		if(keyboard.up) System.out.println("UP");
		if(keyboard.down) System.out.println("DOWN");
		if(keyboard.left) System.out.println("LEFT");
		if(keyboard.right) System.out.println("RIGHT");
	}

	@Override
	public void render(Graphics graphics) {
		int widthLines = (int) Math.ceil((double) ScreenUtils.WIDTH / tileSize);
		int heightLines = (int) Math.ceil((double) ScreenUtils.HEIGHT / tileSize);
		
		graphics.setColor(Color.BLACK);
		
		for(int i = 0; i < widthLines; i++)
			graphics.drawLine(i * tileSize, 0, i * tileSize, ScreenUtils.HEIGHT);
		
		for(int i = 0; i < heightLines; i++)
			graphics.drawLine(0, i * tileSize, ScreenUtils.WIDTH, i * tileSize);
			
	}

}
