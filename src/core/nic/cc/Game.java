package core.nic.cc;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
	Image game1, lod, lodleft, waterbackground, bublina, hitlod;
	int lodX, lodY, game1X, game1Y, ipositionX, ipositionY, recX,recY, bubX,bubY;
	
	boolean movementL, collision;

	public void init(GameContainer c, StateBasedGame game)
			throws SlickException {
		lodX = 100;
		movementL = false;
		collision = false;
		ipositionX = 100;
		ipositionY = 200;
		lodY = 200;
		bubX = 300;
		bubY = 300;
		recX = 895;
		recY = 150;
		
		
		hitlod = new Image("src/core/nic/cc/nic/hitlod.png");
		bublina = new Image("src/core/nic/cc/nic/bublina.png");
		game1 = new Image("src/core/nic/cc/nic/game.png");
		lod = new Image("src/core/nic/cc/nic/lod12.png");
		waterbackground = new Image("src/core/nic/cc/nic/water.jpg");
		lodleft = new Image("src/core/nic/cc/nic/lodleft.png");
	}

	public void update(GameContainer c, StateBasedGame game, int delta)
			throws SlickException {
		Input input = c.getInput();

		if (input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)) {

			lodX = lodX - 1;
			ipositionX = ipositionX - 1;
			movementL = true;
			bubY = bubY +1;
			if (ipositionX > lodX) {
				game1X = game1X + 1;
				lodX = lodX + 1;
			}

		}
		if (input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)) {

			lodX = lodX + 1;
			ipositionX = ipositionX + 1;
			movementL = false;
			bubY = bubY -1;
			if (lodX > 250) {
				game1X = game1X - 1;
				lodX = lodX - 1;
			}

		}

		if (input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP)) {
				if(ipositionY-1 != recY+50){
					lodY = lodY - 1;
					ipositionY = ipositionY - 1;
					collision = false;
					
				}
					if (ipositionY > lodY) {
						game1Y = game1Y + 1;
						lodY = lodY + 1;
			}
				}
		
		if (input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)) {
			lodY = lodY + 1;
			ipositionY = ipositionY + 1;
			if (lodY > 200) {
				game1Y = game1Y - 1;
				lodY = lodY - 1;
			}
		}
		System.out.println(ipositionX + "," + collision);

	}

	public void render(GameContainer c, StateBasedGame game, Graphics g)
			throws SlickException {
		waterbackground.draw();
		if (movementL == true) {

			lodleft.draw(lodX, lodY);
		}
		if (movementL == false) {

			lod.draw(lodX, lodY);
			if(collision = true){
				hitlod.draw(lodX,lodY);
			}
		}
		
		bublina.draw(bubX,bubY);
		game1.draw(game1X, game1Y);

		Input input = c.getInput();

		if (input.isKeyDown(input.KEY_ESCAPE)) {
			game.enterState(0);

		}
		g.fillRect(recX,recY,50,100);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
