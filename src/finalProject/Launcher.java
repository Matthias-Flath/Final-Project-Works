package finalProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Launcher extends Canvas implements Runnable{

	private static final long serialVersionUID = 3782368761176837393L;
	
	public static final int WIDTH = 640, HEIGHT = 480;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	
	
	public Launcher() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Room(WIDTH, HEIGHT, "Breakout!", this);
		
		hud = new HUD();
		
		handler.addObject(new Paddle(270, HEIGHT-80, ID.Paddle ));
		handler.addObject(new Ball(WIDTH/2, HEIGHT/2, ID.Ball,handler));
		
	}
	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if ( bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}


	private void tick() {
		handler.tick();
		hud.tick();
		
	}

	public static int clamp(int var, int min, int max) {
		if(var >= max) {
			return var = max;
		}else if (var <= min){
			return var = min;
		}
		return var;
	}

	public static void main(String[] args) {
		new Launcher();
	}

	
}
