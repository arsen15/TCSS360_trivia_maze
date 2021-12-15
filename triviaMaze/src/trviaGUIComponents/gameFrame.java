package trviaGUIComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import triviaMaze.gameSaveAndLoad;
import triviaMaze.mazeContainer;
import triviaMaze.triviaSQL;




public class gameFrame extends JFrame{
  
  /**
   * 
   */
  private static final long serialVersionUID = -8032623552230545157L;
  /**
   * 
   */

  
  /**
   * Dimensions
   */
  public static final int WIDTH = 500; 
  public static final int HEIGHT = 500;
  
  /**
   * The menu panel.
   */
  private gameMenu menu;
  
  /**
   * The game panel.
   */
  private triviaGUI game;
  
  mazeContainer mC = new mazeContainer();
  
  public gameFrame(gameMenu menu) {
    super();
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    //saving the menu, so we can return to it after closing the game, saving the game should return to game menu too.
    this.menu = menu;
    
    game = new triviaGUI(mC);
    
    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        //pass door arraylist of doors containing questions to the maze container from the SQL for door and question choices 
        triviaSQL sq = new triviaSQL();
        
        mC.fixedArraySetup();    
        mC.setDoors(sq.setup());
//        game = new triviaMazePanel(mC);
        game.start();
        add(game, BorderLayout.CENTER);
        
        
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
                  mazeContainer maze = (mazeContainer) gameSaveAndLoad.loadGame("currentMazeVer.ser");
                  maze.fixedArraySetup();
                  maze.setDoors(sq.setup());
                   game = new triviaGUI(maze);
                   game.start();
                   add(game, BorderLayout.CENTER);
                   //game needs to equal the same triviaMazePanel, but with updated mC


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

               setVisible(false);
          menu.setVisible(true);
              }
            });
            
            setJMenuBar(menuBar);
            
      }
  
    });

    // Pack the frame
    pack();
    setLocationRelativeTo(null); // Center in screen
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