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
import triviaMaze.gameSaveAndLoad;
import triviaMaze.mazeContainer;
import triviaMaze.triviaSQL;

public class gameFrame extends JFrame {

  /**
   * 
   */
  private static final long serialVersionUID = 3800326469028396142L;
  private static int click = 0;
  /**
   * Dimensions
   */
  public static final int WIDTH = 1480;
  public static final int HEIGHT = 600;

  /**
   * The menu panel.
   */
  private gameMenu menu;

  /**
   * The game panel.
   */
  private triviaMazePanel game;

  public gameFrame(gameMenu menu) {
    super("Video Game Trivia");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    // saving the menu, so we can return to it after closing the game, saving
    // the game should return to game menu too.
    this.menu = menu;

    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        // pass door arraylist of doors containing questions to the maze
        // container from the SQL for door and question choices
        triviaSQL sq = new triviaSQL();
        mazeContainer mC = new mazeContainer();
        mC.fixedArraySetup();
        mC.setDoors(sq.setup());
        game = new triviaMazePanel(mC);
        game.start();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(game, BorderLayout.CENTER);

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
                + "Answer: F";
            JOptionPane.showMessageDialog(game, answers, "Cheat Sheet",
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

              click++;
              System.out.println(click);
              gameSaveAndLoad.saveGame(mC, click + " Maze.ser");
            } catch (Exception e) {
              System.out.println(
                  "Something is wrong! Couldn't save!\n" + e.getMessage());
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
              // Load the game with the data and initialize the new maze. Need
              // to have something like a fileCHooser to allow players to choose
              // the
              // file that they want.
              // Create a file Chooser for LOAD method. And changed the save
              // button text on FileChooser to Open.
              // Source:
              // https://community.oracle.com/tech/developers/discussion/1390408/jfilechooser-uimanager-keys-i18n
              UIManager.put("FileChooser.saveButtonText", "Open");
              JFileChooser jChooser = new JFileChooser(
                  FileSystemView.getFileSystemView().getHomeDirectory());
              jChooser.showSaveDialog(null);
              // mazeContainer maze = (mazeContainer) gameSaveAndLoad
              // .loadGame(jChooser.getSelectedFile().getName());
              // // Assign the new updated maze into the mainPanel and show it.
              // final triviaGUI mainPanel = new triviaGUI(returnMaze(maze));
              // // final triviaGUI mainPanel = new triviaGUI(maze);
              final triviaGUI mainPanel = new triviaGUI(
                  returnMaze(gameSaveAndLoad
                      .loadGame(jChooser.getSelectedFile().getName())));
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
            System.exit(0);
          }

        });
        setJMenuBar(menuBar);
      }
    });

    setLocationRelativeTo(null);
  }
  public static mazeContainer returnMaze(mazeContainer theMaze) {
    triviaSQL sq = new triviaSQL();
    theMaze.fixedArraySetup();
    theMaze.setDoors(sq.setup());
    return theMaze;
  }

  /**
   * Allows to return to the game menu.
   */
  @Override
  public void dispose() {
    super.dispose();
    menu.setVisible(true);
  }

}
