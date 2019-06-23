package com.mireen.oe.tilebattle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.mireen.oe.basic.Actor;
import com.mireen.oe.basic.Scene;

public class BattleScene extends Scene {

	public BattleScene() {
		// create stage for the tile battle
		BattleStage battleStage = new BattleStage();
		
		// create actor for the tile battle
		List<Actor> actors = new ArrayList<Actor>();
		TileSoldier tileSoldier = new TileSoldier("/images/roman-toga.png", new Point(480, 480), 48);
		actors.add(tileSoldier);
		
		this.setStage(battleStage);
		this.setActors(actors);
	}

}
