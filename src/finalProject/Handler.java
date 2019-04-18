package finalProject;

import java.awt.Graphics;
import java.util.LinkedList;
/*
 * the handler is a LinkedList of all of our game objects. We loop through it continuously moving and drawing 
 * every object in the Handler.
 */
public class Handler {
	
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempObject = objects.get(i);
			
			tempObject.tick();
			
			
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempObject = objects.get(i);
			
			tempObject.render(g);
			
			
		}
	}
	
	
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}

}
