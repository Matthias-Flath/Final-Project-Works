package finalProject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
 * this class handles the keyboard input that controls the paddle
 */

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.println(key);
		
		for(int i = 0; i < handler.object.size(); i++) {
			//loops through all created objects looking for the paddle
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Paddle) {
				//if the object it is checking is a paddle
				if(key == KeyEvent.VK_A) {//if A is pressed move paddle left
					tempObject.setxPosition(tempObject.getxPosition()-5);
				}
				if(key == KeyEvent.VK_D) {//if D is pressed move paddle right
					tempObject.setxPosition(tempObject.getxPosition()+5);
				}
				
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}
	
}