package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import triviaMaze.mazeContainer;
import triviaMaze.triviaSQL;




public class gameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3800326469028396142L;
	
	
	/**
	 * The menu panel.
	 */
	private gameMenu menu;
	
	/**
	 * The game panel.
	 */
	private triviaMazePanel game;
	
	//private mazeContainer myMaze;
	
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
				add(game, BorderLayout.CENTER);
				setPreferredSize(new Dimension(500, 500));
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
