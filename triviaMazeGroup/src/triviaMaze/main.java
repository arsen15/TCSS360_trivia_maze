/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import GUI.GameMenu;

/**
 * This main class of the program. It creates the menu object and therefore starts the program.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class Main {
	
	/**
	 * The main method, creates the menu object
	 * @param theArgs
	 */
	public static void main(final String[] theArgs) {
		GameMenu gameMenu = new GameMenu();
		gameMenu.setVisible(true);
	}

}
