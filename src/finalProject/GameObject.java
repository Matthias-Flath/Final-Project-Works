package finalProject;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int xPosition, yPosition, xSpeed, ySpeed;
	protected ID id;
	
	public GameObject(int xPosition, int yPosition, ID id) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
}
