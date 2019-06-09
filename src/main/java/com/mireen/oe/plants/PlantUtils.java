package com.mireen.oe.plants;

import java.util.ArrayList;
import java.util.List;

public class PlantUtils {
	
	/** plant list */
	public static List<Plant> plants = new ArrayList<Plant>();
	
	/**
	 * create "plantNum" of plants
	 * @param plantNum
	 */
	public static void createPlants(int plantNum) {
		for(int i = 0; i < plantNum; i++) {
			Plant plant = new Plant();
			plants.add(plant);
		}
	}

}
