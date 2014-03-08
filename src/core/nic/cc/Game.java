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
	Image game1, lod, waterbackground;
	int lodX, lodY, game1X, game1Y, ipositionX, ipositionY;
	Shape rect;
	boolean collision;
	
	public void init(GameContainer c, StateBasedGame game)throws SlickException{
		lodX = -100;
		
		ipositionX = -100;
		ipositionY = 0;
		//-150 x = 0
		lodY = 0;
		game1 = new Image("src/core/nic/cc/nic/game.png");
		lod = new Image("src/core/nic/cc/nic/lod1.png");
		waterbackground = new Image("src/core/nic/cc/nic/water.jpg");
		
	}
	public void update(GameContainer c, StateBasedGame game,int delta)throws SlickException{
		Input input = c.getInput();
		

		
		if(input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)){
				
				lodX = lodX -1;
				ipositionX = ipositionX-1;
			
				if(lodX<150 && game1X<640 && game1X>0){
				game1X = game1X +1;
				lodX = lodX +1;
			}
			
			
		}
		if(input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)){
			if(lodX + 1 != 300){
			lodX = lodX +1;
			ipositionX = ipositionX +1;
				if(lodX>200){
					game1X = game1X -1;
					lodX = lodX -1;
				}
			
			}
		}
		if(input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP)){
			lodY = lodY -1;
			ipositionY = ipositionY -1;
			if(lodY<50 && game1Y>0){
				game1Y = game1Y +1;
				lodY = lodY +1;
			}
		}
		if(input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)){
			lodY = lodY +1;
			ipositionY = ipositionY +1;
			if(lodY>150){
				game1Y = game1Y-1;
				lodY = lodY -1;
			}
		}
		System.out.println(ipositionX +","+ ipositionY);
			
	}
	//public void Collision(boolean collision){
		//if(lodX-1 == rectX){
			//collision = true;
			//if(collision ==true){
				//lodX = lodX +1;
			//}
		//}
	//}
	public void render(GameContainer c, StateBasedGame game, Graphics g)throws SlickException{
		waterbackground.draw();
		lod.draw(lodX, lodY);
		game1.draw(game1X,game1Y);
		//g.fillRect(300, 200, 100, 100);
		
		Input input = c.getInput();
		
		if(input.isKeyDown(input.KEY_ESCAPE)){
			game.enterState(0);
			
		}
		
		
		
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
