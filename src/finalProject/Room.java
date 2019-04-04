package finalProject;

import java.awt.*;
import javax.swing.*;
/*
 * this is our window we play our game inside.
 * 
 */
public class Room extends Canvas {

	

	private static final long serialVersionUID = 8086635427339352854L;
	
	public Room(int width, int height, String title, Launcher launcher) {
			JFrame window = new JFrame(title);//create a window
			
			//set the size and don't allow the size to change
			window.setPreferredSize(new Dimension(width, height));
			window.setMaximumSize(new Dimension(width, height));
			window.setMinimumSize(new Dimension(width, height));
			
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//clicking red x stops program
			window.setResizable(false);//cannot resize
			window.setLocationRelativeTo(null);//spawn in center of screen
			window.add(launcher);//add our launcher to the window
			
			
			window.setVisible(true);//window can be seen
			launcher.start();//start the game
	}
	
//	
// 
	
	
}
