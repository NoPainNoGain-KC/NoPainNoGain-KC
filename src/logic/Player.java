package logic;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import input.InputUtility;



public class Player implements Entity {
	final static int Speed = 3;
	final static int MaxDistance = 6;
	
	private Point position;
	
	private int direction;
	
	private static int size = 30;
	private Color color;
	
	private int numStep;
	private int countStep;
	
	private Block currentBlock;
	
	public Player(Block b){
		position = new Point(0,0);
		this.currentBlock = b;
		b.addPlayer(this);
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		color = new Color(red,green,blue);
		position.setX(this.currentBlock.getPositionX());
		position.setY(this.currentBlock.getPositionY());

	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
		g2d.setColor(color);
		g2d.fillOval(getX()-size/2, getY()-size/2, size, size);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return position.getX();
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return position.getY();
	}
	@Override
	public boolean collideWith(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateStart() {
		// TODO Auto-generated method stub
		if(InputUtility.getKeyPressed(KeyEvent.VK_SPACE)){
			this.numStep = (int) (Math.random()*6+1);
		}
	}

	@Override
	public void updateWalking() {
		// TODO Auto-generated method stub
		if(!finishX()){
			stepX();
		} 
		if(!finishY()){
			stepY();
		} 
		if(currentBlock.position.inPoint(this)) {
			
		}
	}

	@Override
	public void updateBlockAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnd() {
		// TODO Auto-generated method stub
		
	}
	
	private void stepX(){
		int sign = currentBlock.position.comparePositionX(this);
		position.setX(position.getX() + sign*Speed);
		boolean check = sign == 1 ? position.getX() < currentBlock.getPositionX() 
				:  position.getX() > currentBlock.getPositionX();
		if(!check){
			position.setX(currentBlock.getPositionX());
		}
	}
	
	private void stepY(){
		int sign = currentBlock.position.comparePositionX(this);
		position.setY(position.getY() + sign*Speed);
		boolean check = sign == 1 ? position.getY() < currentBlock.getPositionY() 
				:  position.getY() > currentBlock.getPositionY();
		if(!check){
			position.setY(currentBlock.getPositionY());
		}
	}
	
	private boolean finishX(){
		return position.getX() == currentBlock.getPositionX();
	}
	
	private boolean finishY(){
		return position.getY() == currentBlock.getPositionY();
	}
	
	private void endStep(){
		if(countStep < numStep){
			
		} else {
			
		}
	}
	
//	@Override
//	public void update() {
//		// TODO Auto-generated method stub
//		updateRoll();
//		updateWalking();
//		checkEndTurn();
//		super.update();
//		
//	}
//	
//	@Override
//	protected void step(){
//		if(currentBlock.getNextBlock().length > 0 && !choosedNext){
//			
//		} else {
//			
//		}
//			
//		if(choosedNext){
//			this.currentBlock = currentBlock.getNextBlock()[indexOfNext];
//		}
//	}
//	
//	private void updateRoll(){
//		if(ButtonUtility.isRoll() && (MainLogic.turn % 4 == index)){
//			MainLogic.haveAction = true;
//			ButtonUtility.setRoll(false);
//			int numstep = (int) (Math.random()*6+1);
//			this.numstep = numstep;
//		}
//	}
//	
//	public void walking(int step){
//		this.numstep = step;
//		MainLogic.haveAction = true;
//	}
//	
//	private void checkEndTurn(){
//		if((MainLogic.turn) % 4 == index && !inAction){
//			MainLogic.haveAction = false;
//		}
//	}
//	
//	protected void endTurn(){
//		MainLogic.turn ++;
//		finishTurn = false;
//	}
}
