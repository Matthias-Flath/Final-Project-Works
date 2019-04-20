package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/*
 * This is the paddle the player controls. they can move it left and right to   
 * keep the ball from falling off the screen.
 */
public class Paddle extends GameObject {

	
	public Paddle(int xPosition, int yPosition, ID id) {
		super(xPosition, yPosition, id);//constructor just needs a starting position and to know it is a paddle
		
	}

	@Override
	public void tick() {//each tick we need to move the paddle
		xPosition += xSpeed;//based on our speed
		xPosition = Launcher.clamp(xPosition, 0, Launcher.WIDTH -100);//it can not go beyond edge of screen
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);//draws our paddle 
		g.fillRect(xPosition, yPosition, 100, 20);
	}

	@Override
	public Rectangle getBounds() {//sets our collision detection.
		return new Rectangle(xPosition,yPosition, 100, 20);
	
	}

}
