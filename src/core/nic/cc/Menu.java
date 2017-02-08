package core.nic.cc;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	private static AppGameContainer app;
	Image menu, buttonplay, buttons, podklad, optionsglow, exitglow;
	int active = -1;

	public void init(GameContainer c, StateBasedGame game) throws SlickException {

		buttonplay = new Image("src/core/nic/cc/nic/playglow2.png");
		optionsglow = new Image("src/core/nic/cc/nic/optionsglow2.png");
		exitglow = new Image("src/core/nic/cc/nic/exitglow2.png");
		buttons = new Image("src/core/nic/cc/nic/menu2buttons.png");
		podklad = new Image("src/core/nic/cc/nic/menu2.png");

	}

	public void render(GameContainer c, StateBasedGame game, Graphics g) throws SlickException {
		podklad.draw();
		buttons.draw();
		Input input = c.getInput();

		if (input.isKeyPressed(input.KEY_LEFT)) {
			active = Math.abs((active - 1) % 3);
		}
		if (input.isKeyPressed(input.KEY_RIGHT)) {
			active = (active + 1) % 3;
		}
		System.out.println("active " + active);

		switch (active) {
		case 0:
			buttonplay.draw();
			break;
		case 1:
			optionsglow.draw();
			break;
		case 2:
			exitglow.draw();
			break;
		default:
			System.out.println("None selected");
		}

	}

	public void update(GameContainer c, StateBasedGame game, int delta) throws SlickException {
		Input input = c.getInput();

		if (active == 0) {
			if (input.isKeyDown(Input.KEY_ENTER)) {
				active = -1;
				game.enterState(1);
			}

		}
		if (active == 1) {
			if (input.isKeyDown(Input.KEY_ENTER)) {
				game.enterState(2);
			}
		}
		if (active == 2) {
			if (input.isKeyDown(Input.KEY_ENTER)) {
				app.exit();
			}
		}
	}

	public int GetID() {
		return 0;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
