package finalProject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
 * manages our key input 
 */
public class KeyInput extends KeyAdapter {

	private Handler handler;//need a handler because that is where our objects are
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {//when a key is pressed
		int key = e.getKeyCode();
		
		//loop through objects looking for one that cares about key presses
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {//the paddle moves with 'A' and 'D'
				if(key == KeyEvent.VK_A) {
					tempObject.setxSpeed(-5);
				}else if(key == KeyEvent.VK_D) {
					tempObject.setxSpeed(5);
				}
					
			}
			
			
		}
		
		
		
	}
	//loop through objects looking for one that cares about key releases
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {//the paddle stops moving when you release the key
				if(key == KeyEvent.VK_A) {
					tempObject.setxSpeed(0);
				}else if(key == KeyEvent.VK_D) {
					tempObject.setxSpeed(0);
				}
					
			}
			
			
		}
		
		
		
	}

}
