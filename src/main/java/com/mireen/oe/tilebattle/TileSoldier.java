package com.mireen.oe.tilebattle;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mireen.oe.utils.StageUtil;

public class TileSoldier extends StageUtil {
	
	private BufferedImage image;
	private Point position;
	private int size;
	
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
		if(keyboard.up)
			position.y -= size;
		if(keyboard.down)
			position.y += size;
		if(keyboard.left)
			position.x -= size;
		if(keyboard.right)
			position.x += size;
			
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(image, position.x, position.y, size, size, null);
	}
	
}
