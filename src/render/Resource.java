package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {
	
	public static BufferedImage appleSprite;
	
	public static AudioClip collectSound;
	static{
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			appleSprite = ImageIO.read(loader.getResource("Apple.png"));
			collectSound = Applet.newAudioClip((loader.getResource("coin.wav")).toURI().toURL());
		} catch (Exception e) {
			collectSound = null;
		}
	}
}
