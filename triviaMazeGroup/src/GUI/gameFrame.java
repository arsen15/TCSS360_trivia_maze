/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import triviaMaze.GameSaveAndLoad;
import triviaMaze.MazeContainer;
import triviaMaze.TriviaSQL;

/**
 * This class calls upon the game menu and then the game itself. This class runs the 
 * program by "holding" the game and the menu.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class GameFrame extends JFrame {


  private static final long serialVersionUID = 3800326469028396142L;
  
  /**
   * Counter for number of saves.
   */
  private static int myClick = 0;
  /**
   * Dimensions
   */
  public static final int WIDTH = 1480;
  public static final int HEIGHT = 1000;

  /**
   * The menu panel.
   */
  private final GameMenu myMenu;

  /**
   * The game panel.
   */
  private TriviaMazePanel myGame;

  /**
   * The constructor of the game frame. It is used to run the program as well the in game sub menu. 
   * @param theMenu
   */
  public GameFrame(final GameMenu theMenu) {
    super("Video Game Trivia");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    // saving the menu, so we can return to it after closing the game.
    this.myMenu = theMenu;

    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        // pass door arraylist of doors containing questions to the maze
        // container from the SQL for door and question choices
        TriviaSQL sq = new TriviaSQL();
        MazeContainer mC = new MazeContainer();
        mC.fixedArraySetup();
        mC.setDoors(sq.setup());
        myGame = new TriviaMazePanel(mC);
        myGame.start();
        myGame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(myGame, BorderLayout.CENTER);

        // Create a menu option to store SAVE, LOAD, EXIT buttons in game.
        JMenuBar menuBar = new JMenuBar();
        // Create a menu option in game.
        JMenu subMenu = new JMenu("File");
        menuBar.add(subMenu);
        // Create a Help menu option in game.
        JMenu subMenu2 = new JMenu("Help");
        menuBar.add(subMenu2);
        // Add the cheat button that shows the answers to the questions.
        JMenuItem cheatMenuButton = new JMenuItem("Cheat", KeyEvent.VK_C);
        cheatMenuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            // Print out the cheat sheet in the Console.
            System.out
                .println("\n--- Cheat Sheet is printed in the Console ---\n"
                    + "1. Who/What does gael seek?\n"
                    + "Answer: The Dark Soul\n" + "2. Artorias slew manus\n"
                    + "Answer: F"
                    + "3. Who says 'we're more ghosts than people'\n"
                    + "Answer: Arthur Morgan\n"
                    + "4. In the story of GTA V, Michael is in the witness protection program.\n"
                    + "Answer: T");

            // A pop up will appear when the player chooses Cheat in the Help
            // sub menu.
            String answers = "1. Who/What does gael seek?\r\n"
                + "Answer: The Dark Soul\n" + "2. Artorias slew manus\n"
                + "Answer: F\n"
                + "3. Who says 'we're more ghosts than people'\n"
                + "Answer: Arthur Morgan\n"
                + "4. In the story of GTA V, Michael is in the witness protection program.\n"
                + "Answer: F\n"
                + "5. Who does this album art depict? \n"
                + "Answer: Artorias\n"
                + "6. What song is played at the end of Hades? \n"
                + "Answer: It's in the blood. \n"
                + "7. The soul of cinder is found at the first flame. \n"
                + "Answer: T \n"
                + "8. Gwyn,Lord of cinder, is the final boss of dark souls 1. \n"
                + "Answer: T \n"
                + "9. In Skyrim guards say \"i used to be an adventurer like you until...\" \n"
                + "Answer: I took an arrow to the knee. \n"
                + "10. What is the name of the player character in Disco Elysium. \n"
                + "Answer: Harrier Du Bois";
            JOptionPane.showMessageDialog(myGame, answers, "Cheat Sheet",
                JOptionPane.INFORMATION_MESSAGE);
          }
        });
        // Add the Help button into the sub menu.
        subMenu2.add(cheatMenuButton);

        // A sub menu in game. Allow us to SAVE the game.
        JMenuItem saveMenuButton = new JMenuItem("SAVE", KeyEvent.VK_S);
        subMenu.add(saveMenuButton);

        // Save the game when SAVE button is pressed. And generate different
        // save files.
        saveMenuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            System.out.println("you pressed SAVE");
            try {

              myClick++;
              System.out.println(myClick);
              GameSaveAndLoad.saveGame(mC, myClick + " Maze.ser");
            } catch (Exception e) {
              System.out.println(
                  "Something is wrong! Couldn't save!\n" + e.getMessage());
            }
          }
        });

        // Allow us to LOAD the game. 
        JMenuItem loadMenuButton = new JMenuItem("LOAD", KeyEvent.VK_L);
        subMenu.add(loadMenuButton);
        loadMenuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            System.out.println("you pressed LOAD");
            try {
              // Load the game with the data and initialize the new maze. 
              UIManager.put("FileChooser.saveButtonText", "Open");
              JFileChooser jChooser = new JFileChooser(
                  FileSystemView.getFileSystemView().getHomeDirectory());
              jChooser.showSaveDialog(null);

              final TriviaMazePanel mainPanel = new TriviaMazePanel(returnMaze(GameSaveAndLoad.loadGame(jChooser.getSelectedFile().getName())));
              mainPanel.start();
              setContentPane(mainPanel);
              setVisible(true);
            } catch (Exception e) {
              System.out
                  .println("Something is wrong! Couldn't load the saved data!\n"
                      + e.getMessage());
            }
          }
        });

        // Exit button that allows us to close the game.
        JMenuItem exitMenuButton = new JMenuItem("Exit", KeyEvent.VK_E);
        subMenu.add(exitMenuButton);
        exitMenuButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
        	  setVisible(false);
        	  myMenu.setVisible(true);
          }

        });
        setJMenuBar(menuBar);
      }
    });

    setLocationRelativeTo(null);
  }
  
  /**
   * Recreates the maze after loading in a save file.
   * @param theMaze is the maze that loads in.
   * @return
   */
  public static MazeContainer returnMaze(final MazeContainer theMaze) {
    TriviaSQL sq = new TriviaSQL();
    theMaze.fixedArraySetup();
    theMaze.setDoors(sq.setup());
    return theMaze;
  }
  
  /**
   * Allows to return to the game menu when game is closed.
   */
  @Override
  public void dispose() {
    super.dispose();
    myMenu.setVisible(true);
  }

}
