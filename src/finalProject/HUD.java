package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/*
 * the HUD contains some basic information displayed on the screen like lives and score.s
 */
public class HUD {

	public static int LIVES = 3;
	public static int SCORE = 0;
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString("Lives: " + HUD.LIVES, 10, 30);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString("Score: " + HUD.SCORE, Launcher.WIDTH-200, 30);
	}
}
