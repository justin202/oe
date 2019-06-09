package com.mireen.oe.screen;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 * to manipulate screen conveniently
 * @author HQS
 * @Date 2019-06-08 09:30:05
 *
 */
public class ScreenUtils {
	
	/** width : height = 16:9 */
	public static final int WIDTH = 1080;
	public static final int HEIGHT = WIDTH / 16 * 9;
	
	public static final Dimension DIM = new Dimension(WIDTH, HEIGHT);
	
	/**
	 * 	return a point that represents the x and y of the frame should located to
	 * @return
	 */
	public static Point getCenterPoint() {
		Point p = new Point();
		
		p.x = (Toolkit.getDefaultToolkit().getScreenSize().width >> 1) - (WIDTH >> 1);
		p.y = (Toolkit.getDefaultToolkit().getScreenSize().height >> 1) - (HEIGHT >> 1);
		
		return p;
	}

}
