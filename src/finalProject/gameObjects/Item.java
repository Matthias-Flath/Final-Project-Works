package finalProject.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import finalProject.HUD;
import finalProject.Handler;
import finalProject.Launcher;

public class Item extends GameObject{
	
	private Random r = new Random();
	private int rTypes = 5;
	
	public int type;
	public int diameter = 8;
	
	private Handler handler; //needed for collision
		
	public Item(int xPosition, int yPosition, ID id, Handler handler) {
		super(xPosition, yPosition, id);
		this.type = r.nextInt((rTypes - 0) + 1) + 0;; // generates a random item
		xSpeed = 0;
		ySpeed = 2;
		this.handler = handler;
	}
	
	/* Type 0 = Piercing Ball
	 * Type 1 = Extra Life
	 * Type 2 = 10,000 Points
	 * Type 3 = Crazy Ball
	 * Type 4 = Fast Ball
	 */
	
	
	public void collision() {
		
		for (int i = 0; i < handler.objects.size(); i++) {//loop through objects 
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {//collisions with paddle
				
				if(getBounds().intersects(tempObject.getBounds())) {//did we collide?
				
					yPosition = Launcher.HEIGHT + 40;
					
					switch (this.type) { // Item effect
					case 0: Ball.setPierce();
							break;
					case 1: HUD.LIVES++;
							break;
					case 2: HUD.SCORE = HUD.SCORE + 10000;
							break;
					case 3: Ball.setCrazy();
							break;
					case 4: Ball.setFast();
							break;
					default: HUD.SCORE = HUD.SCORE + 5000;
					}
				}
			}	
		}
	}
	
	@Override
	public void tick() {
		//moves the item down
		xPosition += xSpeed;
		yPosition += ySpeed;
		 
		collision();
		
		if (yPosition > Launcher.HEIGHT + 40)
			ySpeed = 0;
	}

	@Override
	public void render(Graphics g) {
		//draws the item
		g.setColor(Color.red);
		g.fillOval(xPosition, yPosition, diameter, diameter);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(xPosition, yPosition, diameter, diameter);
	}
}
