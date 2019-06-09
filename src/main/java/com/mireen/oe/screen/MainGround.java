package com.mireen.oe.screen;

import javax.swing.JFrame;

import com.mireen.oe.plants.PlantUtils;

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
		
		// create canvas
		ContentCanvas contentCanvas = new ContentCanvas();
		
		// create plants
		PlantUtils.createPlants(2);
        
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
		
		// start rendering and updating
//        contentCanvas.run();
		
	}
	
	public synchronized void start(){
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
