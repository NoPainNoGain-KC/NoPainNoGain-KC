package logic;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;



public abstract class Block implements Entity{
	protected int z,width,height;
	//test
	protected Point position;
	
	protected int[] positionx;
	protected int[] positiony;
	protected Player posessedBy;
	protected List<Player> inThisBlock;
	protected Block[] nextBlock;
	
	protected Color color;
	
	public Block(int x, int y,int width,int height){
		position = new Point(x,y);
		this.width = width;
		this.height = height;

		positionx = new int[4];
		positiony = new int[4];
		inThisBlock = new ArrayList<Player>();
		
		int centerx = x + width/4;
		int centery = y + height/4;
		for(int i = 0 ; i<4 ; i++){
			positionx[i] = centerx + (width * (i / 2))/2;
			positiony[i] = centery + (height * (i % 2))/2;
		}
		
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
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

	
	public Block[] getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(Block[] nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPositionX(){
		return positionx[inThisBlock.size()-1];
	}	
	public int getPositionY(){
		return positiony[inThisBlock.size()-1];
	}
	
	public void addPlayer(Player p){
		inThisBlock.add(p);
	}
}
