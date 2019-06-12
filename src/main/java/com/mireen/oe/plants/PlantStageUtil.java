package com.mireen.oe.plants;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.mireen.oe.utils.StageUtil;

public class PlantStageUtil extends StageUtil {
	
	/** plant list */
	public static List<Plant> plants = new ArrayList<Plant>();
	
	private int plantNum;
	
	/**
	 * create "plantNum" of plants
	 * @param plantNum
	 */
	public PlantStageUtil(int plantNum) {
		this.plantNum = plantNum;
		
		for(int i = 0; i < this.plantNum; i++) {
			Plant plant = new Plant();
			plants.add(plant);
		}
		
	}

	@Override
	public void update() {
		for(Plant plant : plants)
			plant.update();
	}

	@Override
	public void render(Graphics graphics) {
		for(Plant plant : plants) {
			graphics.setColor(plant.color);
			graphics.fillOval(plant.location.x, plant.location.y, plant.radius, plant.radius);
			graphics.drawString(plant.name, plant.location.x, plant.location.y);
		}
	}

}
