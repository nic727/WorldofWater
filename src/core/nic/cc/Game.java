package core.nic.cc;


import java.sql.Array;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
	Image game1, lod, lodleft, waterbackground, bublina, hitlod, oxg, boxD, dead;
	int lodX, lodY, game1X, game1Y, ipositionX, ipositionY, boxX, boxY, bubX,
			bubY, oxgX, oxgY, PlayerEl,boxXposition,boxYposition, gold;
	float PlayerOx;
	Array lineD;
	Vector2f gravity;
	

	boolean movementL, collision, camera,posouvani;
	CollisionHandler collisionx;
	
	Box segline;
		
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
		boxX = 500;
		boxXposition = 500;
		boxY = 270;
		boxYposition = 270;
		collisionx = new CollisionHandler(this);
		oxgX = 0;
		oxgY = 0;
		PlayerOx = 100;
		PlayerEl = 100;
		gold = 0;
		
		gravity = new Vector2f(boxX+27/2,boxY);

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
				//boxXposition = boxXposition -1;

				if (ipositionX > lodX) {
					game1X = game1X + 1;
					lodX = lodX + 1;
					bubX = bubX + 1;
					oxgX = oxgX + 1;
					
					boxX = boxX+1;
				}
			}
			if(ipositionX == boxXposition+29 && lodY>=boxY-17 &&lodY<=boxY+27){
				boxX=boxX-1;
				posouvani = true;
				boxXposition = boxXposition -1;
				
			}else{
				posouvani = false;
			}

		}
		if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
			if (!collisionx.isOpaque((ipositionX + 49), ipositionY + 14)) {
				lodX = lodX + 1;
				ipositionX = ipositionX + 1;
				movementL = false;
				collision = false;
				PlayerOx = (float)(PlayerOx -0.05);
				//boxXposition = boxXposition +1;
				if (lodX > 250) {
					game1X = game1X - 1;
					lodX = lodX - 1;
					oxgX = oxgX - 1;
					bubX = bubX - 1;
					
					boxX = boxX -1;
					

				}
			} else {
				collision = true;
			}
		
			if(lodX == boxX-50 && lodY>=boxY-17 &&lodY<=boxY+27){
				boxX=boxX+1;
				posouvani = true;
				boxXposition = boxXposition +1;
				
			}else{
				posouvani = false;
			}

		}
		

		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			if (!collisionx.isOpaque(ipositionX + (49 / 2), ipositionY)) {
				lodY = lodY - 1;
				ipositionY = ipositionY - 1;
				//boxYposition = boxYposition -1;
				if (ipositionY > lodY) {
					game1Y = game1Y + 1;
					lodY = lodY + 1;
					
					bubY = bubY + 1;
					oxgY = oxgY + 1;
					
					boxY =boxY +1;
				}
			}
			if(ipositionY == boxYposition-17 && lodX>=boxY-29 &&lodX<=boxX-50){
				boxY=boxY-1;
				posouvani = true;
				boxYposition = boxYposition -1;
				
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
				//	boxYposition = boxYposition -1;
					boxY = boxY -1;
				//	boxYposition = boxYposition +1;
				}
			} else {
				collision = true;
			}
		}
		if(input.isKeyDown(Input.KEY_ENTER)){
		if(!collisionx.isOpaque(boxX,boxY+27)){
			boxY=boxY + 1;
		}else{
			boxY=boxY - 1;
		}
		}
		
		System.out.println(ipositionY+ "    "  + boxYposition);
		

	}

	public void render(GameContainer c, StateBasedGame game, Graphics g)
			throws SlickException {
		waterbackground.draw();
		if (movementL == true) {

			lodleft.draw(lodX, lodY);
		}
		if ((movementL == false)){
				//|| (!collisionx.isOpaque(ipositionX, ipositionY))) {

			lod.draw(lodX, lodY);
			if (collision == true) {
				hitlod.draw(lodX, lodY);
			}
		}
		boxD.draw(boxX,boxY);
		

		//bublina.draw(bubX, bubY);
		//boxD.draw(recX, recY);

		 bublina.draw(bubX,bubY);
		game1.draw(game1X, game1Y);
		//oxg.draw(oxgX, oxgY);
		if(ipositionX>=1714 && ipositionY<=103){
			g.drawString("chest",300,300);
			g.drawString("gold"+(gold+1), 10,100);
		}
		if(PlayerOx <= 0){
			dead.draw();
			
		}
		if(ipositionX <=1524 && ipositionX>=1384 && ipositionY<=464 && ipositionY>410){
			dead.draw();
		}
		g.drawString(Math.round(PlayerOx) + "oxygen", 10, 60);
		Input input = c.getInput();
		
		//segline.SegLine(4, 20, 30, 100, 50);

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
