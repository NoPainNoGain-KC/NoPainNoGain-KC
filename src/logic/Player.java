package logic;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import input.InputUtility;



public class Player implements Entity {
	//direction
	final static int DOWN = 0;
	final static int LEFT = 1;
	final static int RIGHT = 2;
	final static int UP = 3;
	
	final static int Speed = 3;
	final static int MaxDistance = 6;
	
	private Point position;
	
	private int direction;
	private Point destination;
	
	private static int size = 30;
	private Color color;
	
	private int numStep;
	private int countStep;
	private boolean walking;
	
	
	private Block currentBlock;
	
	public Player(Block b){
		position = new Point(0,0);
		this.currentBlock = b;
		b.addPlayer(this);
		
		direction = Player.DOWN;
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		color = new Color(red,green,blue);
		
		position.setX(this.currentBlock.getPosition().getX());
		position.setY(this.currentBlock.getPosition().getY());

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
			System.out.println(numStep);
			GameLogic.nextPhase();
		}
	}

	@Override
	public void updateWalking() {
		// TODO Auto-generated method stub
		if(walking){
			if(!finishX()){
				stepX();
			} 
			if(!finishY()){
				stepY();
			} 
			if(finishX() && finishY()) {
				endStep();
			}
		} else {
			try{
				if(InputUtility.getKeyPressed(KeyEvent.VK_A)){
					if(direction != RIGHT){
						step(LEFT);
					}
				}
				if(InputUtility.getKeyPressed(KeyEvent.VK_D)){
					if(direction != LEFT){
						step(RIGHT);
					}
				}
				if(InputUtility.getKeyPressed(KeyEvent.VK_W)){
					if(direction != DOWN){
						step(UP);	
					}
				}
				if(InputUtility.getKeyPressed(KeyEvent.VK_S)){
					if(direction != UP){
						step(DOWN);					
					}
				}
			} catch (NullPointerException e){ 
			}
		}
		
	}

	private void step(int direction){
		Field.checkBlock(currentBlock.nextBlock[direction]);
		currentBlock.removePlayer(this);
		currentBlock = currentBlock.nextBlock[direction];
		this.direction = direction;
		destination = currentBlock.getPosition();
		currentBlock.addPlayer(this);
		walking = true;
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
		int sign = destination.comparePositionX(this);
		position.setX(position.getX() + sign*Speed);
		
		boolean check = sign == -1 ? position.getX() > destination.getX() 
				:  position.getX() < destination.getX();
		if(!check){
			position.setX(destination.getX());
		}
	}
	
	private void stepY(){
		int sign = destination.comparePositionY(this);
		position.setY(position.getY() + sign*Speed);
		boolean check = sign ==  1 ? position.getY() < destination.getY() 
				:  position.getY() > destination.getY();
		if(!check){
			position.setY(destination.getY());
		}
	}
	
	private boolean finishX(){
		return position.getX() == destination.getX();
	}
	
	private boolean finishY(){
		return position.getY() == destination.getY();
	}
	
	private void endStep(){
		countStep++;
		walking = false;
		destination = null;
		if(countStep == numStep){ 
			GameLogic.nextPhase();
			countStep = 0;
			numStep = 0;
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
