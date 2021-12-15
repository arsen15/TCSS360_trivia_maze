package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class optionsFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8034933460843923748L;
	
	/**
	 * The menu panel.
	 */
	private gameMenu menu;
	
	private JPanel panel;

	/**
	 * The constructor.
	 * @param menu
	 */
	public optionsFrame(gameMenu menu) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//saving the menu, so we can return to it after closing the game, saving the game should return to game menu too.
		this.menu = menu;
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				returnToMenu();
				add(panel, BorderLayout.SOUTH);
				
				JLabel label = new JLabel("The goal of the game is to reach the end of the maze by moving from room to room.\n"
						                   + "Before a player can enter a room through a door, they must answer a question correctly."	
										   + "Each room has a question on each door present in the room."
										   + "If a question is answered wrong, that door locks."
										   + "If all doors in a room are locked, the player loses and the game ends."
										   + "The player may save and load their game through the in game menu."
										   + "Check out the Help in game menu if you get stuck!"
										   + "Good luck, have fun! ");
				add(label, BorderLayout.NORTH);
				
			}
			
		});
		// Pack the frame
		pack();
		setLocationRelativeTo(null); // Center in screen
	}


	public void returnToMenu() {
		 panel = new JPanel();
		
		JButton returnToMenu = new JButton("Return to Menu");
		returnToMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu.setVisible(true);
				
			}
			
		});
		panel.add(returnToMenu);
		
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
