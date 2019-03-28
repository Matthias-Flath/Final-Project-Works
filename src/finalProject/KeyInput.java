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
		
		//System.out.println(key);//use this to determine if the correct key is being pressed9+
		
		for(int i = 0; i < handler.object.size(); i++) {
			//loops through all created objects looking for the paddle
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Paddle) {
				//if the object it is checking is a paddle
				if(key == KeyEvent.VK_A) {//if A is pressed move paddle left
					if((tempObject.getxPosition()-5) < 0)
					{
						//if location change would put past edge of screen do nothing
					}
					else//otherwise move it
					{
						tempObject.setxPosition(tempObject.getxPosition()-5);
						//tempObject.setxSpeed(-5); This is the proper movement but It isn't currently working
						
						
					}
				}
				if(key == KeyEvent.VK_D) {//if D is pressed move paddle right
					if(tempObject.getxPosition() + 5 > Launcher.WIDTH-64)
					{
						//if it would move past screen don't
					}
					else //otherwise move
					{
						tempObject.setxPosition(tempObject.getxPosition()+5);
						//tempObject.setxSpeed(+5); This is the proper movement but It isn't currently working
					}
				}
				
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			//loops through all created objects looking for the paddle
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Paddle) {
				//if the object it is checking is a paddle
				if(key == KeyEvent.VK_A) {//if A is released stop movement
						tempObject.setxSpeed(0);

					}
				}
				if(key == KeyEvent.VK_D) {//if D is released stop movement
						tempObject.setxSpeed(0);
					}
				}
				
			}
		
	}
	