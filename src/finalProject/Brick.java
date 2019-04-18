package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick extends GameObject{

	
	public Brick(int xPosition, int yPosition, ID id) {
		super(xPosition, yPosition, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(xPosition, yPosition, width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(xPosition, yPosition, width, height);
	}
	
}
