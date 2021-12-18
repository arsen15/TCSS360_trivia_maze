/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import triviaMaze.DirectionButton;
import triviaMaze.QuestionButton;
import triviaMaze.MazeContainer;

/**
 * This class creates the maze GUI.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov  
 * @version 12/17/2021
 */
public class TriviaMazePanel extends JPanel {

  private static final long serialVersionUID = 197500895779284794L;

  /**
   * Dimensions of the JPanel.
   */
  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;

  /**
   * The maze object used to create the maze.
   */
  private MazeContainer myMaze;
  
  /**
   * The constructor that initializes the object when called.
   * @param theMaze
   */
  public TriviaMazePanel(MazeContainer theMaze) {
    super();
    myMaze = theMaze;
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    
  }

  /**
   * This method builds the maze, questions, directional buttons and label.
   */
  public void start() {

    this.setLayout(new BorderLayout());

    JPanel southPanel = new JPanel();

    JLabel myQuestionText = new JLabel("temp Question");
    JButton myOptionA = new JButton("TEMPA");
    JButton myOptionB = new JButton("TEMPB");
    JButton myOptionC = new JButton("TEMPC");
    JButton myOptionD = new JButton("TEMPD");
    southPanel.setLayout(new GridLayout(1, 6));
    southPanel.add(myQuestionText);
    southPanel.add(myOptionA);
    southPanel.add(myOptionB);
    southPanel.add(myOptionC);
    southPanel.add(myOptionD);
    southPanel.setVisible(false);
    add(southPanel, BorderLayout.SOUTH);

    myOptionA.addActionListener(new QuestionButton(myMaze, 'A', southPanel));
    myOptionB.addActionListener(new QuestionButton(myMaze, 'B', southPanel));
    myOptionC.addActionListener(new QuestionButton(myMaze, 'C', southPanel));
    myOptionD.addActionListener(new QuestionButton(myMaze, 'D', southPanel));

    add(southPanel, BorderLayout.SOUTH);

    JPanel westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(5, 5));

    int rowSize = 5;
    int columnSize = 5;
    final JButton[][] keyButtons = new JButton[rowSize][columnSize];

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        if (i == 0 && j == 0) {
          keyButtons[i][j] = new JButton("'*'");
        } else {
          keyButtons[i][j] = new JButton("*");
        }
        westPanel.add(keyButtons[i][j]);
      }
    }

    add(westPanel, BorderLayout.WEST);

    JPanel EastPanel = new JPanel();
    JLabel faceText = new JLabel(
        "Currently Facing " + myMaze.getCurrentDoorFaceString());
    JButton north = new JButton("North");
    JLabel image = new JLabel();
    EastPanel.add(image, BorderLayout.WEST);
    north.addActionListener(
        new DirectionButton(myMaze, 1, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(north, BorderLayout.NORTH);

    JButton south = new JButton("South");
    south.addActionListener(
        new DirectionButton(myMaze, 3, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(south, BorderLayout.SOUTH);

    JButton west = new JButton("West");
    west.addActionListener(
        new DirectionButton(myMaze, 0, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(west, BorderLayout.WEST);

    JButton east = new JButton("East");
    east.addActionListener(
        new DirectionButton(myMaze, 2, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(east, BorderLayout.EAST);
    EastPanel.add(faceText, BorderLayout.EAST);
    add(EastPanel, BorderLayout.EAST);
   
  }

}