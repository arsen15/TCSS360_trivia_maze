/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class creates the directional buttons that allow player to choose direction.
 * It also displays the win pop up when necessary.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class DirectionButton implements ActionListener {

  /**
   * The maze.
   */
  private final MazeContainer myMaze;
  
  /**
   * Value used to determine the direction.
   */
  private final int myDirection;
  
  /**
   * Panel that holds the button components.
   */
  private final JPanel myPanel;

  /**
   * The text of the question.
   */
  private final JLabel myQuestionText;
  
  /**
   * The buttons for the answer options.
   */
  private final JButton myOptionA;
  private final JButton myOptionB;
  private final JButton myOptionC;
  private final JButton myOptionD;
  
  /**
   * Image label used to show the images for each question.
   */
  private JLabel myImageLabel;
  
  private JButton[][] myArray;
  private JLabel myDirectionText;

  /**
   * The constructor that initializes the object when called.
   * 
   * @param theMaze
   * @param theDirection
   * @param theQuestionText
   * @param theOptionA
   * @param theOptionB
   * @param theOptionC
   * @param theOptionD
   * @param thePanel
   * @param theArray
   * @param theDirectionText
   * @param theImage
   */
  public DirectionButton(MazeContainer theMaze, int theDirection,
      final JLabel theQuestionText, JButton theOptionA, JButton theOptionB,
      JButton theOptionC, JButton theOptionD, JPanel thePanel,
      JButton[][] theArray, JLabel theDirectionText, JLabel theImage) {
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
    myImageLabel = theImage;
  }

  /**
   * The action event for all of the directional buttons, question images, directional label.
   */
  public void actionPerformed(ActionEvent theEvent) {
    // myDirectionText.setText("Currently Facing
    // "+myMaze.getCurrentDoorFaceString());
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
      JOptionPane.showMessageDialog(myPanel,
          "Door in the " + myMaze.getCurrentDoorFaceString() + " is locked!\n"
              + "Please choose a different door!",
          "Warning", JOptionPane.WARNING_MESSAGE);
      System.out.println("that door is blocked");
    }

    if (myMaze.getCurrentRoom().checkBlockedDoors()) {
      String loseMessage = "You Lose :( \n" + "Please Try Again!";
      JOptionPane.showMessageDialog(myPanel, loseMessage, "Game Over",
          JOptionPane.INFORMATION_MESSAGE);
      System.out.println("game over");
      System.exit(0);
    }

    if (myMaze.getCurrentRoom().checkBlockedDoors()) {
      System.out.println("game over");
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

      System.out.println("Moved into the room.");
      // move door direction out of range
      myMaze.setDoorDirection(5);
      myPanel.setVisible(false);
      myImageLabel.setVisible(false);
      myDirectionText
          .setText("Currently Facing " + myMaze.getCurrentDoorFaceString());
      return;
    }

    if (myMaze.checkInBoundDirection(myDirection)) {

      System.out.println("checked in bound x");

      // likely the problem zone
      if (myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion) {

        myQuestionText
            .setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()
                + " (TF)");
      } else {
        myQuestionText
            .setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()
                + " (MC)");
      }

      File f = myMaze.getCurrentDoorFace().getQuestion().getImage();
      try {

        BufferedImage picture = ImageIO.read(f);

        myImageLabel.setIcon(new ImageIcon(picture));
        myImageLabel.setVisible(true);
      } catch (Exception z) {
        System.out.println("error loading image or audio" + z.getMessage());
      }

      System.out
          .println(myMaze.getCurrentDoorFace().getQuestion().getQuestionText());
      myOptionA.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionA());
      System.out.println(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionA());
      myOptionB.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionB());
      myOptionC.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionC());
      myOptionD.setText(
          myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionD());

      // sets questioning status
      myMaze.getCurrentDoorFace().setQuestioningStatus(true);
    }

    System.out.println(myMaze.getCurrentXYString());
    if (myMaze.won()) {
      String winMessage = "You win!\n" + "Congratulations!";
      JOptionPane.showMessageDialog(myPanel, winMessage, "Win",
          JOptionPane.INFORMATION_MESSAGE);
      System.out.println("you won");
      System.exit(0);
    }

  }
}
