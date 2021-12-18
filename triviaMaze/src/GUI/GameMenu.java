/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This class creates the main menu of the game. The program runs by calling upon the menu.
 * It holds the start, options, quit buttons. 
 * The menu buttons appear on hover.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class GameMenu extends JFrame {

  private static final long serialVersionUID = -4802340630976324291L;

  /**
   * Frame Dimensions
   */
  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;

  /**
   * The vertical distance between the menu buttons.
   */
  private int VERT_GAP_BETWEEN_BUTTONS = 10;
  
  /**
   * The dimensions of the buttons.
   */
  private final Dimension BUTTON_SIZE = new Dimension(100, 100);
  
  /**
   * Insets dimensions.
   */
  private final Insets INSETS_DIMENSIONS = new Insets(150, 190, 150, 190); 
  
  /**
   * Start button color.
   */
  private final Color START_COLOR = new Color(156, 117, 186);
  
  /**
   * Options button color.
   */
  private final Color OPTIONS_COLOR = new Color(232, 125, 185);
  
  /**
   * The background image of the menu.
   */
  private BufferedImage myBackgroundImage;
  
  /**
   * The JPanel that holds contents of the JFrame.
   */
  private JPanel myPanel;

  /**
   * The game menu constructor. It initializes the game menu.
   */
  public GameMenu() {
	  
    super("Video Game Trivia");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setResizable(false);
    
    File file = new File("MenuBackground.jpg");
    try {
    	 myBackgroundImage = ImageIO.read(file);
    	 
    } catch (final Exception theException) {
        System.out.println("Error loading image or audio" + theException.getMessage());
      }
    
    myPanel = new JPanel();
    myPanel.setBorder(new EmptyBorder(INSETS_DIMENSIONS));
    myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));    
    music();

    // Start button
    JButton start = new JButton("START");
    start.setPreferredSize(BUTTON_SIZE);
    start.addActionListener(new gameListener());
    start.setBackground(START_COLOR);
    myPanel.add(start);
   
    myPanel.add(Box.createVerticalStrut(VERT_GAP_BETWEEN_BUTTONS));
    
    // Options button
    JButton options = new JButton("OPTIONS");
    options.setPreferredSize(BUTTON_SIZE);
    options.addActionListener(new optionsListener());
    options.setBackground(OPTIONS_COLOR);
    myPanel.add(options);
    pack();
    
    myPanel.add(Box.createVerticalStrut(VERT_GAP_BETWEEN_BUTTONS));

    // The quit button
    JButton quit = new JButton("Quit Game");
    quit.setPreferredSize(BUTTON_SIZE);
    quit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Quit the program
        System.exit(0);
      }
    });
    quit.setBackground(Color.PINK);
    myPanel.add(quit);
      
    setLocationRelativeTo(null); // Center in screen
    
    add(myPanel);
    myPanel.setVisible(true);
  }

  /**
   * Action listener for the start button. It starts the game.
   * @author Arsen Shintemirov, Ryan Montoya, Phuc Luu
   *
   */
  private class gameListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent theEvent) {
      setVisible(false);
      new GameFrame(GameMenu.this).setVisible(true);
    }
  }

  /**
   * Action listener for the options button. It opens the options page.
   * @author Arsen Shintemirov, Ryan Montoya, Phuc Luu
   *
   */
  private class optionsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent theEvent) {
      setVisible(false);
      new OptionsFrame(GameMenu.this).setVisible(true);
      
    }
  }
  
  /**
   * The music class fetches the audio file and plays it. This is the background music of the game.
   */
  public static void music() {
		 
	  try {
		  
		File musicFile = new File("Blazer Rail.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(musicFile);
		Clip clip = AudioSystem.getClip();
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.setFramePosition(0);
        clip.start();
        
	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  
  /**
   * Paints the components of the JPanel, specifically the background image.
   */
  @Override
  public void paint(Graphics theGraphic) {
	   myPanel.paint(theGraphic);
	   Graphics2D graphics = (Graphics2D) theGraphic;
	   graphics.drawImage(myBackgroundImage, 0, 0, null );
	   
  }

}