package logic;

public class Field {
	
	private static final Field currentField = new Field(16);
	public static Field getInstance(){
		return currentField;
	}
	
	private static Block[] blocks;
	                             
	public Field(int length){		
		createField(length);
		setNextBlock();
	}
	
	public static Block[] getBlocks(){
		return blocks;
	}
	
	public static void createField(int length){
		blocks = new Block[length];
		for(int i = 0 ; i<length ; i++){
			int x = 0;
			int y = 0;
			if(i<=15 && i>12){
				x = 0;
				y = 4 - (i%4);
			} else if(i<=12 && i>8){
				x = 12 - (i);
				y = 4;
			} else if(i<=8 && i>4){
				x = 4;
				y = (i%4 == 0) ? 4 : i%4;
			} else if(i<=4){
				x = i;
				y = 0;
			} else {
				return;
			}
			blocks[i] = new SimpleBlock(50+100*x,50+100*y,100,100);
		}
	}
	
	public static void setNextBlock(){
		for(int i = 0;i<blocks.length;i++){
			int nextindex = (i+1 < blocks.length) ? i+1 : 0;
			Block[] next = {blocks[nextindex]};
			blocks[i].setNextBlock(next);
		}
	}
}
