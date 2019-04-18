package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
/*This is the ball that bounces around the screen destroying bricks.
 * the player controls the paddle to keep it from falling off the bottom of the screen
 * when it goes off the bottom of the screen it goes back to the center
 * and takes away a life when it destroys a brick it should add score.
 * 
 */

public class Ball extends GameObject {

	private Random r = new Random();
	Handler handler;
	public Ball(int xPosition, int yPosition, ID id, Handler handler) {
		super(xPosition, yPosition, id);
		this.handler = handler;
		xSpeed = r.nextInt((3 - -3) +1) -3;
		ySpeed = -3;

	}


	@Override
	public void tick() {
		xPosition += xSpeed;
		yPosition += ySpeed;
		if(xPosition < 0 || xPosition > 615) {
			xSpeed *= -1;
		}
		if(yPosition < 0) {
			ySpeed *= -1;
		}
		if(yPosition > Launcher.HEIGHT)
		{
			HUD.LIVES--;
			xSpeed = r.nextInt((3 - -3) +1) -3;
			ySpeed = r.nextInt((3 - -3) +1) -3;
			if(xSpeed == 0) {
				xSpeed = 1;
			}
			if(ySpeed == 0) {
				ySpeed = 1;
			}
			xPosition = Launcher.WIDTH/2;
			yPosition = Launcher.HEIGHT/2;
		}
		collision();
	}

	public void collision() {
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {
				//paddle collision code
				if(getBounds().intersects(tempObject.getBounds())) {
					if((this.xPosition - tempObject.getxPosition()) < 10){
					 	this.ySpeed*=-1;
					  	this.xSpeed = -5;
					}else if((this.xPosition - tempObject.getxPosition()) < 20){
						 	this.ySpeed*=-1;
						  	this.xSpeed = -4;
					  }else if((this.xPosition - tempObject.getxPosition()) < 30){
						 	this.ySpeed*=-1;
						  	this.xSpeed = -3;
					  }else if((this.xPosition - tempObject.getxPosition()) < 45){
						 	this.ySpeed*=-1;
						  	this.xSpeed = -2;
					  }else if((this.xPosition - tempObject.getxPosition()) < 50){
						 	this.ySpeed*=-1;
						  	this.xSpeed = -1;
					  }else if((this.xPosition - tempObject.getxPosition()) == 50){
						 	this.ySpeed*=-1;
						  	this.xSpeed = 0;
					  }else if((this.xPosition - tempObject.getxPosition()) < 55){
						 	this.ySpeed*=-1;
						 	this.xSpeed = 1;
					  }
					  else if((this.xPosition - tempObject.getxPosition()) < 70){
						 	this.ySpeed*=-1;
						  	this.xSpeed = 2;
					  }else if((this.xPosition - tempObject.getxPosition()) < 80){
						 	this.ySpeed*=-1;
						 	this.xSpeed = 3;
					  }else if((this.xPosition - tempObject.getxPosition()) < 90){
						 	this.ySpeed*=-1;
						  	this.xSpeed = 4;
					  }else {
						 	this.ySpeed*=-1;
						 	this.xSpeed = 5;
					  	}
				}
			}
			if(tempObject.getId() == ID.Brick) {//brick collison
			}	
		}
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(xPosition, yPosition, 20, 20);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(xPosition,yPosition, 20, 20);
	}

}
