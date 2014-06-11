package core.nic.cc;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Options extends BasicGameState {
	Image options, buttonplay;
	int active;
	public void init(GameContainer c, StateBasedGame game)throws SlickException{
		options = new Image("src/core/nic/cc/nic/options.jpg");
		buttonplay = new Image("src/core/nic/cc/nic/buttonplay.png");
	}
	public void update(GameContainer c, StateBasedGame game, int delta)throws SlickException{
		
		Input input = c.getInput();
		if(active == 1){
			if(input.isKeyDown(Input.KEY_ENTER)){
				
				game.enterState(1);
			}
		
		}
		if(active == 2){
			if(input.isKeyDown(Input.KEY_ENTER)){
				game.enterState(2);
			}
		}
		if(active == 3){
			if(input.isKeyDown(Input.KEY_ENTER)){
				game.enterState(0);
			}
		}
		
	}
	public void render(GameContainer c, StateBasedGame game, Graphics g)throws SlickException{
		Input input = c.getInput();
		options.draw();
//		if(input.isKeyDown(Input.KEY_A)){
//			active = 1;
//			
//		}
//		
//		if(active == 1){
//			buttonplay.draw();
//			if(input.isKeyDown(Input.KEY_S)){
//				active = 2;
//				
//			}
//			
//		}
//		if(active == 2){
//			buttonplay.draw(0, 63);
//		
//		}
//		
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
				game.enterState(0);
		}
		}
		
		
		
	
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
