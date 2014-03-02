package core.nic.cc;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Options extends BasicGameState {
	Image options;
	
	public void init(GameContainer c, StateBasedGame game)throws SlickException{
		options = new Image("src/core/nic/cc/nic/options.jpg");
	}
	public void update(GameContainer c, StateBasedGame game, int delta)throws SlickException{
		
	}
	public void render(GameContainer c, StateBasedGame game, Graphics g)throws SlickException{
		Input input = c.getInput();
		
		g.drawString("supp", 100, 100);
		g.fillOval(75, 100, 100, 100);
		options.draw();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
				game.enterState(0);
			}
		
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
