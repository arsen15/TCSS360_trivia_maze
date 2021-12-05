package trviaGUIComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class gameFrame extends JFrame{
  
  /**
   * 
   */
  private static final long serialVersionUID = 3800326469028396142L;
  /**
   * Dimensions
   */
  public static final int WIDTH = 500; 
  public static final int HEIGHT = 500;
  public static final int SCALE = 2;
  
  //the menu panel
  private gameMenu menu;
  
  //the game panel
  private triviaGUI game;
  
  public gameFrame(gameMenu menu) {
    super();
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    
    //saving the menu, so we can return to it after game is over
    this.menu = menu;
    
    //the panel to hold the menu buttons
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    
    /**
     * The start button. Starts the game when clicked.
     */
    JButton startButton = new JButton("START");
    startButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        
        game.init();
        
      }
      
    });
    
    panel.add(startButton, BorderLayout.WEST);
    
    /**
     * The quit button, closes the game when clicked.
     */
    JButton quitButton = new JButton("QUIT");
    quitButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        
        gameFrame.this.setVisible(false);
        gameFrame.this.dispose();
        
      }
      
    });
    
    panel.add(quitButton, BorderLayout.EAST);
    
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
    
    //game.pause();
    
    menu.setVisible(true);
  }
}
