package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/*
 * the HUD contains some basic information displayed on the screen like lives and score. 
 */
public class HUD {

	//global variables that we use.
	public static boolean GAMEOVER = false;
	public static int LIVES = 3;
	public static int SCORE = 0;
	public void tick() {//doesn't actually do anything right now.
		if(LIVES < 0) {
			GAMEOVER = true;
		}
	}
	
	public void render(Graphics g) {//draw the lives and score on screen
		if(!GAMEOVER) {
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString("Lives: " + HUD.LIVES, 10, 30);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
		g.drawString("Score: " + HUD.SCORE, Launcher.WIDTH-200, 30);
		}
		else { 
			g.setColor(Color.black);
			g.fillRect(0, 0, Launcher.WIDTH, Launcher.HEIGHT);
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.BOLD, 72));
			g.drawString("GAME OVER!", 100, Launcher.HEIGHT/2-100);
			g.drawString("Score: " + HUD.SCORE, 100, Launcher.HEIGHT/2);
		}
	}
}
