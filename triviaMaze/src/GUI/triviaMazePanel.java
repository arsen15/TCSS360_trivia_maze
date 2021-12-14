package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import triviaMaze.DirectionButton;
import triviaMaze.QuestionButton;
import triviaMaze.TFQuestion;
import triviaMaze.mazeContainer;

//the way triviaGUI is rn is it creates a panel, but we already have gamePanel, so we only need the buttons and other things in a method init or start and then
//run that method in the constructor. where do we include the SQL stuff?
public class triviaMazePanel extends JPanel{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 197500895779284794L;
	
	/**
	 * Dimensions
	 */
	public static final int WIDTH = 500; 
	public static final int HEIGHT = 500;
	
	private mazeContainer myMaze;
	
	JPanel myCenterPanel = new JPanel();
	JLabel myDoorBlockedText = new JLabel("");
	JLabel myGameOverText = new JLabel("");
	JLabel myMovedText = new JLabel ("");
	JLabel myWonText = new JLabel("");
	JLabel myCorrectAnswerLabel = new JLabel("");
	private JLabel myWrongAnswerLabel = new JLabel("");

	public triviaMazePanel(mazeContainer theMaze) {
		super();
		myMaze = theMaze;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
		
		myOptionA.addActionListener(new QuestionButton(myMaze,'A',southPanel, myCorrectAnswerLabel, myWrongAnswerLabel));  
		myOptionB.addActionListener(new QuestionButton(myMaze,'B',southPanel, myCorrectAnswerLabel, myWrongAnswerLabel));   
		myOptionC.addActionListener(new QuestionButton(myMaze,'C',southPanel, myCorrectAnswerLabel, myWrongAnswerLabel)); 
		myOptionD.addActionListener(new QuestionButton(myMaze,'D',southPanel, myCorrectAnswerLabel, myWrongAnswerLabel)); 
	
		
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
		JLabel faceText = new JLabel("Currently Facing " + myMaze.getCurrentDoorFaceString());
		
//		JPanel CenterPanel = new JPanel();
//		JLabel doorBlockedText = new JLabel("");
//		JLabel gameOverText = new JLabel("");
//		JLabel movedText = new JLabel ("");
//		JLabel wonText = new JLabel("");
		
		JButton north = new JButton("north");   
        north.addActionListener(new DirectionButton(myMaze,1,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText, 
        											myDoorBlockedText, myGameOverText, myMovedText, myWonText)); 
		EastPanel.add(north,BorderLayout.NORTH);  
		
		
		JButton south = new JButton("south");  
		 south.addActionListener(new DirectionButton(myMaze,3,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText, 
													 myDoorBlockedText, myGameOverText, myMovedText, myWonText)); 
		 EastPanel.add(south,BorderLayout.SOUTH); 
		 
		 
		 JButton west = new JButton("west");  
		 west.addActionListener(new DirectionButton(myMaze,0,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText, 
													myDoorBlockedText, myGameOverText, myMovedText, myWonText)); 
		 EastPanel.add(west,BorderLayout.WEST);
		 
		
		JButton east = new JButton("east");  
	    east.addActionListener(new DirectionButton(myMaze,2,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText, 
												   myDoorBlockedText, myGameOverText, myMovedText, myWonText)); 
		EastPanel.add(east,BorderLayout.EAST);
		
		EastPanel.add(faceText, BorderLayout.EAST);
		add (EastPanel, BorderLayout.EAST); 
		
		myCenterPanel.add(myDoorBlockedText, BorderLayout.CENTER);
		myCenterPanel.add(myGameOverText, BorderLayout.CENTER);
		myCenterPanel.add(myMovedText, BorderLayout.CENTER);
		myCenterPanel.add(myWonText, BorderLayout.CENTER);
		myCenterPanel.add(myCorrectAnswerLabel, BorderLayout.CENTER);
		myCenterPanel.add(myWrongAnswerLabel, BorderLayout.CENTER);
		add(myCenterPanel, BorderLayout.CENTER);
	
		
	} 

	

}