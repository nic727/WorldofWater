package core.nic.cc;



import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
	Image game1, lod, lodleft, waterbackground, bublina, hitlod, oxg, boxD, dead;
	int lodX, lodY, game1X, game1Y, ipositionX, ipositionY, recX, recY, bubX,
			bubY, oxgX, oxgY, PlayerEl;
	float PlayerOx;
	private World world;
	

	boolean movementL, collision, camera;
	CollisionHandler collisionx;

	public void init(GameContainer c, StateBasedGame game)
			throws SlickException {
		
		//b2vec2 gravity(0.0f, -10.0f);
		//b2World world(gravity); 
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

		dead = new Image("src/core/nic/cc/nic/dead.png");
		boxD = new Image("src/core/nic/cc/nic/DDD.jpg");
		oxg = new Image("src/core/nic/cc/nic/oxgenerator.png");
		hitlod = new Image("src/core/nic/cc/nic/hitlod.png");
		bublina = new Image("src/core/nic/cc/nic/bublina.png");
		game1 = new Image("src/core/nic/cc/nic/gamenew.png");
		lod = new Image("src/core/nic/cc/nic/lod12.png");
		waterbackground = new Image("src/core/nic/cc/nic/warter.png");
		lodleft = new Image("src/core/nic/cc/nic/lodleft.png");
	}

	public void update(GameContainer c, StateBasedGame game, int delta)
			throws SlickException {
		Input input = c.getInput();

		if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
			if (!collisionx.isOpaque(ipositionX, ipositionY + 14)) {
				lodX = lodX - 1;
				ipositionX = ipositionX - 1;
				movementL = true;
				PlayerOx = (float) (PlayerOx +0.05);

				if (ipositionX > lodX) {
					game1X = game1X + 1;
					lodX = lodX + 1;
					bubX = bubX + 1;
					oxgX = oxgX + 1;
				}
			}

		}
		if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
			if (!collisionx.isOpaque((ipositionX + 49), ipositionY + 14)) {
				lodX = lodX + 1;
				ipositionX = ipositionX + 1;
				movementL = false;
				collision = false;
				PlayerOx = (float)(PlayerOx -0.05);
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

		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
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
		if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
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
		
		
		System.out.println(Math.round(PlayerOx) + " , " + PlayerOx);

	}

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
		

		//bublina.draw(bubX, bubY);
		//boxD.draw(recX, recY);

		// bublina.draw(bubX,bubY);
		game1.draw(game1X, game1Y);
		//oxg.draw(oxgX, oxgY);
		if(PlayerOx <= 0){
			dead.draw();
			
		}

		g.drawString(Math.round(PlayerOx) + "oxygen", 10, 60);
		Input input = c.getInput();

		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			game.enterState(0);

		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
