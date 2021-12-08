package trviaGUIComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import triviaMaze.DirectionButton;
import triviaMaze.QuestionButton;
import triviaMaze.gameSaveAndLoad;
import triviaMaze.mazeContainer;
import triviaMaze.triviaSQL;

public class triviaGUI extends JPanel {

  /**
   * Unique ID that helps keep track of the class.
   */
  private static final long serialVersionUID = 197500895779284794L;
  private mazeContainer myMaze;

  /**
   * Constructor that helps set up the maze.
   * 
   * @param theMaze
   */
  public triviaGUI(mazeContainer theMaze) {
    myMaze = theMaze;
  }

  /**
   * Second constructor that initializes the mazeContainer class.
   */
  public triviaGUI() {
    myMaze = new mazeContainer();
  }

  /**
   * A method that helps set up the new maze.
   * 
   * @param theMaze
   *          the new maze
   */
  public void setMaze(mazeContainer theMaze) {
    myMaze = theMaze;
  }

  /**
   * Start the whole GUI with all the necessary components.
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

    // Assign the different action listener to when you choose options A, B, C,
    // D.
    myOptionA.addActionListener(new QuestionButton(myMaze, 'A', southPanel));
    myOptionB.addActionListener(new QuestionButton(myMaze, 'B', southPanel));
    myOptionC.addActionListener(new QuestionButton(myMaze, 'C', southPanel));
    myOptionD.addActionListener(new QuestionButton(myMaze, 'D', southPanel));

    add(southPanel, BorderLayout.SOUTH);

    // Construct the maze with the size 5x5.
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
    // Create a group of buttons that helps users navigate throughout the maze.
    JPanel EastPanel = new JPanel();
    JLabel faceText = new JLabel(
        "Currently Facing " + myMaze.getCurrentDoorFaceString());
    // Add different direction buttons and place them accordingly to their
    // position.
    JButton north = new JButton("north");
    north.addActionListener(
        new DirectionButton(myMaze, 1, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText));
    EastPanel.add(north, BorderLayout.NORTH);

    JButton south = new JButton("south");
    south.addActionListener(
        new DirectionButton(myMaze, 3, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText));
    EastPanel.add(south, BorderLayout.SOUTH);

    JButton west = new JButton("west");
    west.addActionListener(
        new DirectionButton(myMaze, 0, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText));
    EastPanel.add(west, BorderLayout.WEST);

    JButton east = new JButton("east");
    east.addActionListener(
        new DirectionButton(myMaze, 2, myQuestionText, myOptionA, myOptionB,
            myOptionC, myOptionD, southPanel, keyButtons, faceText));
    EastPanel.add(east, BorderLayout.EAST);
    EastPanel.add(faceText, BorderLayout.EAST);
    add(EastPanel, BorderLayout.EAST);

  }
  // Pass door arraylist of doors containing questions to the maze container
  // from the SQL for door and question choices.
  // MazeContainer sets up doors trivia SQL might move some to it as well
  public static void main(final String[] theArgs) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        triviaSQL sq = new triviaSQL();
        mazeContainer mC = new mazeContainer();
        mC.fixedArraySetup();
        mC.setDoors(sq.setup());
        final triviaGUI mainPanel = new triviaGUI(mC);
        mainPanel.start();

        // A size for the JFrame. Name the game VideoGameTrivia.
        final Dimension frameSize = new Dimension(500, 500);
        final JFrame window = new JFrame("VideoGameTriva");
        // Close the game when users choose "X". Center the game in the middle
        // of the screen.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(frameSize);
        window.setLocationRelativeTo(null);
        window.setContentPane(mainPanel);
        window.pack();

        // Create a menu option to store SAVE, LOAD, EXIT buttons in game.
        JMenuBar menuBar = new JMenuBar();
        // Create a menu option in game.
        JMenu subMenu = new JMenu("File");
        menuBar.add(subMenu);
        // A sub menu in game. Allow us to SAVE the game.
        JMenuItem saveMenuButton = new JMenuItem("SAVE", KeyEvent.VK_S);
        subMenu.add(saveMenuButton);

        // Save the game when SAVE button is pressed.
        saveMenuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            System.out.println("you pressed SAVE");
            try {
              gameSaveAndLoad.saveGame(mC, "currentMazeVer.ser");
            } catch (Exception e) {
              System.out.println(
                  "Something is wrong! Couldn't save!" + e.getMessage());
            }
          }
        });

        // Allow us to LOAD the game. NOT FINISHED! CAN ONLY LOAD THE GAME ONE
        // TIME ATM!
        JMenuItem loadMenuButton = new JMenuItem("LOAD", KeyEvent.VK_L);
        subMenu.add(loadMenuButton);
        loadMenuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            System.out.println("you pressed LOAD");
            try {
              // Load the game with the data and initialize the new maze.
              mazeContainer maze = (mazeContainer) gameSaveAndLoad
                  .loadGame("currentMazeVer.ser");
              triviaSQL sq = new triviaSQL();
              maze.fixedArraySetup();
              maze.setDoors(sq.setup());
              // Assign the new updated maze into the mainPanel and show it.
              final triviaGUI mainPanel = new triviaGUI(maze);
              mainPanel.start();
              window.pack();
              window.setContentPane(mainPanel);
            } catch (Exception e) {
              System.out
                  .println("Something is wrong! Couldn't load the saved data!"
                      + e.getMessage());
            }

          }
        });

        // Exit button that allows us to close the game.
        JMenuItem exitMenuButton = new JMenuItem("Exit", KeyEvent.VK_E);
        subMenu.add(exitMenuButton);
        exitMenuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            System.exit(0);
          }
        });
        window.setJMenuBar(menuBar);
        window.setVisible(true);
      }
    });
  }
}