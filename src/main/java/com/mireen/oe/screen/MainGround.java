package com.mireen.oe.screen;

import javax.swing.JFrame;

import com.mireen.oe.tilebattle.BattleScene;

/**
 * Assemble every components in here
 * @author HQS
 * @Date 2019-06-08 10:01:36
 *
 */
public class MainGround {

	public static JFrame frame;
	
	public ContentCanvas contentCanvas;
	
	// create a thread to controller contentCanvas
	public Thread thread;
	
	public MainGround() {
		frame = new JFrame();
		
		// create the battle scene and set to the content canvas
		BattleScene battleScene = new BattleScene();
		contentCanvas = new ContentCanvas(battleScene);
		
		// add canvas to frame
		frame.add(contentCanvas);
        frame.pack();
        // configure frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("OTE");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(ScreenUtils.getCenterPoint());
		
		thread = new Thread(contentCanvas);
		
	}
	
	public synchronized void start(){
		// start rendering and updating
		thread.start();
	}
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
