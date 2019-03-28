package finalProject;

import java.awt.Graphics;
import java.util.LinkedList;
/*
 * This class keeps track of all our game objects, allows us to loop through all 
 * objects running their respective tick and render methods.
 */

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();//list of all objects
	
	public void tick() {//loop through objects and run their tick()
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
			
		}
	}
	
	public void render(Graphics g) {//loop through objecs and run their render()
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
			
		}

	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	
	
}
