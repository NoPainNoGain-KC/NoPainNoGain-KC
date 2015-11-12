package logic;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int value){
		x = value;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int value){
		y = value;
	}
	
	
	public boolean inPoint(Entity e){
		return (e.getX() == this.x) && (e.getY() == this.y);
	}
	
	public int comparePositionX(Entity e){
		if(inPoint(e)) return 0;
		return e.getX() < this.x ?  1 : -1;
	}
	
	public int comparePositionY(Entity e){
		if(inPoint(e)) return 0;
		return e.getY() < this.y ?  1 : -1;
	}
}
