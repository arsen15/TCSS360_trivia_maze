/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This class creates the options page of the game.
 * It contains a short list of rules for the game.
 *   
 * @author Arsen Shintemirov, Phuc Luu, Ryan Montoya
 * @version 12/17/2021
 */
public class OptionsFrame extends JFrame {

  private static final long serialVersionUID = 8034933460843923748L;
  
  /**
   * The dimensions of the options screen.
   */
  public static final int WIDTH = 500; 
  public static final int HEIGHT = 500;
  
  /**
   * The menu.
   */
  private GameMenu myMenu;

  /**
   * The panel that holds JFrame components.
   */
  private JPanel myPanel;

  
  /**
   * The constructor that initializes the options object.
   * 
   * @param theMenu
   */
  public OptionsFrame(GameMenu theMenu) {
    super("Rules");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // saving the menu, so we can return to it after closing the game, saving
    // the game should return to game menu too.
    this.myMenu = theMenu;

    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        returnToMenu();
        add(myPanel, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        String textInOptionButton = "\t      RULES\n"
            + "1) The goal of the game is to reach the end of the maze by moving from room to room.\n"
            + "2) Before a player can enter a room through a door, they must answer a question correctly.\n"
            + "3) Each room has a question on each door present in the room.\n"
            + "4) If a question is answered wrong, that door locks.\n"
            + "5) If all doors in a room are locked, the player loses and the game ends.\n";
        JTextArea textArea = new JTextArea(500, 500);
        textArea.setText(textInOptionButton);
        textArea.setFont(new Font("Serif", Font.PLAIN, 25));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        setLocationRelativeTo(null);
        add(textArea, BorderLayout.CENTER);
      }

    });
    // Pack the frame
    pack();
    setLocationRelativeTo(null); // Center in screen
  }

  /**
   * This method holds the button and action listener that allows player to return to main menu.
   */
  public void returnToMenu() {
    myPanel = new JPanel();

    JButton returnToMenu = new JButton("Return to Menu");
    returnToMenu.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent theEvent) {
        setVisible(false);
        myMenu.setVisible(true);
      }
    });
    myPanel.add(returnToMenu);
  }

  /**
   * Allows to return to the game menu.
   */
  @Override
  public void dispose() {
    super.dispose();
    myMenu.setVisible(true);
  }
}
