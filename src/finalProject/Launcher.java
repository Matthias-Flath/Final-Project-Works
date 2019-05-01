package finalProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Launcher extends Canvas implements Runnable{

	private static final long serialVersionUID = 3782368761176837393L;
	//some variables we need the width and height are public static finals so other   
	//objects can use them to determine where they are if we want to change the size of the room
	//without changing individual numbers.
	public static final int WIDTH = 640, HEIGHT = 480;
	private Thread thread;
	private boolean running = false;
	private static Handler handler;
	private HUD hud;
	/*
	 * This is the launcher. It contains both the main method that actually starts the game
	 * as well as most of the back-ground programming including the game loop and 
	 * key listener. this is also where you actually add objects to the game.
	 */
	
	public Launcher() {//use this to add objects to our handler then spawn a room
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));//need this to look for key presses
		new Room(WIDTH, HEIGHT, "Breakout!", this);
		
		hud = new HUD();
		
		handler.addObject(new Paddle(270, HEIGHT-80, ID.Paddle ));//need to add these after the handler is made
		handler.addObject(new Ball(WIDTH/2, HEIGHT/2, ID.Ball,handler));
		
		// adds the bricks
		addBricks();
		
	}
	
	public static void addBricks() {
		for (int i = 40; i < HEIGHT * 3 / 8; i = i + Brick.BRICK_HEIGHT + 16)
		{
			for (int j = 4; j <= WIDTH - Brick.BRICK_WIDTH; j = j + Brick.BRICK_WIDTH + 16) {
				
				handler.addObject(new Brick(j, i, ID.Brick));
			}
		}
	}
	
	public synchronized void start() {//remember our room runs this. starts the thread
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	public synchronized void stop() {//stops the thread
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//the actual Game loop is a standard game loop you can look up
	//it uses your system time to loop through your code running the tick() and render() methods
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double nanoSeconds = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta+=(now-lastTime)/nanoSeconds;
			lastTime = now;
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			if(System.currentTimeMillis()-timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}	
		}
		stop();
	}
	
	
	private void render() {//draws stuff
		BufferStrategy bs = this.getBufferStrategy();//used to slow down the loop
		if ( bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);//fill the screen with black
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		handler.render(g);//loop through all objects drawing them
		hud.render(g);//draw the HUD
		
		g.dispose();
		bs.show();
	}


	private void tick() {
		handler.tick();//loops through all objects running their tick() methods
		hud.tick();//tick()the HUD
		
	}

	public static int clamp(int var, int min, int max) {//used to set bounds on objects movement sometimes
		if(var >= max) {
			return var = max;
		}else if (var <= min){
			return var = min;
		}
		return var;
	}
//our main method
	public static void main(String[] args) {
		new Launcher();//just need a launcher which has a room which runs the start.
	}

	
}
