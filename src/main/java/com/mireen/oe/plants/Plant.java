package com.mireen.oe.plants;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import com.mireen.oe.screen.ScreenUtils;
import com.mireen.oe.utils.CommonUtils;

public class Plant {
	
	public Point location;
	public int radius;
	public Color color;
	public String name;
	public int mass;
	
	public Plant() {
		this.radius = CommonUtils.getRandomNumber(10, 100);
		this.location = new Point(CommonUtils.getRandomNumber(0, ScreenUtils.WIDTH - radius), CommonUtils.getRandomNumber(0, ScreenUtils.HEIGHT - radius));
		// check whether there is overlap
		checkOverLap();
		this.color = CommonUtils.getRandomColor();
		this.name = CommonUtils.getRandomName();
		this.mass = CommonUtils.getRandomNumber(1, Integer.MAX_VALUE);
		System.out.println(this);
	}

	/**
	 * check whether there is overlap
	 */
	private void checkOverLap() {
		boolean check = PlantUtils.plants.size() != 0;
		while(check) {
			for(Plant plant : PlantUtils.plants) {
				Rectangle plantRect = new Rectangle(plant.location.x, plant.location.y, plant.radius, plant.radius);
				Rectangle rect = new Rectangle(this.location.x, this.location.y, this.radius, this.radius);
				if(rect.intersects(plantRect)) {
					this.location = new Point(CommonUtils.getRandomNumber(radius, ScreenUtils.WIDTH - radius), CommonUtils.getRandomNumber(radius, ScreenUtils.HEIGHT - radius));
					check = true;
					break;
				}else
					check = false;
			}
		}
	}
	
	public void update() {
		this.location.x += 1;
		if(this.location.x >= ScreenUtils.WIDTH)
			this.location.x = 0;
	}

	@Override
	public String toString() {
		return "Plant [location=" + location + ", radius=" + radius + ", color=" + color + ", name=" + name + ", mass="
				+ mass + "]";
	}

}
