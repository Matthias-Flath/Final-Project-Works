package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/*
 * the HUD contains some basic information displayed on the screen like lives and score. 
 */
public class HUD {

	//global variables that we use.
	public static int LIVES = 3;
	public static int SCORE = 0;
	public void tick() {//doesn't actually do anything right now.
		
	}
	
	public void render(Graphics g) {//draw the lives and score on screen
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString("Lives: " + HUD.LIVES, 10, 30);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString("Score: " + HUD.SCORE, Launcher.WIDTH-200, 30);
	}
}
