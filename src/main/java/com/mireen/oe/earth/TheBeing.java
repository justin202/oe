package com.mireen.oe.earth;

import java.awt.Point;
import java.util.List;

public class TheBeing {
	
	private Point point;
	
	private String name;
	
	private int gender;
	
	private TheBeing pouse;
	
	private List<TheBeing> children;

	public TheBeing() {
	}

	public TheBeing(Point point, String name, int gender, TheBeing pouse, List<TheBeing> children) {
		this.point = point;
		this.name = name;
		this.gender = gender;
		this.pouse = pouse;
		this.children = children;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public TheBeing getPouse() {
		return pouse;
	}

	public void setPouse(TheBeing pouse) {
		this.pouse = pouse;
	}

	public List<TheBeing> getChildren() {
		return children;
	}

	public void setChildren(List<TheBeing> children) {
		this.children = children;
	}

}
