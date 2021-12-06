package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 
 * @author Ryan. Arsen, Phuc
 *
 */
public class QuestionButton implements ActionListener {

  private mazeContainer myMaze;
  private char myMultipleChoice;
  private JPanel myPanel;
  
  /**
   * Constructor that helps set up the Question Button.
   * @param theMaze set up the maze.
   * @param theChoice Set up all the multiple choice.
   */
  public QuestionButton(mazeContainer theMaze, char theChoice) {
    myMaze = theMaze;
    myMultipleChoice = theChoice;
  }

  /**
   * Second constructor that helps set up the Question Button.
   * Also will take in the Panel.
   * @param theMaze
   * @param theChoice
   * @param thePanel
   */
  public QuestionButton(mazeContainer theMaze, char theChoice,
      JPanel thePanel) {
    myMaze = theMaze;
    myMultipleChoice = theChoice;
    myPanel = thePanel;
  }

  /**
   * Actions that follow after the buttons are pressed.
   */
  public void actionPerformed(ActionEvent e) {
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
      System.out.println("Jpanel case ");
      myPanel.repaint();
    } else {
      System.out.println("try to move again");
    }
    if (myMaze.getCurrentRoom().checkBlockedDoors()) {
      System.out.println("game over");
    }

  }

}
