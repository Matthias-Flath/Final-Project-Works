package finalProject;

import java.awt.Graphics;
/*
 * The GameObject class contains all the basic information every object will have
 * including an x and y position, a speed if necessary, and an id
 * it also sets up all the methods that are guaranteed needed including the 
 * tick() method(what happens every frame) and the render()method (what is drawn every frame)
 * as well as the getters and setters for all variables.
 */
public abstract class GameObject { 
	protected int xPosition;
	protected int yPosition;
	protected ID id;
	protected double xSpeed;
	protected double ySpeed;
	
	public GameObject(int xPosition, int yPosition, ID id) {
		//sets the starting position as well as identifys what kind of object it is.
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPostition() {
		return yPosition;
	}

	public void setyPostition(int yPostition) {
		this.yPosition = yPostition;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double d) {
		this.xSpeed = d;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	
	
	
	
	
}
