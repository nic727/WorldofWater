package core.nic.cc;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.Timer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class Menu extends BasicGameState{
	Image menu, buttonplay;
	public void init(GameContainer c, StateBasedGame game)throws SlickException{
		menu = new Image("src/core/nic/cc/nic/wow.jpg");
		buttonplay = new Image("src/core/nic/cc/nic/buttonplay.png");
	}
	public void render(GameContainer c, StateBasedGame game, Graphics g)throws SlickException{
		menu.draw();
		Input input = c.getInput();
		if(input.isKeyDown(Input.KEY_S)){
			buttonplay.draw();
		}
		
		//g.setColor(Color.green);
		//g.drawString("Why hello there", 250, 180);
		//g.fillRect(242, 242, 150, 32);
		
		
	}
	public void update(GameContainer c, StateBasedGame game, int delta)throws SlickException{
		Input input = c.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		
		if(input.isKeyDown(Input.KEY_ENTER)){
				
				game.enterState(2);
			
		
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
