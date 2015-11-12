package logic;


import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;

public class PlayerStatus implements IRenderable {
	int height,width;
	Point position;
	int x,y;
	Color color;
	public PlayerStatus(Point position,int high,int width,Color color) {
		// TODO Auto-generated constructor stub
		//This.position=position;
		this.position=position;
		x=position.getX();
		y=position.getY();
		this.height=high;
		this.width=width;
		this.color=color;
	}
	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(color);
		g2.fillRect(x, y, width,height );
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}
	
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
