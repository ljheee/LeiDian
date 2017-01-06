package com.ljheee.plane;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Plane {

	static int x;
	static int y;
	private int size;
	int speed;
	private JFrame jf;
	private ImageIcon hero;
	
	public Plane() {
	}

	public Plane(int x, int y, int size, JFrame jf) {
		this.x=x;
		this.y=y;
		this.size=size;
		this.jf=jf;
	}
	
	/**
	 * 绘制飞机[我方]
	 * @param g
	 */
	public void draw(Graphics g) {
		hero  =new ImageIcon("pic/hero1.png");
		g.drawImage(hero.getImage(), x, y,size,size, jf);
	}
	
	
	
	
}
