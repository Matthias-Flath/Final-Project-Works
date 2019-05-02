package finalProject;

import java.awt.Graphics; 
import java.util.LinkedList;

import finalProject.gameObjects.GameObject;
/*
 * the handler is a LinkedList of all of our game objects. We loop through it continuously moving and drawing 
 * every object in the Handler. 
 */
public class Handler {
	//our list of objects
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	//loops through every object running their respective tick() methods
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempObject = objects.get(i);
			
			tempObject.tick();
			
			
		}
	}
	//loops through every object running their respective render() methods
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempObject = objects.get(i);
			
			tempObject.render(g);
			
			
		}
	}
	
	
	//the ability to add or remove objects from our list.
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}

}
