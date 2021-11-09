package triviaMaze;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class triviaGUI extends JPanel {
 
	
	public void start() {  
		
		this.setLayout(new BorderLayout());
		
		
	
		JPanel panel = new JPanel(); 
	
		JButton north = new JButton("north");
		panel.add(north,BorderLayout.NORTH);
		JButton east = new JButton("east");
		panel.add(east,BorderLayout.EAST);
		JButton south = new JButton("south");
		panel.add(south,BorderLayout.SOUTH);
		JButton west = new JButton("west");
		panel.add(west,BorderLayout.WEST);
		add(panel, BorderLayout.EAST); 
		add(new JButton("beans"),BorderLayout.WEST );
		
		
		
		
		
	} 
	
	  public static void main(final String[] theArgs) {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                final triviaGUI mainPanel = new triviaGUI();
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
