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

	private Random r = new Random();//this helps determine starting direction.
	Handler handler;//we need this to be able to loop through objects checking for collision
	public Ball(int xPosition, int yPosition, ID id, Handler handler) {
		super(xPosition, yPosition, id);
		this.handler = handler;
		xSpeed = r.nextInt((3 - -3) +1) -3;//random starting direction
		ySpeed = -3;

	}


	@Override//the tick method contains how the ball will move
	public void tick() {
		xPosition += xSpeed;//every tick it will move
		yPosition += ySpeed;
		if(xPosition < 0 || xPosition > 615) {//if it hits either wall bounce.
			xSpeed *= -1;
		}
		if(yPosition < 0) {//if it hits the ceiling bounce
			ySpeed *= -1;
		}
		if(yPosition > Launcher.HEIGHT)//if it goes beneath the floor
		{
			HUD.LIVES--;//subtract from lives
			xSpeed = r.nextInt((3 - -3) +1) -3;//choose a new random movement
			ySpeed = -3;
			xPosition = Launcher.WIDTH/2;//then move the ball back to starting position
			yPosition = Launcher.HEIGHT/2;
		}
		collision();//call the method that checks if we hit anything.
	}

	//the collision method loops through all objects checking if the ball
	//collided with any of them.
	public void collision() {
		for (int i = 0; i < handler.objects.size(); i++) {//loop through objects
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {//if the object is a paddle
				//paddle collision code
				if(getBounds().intersects(tempObject.getBounds())) {//did we collide?
				//if we collided check where on the paddle and bounce based on that.
					if((this.xPosition - tempObject.getxPosition()) < 10){
					 	this.ySpeed*=-3;
					  	this.xSpeed = -5;
					}else if((this.xPosition - tempObject.getxPosition()) < 20){
						 	this.ySpeed*=-3;
						  	this.xSpeed = -4;
					  }else if((this.xPosition - tempObject.getxPosition()) < 30){
						 	this.ySpeed*=-3;
						  	this.xSpeed = -3;
					  }else if((this.xPosition - tempObject.getxPosition()) < 45){
						 	this.ySpeed*=-3;
						  	this.xSpeed = -2;
					  }else if((this.xPosition - tempObject.getxPosition()) < 50){
						 	this.ySpeed*=-3;
						  	this.xSpeed = -1;
					  }else if((this.xPosition - tempObject.getxPosition()) == 50){
						 	this.ySpeed*=-3;
						  	this.xSpeed = 0;
					  }else if((this.xPosition - tempObject.getxPosition()) < 55){
						 	this.ySpeed*=-3;
						 	this.xSpeed = 1;
					  }else if((this.xPosition - tempObject.getxPosition()) < 70){
						 	this.ySpeed*=-3;
						  	this.xSpeed = 2;
					  }else if((this.xPosition - tempObject.getxPosition()) < 80){
						 	this.ySpeed*=-3;
						 	this.xSpeed = 3;
					  }else if((this.xPosition - tempObject.getxPosition()) < 90){
						 	this.ySpeed*=-3;
						  	this.xSpeed = 4;
					  }else {
						 	this.ySpeed*=-3;
						 	this.xSpeed = 5;
					  	}
				}
			}
			if(tempObject.getId() == ID.Brick) {//brick collison
			}	
		}
	}
	//the render() method draws the ball
	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(xPosition, yPosition, 20, 20);
	}

	// the getBounds() method allows us to check for collision.
	@Override
	public Rectangle getBounds() {
		return new Rectangle(xPosition,yPosition, 20, 20);//it is a rectangle but oh well
	}

}
