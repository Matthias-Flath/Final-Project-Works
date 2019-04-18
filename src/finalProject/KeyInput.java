package finalProject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
 * manages our key input 
 */
public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {
				if(key == KeyEvent.VK_A) {
					tempObject.setxSpeed(-5);
				}else if(key == KeyEvent.VK_D) {
					tempObject.setxSpeed(5);
				}
					
			}
			
			
		}
		
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getId() == ID.Paddle) {
				if(key == KeyEvent.VK_A) {
					tempObject.setxSpeed(0);
				}else if(key == KeyEvent.VK_D) {
					tempObject.setxSpeed(0);
				}
					
			}
			
			
		}
		
		
		
	}

}
