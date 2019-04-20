package finalProject;

import java.awt.Graphics;
import java.awt.Rectangle;
/*
 * the abstract class GameObject contains all the information every object in our game uses
 * the x and y coordinates, the speed they move at and the coordinates.
 * it contains getters and setters for all of this information as well as the 
 * method getBounds() which is used to determine collision.  
 */
public abstract class GameObject {
	
	protected int xPosition, yPosition, xSpeed, ySpeed;//position on screen and speed
	protected ID id;//identifies what the object is.
	
	//every object on creation has these
	public GameObject(int xPosition, int yPosition, ID id) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.id = id;
	}
	
	//these abstract methods are necessary for every object on the screen
	public abstract void tick();//what the object does
	public abstract void render(Graphics g);//what the object looks like
	public abstract Rectangle getBounds();//what is the objects collision box
	

	//getters and setters
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
