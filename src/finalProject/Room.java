package finalProject;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
//this is just the parameters on our game room. How big it is what clicking the X does
//make it visible, then start.    
public class Room extends Canvas {
	
	private static final long serialVersionUID = 8086635427339352854L;
//basically it is a JFrame that has a Launcher object added to it then runs the start command
	//in that Launcher
	public Room(int width, int height, String title, Launcher launcher) {
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(launcher);
		frame.setVisible(true);
		launcher.start();
		
	}
	
	
}
