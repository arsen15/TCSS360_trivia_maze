package triviaMaze;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class triviaGUI extends JPanel {
 
	private ArrayList<ArrayList<Room>> myMaze;
	public triviaGUI(ArrayList<ArrayList<Room>> theMaze) { 
		myMaze = theMaze;
	}
	
	
	public void start() {  
		
		this.setLayout(new BorderLayout());
		
		
	
		JPanel panel = new JPanel(); 
	
		JButton north = new JButton("north");  
		
		north.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
			  
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
			        "1", "2", "3",
			        "4", "5", "6",
			        "7", "8", "9",
			        "*", "0", "#" }; 
		 
		  final JButton[] keyButtons = new JButton[KEYS.length];
		 // Dimension KEY_SIZE = new Dimension(50, 50);
		
		  for (int i = 0; i < keyButtons.length; i++) {
	            keyButtons[i] = new JButton(KEYS[i]);
	          //  keyButtons[i].setPreferredSize(KEY_SIZE);
	            j.add(keyButtons[i]);
	        }
		add(j, BorderLayout.WEST);
		//add(new JButton("beans"),BorderLayout.WEST );
		
		
		
		
		
	} 
	
	  public static void main(final String[] theArgs) {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {  
	            	
	            
	            	ArrayList<ArrayList<Room>> temp =  new ArrayList<ArrayList<Room>>();  
	            	triviaSQL sq = new triviaSQL(); 
	            	sq.setup(temp);
	                final triviaGUI mainPanel = new triviaGUI(temp);
	                mainPanel.start();
	                
	                // A size for the JFrame.
	                final Dimension frameSize = new Dimension(500, 500);
	                
	                final JFrame window = 
	                    new JFrame("Demo Border");
	                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                //window.add(mainPanel);
	                window.setContentPane(mainPanel);  
	                window.pack();
	               // window.setSize(frameSize);
	             
	                window.setVisible(true);
	            }
	        });
	    }
	
	
	
	
	
}
