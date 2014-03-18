package core.nic.cc;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class CollisionHandler {
	Image image, image1;
	Game game;
	Color color;

	public CollisionHandler(Game gam) {
		game = gam;

	}

	public boolean isOpaque(int x, int y) {
		image = game.game1;
		
		color = image.getColor(x, y);
		int alpha = color.getAlpha();
		System.out.println("[" + x + "," + y + "] " + color.a + ", " + color.r
				+ ", " + color.g + ", " + color.b);
		if (alpha < 1) {
			return false;
		}
		return true;

	}
	}