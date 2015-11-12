import javax.swing.JComponent;
import javax.swing.JFrame;

import render.GameScreen;
import logic.GameLogic;


//try
public class Main {
	public static void main(String[] args){
		JFrame frame = new JFrame("Catch a friut");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameLogic logic = new GameLogic();
		JComponent gameScreen = new GameScreen();
		
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		gameScreen.requestFocus();
		
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			gameScreen.repaint();
			logic.logicUpdate();
			//InputUtility.updateInputState();
		}
	}
}
