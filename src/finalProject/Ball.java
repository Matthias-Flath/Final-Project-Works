package finalProject;
import java.awt.*;
import java.util.Random;
/*This is the ball that bounces around the screen destroying bricks.
 * the player controls the paddle to keep it from falling off the bottom of the screen
 * when it goes off the bottom of the screen it goes back to the center
 * and takes away a life when it destroys a brick it should add score. 
 * 
 */

public class Ball extends GameObject{
	
	private Random r;
	private static int tempScore = 0; //score used to keep track of bricks destroyed
	static int ballCount;
	public int diameter;
	private Handler handler;//we need this to be able to loop through objects checking for collision
	
	public Ball(int xPosition, int yPosition, ID id, Handler handler) {
		super(xPosition, yPosition, id);
		this.handler = handler;
		ballCount++;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		xSpeed = 3;
		ySpeed = 1;
		diameter = 20;
	}

	// Ball movement
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
			if (HUD.LIVES > 0) { //if lives are remaining
			
			HUD.LIVES--;//subtract from lives
				
			resetPos(); // resets ball position
			}
			
			else { //if no lives are remaining
				xPosition = Launcher.WIDTH/2;
				yPosition = Launcher.HEIGHT + 200; //locks the ball off-screen
			}
		}
		collision();
	}
	
	public void resetPos() {
		xSpeed = 3;//choose a new random movement
		ySpeed = -3;
		
		xPosition = Launcher.WIDTH/2;//then move the ball back to starting position
		yPosition = Launcher.HEIGHT/2;
	}
	
	public void collision() {
		for (int i = 0; i < handler.objects.size(); i++) {//loop through objects
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {//if the object is a paddle
				//paddle collision code
				if(getBounds().intersects(tempObject.getBounds())) {//did we collide?
				//if we collided check where on the paddle and bounce based on that.
					if((this.xPosition - tempObject.getxPosition()) < 10){
					 	this.ySpeed =-3;
					  	this.xSpeed = -5;
					}else if((this.xPosition - tempObject.getxPosition()) < 20){
						 	this.ySpeed =-3;
						  	this.xSpeed = -4;
					  }else if((this.xPosition - tempObject.getxPosition()) < 30){
						 	this.ySpeed =-3;
						  	this.xSpeed = -3;
					  }else if((this.xPosition - tempObject.getxPosition()) < 45){
						 	this.ySpeed =-3;
						  	this.xSpeed = -2;
					  }else if((this.xPosition - tempObject.getxPosition()) < 50){
						 	this.ySpeed =-3;
						  	this.xSpeed = -1;
					  }else if((this.xPosition - tempObject.getxPosition()) == 50){
						 	this.ySpeed =-3;
						  	this.xSpeed = 0;
					  }else if((this.xPosition - tempObject.getxPosition()) < 55){
						 	this.ySpeed =-3;
						 	this.xSpeed = 1;
					  }else if((this.xPosition - tempObject.getxPosition()) < 70){
						 	this.ySpeed =-3;
						  	this.xSpeed = 2;
					  }else if((this.xPosition - tempObject.getxPosition()) < 80){
						 	this.ySpeed =-3;
						 	this.xSpeed = 3;
					  }else if((this.xPosition - tempObject.getxPosition()) < 90){
						 	this.ySpeed =-3;
						  	this.xSpeed = 4;
					  }else {
						 	this.ySpeed =-3;
						 	this.xSpeed = 5;
					  	}
				}
			}
			if(tempObject.getId() == ID.Brick) {//brick collision
				if(getBounds().intersects(tempObject.getBounds())) {
					
					this.ySpeed = this.ySpeed * -1;
					
					HUD.SCORE = HUD.SCORE + 100;
					tempScore = tempScore + 100;
					
					tempObject.setyPosition(tempObject.getyPosition() - Launcher.HEIGHT); // Bricks are moved off-screen when hit
					
					//checks if room is empty
					if (tempScore >= 3200) {
						tempScore = 0;
						resetPos();
						Launcher.addBricks();
					}
				}
			}	
		}
	}
	
	
	public void render(Graphics g) {
		//draw the tail of the ball. 
		g.setColor(Color.WHITE);
		g.fillOval(xPosition - 8*xSpeed, yPosition -8*ySpeed , diameter, diameter);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(xPosition - 6*xSpeed, yPosition -6*ySpeed, diameter, diameter);
		
		g.setColor(Color.GRAY);
		g.fillOval(xPosition -4*xSpeed, yPosition -4*ySpeed, diameter, diameter);
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(xPosition - 2*xSpeed, yPosition - 2*ySpeed, diameter, diameter);
		//draw the ball
		g.setColor(Color.BLACK);
		g.fillOval(xPosition, yPosition, diameter, diameter);
		
	
	}

	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(xPosition, yPosition, diameter, diameter);
	}
}