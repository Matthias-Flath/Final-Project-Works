package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

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
					this.ySpeed*=-1;
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
