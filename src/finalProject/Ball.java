package finalProject;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{

	public Ball(int xPosition, int yPosition, ID id) {
		super(xPosition, yPosition, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(xPosition, yPosition, 32, 32);
		// TODO Auto-generated method stub
		
	}

	/*	public int xPosition;
	 * 	public int yPosition;
	 * 	public int xSpeed;
	 * 	public int ySpeed;
	 * 	public image;
	 * 	public static int lives = 3;
	 * 	public static int ballCount = 0;
	 * 
	 * 	
	 *		public Ball{
	 *			ballCount++;
	 * 			xPostition =;	
	 * 			yPosition =;
	 * 			xSpeed =;
	 * 			ySpeed;
	 * 		}
	 * 
	 * 
	 * 
	 * 	public move(){
	 * 		xPosition += xSpeed;
	 * 		yPosition += ySpeed;
	 * 
	 * 		if(collision with paddle)
	 * 		{
	 * 			bounce()
	 * 		}
	 * 		
	 * 		if(xPosition<0 || x > width)//left or right wall
	 * 		{
	 * 		bounce()
	 * 		}
	 * 
	 * 		if (yPosition < 0)//top of screen
	 * {
	 * bounce()
	 * }
	 * 
	 * if(collide with brick)
	 * {
	 * 
	 * }
	 * 			if(yPosition > bottom screen)//falls off bottom
	 * 		{
	 * 				ballCount -=1;
	 * 				destroy self
	 * 			if(ballCount < 1)
	 * 				{
	 * 					lives -= 1;
	 * 				}
	 * 		}
	 * 
	 * 	}
	 * 	
	 * 	
	 * 	public void bounce(){
	 * 			
	 * 		
	 * 		
	 * 		}
	 * 
	 * 
	 * 
	 */
}
