package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import triviaMaze.gameSaveAndLoad;
import triviaMaze.mazeContainer;
import triviaMaze.triviaSQL;

public class gameMenu extends JFrame {

  /**
   * 
   */
  private static final long serialVersionUID = -4802340630976324291L;

  /**
   * Dimensions
   */
  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;

  private int VERT_GAP_BETWEEN_BUTTONS = 10;

  public gameMenu() {
    super("Video Game Trivia");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));

    // Start button
    JButton start = new JButton("START");
    start.setPreferredSize(new Dimension(50, 50));
    start.addActionListener(new gameListener());

    // Load button
    // JButton load = new JButton("LOAD");
    // load.setPreferredSize(new Dimension(50, 50));
    // load.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent ae) {
    // load.setEnabled(false);
    // }
    // }
    // );
    // load.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent ev) {
    // System.out.println("you pressed LOAD");
    // try {
    // // Load the game with the data and initialize the new maze. Need
    // // to have something like a fileCHooser to allow players to choose
    // // the
    // // file that they want.
    // // Create a file Chooser for LOAD method. And changed the save
    // // button text on FileChooser to Open.
    // // Source:
    // //
    // https://community.oracle.com/tech/developers/discussion/1390408/jfilechooser-uimanager-keys-i18n
    // UIManager.put("FileChooser.saveButtonText", "Open");
    // JFileChooser jChooser = new JFileChooser(
    // FileSystemView.getFileSystemView().getHomeDirectory());
    // jChooser.showSaveDialog(null);
    // // mazeContainer maze = (mazeContainer) gameSaveAndLoad
    // // .loadGame(jChooser.getSelectedFile().getName());
    // // // Assign the new updated maze into the mainPanel and show it.
    // // final triviaGUI mainPanel = new triviaGUI(returnMaze(maze));
    // // // final triviaGUI mainPanel = new triviaGUI(maze);
    // final triviaGUI mainPanel = new triviaGUI(
    // returnMaze(gameSaveAndLoad
    // .loadGame(jChooser.getSelectedFile().getName())));
    // mainPanel.start();
    // setContentPane(mainPanel);
    // setVisible(true);
    // } catch (Exception e) {
    // System.out
    // .println("Something is wrong! Couldn't load the saved data!\n"
    // + e.getMessage());
    // }
    // }
    // });
    
    // Options button
    JButton options = new JButton("OPTIONS");
    options.setPreferredSize(new Dimension(50, 50));
    options.addActionListener(new optionsListener());
    pack();
    // The quit button
    JButton quit = new JButton("Quit Game");
    quit.setPreferredSize(new Dimension(50, 50));
    quit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Quit the program
        System.exit(0);
      }
    });
    quit.setBackground(Color.LIGHT_GRAY);
    JPanel centerPanel = createCenterVerticalPanel(VERT_GAP_BETWEEN_BUTTONS,
        start, options, quit);
    add(centerPanel);

    // pack();
    setLocationRelativeTo(null); // Center in screen
    // setPreferredSize(new Dimension(1000, 1000));
  }

  protected mazeContainer returnMaze(mazeContainer theMaze) {
    triviaSQL sq = new triviaSQL();
    theMaze.fixedArraySetup();
    theMaze.setDoors(sq.setup());
    return theMaze;
  }

  private static JPanel createCenterVerticalPanel(
      final int spaceBetweenComponents, final JComponent... components) {
    final JPanel panel = new JPanel();

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(new EmptyBorder(new Insets(150, 190, 150, 190)));

    Arrays.stream(components).forEach(component -> {
      component.setAlignmentX(JPanel.CENTER_ALIGNMENT);
      panel.add(component);
      panel.add(Box.createRigidArea(new Dimension(10, spaceBetweenComponents)));
    });

    return panel;
  }

  private class gameListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
      new gameFrame(gameMenu.this).setVisible(true);
      // pack();
    }
  }

  private class optionsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
      new optionsFrame(gameMenu.this).setVisible(true);
      // pack();
    }
  }
}