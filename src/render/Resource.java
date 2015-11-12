package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {
	
	public static BufferedImage[] playerPicture=new BufferedImage[8];
	
	public static AudioClip collectSound;
	static{
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			for(int i=0;i<8;i++)
			{
				try
				{
					playerPicture[i]= ImageIO.read(loader.getResource("player"+i+".png"));
				}catch(Exception e)
				{
					playerPicture[i]=null;
				}
			}
			collectSound = Applet.newAudioClip((loader.getResource("coin.wav")).toURI().toURL());
		} catch (Exception e) {
			collectSound = null;
			
		}
	}
}
