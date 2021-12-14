package triviaMaze;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import trviaGUIComponents.gameStateManager;

public class gamePanel extends JPanel implements Runnable, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2273162937876463300L;
	/**
	 * Dimensions
	 */
	public static final int WIDTH = 320; 
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	/**
	 * The game thread.
	 */
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	/**
	 * Image.
	 */
	private BufferedImage image;
	private Graphics2D g;
	
	//Game state manager
	private gameStateManager gameStateManager; 
	
	
	//The constructor
	public gamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	public void update() {
		
		gameStateManager.update();
		
	}
	
	public void draw() {
		gameStateManager.draw(g);
	}
	
	public void drawToScreen() {
		Graphics g2 = getGraphics();
			g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
			g2.dispose();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		gameStateManager.keyPressed(e.getKeyCode());
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		gameStateManager.keyReleased(e.getKeyCode());
		
	}


	@Override
	public void run() {
		
		long start;
		long elapsed;
		long wait;
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		gameStateManager = new gameStateManager();
		
		/**
		 * Game loop
		 */
		while (running) {
			
			start = System.nanoTime();
		
			//Update
			update();
			
			//Draw
			draw();
			
			//Draw to screen
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			
			if (wait < 0) {
				wait = 5;
			}
			
			try {
				Thread.sleep(wait);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
