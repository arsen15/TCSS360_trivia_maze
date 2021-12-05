package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import triviaMaze.mazeContainer;
import triviaMaze.triviaSQL;




public class gameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3800326469028396142L;
	
	/**
	 * Dimensions
	 */
	public static final int WIDTH = 500; 
	public static final int HEIGHT = 500;
	
	/**
	 * The menu panel.
	 */
	private gameMenu menu;
	
	/**
	 * The game panel.
	 */
	private triviaMazePanel game;
	
	public gameFrame(gameMenu menu) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//saving the menu, so we can return to it after closing the game, saving the game should return to game menu too.
		this.menu = menu;
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				//pass door arraylist of doors containing questions to the maze container from the SQL for door and question choices 
				triviaSQL sq = new triviaSQL();
				mazeContainer mC = new mazeContainer();
				mC.fixedArraySetup();    
				mC.setDoors(sq.setup());
				game = new triviaMazePanel(mC);
				
				game.start();
				game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
				add(game, BorderLayout.CENTER);
				
				/////
		        JMenuBar menuBar = new JMenuBar();

		        // Create a menu option in game.
		        JMenu menu = new JMenu("File");
		        menuBar.add(menu);

		        // A sub menu in game. Allow us to SAVE the game. NOT FINISHED!        
		        JMenuItem menuItem = new JMenuItem("SAVE", KeyEvent.VK_T);
		        menu.add(menuItem);
		        
		        // Allow us to LOAD the game. NOT FINISHED!   
		        JMenuItem menuItem2 = new JMenuItem("LOAD", KeyEvent.VK_T);
		        menu.add(menuItem2);
		        setJMenuBar(menuBar);

		        /////
			}
	
		});

		// Pack the frame
		pack();
		setLocationRelativeTo(null); // Center in screen
	}
	
	/**
	 * Allows to return to the game menu.
	 */
	@Override
	public void dispose() {
		super.dispose();
		
		menu.setVisible(true);
	}
	

}
