package core.nic.cc;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
	Image game1, lod;
	int lodX, lodY, game1X, game1Y;
	
	public void init(GameContainer c, StateBasedGame game)throws SlickException{
		lodX = 100;
		lodY = 70;
		
		game1 = new Image("src/core/nic/cc/nic/game.jpg");
		lod = new Image("src/core/nic/cc/nic/lod1.png");
	}
	public void update(GameContainer c, StateBasedGame game,int delta)throws SlickException{
		Input input = c.getInput();
		if(input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)){
			lodX = lodX -1;
			if(lodX<100){
				game1X = game1X +1;
				lodX = lodX +1;
			}
			
		}
		if(input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)){
			lodX = lodX +1;
				if(lodX>200){
					game1X = game1X -1;
					lodX = lodX -1;
			
			}
		}
		if(input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP)){
			lodY = lodY -1;
			if(lodY<150){
				game1Y = game1Y +1;
				lodY = lodY +1;
			}
		}
		if(input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)){
			lodY = lodY +1;
			if(lodY>150){
				game1Y = game1Y-1;
				lodY = lodY -1;
			}
		}
	}
	public void render(GameContainer c, StateBasedGame game, Graphics g)throws SlickException{
		game1.draw(game1X,game1Y);
		lod.draw(lodX, lodY);
		Input input = c.getInput();
		
		if(input.isKeyDown(input.KEY_ESCAPE)){
			game.enterState(0);
		}
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
