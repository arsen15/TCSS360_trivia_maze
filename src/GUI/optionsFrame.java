package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class optionsFrame extends JFrame {

  /**
   * 
   */
  private static final long serialVersionUID = 8034933460843923748L;

  /**
   * The menu panel.
   */
  private gameMenu menu;

  private JPanel panel;
  public static final int WIDTH = 500; 
  public static final int HEIGHT = 500;
  
  /**
   * The constructor.
   * 
   * @param menu
   */
  public optionsFrame(gameMenu menu) {
    super("Rules");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // saving the menu, so we can return to it after closing the game, saving
    // the game should return to game menu too.
    this.menu = menu;

    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        returnToMenu();
        add(panel, BorderLayout.SOUTH);
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

  public void returnToMenu() {
    panel = new JPanel();

    JButton returnToMenu = new JButton("Return to Menu");
    returnToMenu.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        menu.setVisible(true);
      }
    });
    panel.add(returnToMenu);
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
