package finalProject;

import java.awt.Graphics;
import java.awt.Color;

/*
 * the thing the player will control, a thin rectangle on the bottom of the screen
 * that is used to keep the ball from falling off the bottom of the screen.
 */

public class Paddle extends GameObject {

	
	
	public Paddle(int xPosition, int yPosition, ID id) {
		super(xPosition, yPosition, id);
		// TODO Auto-generated constructor stub
	}

	public void tick() {//This is what is called each run loop it changes the speed of the paddle
		xPosition += this.xSpeed;
		yPosition +=this.ySpeed;
	}
	
	public void render(Graphics g) {
		//called every run loop draws the paddle at it's current position.
		g.setColor(Color.white);
		g.fillRect(xPosition, yPosition, 64, 16);
	}

	
}
