package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DirectionButton implements ActionListener {
    
	private mazeContainer myMaze;
	private int myDirection; 
	private JPanel myPanel;
	
	
	
	JLabel myQuestionText;
	JButton myOptionA; 
	JButton myOptionB;  
	JButton myOptionC; 
	JButton myOptionD;
	
	
	
	public DirectionButton(mazeContainer theMaze, int theDirection, JPanel thePanel) { 
		myDirection =theDirection; 
		myMaze = theMaze; 
		myPanel = thePanel;
	} 
	
	public DirectionButton(mazeContainer theMaze, int theDirection, JLabel theQuestionText, JButton theOptionA, JButton theOptionB, JButton theOptionC 
			, JButton theOptionD, JPanel thePanel) { 
		myMaze =theMaze; 
		
		myDirection = theDirection;
		
		
		 myQuestionText= theQuestionText;
	     myOptionA= theOptionA;
		 myOptionB= theOptionB; 
		 myOptionC = theOptionC;
		 myOptionD = theOptionD; 
		 myPanel = thePanel;
	}
	
	
	public void actionPerformed (ActionEvent e) {   
		
	     
		
		
		myMaze.setDoorDirection(myDirection); 
		if(myMaze.getCurrentDoorFace().getBlockedStatus() == false ) { 
			myPanel.setVisible(true);
		} else { 
			System.out.println("that door is blocked");
		}
		
		 if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
	    	 System.out.println("game over");
	     }
		if(myMaze.getCurrentDoorFace().checkDoor()) {  
			
			myMaze.moveFaceDirection(); 
			System.out.println("moved north ");
		} 
		
	//	 JLabel myQuestionText = (JLabel)myPanel.getComponentAt(1,1);
	 //    JButton myOptionA = (JButton)myPanel.getComponentAt(1,2); 
	//     JButton myOptionB = (JButton)myPanel.getComponentAt(1,3); 
	 //     JButton myOptionC = (JButton)myPanel.getComponentAt(1,4); 
	  //    JButton myOptionD = (JButton)myPanel.getComponentAt(1,5);
	
		if(myMaze.checkInBoundDirection(myDirection)) {  
		
			System.out.println("checked in bound x");   
			if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion) {  
				
			   
				myQuestionText.setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()+" (TF)"); 
              } else { 
			myQuestionText.setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()+" (MC)");  
              } 
			System.out.println(myMaze.getCurrentDoorFace().getQuestion().getQuestionText());
			myOptionA.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionA()); 
			myOptionB.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionB()); 
			myOptionC.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionC()); 
			myOptionD.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionD());
	
		} 
	
	    System.out.println(myMaze.getCurrentXYString());
	    if(myMaze.won()) { 
	    	 System.out.println("you won");
	     }
	}
	}

