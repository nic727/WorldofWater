package core.nic.cc;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class Asdf extends StateBasedGame{
	
	private AppGameContainer container;
	private static AppGameContainer app;
	
	
	
	public static void main(String[] args){
		try {
			app = new AppGameContainer(new Asdf("game"));
		} catch (SlickException e) {

			e.printStackTrace();
		}

		app.setSmoothDeltas(true);
		app.setTargetFrameRate(60);
		app.setVSync(true);

		app.setVerbose(false);
		app.setShowFPS(true);

		try {
			app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Asdf(String name){
		super(name);
	}
	
	public void initStatesList(GameContainer c) throws SlickException{
		addState(new Menu());
		//addState(new Game();
		addState(new Options());
		//addState(new Exit();
	
	}
	public void ChangeState(){
		
	}
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
		if (key == Input.KEY_Q) {
			if (container != null) {
				try {
					container.setFullscreen(!container.isFullscreen());
					if (container.isFullscreen()) {
						container.setMouseGrabbed(true);
					} else
						container.setMouseGrabbed(false);
				} catch (SlickException e) {
					Log.error(e);
				}

			}

		}

	}

}
