/**
 * Ryan, Arsen, Phuc
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class triviaGUI extends JPanel {
  /**
   * 
   */
  private static final long serialVersionUID = 197500895779284794L;
  private mazeContainer myMaze;
  public triviaGUI(mazeContainer theMaze) { 
    myMaze = theMaze;
  } 
  public triviaGUI() { 
    
  }

  public void start() {    
    this.setLayout(new BorderLayout());

    JPanel panel = new JPanel(); 
  
    JButton north = new JButton("north");   
    
    JPanel southPanel = new JPanel();
    JButton answerBox = new JButton("answer");    
 
    JLabel errorBox = new JLabel("errorLabel");  
    southPanel.setLayout(new GridLayout(5,1));  
    southPanel.setVisible(false);
    add(southPanel,BorderLayout.SOUTH); 
    
    errorBox.setText("testing box ");
    answerBox.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent e) { 
        System.out.println("new button pressed"); 
        myMaze.getCurrentDoorEast().getQuestion().checkQuestion('A');
        if(myMaze.getCurrentDoorEast().getQuestion().answer()) { 
          //myMaze.moveNorth();
        }
      }
    });
    
    
    // create a panel for the south location i guess idk 
    answerBox.setVisible(false); 
    add(answerBox,BorderLayout.SOUTH);
    
    north.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent e) {  
           if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
             System.out.println("game over");
           }
        if(myMaze.getCurrentDoorNorth().checkDoor()) { 
          myMaze.moveNorth(); 
          System.out.println("moved north ");
        } 
        
        //answerBox.setText(myMaze.getCurrentRoom().getNorth().getQuestion().getQuestionText());
        
        
        // put forward the question connecting buttons then check it in the container  
        
        if(myMaze.checkInBoundY(1)) { 
           answerBox.setVisible(true);
        } else { 
          errorBox.setVisible(true);
        }
        //myMaze.checkNorth();   
        //  answerBox.setVisible(true);
      //  add(new JButton("input"),BorderLayout.SOUTH);
        
         System.out.println("nerd"); 
        //repaint();
      }
    });
    panel.add(north,BorderLayout.NORTH);
    JButton east = new JButton("east");
    panel.add(east,BorderLayout.EAST);
    JButton south = new JButton("south");
    panel.add(south,BorderLayout.SOUTH);
    JButton west = new JButton("west");
    panel.add(west,BorderLayout.WEST);
    add(panel, BorderLayout.EAST);  
    
    JPanel j = new JPanel();  
    j.setLayout(new GridLayout(5,5));
    
     final String[] KEYS = {
              "*", "*", "*", "*", "*",
              "*", "*", "*", "*", "*",
              "*", "*", "*", "*", "*",
              "*", "*", "*", "*", "*",
              "*", "*", "*",  "*", "*" }; 
     
      final JButton[] keyButtons = new JButton[KEYS.length];
     // Dimension KEY_SIZE = new Dimension(50, 50);
    
      for (int i = 0; i < keyButtons.length; i++) {
              keyButtons[i] = new JButton(KEYS[i]);
            //  keyButtons[i].setPreferredSize(KEY_SIZE);
              j.add(keyButtons[i]);
          }
    add(j, BorderLayout.WEST);
  } 
  
  //pass door arraylist of doors containing questions to the maze container from the SQL for door and question choices  
  //mazecontainer sets up doors trivia SQL might move some to it as well 
    public static void main(final String[] theArgs) {
          EventQueue.invokeLater(new Runnable() {
              @Override
              public void run() {  
                triviaSQL sq = new triviaSQL();   
              mazeContainer mC = new mazeContainer(); 
                mC.fixedArraySetup();  
                //  sq.setup();  
                mC.setDoors(sq.setup());
                  final triviaGUI mainPanel = new triviaGUI();
                  mainPanel.start(); 
                  // A size for the JFrame.
                  final Dimension frameSize = new Dimension(500, 500);
                  
                  final JFrame window = 
                      new JFrame("VideoGameTriva");
                  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                  window.setSize(frameSize);
                  //window.add(mainPanel);
                  window.setContentPane(mainPanel);  
                  window.pack();
                 // window.setSize(frameSize);
               
                  window.setVisible(true);
              }
          });
      }
}
