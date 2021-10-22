package dev.rezilz.expedition;

import java.awt.Graphics; 

import java.awt.image.BufferStrategy;
import dev.rezilz.expedition.display.Display;
import dev.rezilz.expedition.gfx.Assets;
import dev.rezilz.expedition.gfx.GameCamera;
import dev.rezilz.expedition.input.KeyManager;
import dev.rezilz.expedition.input.MouseManager;
import dev.rezilz.expedition.states.State;
import dev.rezilz.expedition.states.levels.Level3;
import dev.rezilz.expedition.states.CompleteState;
import dev.rezilz.expedition.states.GameOverState;
import dev.rezilz.expedition.states.GameState;
import dev.rezilz.expedition.states.HelpState;
import dev.rezilz.expedition.states.MenuState;
import dev.rezilz.expedition.states.SplashState;

// hold all of the code of the game 
	public class Game implements Runnable {

		private Display display;
		private int width, height;
		public String title;
		
		private boolean running = false;
		private Thread thread; //mini program 
		
		private BufferStrategy bs; //for draw not in the actual screen 
		private Graphics g;
		
		//States
		public State gameState, menuState, helpState, splashState, overState, compState, level1;
		
		//Input
		private KeyManager keyManager;
		private MouseManager mouseManager;
		
		//Camera
		private GameCamera gameCamera;
		
		//Handler
		private Handler handler;
		
		//Audio
		
		
		public Game(String title, int width, int height){
			this.width = width;
			this.height = height;
			this.title = title;
			keyManager = new KeyManager();
			mouseManager = new MouseManager();
		}
		
		private void init(){ //for the graphic of the game
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		//testImage = ImageLoader.loadImage("res/textures/test.png");
		//////	test = ImageLoader.loadImage("res/entity/linkformatted.png");
			/////sheet= new SpriteSheet(test);
			Assets.init();
			
			handler = new Handler(this);
			gameCamera = new GameCamera(handler,0, 0);
			
			helpState = new HelpState(handler);
			menuState = new MenuState(handler);
			gameState = new GameState(handler);
			splashState = new SplashState(handler);
			overState = new GameOverState(handler);
			compState = new CompleteState(handler);
			level1 = new Level3(handler);
			
			State.setState(splashState); 
		}	    
	
		private void tick(){ //update the game (rename it update)
			
			keyManager.tick();
			if(State.getState()!= null)
				State.getState().tick();
		}
	
	
		private void render(){ //render the game
			bs = display.getCanvas().getBufferStrategy();
			if(bs == null){
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics(); //compare to the brush
			//Clear Screen
			g.clearRect(0, 0, width, height); 	
			
			//Draw Here!
			
			if(State.getState()!= null)
				State.getState().render(g);
			bs.show();
			g.dispose(); //done the drawing
		}
		
		public void run(){ //implements runnable
			
			init();
			int fps = 60; //how fast?
			double timePerTick = 1000000000 / fps; // 1 billion ns in 1 sec
			double delta =0;
			long now;
			long lastTime = System.nanoTime();
			long timer = 0;
			int ticks = 0;
			
			while(running){ //while running is true
				now = System.nanoTime();
				delta += (now - lastTime) / timePerTick ; // give duration of the time 
				timer += now - lastTime;
				// tell u when to call tick & render method
				lastTime = now;
				
				if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
				} 
				
				if(timer >= 1000000000) {
					//System.out.println("Ticks and Frames: " + ticks);
					ticks = 0;
					timer = 0;
					
				}
			}
			
			stop(); //if false 
			
		}
		
		public KeyManager getKeyManager() {
			return keyManager;
		}
		
		public MouseManager getMouseManager() {
			return mouseManager;
		}
		
		public GameCamera getGameCamera() {
			return gameCamera;
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getHeight() {
			return height;
		}
		
		public synchronized void start(){ //sync for using thread directly to start
			if(running) //if running don't do anything
				return; 
			running = true; //if not false --> true 
			thread = new Thread(this);
			thread.start();
			
		}
		
		public synchronized void stop(){ //sync for using thread directly to stop
			if(!running)
				return;
			running = false;
			try {
				thread.join(); //must surround with try catch
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	
	}











