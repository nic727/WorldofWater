package core.nic.cc;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{
	private static AppGameContainer app;
	Image menu, buttonplay, buttons, podklad,optionsglow, exitglow;
	int active = 0;
	
	public void init(GameContainer c, StateBasedGame game)throws SlickException{
		
		buttonplay = new Image("src/core/nic/cc/nic/playglow2.png");
		optionsglow = new Image("src/core/nic/cc/nic/optionsglow2.png");
		exitglow = new Image("src/core/nic/cc/nic/exitglow2.png");
		buttons = new Image("src/core/nic/cc/nic/menu2buttons.png");
		podklad = new Image("src/core/nic/cc/nic/wowmenu.png");
		
		
	}
	public void render(GameContainer c, StateBasedGame game, Graphics g)throws SlickException{
		podklad.draw();
		buttons.draw();
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
			optionsglow.draw();
			if(input.isKeyDown(Input.KEY_D)){
				active = 3;
			}
		}
		if(active == 3){
			exitglow.draw();
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
