package logic;



import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import render.RenderableHolder;

public class GameLogic {
	
	//private PlayStatus[] playStatus;
	private Player[] player;
	private List<Block> blocks;
	private PlayerStatus[] playerStatus;
	private int ticCouter,z,index;
	private static int phase;
	static int PhaseStart=0,
			PhaseWalking=1,
			PhaseBlockAction=2,
			PhaseAction=3,
			PhaseEnd=4;
	static int PlaystatusHight=350;
	static int PlaystatusWidth=150;
	static Point[] position=new Point[]{
		new Point(0,0),new Point(0,350),new Point(850,0),new Point(850,350)
	};
	public GameLogic() {
		// TODO Auto-generated constructor stub
		
		playerStatus=new PlayerStatus[4];
		Color[] color=new Color[4];
		color[0]=Color.BLACK;
		color[1]=Color.blue;
		color[2]=Color.GRAY;
		color[3]=Color.GREEN;
		
		blocks = new ArrayList<Block>();
		
		for(Block block : Field.getBlocks()){
			block.position.setX(block.position.getX()+180);
			RenderableHolder.getInstance().add(block);
			blocks.add(block);
		}
		//dfdfdd
		player = new Player[4];
		blocks =new ArrayList<>();
		//makeMap
		Block first = Field.getBlocks()[0];
		for(int i=0;i<4;i++)
		{
			playerStatus[i]=new PlayerStatus(position[i],PlaystatusHight,PlaystatusWidth,color[i]);
			RenderableHolder.getInstance().add(playerStatus[i]);
			player[i]=new Player(first);
			RenderableHolder.getInstance().add(player[i]);
		}
		phase=PhaseStart;
		index=0;
		ticCouter=0;
		z=0;
	}

	public void logicUpdate() {
		// TODO Auto-generated method stub
		Player now=player[index];
		if(phase==PhaseStart)
		{
			now.updateStart();
//			if(now.endStart())
//			{
//				phase+=1;
//			}
		}
		else if(phase==PhaseWalking)
		{
			now.updateWalking();
//			if(now.endWalking())
//			{
//				phase+=1;
//			}
		}
		/*
		else if(phase==PhaseBlockAction)
		{
			if(now.endBlockAction())
			{
				phase+=1;
			}
		}
		else if(phase==PhaseAction)
		{
			if(now.endAciton())
			{
				phase+=1;
			}
		}
		else if(phase==PhaseEnd)
		{
			
			if(endEnd())
			{
				phase=0;
			}
		}
	}

	private boolean endEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean endWalking() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean endStart() {
		// TODO Auto-generated method stub
		return false;
	}*/
		
	
	}
	public void nextPhase(){
		if(phase != GameLogic.PhaseEnd)
			phase ++;
		else
			phase = 0;
	}
}
