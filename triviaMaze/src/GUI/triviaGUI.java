package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import com.sun.tools.javac.Main;

import triviaMaze.DirectionButton;
import triviaMaze.QuestionButton;
import triviaMaze.gameSaveAndLoad;
import triviaMaze.mazeContainer;
import triviaMaze.triviaSQL;

public class triviaGUI extends JPanel {
 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 197500895779284794L;
	private mazeContainer myMaze; 
	
	private static int click = 0;
	public triviaGUI(mazeContainer theMaze) { 
		myMaze = theMaze;
	} 
	public triviaGUI() { 
		myMaze = new mazeContainer();
	}
	
	
	public void start() {  
		
		this.setLayout(new BorderLayout());
		
	
	//	JPanel panel = new JPanel(); 
	
	//	JButton north = new JButton("north");   
		
		JPanel southPanel = new JPanel();
	
		JLabel myQuestionText = new JLabel("temp Question");
		JButton myOptionA = new JButton("TEMPA");    
		JButton myOptionB = new JButton("TEMPB");    
		JButton myOptionC = new JButton("TEMPC");     
		JButton myOptionD = new JButton("TEMPD");    
		southPanel.setLayout(new GridLayout(1,6));   
		southPanel.add(myQuestionText); 
		southPanel.add(myOptionA); 
		southPanel.add(myOptionB); 
		southPanel.add(myOptionC); 
		southPanel.add(myOptionD);
		southPanel.setVisible(false); 
		add(southPanel,BorderLayout.SOUTH); 
		
		myOptionA.addActionListener(new QuestionButton(myMaze,'A',southPanel));  
		myOptionB.addActionListener(new QuestionButton(myMaze,'B',southPanel));   
		myOptionC.addActionListener(new QuestionButton(myMaze,'C',southPanel)); 
		myOptionD.addActionListener(new QuestionButton(myMaze,'D',southPanel)); 
	
		
		add(southPanel,BorderLayout.SOUTH);

//		add(panel, BorderLayout.EAST);  
		
		JPanel westPanel = new JPanel();  
		westPanel.setLayout(new GridLayout(5,5));
		
		int rowSize= 5; 
		int columnSize=5; 
		final JButton[][] keyButtons = new JButton[rowSize][columnSize];
		  
		  for(int i = 0; i< rowSize; i++) { 
			  for(int j =0; j< columnSize; j++) {  
				  if(i==0 && j==0 ) { 
					  keyButtons[i][j] = new JButton("'*'"); 
				  } else {
 				  keyButtons[i][j] = new JButton("*");  
				  }
				  westPanel.add(keyButtons[i][j]);
			  }
		  }  
		  
		add(westPanel, BorderLayout.WEST);	 
		
		JPanel EastPanel = new JPanel();   
		JLabel faceText = new JLabel("Currently Facing "+myMaze.getCurrentDoorFaceString()); 
		JLabel image= new JLabel();
		JButton north = new JButton("north");   
		 EastPanel.add(image,BorderLayout.WEST);
        north.addActionListener(new DirectionButton(myMaze,1,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText,image)); 
		EastPanel.add(north,BorderLayout.NORTH);  
		
		
		JButton south = new JButton("south");  
		 south.addActionListener(new DirectionButton(myMaze,3,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText,image)); 
		 EastPanel.add(south,BorderLayout.SOUTH); 
		 
		 
		 JButton west = new JButton("west");  
		 west.addActionListener(new DirectionButton(myMaze,0,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText,image)); 
		 EastPanel.add(west,BorderLayout.WEST);
		 
		
		JButton east = new JButton("east");  
	    east.addActionListener(new DirectionButton(myMaze,2,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText,image)); 
		EastPanel.add(east,BorderLayout.EAST);    
	//	JLabel faceText = new JLabel("Currently "+myMaze.getCurrentDoorFaceString());
		EastPanel.add(faceText, BorderLayout.EAST);  
		File f = new File("./fireSeekerArt.jpg");   
		
		try { 
		   String bip = "/Users/ryanm/workspace/triviaMazeLocal/fireSeeker.mp3";  
		   AudioInputStream audioInputStream = 
	                AudioSystem.getAudioInputStream(new File("fireSeekerAudio.mp3").getAbsoluteFile()); 
		   Clip clip  = AudioSystem.getClip(); 
		   clip.open(audioInputStream); 
		  
		   
		   
		   
		} catch(Exception e) { 
			System.out.println("error loading image"+e.getMessage());
		} 
		
		
		add (EastPanel, BorderLayout.EAST); 
	
		
	} 
	//pass door arraylist of doors containing questions to the maze container from the SQL for door and question choices  
	//mazecontainer sets up doors trivia SQL might move some to it as well 
	  public static void main(final String[] theArgs) {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {  
	            	
	            
	         
	            	triviaSQL sq = new triviaSQL();   
	            	
	            	mazeContainer mC = new mazeContainer(); 
	            	mC.fixedArraySetup();    
	            	mC.setDoors(sq.setup()); 
	            	
	            	
	            	
	                final triviaGUI mainPanel = new triviaGUI(mC);
	                mainPanel.start();
	                
	                // A size for the JFrame.
	                final Dimension frameSize = new Dimension(500, 500);
	                
	                final JFrame window = 
	                    new JFrame("VideoGameTriva");  
	               
	     
	                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	                window.setSize(frameSize); 
	                
	                window.setLocationRelativeTo(null);
	                //window.add(mainPanel);
	                window.setContentPane(mainPanel);  
	                window.pack();
	             
	             
	                window.setVisible(true); 
	                
	                
	                
	                
	             // Create a menu option to store SAVE, LOAD, EXIT buttons in game.
	                JMenuBar menuBar = new JMenuBar();
	                // Create a menu option in game.
	                JMenu subMenu = new JMenu("File");
	                menuBar.add(subMenu);
	                // Create a Help menu option in game.
	                JMenu subMenu2 = new JMenu("Help");
	                menuBar.add(subMenu2);
	                // Add the cheat button that shows the answers to the questions.
	                JMenuItem cheatMenuButton = new JMenuItem("Cheat", KeyEvent.VK_C);
	                cheatMenuButton.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent ev) {
	                    // Print out the cheat sheet in the Console.
	                    System.out.println("\n--- Cheat Sheet is printed in the Console ---\n"
	                        + "1. Who/What does gael seek?\n" + "Answer: The Dark Soul\n"
	                        + "2. Artorias slew manus\n" + "Answer: F");
	                    // A pop up will appear when the player chooses Cheat in the Help sub menu.
	                    String answers = "1. Who/What does gael seek?\r\n"
	                        + "Answer: The Dark Soul\n"
	                        + "2. Artorias slew manus\n"
	                        + "Answer: F";
	                    JOptionPane.showMessageDialog(mainPanel, answers, "Cheat Sheet", JOptionPane.INFORMATION_MESSAGE);
	                  }
	                });
	                // Add the Help button into the sub menu.
	                subMenu2.add(cheatMenuButton);

	                // A sub menu in game. Allow us to SAVE the game.
	                JMenuItem saveMenuButton = new JMenuItem("SAVE", KeyEvent.VK_S);
	                subMenu.add(saveMenuButton);

	                // Save the game when SAVE button is pressed. And generate different
	                // save files.
	                saveMenuButton.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent ev) {
	                    System.out.println("you pressed SAVE");
	                    try {
	                      click++;
	                      System.out.println(click);
	                      gameSaveAndLoad.saveGame(mC, click + " Maze.ser");
	                    } catch (Exception e) {
	                      System.out.println(
	                          "Something is wrong! Couldn't save!" + e.getMessage());
	                    }
	                  }
	                });

	                // Allow us to LOAD the game. NOT FINISHED! CAN ONLY LOAD THE GAME ONE
	                // TIME ATM!
	                JMenuItem loadMenuButton = new JMenuItem("LOAD", KeyEvent.VK_L);
	                subMenu.add(loadMenuButton);
	                loadMenuButton.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent ev) {
	                    System.out.println("you pressed LOAD");
	                    try {
	                      // Load the game with the data and initialize the new maze. Need
	                      // to have something like a fileCHooser to allow players to choose
	                      // the
	                      // file that they want.
	                      // Create a file Chooser for LOAD method. And changed the save
	                      // button text on FileChooser to Open.
	                      // Source:
	                      // https://community.oracle.com/tech/developers/discussion/1390408/jfilechooser-uimanager-keys-i18n
	                      UIManager.put("FileChooser.saveButtonText", "Open");
	                      JFileChooser jChooser = new JFileChooser(
	                          FileSystemView.getFileSystemView().getHomeDirectory());
	                      jChooser.showSaveDialog(null);
	                      mazeContainer maze = (mazeContainer) gameSaveAndLoad
	                          .loadGame(jChooser.getSelectedFile().getName());
	                      // Assign the new updated maze into the mainPanel and show it.
	                      final triviaGUI mainPanel = new triviaGUI(returnMaze(maze));
	                      // final triviaGUI mainPanel = new triviaGUI(maze);
	                      mainPanel.start();
	                      window.pack();
	                      window.setContentPane(mainPanel);
	                      window.repaint();
	                      window.pack();
	                    } catch (Exception e) {
	                      System.out
	                          .println("Something is wrong! Couldn't load the saved data!"
	                              + e.getMessage());
	                    }
	                  }
	                });

	                // Exit button that allows us to close the game.
	                JMenuItem exitMenuButton = new JMenuItem("Exit", KeyEvent.VK_E);
	                subMenu.add(exitMenuButton);
	                exitMenuButton.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent ev) {
	                    System.exit(0);
	                  }
	                });
	                window.setJMenuBar(menuBar);
	                window.setVisible(true);
	            }
	        });
	    } 
	  public static mazeContainer returnMaze(mazeContainer theMaze) {
		    triviaSQL sq = new triviaSQL();
		    theMaze.fixedArraySetup();
		    theMaze.setDoors(sq.setup());
		    return theMaze;
		  }

	

}
