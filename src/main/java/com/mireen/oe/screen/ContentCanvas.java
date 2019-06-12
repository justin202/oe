package com.mireen.oe.screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.mireen.oe.utils.StageUtil;

public class ContentCanvas extends Canvas implements Runnable {

	private static final long serialVersionUID = -5968928181937806294L;
	
	private StageUtil stageUtil;
	
	// create a buffered image which matches the screen
	private BufferedImage bufferedImage = new BufferedImage(ScreenUtils.WIDTH, ScreenUtils.HEIGHT, BufferedImage.TYPE_INT_RGB);

	public ContentCanvas(StageUtil stageUtil) {
		// set Dimension for the canvas
		setPreferredSize(ScreenUtils.DIM);
		setBackground(Color.WHITE);
		
		this.stageUtil = stageUtil;
	}

	/**
	 * render the canvas
	 */
	private void render() {
		// get buffer strategy, if not set, then create a triple buffer strategy
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		// get the graphic of buffer strategy.
		Graphics bufferStrategyGraphic = bs.getDrawGraphics();
		
		// get graphic of buffered image
		Graphics bufferedImageGraphic = bufferedImage.getGraphics();

		// ******************** render ********************
		// before drawing, clear screen
		bufferedImageGraphic.clearRect(0, 0, ScreenUtils.WIDTH, ScreenUtils.HEIGHT);
		// draw the shapes to bufferedImage, by invoking the render method in the stageUtil
		stageUtil.render(bufferedImageGraphic);
		// draw the bufferedImage
		bufferStrategyGraphic.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
		// ******************** render ********************
		
		// dispose the graphics
		bufferedImageGraphic.dispose();
		bufferStrategyGraphic.dispose();
		
		// show the bufferedImage by the bufferStrategy
		bs.show();
	}
	
	/**
	 * update
	 */
	private void update() {
		stageUtil.update();
	}

	private static final int DEFAULT_FPS = 60;
	// 1ms = 1000000ns
	private static final int MS_TO_NS = 1000000;
	// frame per second, update per second
	public static int fps = 0, ups = 0;
	// interval of each loop
	private double delta = 0.0;
	@Override
	public void run() {
		// 计算出指定FPS数值中，每帧需要多少时间(1/60 s)--unit: ns
		long fpsTime = (long) ((Double.valueOf(1000) / Double.valueOf(DEFAULT_FPS)) * MS_TO_NS);

		// 绘制图像前的时间戳
		long now = 0;
		
		// 上次绘制的时间
		long lastTime = System.nanoTime();

		// 每次绘制图像耗时（毫秒）
		long total = 0;
		
		while (true) {
			now = System.nanoTime();
			
			delta += (now - lastTime) / fpsTime;
			
			lastTime = now;
			
			if(delta >= 1) {
				// 更新
				update();
				ups++;
				delta--;
			}
			// 绘制图像
			render();
			fps++;

			try {
				// 除去绘制之后还需要休眠的时间
				total = System.nanoTime() - now;
				
				if (total > fpsTime) {
					// 如果本次绘制时间超过每帧需要绘制的时间，则直接继续绘制
					continue;
				}

				// unit: ms
				Thread.sleep((fpsTime - (System.nanoTime() - now)) / MS_TO_NS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while((System.nanoTime()- now) < fpsTime){
				// 使用循环，精确控制每帧绘制时长
				System.nanoTime();
			}
			
			// ups=DEFAULT_FPS时为1s
			if(ups >= DEFAULT_FPS) {
				MainGround.frame.setTitle("OTE | " + ups + " ups, " + fps + " fps");
				ups = 0;
				fps = 0;
			}
		}
	}

}
