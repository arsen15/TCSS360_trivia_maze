package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionButton implements ActionListener {
	
	private mazeContainer myMaze;
	private char myMultipleChoice; 
	private JPanel myPanel;
	private JLabel myCorrectAnswerLabel = new JLabel("");
	private JLabel myWrongAnswerLabel = new JLabel("");
	
	public QuestionButton(mazeContainer theMaze, char theChoice) { 
		myMaze=theMaze; 
		myMultipleChoice = theChoice;
	} 
	
	
	public QuestionButton(mazeContainer theMaze, char theChoice, JPanel thePanel, JLabel theCorrectAnswerLabel, JLabel theWrongAnswerLabel) { 
		myMaze = theMaze; 
		myMultipleChoice = theChoice; 
		myPanel = thePanel;
		myCorrectAnswerLabel = theCorrectAnswerLabel;
		myWrongAnswerLabel = theWrongAnswerLabel;
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
		 
		 //If currently faced door is not blocked - means answered correctly and may enter the room
		 if(myMaze.getCurrentDoorFace().getBlockedStatus()) { 
			 //Answering the question wrong
			myMaze.blockAdjacent();
			myPanel.setVisible(false);  
			System.out.println("Wrong answer! Door is blocked now. ");
			myWrongAnswerLabel.setText("Wrong answer! Door is blocked now.");
			//myPanel.repaint();
		 } else {
			 //Answering the question right
			 System.out.println("Correct! You may enter the room.");
			 myCorrectAnswerLabel.setText("Correct! You may enter the room.");
		 }
		 
		 

		 
		 if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
	    	 System.out.println("game over");
	     } 
		     
		
		myMaze.setDoorDirection(5);
	}	
		
	
}