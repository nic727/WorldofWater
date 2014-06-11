package core.nic.cc;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class CollisionHandler {
	Image image;
	SpriteSheet ss;
	Game game;
	Color color;
	Crate[] things;

	public CollisionHandler(Game gam) {
		game = gam;

	}

	public boolean isOpaque(int b, int y) {
		image = game.game1;
		
		color = image.getColor(b, y);
		int alpha = color.getAlpha();
		//System.out.println("[" + b + "," + y + "] " + color.a + ", " + color.r
			//	+ ", " + color.g + ", " + color.b);
		if (alpha < 1) {
			return false;
		}
		return true;

	}
	public boolean isHit(int b, int y) {
		image = game.utesy;
		
		color = image.getColor(b, y);
		int alpha = color.getAlpha();
		//System.out.println("[" + b + "," + y + "] " + color.a + ", " + color.r
			//	+ ", " + color.g + ", " + color.b);
		if (alpha < 1) {
			return false;
		}
		return true;
	}
	public boolean isOxygen(int b, int y) {
		
			image = game.game1;
		
			//ss = (SpriteSheet) game.ballspritesheet.getSprite(1, 0);
		
		color = image.getColor(b, y);
		int alpha = color.getAlpha();
		//System.out.println("[" + b + "," + y + "] " + color.a + ", " + color.r
			//	+ ", " + color.g + ", " + color.b);
		if (alpha < 1) {
			return false;
		}
		return true;
	}
	
	
	public boolean isPicked(int b, int y) {
		image = game.coin;
		System.out.println(b + " " + y);
		color = image.getColor(b, y);
		int alpha = color.getAlpha();
		//System.out.println("[" + b + "," + y + "] " + color.a + ", " + color.r
			//	+ ", " + color.g + ", " + color.b);
		if (alpha < 1) {
			return false;
		}
		return true;
	}

	}