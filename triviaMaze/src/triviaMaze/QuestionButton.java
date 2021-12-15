package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class QuestionButton implements ActionListener {
	
	private mazeContainer myMaze;
	private char myMultipleChoice; 
	private JPanel myPanel;
	public QuestionButton(mazeContainer theMaze, char theChoice) { 
		myMaze=theMaze; 
		myMultipleChoice = theChoice;
	} 
	
	
	public QuestionButton(mazeContainer theMaze, char theChoice, JPanel thePanel) { 
		myMaze=theMaze; 
		myMultipleChoice = theChoice; 
		myPanel = thePanel;
	}
	
	public void actionPerformed (ActionEvent e) { 
		 
		// sets the door into questioning status
		myMaze.getCurrentDoorFace().setQuestioningStatus(true);
		
	//	System.out.println("new button pressed"); 
		if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion && myMultipleChoice =='A') { 
			myMaze.getCurrentDoorFace().getQuestion().checkQuestion('T');
		} else if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion && myMultipleChoice =='B') { 
			myMaze.getCurrentDoorFace().getQuestion().checkQuestion('F');
		} else {
		
		myMaze.getCurrentDoorFace().getQuestion().checkQuestion(myMultipleChoice); 
		} 
		 
		 myMaze.getCurrentDoorFace().checkQuestion(); 
		 if(myMaze.getCurrentDoorFace().getBlockedStatus()) {  
			 myMaze.blockAdjacent();
			 myPanel.setVisible(false);  
				System.out.println("Jpanel case ");
				myPanel.repaint();
		 } else { 
			 System.out.println("try to move again");
		 }
		 
		 
		 
		 
		 if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
	    	 System.out.println("game over");
	     } 
		 
		
		 /*
		if(myMaze.getCurrentDoorFace().getQuestion().answer()) { 
			System.out.println("try to move again");
			myMaze.getCurrentDoorFace().checkQuestion(); 
			
			if(myMaze.getCurrentDoorFace().getBlockedStatus() == true) { 
				myPanel.setVisible(false);  
				System.out.println("Jpanel case ");
				myPanel.repaint();
			}
		} */    
		
		myMaze.setDoorDirection(5);
	}	
		
	
}
