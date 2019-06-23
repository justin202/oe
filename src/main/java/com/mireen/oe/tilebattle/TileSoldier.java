package com.mireen.oe.tilebattle;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mireen.oe.basic.Actor;

public class TileSoldier extends Actor {
	
	private BufferedImage image;
	private Point position;
	private int size;
	
	/**
	 * 
	 * @param path		the image path
	 * @param position	the initial position of the soldier
	 * @param size		the dimension of the soldier
	 */
	public TileSoldier(String path, Point position, int size) {
		try {
			image = ImageIO.read(TileSoldier.class.getResource(path));
			this.position = position;
			this.size = size;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		if(keyboard.isPressed && keyboard.lastPressedKey.equalsIgnoreCase("w")) 
			position.y -= size;
		if(keyboard.isPressed && keyboard.lastPressedKey.equalsIgnoreCase("s")) 
			position.y += size;
		if(keyboard.isPressed && keyboard.lastPressedKey.equalsIgnoreCase("a")) 
			position.x -= size;
		if(keyboard.isPressed && keyboard.lastPressedKey.equalsIgnoreCase("d")) 
			position.x += size;
		keyboard.lastPressedKey = "";
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(image, position.x, position.y, size, size, null);
	}
	
}
