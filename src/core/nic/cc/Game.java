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
	Image game1, lod, lodleft, waterbackground, bublina, hitlod, oxg, boxD,
			dead, truhla, notes1, notes2, note12, allnotes,allnotesButton1;
	int lodX, lodY, game1X, game1Y, ipositionX, ipositionY, bubX,
			bubY, oxgX, oxgY, PlayerEl, boxXposition, boxYposition, gold,
			speed, boxX, boxY, xn, x0, allnotesN, n;
	float PlayerOx, life;

	
	Objects BoxDown;
	
	Crate[] chest, box, notes;

	
	boolean movementL, collision, camera, posouvani, hit, chestEmpty, notesOn, ControlsOn, noteFind;
	CollisionHandler collisionx;


	public void init(GameContainer c, StateBasedGame game)
			throws SlickException {

		
		ControlsOn = true;
		chestEmpty = false;
		notesOn = false;
		hit = false;
		life = 1000;
		speed = 0;
		lodX = 100;
		movementL = false;
		collision = false;
		camera = false;
		noteFind = false;
		ipositionX = 100;
		allnotesN = 0;
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
		BoxDown = new Objects(this);

		

		dead = new Image("src/core/nic/cc/nic/dead.png");
		boxD = new Image("src/core/nic/cc/nic/DDD.jpg");
		oxg = new Image("src/core/nic/cc/nic/oxgenerator.png");
		hitlod = new Image("src/core/nic/cc/nic/hitlod.png");
		bublina = new Image("src/core/nic/cc/nic/bublina.png");
		game1 = new Image("src/core/nic/cc/nic/gamenwow2.png");
		lod = new Image("src/core/nic/cc/nic/lod12.png");
		waterbackground = new Image("src/core/nic/cc/nic/water123.png");
		lodleft = new Image("src/core/nic/cc/nic/lodleft.png");
		truhla = new Image("src/core/nic/cc/nic/chest1.png");
		notes1 = new Image("src/core/nic/cc/nic/notes.png");
		notes2 = new Image("src/core/nic/cc/nic/notes.png");
		note12 = new Image("src/core/nic/cc/nic/note1a.png");
		allnotes = new Image("src/core/nic/cc/nic/allnotes.png");
		allnotesButton1 = new Image("src/core/nic/cc/nic/allnotesbutton1.png");

		chest = new Crate[10];
		chest[1] = new Crate();
		chest[1].x = 1750;
		chest[1].y = 90;
		chest[2] = new Crate();
		chest[2].x = 1500;
		chest[2].y = 400;
		
		box = new Crate[20];
		box[1] = new Crate();
		box[1].x = 500;
		box[1].y = 270;
		
		notes = new Crate[10];
		notes[1] = new Crate();
		notes[1].x = 395;
		notes[1].y = 365;
		notes[2] = new Crate();
		notes[2].x = 200;
		notes[2].y = 270;
		
		
		

	}

	public void update(GameContainer c, StateBasedGame game, int delta)
			throws SlickException {
		Input input = c.getInput();
		
		if(ControlsOn == true){

		if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
			if (!collisionx.isOpaque(ipositionX, ipositionY + 14)) {
				lodX = lodX - 1;
				ipositionX = ipositionX - 1;
				movementL = true;
				PlayerOx = (float) (PlayerOx + 0.05);

				if (ipositionX > lodX) {
					game1X = game1X + 1;
					lodX = lodX + 1;
					bubX = bubX + 1;
					oxgX = oxgX + 1;
				
					for(int n=0; n<10; n++){
					notes[n].x = notes[n].x+1;
					//chest[n].x = chest[n].x+1;
					}
					boxX = boxX + 1;
				}
			}
			if (ipositionX == boxXposition + 29 && lodY >= boxY - 17
					&& lodY <= boxY + 27) {
				boxX = boxX - 1;
				posouvani = true;
				boxXposition = boxXposition - 1;

			} else {
				posouvani = false;
			}

		}
		if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
			if (!collisionx.isOpaque((ipositionX + 49), ipositionY + 14)) {
				lodX = lodX + 1;
				ipositionX = ipositionX + 1;
				movementL = false;
				collision = false;
				PlayerOx = (float) (PlayerOx - 0.05);
				// boxXposition = boxXposition +1;
				if (lodX > 250) {
					game1X = game1X - 1;
					lodX = lodX - 1;
					oxgX = oxgX - 1;
					bubX = bubX - 1;
					for(int n=0; n<10; n++){
					chest[n].x = chest[n].x-1; 
					box[n].x = box[n].x - 1;
					notes[1].x = notes[n].x-1;
					}
				}
			} else {
				collision = true;
			}

			if (lodX == box[1].x - 50 && lodY >= box[1].x - 17 && lodY <= box[1].y + 27) {
				box[1].x = box[1].x + 1;
				posouvani = true;
				boxXposition = boxXposition + 1;

			} else {
				posouvani = false;
			}

		}

		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			if (!collisionx.isOpaque(ipositionX + (49 / 2), ipositionY)) {
				lodY = lodY - 1;
				ipositionY = ipositionY - 1;
				if (ipositionY > lodY) {
					game1Y = game1Y + 1;
					lodY = lodY + 1;
					chest[1].y = chest[1].y+1; 
					bubY = bubY + 1;
					oxgY = oxgY + 1;
					
					for(int n=0; n<10; n++){
					box[n].y = box[n].y + 1;
					notes[n].y = notes[n].y +1;
					}
				}
					
			}
			if (ipositionY == boxYposition - 17 && lodX >= box[1].y - 29
					&& lodX <= box[1].x - 50) {
				box[1].y = box[1].y - 1;
				posouvani = true;
				boxYposition = boxYposition - 1;

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
					for(int n=0; n<10; n++){
					//chest[n].y = chest[n].y-1; 
					//box[n].y = box[n].y - 1;
					notes[1].y = notes[1].y -1;
					}
				}
			} else {
				collision = true;
			}
		}
		
		if (input.isKeyDown(Input.KEY_ENTER)) {
			if (!collisionx.isOpaque(box[1].x, box[1].y + 27)) {
				box[1].y = box[1].y + 1;
			} else {
				box[1].y = box[1].y - 1;
			}
		}
		if(PlayerOx<0){
			life = life-1;
			hit = true;
			
		}
		if(collision == true){
			life = life -5;
		
		}
		}
		if(input.isKeyDown(Input.KEY_TAB)) {
			
			notesOn = true;
			ControlsOn = false;
		}
		if(input.isKeyDown(Input.KEY_Q)){
			notesOn = false;
			ControlsOn = true;
		}
		if((ipositionX >= 350 && ipositionX<416)&& ( ipositionY >= 343 && ipositionY<= 379)){
			noteFind = true;
			
		}else{
			noteFind =false;
		}
		if(noteFind==true && allnotesN<1){
			allnotesN = allnotesN +1;
		}
		//if(chest[1].x >= ){}
		


		System.out.println(allnotesN);

	}

	public void render(GameContainer c, StateBasedGame game, Graphics g)
			throws SlickException {
		waterbackground.draw((float) (game1X - 0.5), (float) (game1Y - 0.5));
		if (movementL == true) {

			lodleft.draw(lodX, lodY);
		}
		if ((movementL == false)) {
			// || (!collisionx.isOpaque(ipositionX, ipositionY))) {

			lod.draw(lodX, lodY);
			if (collision == true) {
				hitlod.draw(lodX, lodY);
			}
		}

		boxD.draw(box[1].x,box[1].y);

		bublina.draw(bubX, bubY);
		game1.draw(game1X, game1Y);
		// oxg.draw(oxgX, oxgY);
		if (ipositionX >= 200 && ipositionY <= 300) {
			g.drawString("chest", 300, 300);
			if (gold<=1){
			gold = gold+1;
			g.drawString("gold: " + (gold), 10, 150);
			}
		}
		if (life <= 0) {
		dead.draw();

		}
		truhla.draw(chest[1].x, chest[1].y);
		if(allnotesN!=1){
		notes1.draw(notes[1].x,notes[1].y );
		noteFind =false;
		}
		notes2.draw(notes[2].x, notes[2].y);

		g.drawString("oxygen: " + Math.round(PlayerOx), 10, 60);
		g.drawString("life: " + Math.round(life), 10, 100);
		if(noteFind ==true){
			note12.draw();
			
		}
		
		
		Input input = c.getInput();
		
		if(notesOn == true){
				allnotes.draw();
				if(allnotesN >= 1){
					allnotesButton1.draw(150, 180);
				}
			
			}
		

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
