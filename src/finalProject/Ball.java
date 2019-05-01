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
	
	private Random r = new Random();
	private static int tempScore = 0; //score used to keep track of bricks destroyed
	
	public int diameter;
	private Handler handler = new Handler();//we need this to be able to loop through objects checking for collision
	
	// Item related
	private static boolean pierce = false;
	private static int pierceTime = 0;
	
	private static boolean crazy = false;
	private static int crazyTime = 0;
	
	private static boolean fast = false;
	private static int fastTime = 0;
	
	public Ball(int xPosition, int yPosition, ID id, Handler handler) {
		super(xPosition, yPosition, id);
		this.handler = handler;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		
		if (fast == false) {
		xSpeed = r.nextInt(6) - 3;
		ySpeed = 1;
		}
		
		else {
			xSpeed = 2 * (r.nextInt(6) - 3);
			ySpeed = 2;
		}
		
		diameter = 20;
	}

	//Item related  
	public static void setPierce() {
		pierce = true;
		pierceTime = 350;
	}
	
	public static void setCrazy() {
		crazy = true;
		crazyTime = 350;
	}
	
	public static void setFast() {
		fast = true;
		fastTime = 350;
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
			HUD.LIVES--;
			if (HUD.LIVES >= 0) { //if lives are remaining
			resetPos(); // resets ball position
			}
			else { 
				HUD.LIVES--;//if no lives are remaining
				xPosition = Launcher.WIDTH/2;
				yPosition = Launcher.HEIGHT + 200; //locks the ball off-screen
			}
		}
		
		if (crazy == true && crazyTime % 10 == 0)
			crazy();
		
		collision();
		
		//item related
		if (pierceTime > 0)
			pierceTime--;
		
		else
			pierce = false;
		
		if (crazyTime > 0)
			crazyTime--;
		
		else
			crazy = false;
		
		if (fastTime > 0)
			fastTime--;
		
		else
			fast = false;
	}
	
	private void crazy() {
		if (fast == false) {
		xSpeed = r.nextInt(6) - 3;
		ySpeed = r.nextInt(6) - 3;
		}
		
		else {
			xSpeed = 2 * (r.nextInt(6) - 3);
			ySpeed = 2 * (r.nextInt(6) - 3);
		}
		
		if (ySpeed == 0) {
			if (fast == false)
			ySpeed = 1;
			else
				ySpeed = 2;
		}
	}
	
	public void resetPos() {
		
		if (fast == false) {
		xSpeed = r.nextInt(6) - 3;
		ySpeed = -3;
		}
		
		else {
			xSpeed = 2 * (r.nextInt(6) - 3);
			ySpeed = -6;	
		}
		
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
						if (fast == false) {
					 	this.ySpeed =-3;
					  	this.xSpeed = -5;
						}
						else {
							this.ySpeed =-6;
						  	this.xSpeed = -10;	
						}
						
					}else if((this.xPosition - tempObject.getxPosition()) < 20){
							if (fast == false) {
						 	this.ySpeed =-3;
						  	this.xSpeed = -4;
							}
							else {
								this.ySpeed =-6;
							  	this.xSpeed = -8;
							}
							
					  }else if((this.xPosition - tempObject.getxPosition()) < 30){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						  	this.xSpeed = -3;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = -6;
						  	}
						  	
					  }else if((this.xPosition - tempObject.getxPosition()) < 45){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						  	this.xSpeed = -2;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = -4;
						  	}
						  	
					  }else if((this.xPosition - tempObject.getxPosition()) < 50){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						  	this.xSpeed = -1;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = -2;
						  	}
						  	
					  }else if((this.xPosition - tempObject.getxPosition()) == 50){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						  	this.xSpeed = 0;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = 0;
						  	}
						  	
					  }else if((this.xPosition - tempObject.getxPosition()) < 55){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						 	this.xSpeed = 1;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = 2;
						  	}
						 	
					  }else if((this.xPosition - tempObject.getxPosition()) < 70){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						  	this.xSpeed = 2;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = -4;
						  	}
						  	
					  }else if((this.xPosition - tempObject.getxPosition()) < 80){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						 	this.xSpeed = 3;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = -6;
						  	}
						 	
					  }else if((this.xPosition - tempObject.getxPosition()) < 90){
						  	if (fast == false) {
						 	this.ySpeed =-3;
						  	this.xSpeed = 4;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = -8;
						  	}
					  }else {
						  	if (fast == false) {
						 	this.ySpeed =-3;
						 	this.xSpeed = 5;
						  	}
						  	else {
						  		this.ySpeed =-6;
							  	this.xSpeed = 10;
						  	}
					  	}
				}
			}
			if (tempObject.getId() == ID.Brick) {// brick collision
			    if (getBounds().intersects(tempObject.getBounds())) {
			    	
			    if (pierce == false) {
			     if (xPosition + 20 <= tempObject.getxPosition()
			       || xPosition >= tempObject.getxPosition() + Brick.BRICK_WIDTH) {
			      if (yPosition + 10 >= tempObject.getyPosition()
			        && yPosition + 10 <= tempObject.getyPosition() + Brick.BRICK_HEIGHT) {
			       this.xSpeed = this.xSpeed * -1;
			      }
			     } else {
			      this.ySpeed = this.ySpeed * -1;
			     }
			    }
			    
			     HUD.SCORE = HUD.SCORE + 100;
			     tempScore = tempScore + 100;
			     
			     if (r.nextInt(12) == 0) // random chance to spawn an item
			    	 handler.addObject(new Item(tempObject.getxPosition(), tempObject.getyPosition(), ID.Item, handler));
			     
			     tempObject.setyPosition(tempObject.getyPosition() - Launcher.HEIGHT); // Bricks are moved off-screen
			                       // when hit
			     // checks if room is empty
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