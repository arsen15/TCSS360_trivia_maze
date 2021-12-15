package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Ryan, Arsen, Phuc
 *
 */
public class DirectionButton implements ActionListener {

  private mazeContainer myMaze;
  private int myDirection;
  private JPanel myPanel;
  JLabel myQuestionText;
  JButton myOptionA;
  JButton myOptionB;
  JButton myOptionC;
  JButton myOptionD;
  JButton[][] myArray;
  JLabel myDirectionText;

  public DirectionButton(mazeContainer theMaze, int theDirection,
      JPanel thePanel) {
    myDirection = theDirection;
    myMaze = theMaze;
    myPanel = thePanel;
  }

  public DirectionButton(mazeContainer theMaze, int theDirection,
      JLabel theQuestionText, JButton theOptionA, JButton theOptionB,
      JButton theOptionC, JButton theOptionD, JPanel thePanel) {
    myMaze = theMaze;
    myDirection = theDirection;
    myQuestionText = theQuestionText;
    myOptionA = theOptionA;
    myOptionB = theOptionB;
    myOptionC = theOptionC;
    myOptionD = theOptionD;
    myPanel = thePanel;
  }
  public DirectionButton(mazeContainer theMaze, int theDirection,
      JLabel theQuestionText, JButton theOptionA, JButton theOptionB,
      JButton theOptionC, JButton theOptionD, JPanel thePanel,
      JButton[][] theArray) {
    myMaze = theMaze;

    myDirection = theDirection;

    myQuestionText = theQuestionText;
    myOptionA = theOptionA;
    myOptionB = theOptionB;
    myOptionC = theOptionC;
    myOptionD = theOptionD;
    myPanel = thePanel;
    myArray = theArray;
  }
  public DirectionButton(mazeContainer theMaze, int theDirection,
      JLabel theQuestionText, JButton theOptionA, JButton theOptionB,
      JButton theOptionC, JButton theOptionD, JPanel thePanel,
      JButton[][] theArray, JLabel theDirectionText) {
    myMaze = theMaze;
    myDirection = theDirection;
    myQuestionText = theQuestionText;
    myOptionA = theOptionA;
    myOptionB = theOptionB;
    myOptionC = theOptionC;
    myOptionD = theOptionD;
    myPanel = thePanel;
    myArray = theArray;
    myDirectionText = theDirectionText;
  }

  public void actionPerformed(ActionEvent e) {

    // returns if the door is in questioning as movement is locked

    if (myMaze.getCurrentDoorFace() != null
        && myMaze.getCurrentDoorFace().getQuestioningStatus()
        && myMaze.getDoorDirection() != myDirection
        && myMaze.getCurrentDoorFace().getBlockedStatus() == false) {
      return;
    }

    myMaze.setDoorDirection(myDirection);
    myDirectionText
        .setText("Currently Facing " + myMaze.getCurrentDoorFaceString());
    if (myMaze.getCurrentDoorFace().getBlockedStatus() == true) {
      myPanel.setVisible(false);
    }
    if (myMaze.getCurrentDoorFace().getBlockedStatus() == false) {
      myPanel.setVisible(true);
    } else {
      JOptionPane.showMessageDialog(myPanel, "Door in the " + myMaze.getCurrentDoorFaceString() +" is locked!\n" + "Please choose a different door!", "Warning", JOptionPane.WARNING_MESSAGE);
      System.out.println("that door is blocked");
    }

    if (myMaze.getCurrentRoom().checkBlockedDoors()) {
      String loseMessage = "You Lose :( \n" + "Please Try Again!";
      JOptionPane.showMessageDialog(myPanel, loseMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
      System.out.println("game over");
      System.exit(0);
    }
    if (myMaze.getCurrentDoorFace().checkDoor()) {
      // int index = myMaze.getCurrrentX()
      JButton beforeMove = myArray[myMaze.getCurrentY() - 1][myMaze
          .getCurrentX() - 1];
      beforeMove.setText("*");
      myMaze.moveFaceDirection();
      JButton afterMove = myArray[myMaze.getCurrentY() - 1][myMaze.getCurrentX()
          - 1];
      afterMove.setText("'*'");
      
      System.out.println("moved");
      
      // move door direction out of range
      myMaze.setDoorDirection(5);
      myPanel.setVisible(false);
      myDirectionText
          .setText("Currently Facing " + myMaze.getCurrentDoorFaceString());
      return;
    }

    if (myMaze.checkInBoundDirection(myDirection)) {

      System.out.println("checked in bound x");
      if (myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion) {

        myQuestionText
            .setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()
                + " (TF)");
      } else {
        myQuestionText
            .setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()
                + " (MC)");
      }
      System.out
          .println(myMaze.getCurrentDoorFace().getQuestion().getQuestionText());
      myOptionA.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionA());
      myOptionB.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionB());
      myOptionC.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionC());
      myOptionD.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionD());
      if (myDirection == 0) {
        System.out.println("got to set the question for west direction");
      }
      // sets questioning status
      myMaze.getCurrentDoorFace().setQuestioningStatus(true);
    }

    System.out.println(myMaze.getCurrentXYString());
    if (myMaze.won()) {
      String winMessage = "You win!\n" + "Congratulation!";
      JOptionPane.showMessageDialog(myPanel, winMessage, "Win", JOptionPane.INFORMATION_MESSAGE);
      System.out.println("you won");
      System.exit(0);
    }

  }
}