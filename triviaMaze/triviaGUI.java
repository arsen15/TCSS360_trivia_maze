package triviaMaze;

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
		myMaze = new mazeContainer();
	}
	
	
	public void start() {  
		 
		
	//	triviaSQL sq = new triviaSQL();    
	//	myMaze.fixedArraySetup();  
	//	myMaze.setDoors(sq.setup()); 
		
		
		
		
		
		
		
		this.setLayout(new BorderLayout());
		
	
		JPanel panel = new JPanel(); 
	
		JButton north = new JButton("north");   
		
		JPanel southPanel = new JPanel();
	
		JLabel myQuestionText = new JLabel("temp Question");
		JButton myOptionA = new JButton("TEMPA");    
		JButton myOptionB = new JButton("TEMPB");    
		JButton myOptionC = new JButton("TEMPC");     
		JButton myOptionD = new JButton("TEMPD");    
		southPanel.setLayout(new GridLayout(1,6));   
		southPanel.add(myQuestionText); 
		southPanel.add(myOptionA); 
		southPanel.add(myOptionB); 
		southPanel.add(myOptionC); 
		southPanel.add(myOptionD);
		southPanel.setVisible(false); 
		add(southPanel,BorderLayout.SOUTH); 
		
		myOptionA.addActionListener(new QuestionButton(myMaze,'A',southPanel));  
		myOptionB.addActionListener(new QuestionButton(myMaze,'B',southPanel));   
		myOptionC.addActionListener(new QuestionButton(myMaze,'C',southPanel)); 
		myOptionD.addActionListener(new QuestionButton(myMaze,'D',southPanel)); 
	
		
		add(southPanel,BorderLayout.SOUTH);
	//	north.addActionListener(new DirectionButton(myMaze,1,southPanel));  
		north.addActionListener(new DirectionButton(myMaze,1,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel)); 
		 /*
		north.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {  
			     if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
			    	 System.out.println("game over");
			     }
				if(myMaze.getCurrentDoorNorth().checkDoor()) { 
					myMaze.moveNorth(); 
					System.out.println("moved north ");
				} 
				
			
				int northOne = -1;
				if(myMaze.checkInBoundY(northOne)) {  
				
					System.out.println("checked in bound x");   
					if(myMaze.getCurrentDoorNorth().getQuestion() instanceof TFQuestion) { 
						myQuestionText.setText(myMaze.getCurrentDoorNorth().getQuestion().getQuestionText()+" (TF)"); 
	                  } else { 
					myQuestionText.setText(myMaze.getCurrentDoorNorth().getQuestion().getQuestionText()+" (MC)");  
	                  } 
					System.out.println(myMaze.getCurrentDoorNorth().getQuestion().getQuestionText());
					myOptionA.setText(myMaze.getCurrentDoorNorth().getQuestion().getMultipleChoiceOptionA()); 
					myOptionB.setText(myMaze.getCurrentDoorNorth().getQuestion().getMultipleChoiceOptionB()); 
					myOptionC.setText(myMaze.getCurrentDoorNorth().getQuestion().getMultipleChoiceOptionC()); 
					myOptionD.setText(myMaze.getCurrentDoorNorth().getQuestion().getMultipleChoiceOptionD());
			
		
					int north = 1;
					myMaze.setDoorDirection(north); 
					if(myMaze.getCurrentDoorFace().getBlockedStatus() == false ) { 
						southPanel.setVisible(true);
					} else { 
						System.out.println("that door is blocked");
					}
				} 
			
			    System.out.println(myMaze.getCurrentXYString());
			    if(myMaze.won()) { 
			    	 System.out.println("you won");
			     }
			}
		});  */
		
		
		
		
		panel.add(north,BorderLayout.NORTH);
		JButton east = new JButton("east");  
	//    east.addActionListener(new DirectionButton(myMaze,2,southPanel));  
	    east.addActionListener(new DirectionButton(myMaze,2,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel)); 
	     /*
	    east.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {  
			     if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
			    	 System.out.println("game over");
			     }
				if(myMaze.getCurrentDoorEast().checkDoor()) { 
					myMaze.moveEast(); 
					System.out.println("moved east");
				} 
				
				int eastOne = 1;
				if(myMaze.checkInBoundX(eastOne)) {   
					System.out.println("checked in bound x");   
					if(myMaze.getCurrentDoorEast().getQuestion() instanceof TFQuestion) { 
						myQuestionText.setText(myMaze.getCurrentDoorEast().getQuestion().getQuestionText()+" (TF)"); 
	                  } else { 
					myQuestionText.setText(myMaze.getCurrentDoorEast().getQuestion().getQuestionText()+" (MC)");  
	                  } 
					System.out.println(myMaze.getCurrentDoorEast().getQuestion().getQuestionText());
					myOptionA.setText(myMaze.getCurrentDoorEast().getQuestion().getMultipleChoiceOptionA()); 
					myOptionB.setText(myMaze.getCurrentDoorEast().getQuestion().getMultipleChoiceOptionB()); 
					myOptionC.setText(myMaze.getCurrentDoorEast().getQuestion().getMultipleChoiceOptionC()); 
					myOptionD.setText(myMaze.getCurrentDoorEast().getQuestion().getMultipleChoiceOptionD()); 
			
					
					int east = 2;
					myMaze.setDoorDirection(east); 
					
					if(myMaze.getCurrentDoorFace().getBlockedStatus() == false ) { 
						southPanel.setVisible(true);
					} else { 
						System.out.println("that door is blocked");
					}
					
					
				} 
				
				  System.out.println(myMaze.getCurrentXYString());
			     if(myMaze.won()) { 
			    	 System.out.println("you won");
			     }
			}
		});  */
		
		
		panel.add(east,BorderLayout.EAST); 
		
		JButton south = new JButton("south");   
	//	 south.addActionListener(new DirectionButton(myMaze,3,southPanel));  
		 south.addActionListener(new DirectionButton(myMaze,3,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel)); 
		  /*
		 south.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {  
				     if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
				    	 System.out.println("game over");
				     }
					if(myMaze.getCurrentDoorSouth().checkDoor()) { 
						myMaze.moveSouth(); 
						System.out.println("moved south");
					} 
					
					int southOne = 1;
					if(myMaze.checkInBoundY(southOne)) {   
						System.out.println("checked in bound x");   
						if(myMaze.getCurrentDoorEast().getQuestion() instanceof TFQuestion) { 
							myQuestionText.setText(myMaze.getCurrentDoorSouth().getQuestion().getQuestionText()+" (TF)"); 
		                  } else { 
						myQuestionText.setText(myMaze.getCurrentDoorSouth().getQuestion().getQuestionText()+" (MC)");  
		                  } 
						System.out.println(myMaze.getCurrentDoorSouth().getQuestion().getQuestionText());
						myOptionA.setText(myMaze.getCurrentDoorSouth().getQuestion().getMultipleChoiceOptionA()); 
						myOptionB.setText(myMaze.getCurrentDoorSouth().getQuestion().getMultipleChoiceOptionB()); 
						myOptionC.setText(myMaze.getCurrentDoorSouth().getQuestion().getMultipleChoiceOptionC()); 
						myOptionD.setText(myMaze.getCurrentDoorSouth().getQuestion().getMultipleChoiceOptionD());
				
					  
						int south = 3;
						myMaze.setDoorDirection(south);  
						if(myMaze.getCurrentDoorFace().getBlockedStatus() == false ) { 
							southPanel.setVisible(true);
						} else { 
							System.out.println("that door is blocked");
						} 
						
					} 
					
					  System.out.println(myMaze.getCurrentXYString());
					  if(myMaze.won()) { 
					    	 System.out.println("you won");
					     }
				}
			});  */
		
		
		panel.add(south,BorderLayout.SOUTH);  
		
		JButton west = new JButton("west");  
	//	 west.addActionListener(new DirectionButton(myMaze,0, southPanel));  
		 west.addActionListener(new DirectionButton(myMaze,0,myQuestionText,myOptionA,myOptionB,myOptionC,myOptionD,southPanel)); 
		 /*
		 west.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {  
				     if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
				    	 System.out.println("game over");
				     }
					if(myMaze.getCurrentDoorSouth().checkDoor()) { 
						myMaze.moveWest(); 
						System.out.println("moved west");
					} 
					
					int westOne = -1;
					if(myMaze.checkInBoundX(westOne)) {   
						System.out.println("checked in bound x");   
						if(myMaze.getCurrentDoorEast().getQuestion() instanceof TFQuestion) { 
							myQuestionText.setText(myMaze.getCurrentDoorSouth().getQuestion().getQuestionText()+" (TF)"); 
		                  } else { 
						myQuestionText.setText(myMaze.getCurrentDoorWest().getQuestion().getQuestionText()+" (MC)");  
		                  } 
						System.out.println(myMaze.getCurrentDoorWest().getQuestion().getQuestionText());
						myOptionA.setText(myMaze.getCurrentDoorWest().getQuestion().getMultipleChoiceOptionA()); 
						myOptionB.setText(myMaze.getCurrentDoorWest().getQuestion().getMultipleChoiceOptionB()); 
						myOptionC.setText(myMaze.getCurrentDoorWest().getQuestion().getMultipleChoiceOptionC()); 
						myOptionD.setText(myMaze.getCurrentDoorWest().getQuestion().getMultipleChoiceOptionD());
				
				
						int west = 0;
						myMaze.setDoorDirection(west); 
						if(myMaze.getCurrentDoorFace().getBlockedStatus() == false ) { 
							southPanel.setVisible(true);
						} else { 
							System.out.println("that door is blocked");
						}
					} 
					
					  System.out.println(myMaze.getCurrentXYString());
					  if(myMaze.won()) { 
					    	 System.out.println("you won");
					     } 
					 
				}
			});   */
		
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
	            	mC.setDoors(sq.setup()); 
	            	
	            	
	            	
	                final triviaGUI mainPanel = new triviaGUI(mC);
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
	             
	             
	                window.setVisible(true);
	            }
	        });
	    }
	

}
