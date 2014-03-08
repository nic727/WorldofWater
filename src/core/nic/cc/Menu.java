package core.nic.cc;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.Timer;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class Menu extends BasicGameState{
	private static AppGameContainer app;
	Image menu, buttonplay;
	int active = 0;
	
	public void init(GameContainer c, StateBasedGame game)throws SlickException{
		menu = new Image("src/core/nic/cc/nic/wow.jpg");
		buttonplay = new Image("src/core/nic/cc/nic/buttonplay.png");
		
		
	}
	public void render(GameContainer c, StateBasedGame game, Graphics g)throws SlickException{
		menu.draw();
		Input input = c.getInput();
		if(input.isKeyDown(Input.KEY_A)){
			active = 1;
			
		}
		
		if(active == 1){
			buttonplay.draw();
			if(input.isKeyDown(Input.KEY_S)){
				active = 2;
				
			}
			
		}
		if(active == 2){
			buttonplay.draw(0, 63);
			if(input.isKeyDown(Input.KEY_D)){
				active = 3;
			}
		}
		if(active == 3){
			buttonplay.draw(0, 135);
		}
		
		
		//g.setColor(Color.green);
		//g.drawString("Why hello there", 250, 180);
		//g.fillRect(242, 242, 150, 32);
		
		
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
				app.exit();
			}
		}
	}
	public int GetID(){
		return 0;
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
