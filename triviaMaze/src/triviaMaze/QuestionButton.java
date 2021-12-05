<<<<<<< HEAD
package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionButton implements ActionListener {
	
	mazeContainer myMaze;
	char myMultipleChoice;
	public QuestionButton(mazeContainer theMaze, char theChoice) { 
		myMaze=theMaze; 
		myMultipleChoice = theChoice;
	}
	
	public void actionPerformed (ActionEvent e) { 
		 
		
		
		
	//	System.out.println("new button pressed"); 
		if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion && myMultipleChoice =='A') { 
			myMaze.getCurrentDoorFace().getQuestion().checkQuestion('T');
		} else if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion && myMultipleChoice =='B') { 
			myMaze.getCurrentDoorFace().getQuestion().checkQuestion('F');
		} else {
		
		myMaze.getCurrentDoorFace().getQuestion().checkQuestion(myMultipleChoice); 
		}
		if(myMaze.getCurrentDoorFace().getQuestion().answer()) { 
			System.out.println("try to move again");
			myMaze.getCurrentDoorFace().checkQuestion();
			
		}
	}
=======
package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionButton implements ActionListener {
	
	mazeContainer myMaze;
	char myMultipleChoice;
	public QuestionButton(mazeContainer theMaze, char theChoice) { 
		myMaze=theMaze; 
		myMultipleChoice = theChoice;
	}
	
	public void actionPerformed (ActionEvent e) { 
		 
		
		
		
	//	System.out.println("new button pressed"); 
		if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion && myMultipleChoice =='A') { 
			myMaze.getCurrentDoorFace().getQuestion().checkQuestion('T');
		} else if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion && myMultipleChoice =='B') { 
			myMaze.getCurrentDoorFace().getQuestion().checkQuestion('F');
		} else {
		
		myMaze.getCurrentDoorFace().getQuestion().checkQuestion(myMultipleChoice); 
		}
		if(myMaze.getCurrentDoorFace().getQuestion().answer()) { 
			System.out.println("try to move again");
			myMaze.getCurrentDoorFace().checkQuestion();
			
		}
	}
>>>>>>> d41749bba451d49e9a0aeff0b1e7f820ff5e976c
}