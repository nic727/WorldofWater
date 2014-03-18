package core.nic.cc;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
	Image game1, lod, lodleft, waterbackground, bublina, hitlod, oxg, boxD;
	int lodX, lodY, game1X, game1Y, ipositionX, ipositionY, recX, recY, bubX,
			bubY, oxgX, oxgY, PlayerEl;
	int PlayerOx;

	boolean movementL, collision, camera;
	CollisionHandler collisionx;

	public void init(GameContainer c, StateBasedGame game)
			throws SlickException {
		lodX = 100;
		movementL = false;
		collision = false;
		camera = false;
		ipositionX = 100;
		ipositionY = 200;
		lodY = 200;
		bubX = 100;
		bubY = 100;
		recX = 150;
		recY = 150;
		collisionx = new CollisionHandler(this);
		oxgX = 0;
		oxgY = 0;
		PlayerOx = 100;
		PlayerEl = 100;

		boxD = new Image("src/core/nic/cc/nic/DDD.jpg");
		oxg = new Image("src/core/nic/cc/nic/oxgenerator.png");
		hitlod = new Image("src/core/nic/cc/nic/hitlod.png");
		bublina = new Image("src/core/nic/cc/nic/bublina.png");
		game1 = new Image("src/core/nic/cc/nic/game1.png");
		lod = new Image("src/core/nic/cc/nic/lod12.png");
		waterbackground = new Image("src/core/nic/cc/nic/water.jpg");
		lodleft = new Image("src/core/nic/cc/nic/lodleft.png");
	}

	@SuppressWarnings("static-access")
	public void update(GameContainer c, StateBasedGame game, int delta)
			throws SlickException {
		Input input = c.getInput();

		if (input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)) {
			if (!collisionx.isOpaque(ipositionX, ipositionY + 14)) {
				lodX = lodX - 1;
				ipositionX = ipositionX - 1;
				movementL = true;

				if (ipositionX > lodX) {
					game1X = game1X + 1;
					lodX = lodX + 1;
					bubX = bubX + 1;
					oxgX = oxgX + 1;
				}
			}

		}
		if (input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)) {
			if (!collisionx.isOpaque(ipositionX + 49, ipositionY + 14)) {
				lodX = lodX + 1;
				ipositionX = ipositionX + 1;
				movementL = false;
				collision = false;
				if (lodX > 250) {
					game1X = game1X - 1;
					lodX = lodX - 1;
					oxgX = oxgX - 1;
					bubX = bubX - 1;

				}
			} else {
				collision = true;
			}

		}

		if (input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP)) {
			if (!collisionx.isOpaque(ipositionX + (49 / 2), ipositionY)) {
				lodY = lodY - 1;
				ipositionY = ipositionY - 1;

				if (ipositionY > lodY) {
					game1Y = game1Y + 1;
					lodY = lodY + 1;
					bubY = bubY + 1;
					oxgY = oxgY + 1;
				}
			}
		}
		if (input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)) {
			if (!collisionx.isOpaque(ipositionX + (49 / 2), ipositionY + 28)) {
				lodY = lodY + 1;
				ipositionY = ipositionY + 1;
				collision = false;
				if (lodY > 200) {
					game1Y = game1Y - 1;
					lodY = lodY - 1;
					bubY = bubY - 1;
					oxgY = oxgY - 1;
				}
			} else {
				collision = true;
			}
		}
		System.out.println(collision + " , " + ipositionX);

	}

	@SuppressWarnings("static-access")
	public void render(GameContainer c, StateBasedGame game, Graphics g)
			throws SlickException {
		waterbackground.draw();
		if (movementL == true) {

			lodleft.draw(lodX, lodY);
		}
		if ((movementL == false)
				&& (!collisionx.isOpaque(ipositionX, ipositionY))) {

			lod.draw(lodX, lodY);
			if (collision == true) {
				hitlod.draw(lodX, lodY);
			}
		}

		bublina.draw(bubX, bubY);
		boxD.draw(recX, recY);

		// bublina.draw(bubX,bubY);
		game1.draw(game1X, game1Y);
		oxg.draw(oxgX, oxgY);

		g.drawString(PlayerOx + "oxygen", 10, 10);
		Input input = c.getInput();

		if (input.isKeyDown(input.KEY_ESCAPE)) {
			game.enterState(0);

		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
