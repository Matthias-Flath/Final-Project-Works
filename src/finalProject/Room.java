package finalProject;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Room extends Canvas {
	
	private static final long serialVersionUID = 8086635427339352854L;

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
