package core.nic.cc;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class CollisionHandler {
	Image image;
	Animation animation;
	Game game;
	Color color;

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
		animation = game.ballss;
		
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