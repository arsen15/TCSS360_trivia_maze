package triviaMaze;

import javax.swing.JFrame;

import trviaGUIComponents.triviaGUI;


public class main {
	
	/**
	 * the main method, so far runs the gui
	 * @param theArgs
	 */
	public static void main(final String[] theArgs) {
		// gui stuff
		triviaSQL sq = new triviaSQL();  
		
    	mazeContainer mC = new mazeContainer(); 
    	mC.fixedArraySetup();  
    	//sq.setup();  
    	mC.setDoors(sq.setup());
    	final triviaGUI mainPanel = new triviaGUI(mC);
        mainPanel.start();
        
		JFrame window = new JFrame();
		window.setContentPane(new gamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
		//maze stuff, need to add Ryan's gui to my gui
		//mazeContainer mc = new mazeContainer(); 
		// mc.roomSetup(); 
		//System.out.println( mc.getMaze().get(0).get(0).getEast().getQuestion().getQuestionText());
		
	}
	

	
	
}
