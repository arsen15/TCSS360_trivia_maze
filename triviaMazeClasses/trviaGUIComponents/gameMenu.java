package trviaGUIComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gameMenu extends JFrame {
  
  /**
   * 
   */
  private static final long serialVersionUID = -4802340630976324291L;
  
  private int VERT_GAP_BETWEEN_BUTTONS = 5;
  
  public gameMenu() {
    super();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(500, 500));
    
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    add(panel, BorderLayout.NORTH);
    
    //Panel to hold the several elements in the menuPanel and prevent window's dimension change.
    JPanel containerPanel = new JPanel();
    containerPanel.setLayout(new BorderLayout());
    
    //Menu buttons panel
    JPanel menuButtonsPanel = new JPanel();
    GridLayout menuButtonsLayout = new GridLayout(0, 1);
    menuButtonsLayout.setVgap(VERT_GAP_BETWEEN_BUTTONS);
    menuButtonsPanel.setLayout(menuButtonsLayout);
    containerPanel.add(menuButtonsPanel, BorderLayout.NORTH);
    
    JButton start = new JButton("START");
    start.setPreferredSize(new Dimension(30, 30));
    start.addActionListener(new gameListener());
    menuButtonsPanel.add(start);
    
    add(containerPanel, BorderLayout.CENTER);
    
    // The quit button
    JButton quit = new JButton("Quit Game");
    quit.addActionListener(new ActionListener() {
    @Override
      public void actionPerformed(ActionEvent e) {
        // Quit the program
        System.exit(0);
      }
    });
    quit.setBackground(Color.LIGHT_GRAY);
    add(quit, BorderLayout.SOUTH);
        
    pack();
    setLocationRelativeTo(null); // Center in screen
  }
  
  private class gameListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      
      setVisible(false);
      
      new gameFrame(gameMenu.this).setVisible(true);
    }
    
  }

}