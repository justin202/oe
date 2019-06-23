package com.mireen.oe.basic;

import java.awt.Graphics;
import java.util.List;

import com.mireen.oe.input.Keyboard;

public class Scene {
	
	protected List<Actor> actors;
	
	protected Stage stage;
	
	/**
	 * update stage and actors
	 */
	public void update() {
		actors.forEach((actor) -> {
			actor.update();
		});
		
		stage.update();
	}
	
	/**
	 * render stage and actors
	 * @param graphics
	 */
	public void render(Graphics graphics) {
		actors.forEach((actor) -> {
			actor.render(graphics);
		});
		
		stage.render(graphics);
	}

	public void setKeyboard(Keyboard keyboard) {
		this.actors.forEach((actor) -> {
			actor.setKeyboard(keyboard);
		});
		this.stage.setKeyboard(keyboard);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
}
