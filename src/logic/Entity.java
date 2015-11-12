package logic;

import render.IRenderable;




public interface Entity extends IRenderable{
	
	//check collide with other
	public int getX();
	public int getY();
	
	//check collide with other
	public boolean collideWith(Entity e);
	
	//update each phase
	public void updateStart();
	public void updateWalking();
	public void updateBlockAction();
	public void updateAction();
	public void updateEnd();
	
}
