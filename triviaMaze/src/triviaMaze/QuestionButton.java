/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * This class creates action listeners for the question buttons.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class QuestionButton implements ActionListener {

	/**
	 * The maze.
	 */
  private MazeContainer myMaze;
  
  /**
   * Character for multiple choice answers.
   */
  private char myMultipleChoice;
  
  /**
   * JPanel to hold the components.
   */
  private JPanel myPanel;
  
  /**
   * Constructor that initializes the question button.
   * @param theMaze
   * @param theChoice
   * @param thePanel
   */
  public QuestionButton(MazeContainer theMaze, char theChoice, JPanel thePanel) {
    myMaze = theMaze;
    myMultipleChoice = theChoice;
    myPanel = thePanel;
  }
  

  /**
   * Method that handles the actions performed when question button is pressed.
   * Also provides some directions to the player.
   */
  public void actionPerformed(ActionEvent theEvent) {
	  

    // sets the door into questioning status
    myMaze.getCurrentDoorFace().setQuestioningStatus(true);

    // System.out.println("new button pressed");
    if (myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion
        && myMultipleChoice == 'A') {
      myMaze.getCurrentDoorFace().getQuestion().checkQuestion('T');
    } else if (myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion
        && myMultipleChoice == 'B') {
      myMaze.getCurrentDoorFace().getQuestion().checkQuestion('F');
    } else {

      myMaze.getCurrentDoorFace().getQuestion().checkQuestion(myMultipleChoice);
    }

    myMaze.getCurrentDoorFace().checkQuestion();
    if (myMaze.getCurrentDoorFace().getBlockedStatus()) {
      myMaze.blockAdjacent();
      myPanel.setVisible(false);
      System.out.println("WRONG!");
      myPanel.repaint();
      
      
    } else {
      System.out.println("Correct! You may enter the room.");
    }

    if (myMaze.getCurrentRoom().checkBlockedDoors()) {
      System.out.println("game over");
    }


    myMaze.setDoorDirection(5);
  }

}
