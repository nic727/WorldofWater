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
	public Rectangle BoxDown(float x,float y, float width, float height){
		height = 29;
		width = 29;
		yp = game.boxYposition+29;
		xp = game.boxXposition;
		z = game.boxXposition;
		vzdalenost = yp-game.boxXposition;
		BoxDown(x,y, 29,29);
		for(yp=game.boxYposition; yp<=100; yp++ ){
			if(!collisionx.isOpaque((xp), (yp+1))){
				yp = yp+1;
				System.out.println(yp);
		}
			else{
				 BoxDown.transform(Transform.createRotateTransform((float) Math.cos(vzdalenost/height), xp, yp ));
			}
		}
		
		return BoxDown;
	}
	public Rectangle BoxUp(float x,float y, float width, float height){
		
		
		return BoxUp;
	}
	public void draw(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}

}
