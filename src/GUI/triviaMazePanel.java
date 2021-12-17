package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import triviaMaze.DirectionButton;
import triviaMaze.QuestionButton;
import triviaMaze.TFQuestion;
import triviaMaze.GameSaveAndLoad;
import triviaMaze.mazeContainer;

//the way triviaGUI is rn is it creates a panel, but we already have gamePanel, so we only need the buttons and other things in a method init or start and then
//run that method in the constructor. where do we include the SQL stuff?
public class triviaMazePanel extends JPanel {

  /**
   * 
   */
  private static final long serialVersionUID = 197500895779284794L;

  /**
   * Dimensions
   */
  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;

  private mazeContainer myMaze;

  public triviaMazePanel(mazeContainer theMaze) {
    super();
    myMaze = theMaze;
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    
  }

  public void start() {

    this.setLayout(new BorderLayout());
    
    // JPanel panel = new JPanel();

    // JButton north = new JButton("north");

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
    
    // add(panel, BorderLayout.EAST);

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
    JButton north = new JButton("north");
    JLabel image = new JLabel();
    EastPanel.add(image, BorderLayout.WEST);
    north.addActionListener(
        new DirectionButton(myMaze, 1, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(north, BorderLayout.NORTH);

    JButton south = new JButton("south");
    south.addActionListener(
        new DirectionButton(myMaze, 3, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(south, BorderLayout.SOUTH);

    JButton west = new JButton("west");
    west.addActionListener(
        new DirectionButton(myMaze, 0, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(west, BorderLayout.WEST);

    JButton east = new JButton("east");
    east.addActionListener(
        new DirectionButton(myMaze, 2, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText, image));
    EastPanel.add(east, BorderLayout.EAST);
    // JLabel faceText = new JLabel("Currently
    // "+myMaze.getCurrentDoorFaceString());
    EastPanel.add(faceText, BorderLayout.EAST);
    add(EastPanel, BorderLayout.EAST);
   
  }

}