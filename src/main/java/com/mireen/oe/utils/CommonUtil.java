package com.mireen.oe.utils;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Random;

public class CommonUtil {
	
	private static Random random = new Random();
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	
	/**
	 * 	get a random number range in [from, to]
	 * @param from
	 * @param to
	 * @return
	 */
	public static int getRandomNumber(int from, int to) {
		int ret = random.nextInt(to - from + 1) + from;
		return ret;
	}
	
	/**
	 * 	get a random color
	 * @return
	 */
	public static Color getRandomColor() {
		int ret = random.nextInt(4);
		switch(ret) {
			case 0:
				return Color.red;
			case 1:
				return Color.orange;
			case 2:
				return Color.magenta;
			case 3:
				return Color.blue;
			case 4:
				return Color.green;
		}
		return null;
	}
	
	private static final String[] baseStrs = {
			"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "-"
		};
	
	/**
	 * 	get a random name
	 * @return
	 */
	public static String getRandomName() {
		StringBuffer temp = new StringBuffer();
		int length = getRandomNumber(5, 12);
		for(int i = 0; i < length; i++) {
			temp.append(baseStrs[random.nextInt(baseStrs.length)]);
		}
		String ret = temp.toString();
		if(ret.startsWith("-"))
			return ret.replaceFirst("-", baseStrs[random.nextInt(baseStrs.length - 1)]);
		else if(ret.endsWith("-"))
			return ret.substring(0, ret.length() - 1);
		else
			return ret;
	}
	
}
