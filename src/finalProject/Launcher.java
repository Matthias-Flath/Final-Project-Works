package finalProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*
 * the background of our game containing the main method.
 * creates all the objects, adds them to the handler, creates the window,
 * contains the game loop 
 */

public class Launcher extends Canvas implements Runnable {

	private static final long serialVersionUID = -946441977572068398L;

	public static final int WIDTH = 640, HEIGHT = (WIDTH/12*9);
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public Launcher() {
		handler = new Handler();//create our handler
		this.addKeyListener(new KeyInput(handler));//tell our game to listen to keyboard input
		new Room(WIDTH, HEIGHT, "Break-Out", this);//create our window.
		
		//add paddle to handler
		handler.addObject(new Paddle(WIDTH/2-32, HEIGHT - 100, ID.Paddle));
		handler.addObject(new Ball(WIDTH/2-32, HEIGHT/2, ID.Ball));
		
		
	}
	
	public synchronized void  start() {//starts the game
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	public synchronized void stop() {//stops the game
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		/*I used a standardized game loop used in many games
		 * you can find variations of these by googling them
		 * this one calculates your fps and displays it while the game is running
		*/
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		double timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {//the game loop
			long now = System.nanoTime();
			delta += (now + lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {// call tick and render
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {//displaying the calculated fps
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	


	private void tick() {//calls handler tick() which runs all objects tick()
		handler.tick();
	}
	
	private void render() {//calls handler render() which runs all objects render()
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);//sets background color 
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		new Launcher();//run the game 
	}

	
	
	
	
}
