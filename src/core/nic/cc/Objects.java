package core.nic.cc;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Transform;


public class Objects {
	Game game;
	boolean gravity;
	Rectangle BoxDown, BoxUp;
	int xp,yp, z;
	CollisionHandler collisionx;
	float vzdalenost;
	
	public Objects(Game gam){
		game = gam;
		
	}
	public int BoxDown(float x,float y){
		int height = 27;
		int width = 27;
		yp = game.boxY+27;
		xp = game.boxX;
	//	z = game.boxXposition;
		vzdalenost = yp-game.boxY;
		

		for(yp=game.boxY; yp<=100; yp++ ){
			if(!collisionx.isOpaque((xp), (yp+1))){
				yp = yp+1;
				
		}
			else{
				 BoxDown.transform(Transform.createRotateTransform((float) Math.cos(vzdalenost/height), xp, yp ));
			}
		}
		System.out.println(yp);
		
		return xp;
	}
	
	
		// TODO Auto-generated method stub
		
	}

