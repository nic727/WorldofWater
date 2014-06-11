package core.nic.cc;

import java.sql.Array;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
	Image game1, lod, lodleft, waterbackground, bublina, hitlod, oxg, boxD,
			dead, truhla, notes1, notes2, note12, allnotes, allnotesButton1,CircleSprite,
			playAgain, buttonReturnglow, QuitGame, playAgainglow, QuitGameglow,
			buttonReturn, utesy, gameOptions, coin;
	int lodX, lodY, game1X, game1Y, ipositionX, ipositionY, bubX, bubY, oxgX,
			oxgY, PlayerEl, boxXposition, boxYposition, gold, speed, boxX,
			boxY, xn, x0, allnotesN, n, activeButton;
	float PlayerOx, life;

	Objects BoxDown;

	Crate[] chest, box, notes, coins;

	boolean movementL, collision, camera, posouvani, hit, chestEmpty, notesOn,
			ControlsOn, noteFind, optionsOn, oxygen, coinThere;
	CollisionHandler collisionx;
	SpriteSheet ballspritesheet, lifeBar, oxbar;
	Animation ballss, lifeBarAnimation;

	public void init(GameContainer c, StateBasedGame game)
			throws SlickException {

		restart();

		coin = new Image("src/core/nic/cc/nic/coin.png");
		buttonReturnglow = new Image("src/core/nic/cc/nic/buttonReturnglow.png");
		buttonReturn = new Image("src/core/nic/cc/nic/buttonReturn.png");
		gameOptions = new Image("src/core/nic/cc/nic/gameOptions.png");
		utesy = new Image("src/core/nic/cc/nic/utesy.png");
		playAgain = new Image("src/core/nic/cc/nic/playAgain.png");
		playAgainglow = new Image("src/core/nic/cc/nic/playAgainglow.png");
		dead = new Image("src/core/nic/cc/nic/dead2.png");
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
		QuitGame = new Image("src/core/nic/cc/nic/QuitGame.png");
		QuitGameglow = new Image("src/core/nic/cc/nic/QuitGameglow.png");
		CircleSprite = new Image("src/core/nic/cc/nic/CircleSpriteSheet.png");
		
		ballspritesheet = new SpriteSheet("src/core/nic/cc/nic1/bubblesOx.png", (113/2), 87);
		ballss = new Animation(ballspritesheet,60 );
		
		lifeBar = new SpriteSheet("src/core/nic/cc/nic1/healthbar.png", 126,18);
		lifeBarAnimation = new Animation(lifeBar, 100);

		oxbar = new SpriteSheet("src/core/nic/cc/nic1/oxbar.png", 126,18);
	}

	void restart() {
		
		oxygen = false;
		optionsOn = false;
		game1X = 0;
		game1Y = 0;
		activeButton = 0;
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
		bubX = 210;
		bubY = 290;
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
		coinThere = true;
		BoxDown = new Objects(this);

		chest = new Crate[10];
		chest[0] = new Crate();
		chest[0].x = 1750;
		chest[0].y = 90;
		chest[1] = new Crate();
		chest[1].x = 1500;
		chest[1].y = 400;

		box = new Crate[20];
		box[0] = new Crate();
		box[0].x = 500;
		box[0].y = 270;
		box[1] = new Crate();
		box[1].x = 600;
		box[1].y = 300;

		notes = new Crate[10];
		notes[0] = new Crate();
		notes[0].x = 395;
		notes[0].y = 365;
		notes[1] = new Crate();
		notes[1].x = 545;
		notes[1].y = 265;
		System.out.println("cus");
		
		coins = new Crate[20];
		coins[0] = new Crate();
		coins[0].x = 400;
		coins[0].y = 300;
		coins[1] = new Crate();
		coins[1].x = 350;
		coins[1].y = 200;

	}

	public void update(GameContainer c, StateBasedGame game, int delta)
			throws SlickException {
		Input input = c.getInput();

		if (ControlsOn == true) {

			if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
				if (!collisionx.isOpaque(ipositionX, ipositionY + 14)) {
					lodX = lodX - 1;
					ipositionX = ipositionX - 1;
					movementL = true;
					//PlayerOx = (float) (PlayerOx + 0.05);

					if (ipositionX > lodX) {
						game1X = game1X + 1;
						lodX = lodX + 1;
						bubX = bubX + 1;
						oxgX = oxgX + 1;

						for (int n = 0; n <= 1; n++) {

							notes[n].x = notes[n].x + 1;

							chest[n].x = chest[n].x + 1;
							coins[n].x = coins[n].x +1;
						}
						boxX = boxX + 1;
					}
				}
				if (collisionx.isHit(ipositionX, ipositionY + 14)) {
					collision = true;

				}
				if(collisionx.isOxygen(ipositionX, ipositionY +14)){
					oxygen = true;
					if(PlayerOx<100){
						PlayerOx = PlayerOx+1;
					}
				}else{
					oxygen = false;
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
			if (input.isKeyDown(Input.KEY_D)
					|| input.isKeyDown(Input.KEY_RIGHT)) {
				if (!collisionx.isOpaque((ipositionX + 49), ipositionY + 14)) {
					lodX = lodX + 1;
					ipositionX = ipositionX + 1;
					movementL = false;
					collision = false;
					//PlayerOx = (float) (PlayerOx - 0.05);
					// boxXposition = boxXposition +1;
					if (lodX > 250) {
						game1X = game1X - 1;
						lodX = lodX - 1;
						oxgX = oxgX - 1;
						bubX = bubX - 1;
						for (int n = 0; n <= 1; n++) {

							chest[n].x = chest[n].x - 1;
							coins[n].x = coins[n].x -1;
							box[n].x = box[n].x - 1;
							notes[n].x = notes[n].x - 1;
						}
					}
				}
				if (collisionx.isHit(ipositionX + 49, ipositionY + 14)) {
					collision = true;
				}
				if(collisionx.isOxygen(ipositionX+49, ipositionY +14)){
					oxygen = true;
					if(PlayerOx<100){
						PlayerOx = PlayerOx+1;
					}
				}else{
					oxygen = false;
				}
				

				if (lodX == box[1].x - 50 && lodY >= box[1].x - 17
						&& lodY <= box[1].y + 27) {
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
						chest[1].y = chest[1].y + 1;
						bubY = bubY + 1;
						oxgY = oxgY + 1;

						for (int n = 0; n <= 1; n++) {

							box[n].y = box[n].y + 1;
							notes[n].y = notes[n].y + 1;
							coins[n].y = coins[n].y +1;
						}
					}

				}
				if(collisionx.isOxygen(ipositionX+(49/2), ipositionY)){
					oxygen = true;
					if(PlayerOx<100){
						PlayerOx = PlayerOx+1;
					}
				}else{
					oxygen = false;
				}
				if (collisionx.isHit(ipositionX + (49 / 2), ipositionY)) {
					collision = true;
				}
				
				if (ipositionY == boxYposition - 17 && lodX >= box[1].y - 29
						&& lodX <= box[1].x - 50) {
					box[1].y = box[1].y - 1;
					posouvani = true;
					boxYposition = boxYposition - 1;

				}
			}
			if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
				if (!collisionx
						.isOpaque(ipositionX + (49 / 2), ipositionY + 28)) {
					lodY = lodY + 1;
					ipositionY = ipositionY + 1;
					collision = false;

					if (lodY > 200) {
						game1Y = game1Y - 1;
						lodY = lodY - 1;
						bubY = bubY - 1;
						oxgY = oxgY - 1;

						for (int n = 0; n <= 1; n++) {
							chest[n].y = chest[n].y - 1;

							box[n].y = box[n].y - 1;
							coins[n].y = coins[n].y -1;
							notes[n].y = notes[n].y - 1;
						}

					}
				}
				if(collisionx.isOxygen(ipositionX+(49/2), ipositionY+28)){
					oxygen = true;
					if(PlayerOx<100){
						PlayerOx = PlayerOx+1;
					}
				}else{
					oxygen = false;
				}
				if (collisionx.isHit(ipositionX + (49 / 2), ipositionY + 28)) {
					collision = true;
				}
			}
			

			if (input.isKeyDown(Input.KEY_ENTER)) {
				if (!collisionx.isOpaque(box[0].x, box[0].y + 27)) {
					box[0].y = box[0].y + 1;
				} else {
					box[0].y = box[0].y - 1;
				}
			}
			if (PlayerOx < 0) {
				life = life - 1;
				hit = true;

			}
			if (collision == true) {
				life = life - 5;

			}
		}
		if (input.isKeyDown(Input.KEY_ESCAPE)) {

			optionsOn = true;
		}

		if (input.isKeyDown(Input.KEY_Q)) {
			notesOn = false;
			ControlsOn = true;
			optionsOn = false;
		}
		
		if (life <= 0) {
			ControlsOn = false;
		}
		// if(chest[1].x >= ){}
		notes(c);
		
//		for(int i = 0; i<=11; i++){
//			
//			
//			System.out.println(ballss.getImage(i));
		//}
		
		PlayerOx = (float) (PlayerOx - 0.05);
		
	
		
	}
	void notes(GameContainer c){
 
		
		
		Input input = c.getInput();
		
		if (input.isKeyDown(Input.KEY_TAB)) {

			notesOn = true;
			ControlsOn = false;
		}

		if ((ipositionX >= 350 && ipositionX < 416)
				&& (ipositionY >= 343 && ipositionY <= 379)) {
			allnotesN = 1;

		}
		if ((ipositionX >= 500 && ipositionX < 566)
				&& (ipositionY >= 243 && ipositionY <= 279)) {
			allnotesN =2;
		}
		
	}	
//		if ((ipositionX >= 350 && ipositionX < 416)
//				&& (ipositionY >= 343 && ipositionY <= 379)) {
//			allnotesN = 1;
//
//		} else {
//			noteFind = false;
//		}
		
//		if ((ipositionX >= 500 && ipositionX < 566)
//				&& (ipositionY >= 243 && ipositionY <= 279)) {
//			noteFind = true;
//		}else{
//			noteFind = false;
//		}
			
//		if (noteFind == true && allnotesN < 1) {
//			allnotesN = allnotesN + 1;
//		}
//		if (noteFind == true && allnotesN > 1 && allnotesN<2) {
//			allnotesN = allnotesN + 1;
//		}
//		
//		if (input.isKeyDown(Input.KEY_DOWN)){
//			activeButton = 1;}
//		
//		
//		
//	}
	
	void chest(GameContainer c){
		
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

		//boxD.draw(box[0].x, box[0].y);

		
		ballss.draw(bubX, bubY);
		ballss.draw(bubX+400, bubY+25);
		game1.draw(game1X, game1Y);
		// oxg.draw(oxgX, oxgY);
		if (ipositionX >= 200 && ipositionY <= 300) {
			g.drawString("chest", 300, 300);
			if (gold <= 1) {
				gold = gold + 1;
				g.drawString("gold: " + (gold), 10, 150);
			}
		}
		truhla.draw(chest[0].x, chest[0].y);
		
		notes(c,game,g);
		 
		spriteSheets(c, game, g);
		
		
		g.drawString("oxygen: " + Math.round(PlayerOx), 10, 60);
		g.drawString("life: " + Math.round(life), 10, 100);
		if (noteFind == true) {
			note12.draw();

		}
		if(oxygen ==true){
			g.drawString("jeeeej new oxygen", 10, 130);
		}

		Input input = c.getInput();
		
		

		if (notesOn == true) {
			allnotes.draw();
			if (allnotesN >= 1) {
				allnotesButton1.draw(150, 180);
			}

		}
		
		options(c,game,g);
		deadScreen(c,game,g);
		

	}
	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	
	
	void spriteSheets(GameContainer c, StateBasedGame game, Graphics g){

		if(life<=1000 && life>=900){
			lifeBar.getSprite(0, 0).draw(10,120);
		}
		if(life<900 && life>=800){
			lifeBar.getSprite(0, 1).draw(10,120);
		}
		if(life<800 && life>=700){
			lifeBar.getSprite(0, 2).draw(10,120);
		}
		if(life<700 && life>=600){
			lifeBar.getSprite(0, 3).draw(10,120);
		}
		if(life<600 && life>=500){
			lifeBar.getSprite(0, 4).draw(10,120);
		}
		if(life<500 && life>=400){
			lifeBar.getSprite(0, 5).draw(10,120);
		}
		if(life<400 && life>=300){
			lifeBar.getSprite(0, 6).draw(10,120);
		}
		if(life<300 && life>=200){
			lifeBar.getSprite(0, 7).draw(10,120);
		}
		if(life<200 && life>=100){
			lifeBar.getSprite(0, 8).draw(10,120);
		}
		if(life<100 && life>=0){
			lifeBar.getSprite(0, 9).draw(10,120);
		}
		
		
		if(PlayerOx<=101 && PlayerOx>=90){
			oxbar.getSprite(0, 0).draw(10,80);
		}
		if(PlayerOx<90 && PlayerOx>=80){
			oxbar.getSprite(0, 1).draw(10,80);
		}
		if(PlayerOx<80 && PlayerOx>=70){
			oxbar.getSprite(0, 2).draw(10,80);
		}
		if(PlayerOx<70 && PlayerOx>=60){
			oxbar.getSprite(0, 3).draw(10,80);
		}
		if(PlayerOx<60 && PlayerOx>=50){
			oxbar.getSprite(0, 4).draw(10,80);
		}
		if(PlayerOx<50 && PlayerOx>=40){
			oxbar.getSprite(0, 5).draw(10,80);
		}
		if(PlayerOx<40 && PlayerOx>=30){
			oxbar.getSprite(0, 6).draw(10,80);
		}
		if(PlayerOx<30 && PlayerOx>=20){
			oxbar.getSprite(0, 7).draw(10,80);
		}
		if(PlayerOx<20 && PlayerOx>=10){
			oxbar.getSprite(0, 8).draw(10,80);
		}
		if(PlayerOx<10 && PlayerOx>=0){
			oxbar.getSprite(0, 9).draw(10,80);
		}

	}
	
	void options(GameContainer c, StateBasedGame game, Graphics g){
		
		Input input = c.getInput();
		
		if (optionsOn == true) {
			ControlsOn = false;
			gameOptions.draw();
			buttonReturn.draw(240, 200);
			if (activeButton ==1) {
				buttonReturnglow.draw(240, 200);
				if(input.isKeyDown(Input.KEY_A)){
					game.enterState(0);
				}
			
			}

		} else {
			optionsOn = false;
		}

	}
	
	void notes(GameContainer c, StateBasedGame game, Graphics g){
		Input input = c.getInput();
		if (allnotesN == 1) {
			notes1.draw(notes[0].x, notes[0].y);
		
			}
		if(allnotesN !=2){
			notes1.draw(notes[1].x, notes[1].y);
		}
		}
		
	
	void deadScreen(GameContainer c, StateBasedGame game, Graphics g){
		Input input = c.getInput();
		
		if (life <= 0) {
			dead.draw();
			playAgain.draw(200, 240);
			QuitGame.draw(350, 240);
			if (activeButton == 0) {
				playAgainglow.draw(200, 240);
				if (input.isKeyDown(Input.KEY_A)) {
					restart();
					game1.draw(game1X, game1Y);
				}
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
				activeButton = 1;
			}
			if (activeButton == 1) {
				playAgainglow.draw(200, 240);
				if (input.isKeyDown(Input.KEY_A)) {
					restart();
					game1.draw(game1X, game1Y);
				}
			}
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				activeButton = 2;
			}
			if (activeButton == 2) {
				QuitGameglow.draw(350, 240);
				if (input.isKeyDown(Input.KEY_A)) {
					restart();
					game.enterState(0);
				}
			}

		}

	}
}
