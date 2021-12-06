package triviaMaze;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class triviaGUI extends JPanel {
 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 197500895779284794L;
	private mazeContainer myMaze;
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
		JButton north = new JButton("north");   
        north.addActionListener(new DirectionButton(myMaze,1,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText)); 
		EastPanel.add(north,BorderLayout.NORTH);  
		
		
		JButton south = new JButton("south");  
		 south.addActionListener(new DirectionButton(myMaze,3,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText)); 
		 EastPanel.add(south,BorderLayout.SOUTH); 
		 
		 
		 JButton west = new JButton("west");  
		 west.addActionListener(new DirectionButton(myMaze,0,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText)); 
		 EastPanel.add(west,BorderLayout.WEST);
		 
		
		JButton east = new JButton("east");  
	    east.addActionListener(new DirectionButton(myMaze,2,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel,keyButtons,faceText)); 
		EastPanel.add(east,BorderLayout.EAST);    
	//	JLabel faceText = new JLabel("Currently "+myMaze.getCurrentDoorFaceString());
		EastPanel.add(faceText, BorderLayout.EAST);
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
	            }
	        });
	    }
	

}
