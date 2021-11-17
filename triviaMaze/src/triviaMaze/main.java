package triviaMaze;

import javax.swing.JFrame;


public class main {
	
	/**
	 * the main method, so far runs the gui
	 * @param theArgs
	 */
	public static void main(final String[] theArgs) {
		JFrame window = new JFrame();
		window.setContentPane(new gamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
	

	
	
}
