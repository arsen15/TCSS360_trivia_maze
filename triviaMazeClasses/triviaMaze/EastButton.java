package triviaMaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EastButton implements ActionListener {
	
	mazeContainer myMaze;
	
	public EastButton(mazeContainer theMaze) { 
		myMaze=theMaze;
	}
	
	public void actionPerformed (ActionEvent e) { 
		  if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
		    	 System.out.println("game over");
		     }
			if(myMaze.getCurrentDoorEast().checkDoor()) { 
				myMaze.moveEast(); 
				System.out.println("moved east");
			} 
			
			//answerBox.setText(myMaze.getCurrentRoom().getNorth().getQuestion().getQuestionText());
			
			
			// put forward the question connecting buttons then check it in the container  
			
			if(myMaze.checkInBoundX(1)) { 
			//	 answerBox.setVisible(true);
			} else { 
			//	errorBox.setVisible(true);
			}
			//myMaze.checkNorth();   
			//  answerBox.setVisible(true);
		//	add(new JButton("input"),BorderLayout.SOUTH);
			
		   System.out.println("nerd"); 
		  //repaint();
	}
}