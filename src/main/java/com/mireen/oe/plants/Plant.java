package com.mireen.oe.plants;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import com.mireen.oe.screen.ScreenUtils;
import com.mireen.oe.utils.CommonUtil;

public class Plant {
	
	public Point location;
	public int radius;
	public Color color;
	public String name;
	public int mass;
	
	public Plant() {
		this.radius = CommonUtil.getRandomNumber(10, 100);
		this.location = new Point(CommonUtil.getRandomNumber(0, ScreenUtils.WIDTH - radius), CommonUtil.getRandomNumber(0, ScreenUtils.HEIGHT - radius));
		// check whether there is overlap
		checkOverLap();
		this.color = CommonUtil.getRandomColor();
		this.name = CommonUtil.getRandomName();
		this.mass = CommonUtil.getRandomNumber(1, Integer.MAX_VALUE);
		System.out.println(this);
	}

	/**
	 * check whether there is overlap
	 */
	private void checkOverLap() {
		boolean check = PlantStageUtil.plants.size() != 0;
		while(check) {
			for(Plant plant : PlantStageUtil.plants) {
				Rectangle plantRect = new Rectangle(plant.location.x, plant.location.y, plant.radius, plant.radius);
				Rectangle rect = new Rectangle(this.location.x, this.location.y, this.radius, this.radius);
				if(rect.intersects(plantRect)) {
					this.location = new Point(CommonUtil.getRandomNumber(radius, ScreenUtils.WIDTH - radius), CommonUtil.getRandomNumber(radius, ScreenUtils.HEIGHT - radius));
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
