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
		super(xPosition, yPosition, id);
		
	}

	@Override
	public void tick() {
		xPosition += xSpeed;
		xPosition = Launcher.clamp(xPosition, 0, Launcher.WIDTH -100);
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(xPosition, yPosition, 100, 20);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(xPosition,yPosition, 100, 20);
	
	}

}
