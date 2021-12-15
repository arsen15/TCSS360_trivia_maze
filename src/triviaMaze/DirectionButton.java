package triviaMaze;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.tools.javac.Main;

public class DirectionButton implements ActionListener {
    
	private mazeContainer myMaze;
	private int myDirection; 
	private JPanel myPanel;
	
	
	
	private JLabel myQuestionText;
	private JButton myOptionA; 
	private JButton myOptionB;  
	private JButton myOptionC; 
	private JButton myOptionD;
	private JLabel myImageLabel;
	JButton[][] myArray; 
	JLabel myDirectionText;
	
	public DirectionButton(mazeContainer theMaze, int theDirection, JPanel thePanel) { 
		myDirection =theDirection; 
		myMaze = theMaze; 
		myPanel = thePanel;
	} 
	
	public DirectionButton(mazeContainer theMaze, int theDirection, JLabel theQuestionText, JButton theOptionA, JButton theOptionB, JButton theOptionC 
			, JButton theOptionD, JPanel thePanel) { 
		myMaze =theMaze; 
		
		myDirection = theDirection;
		
		
		 myQuestionText= theQuestionText;
	     myOptionA= theOptionA;
		 myOptionB= theOptionB; 
		 myOptionC = theOptionC;
		 myOptionD = theOptionD; 
		 myPanel = thePanel;
	} public DirectionButton(mazeContainer theMaze, int theDirection, JLabel theQuestionText, JButton theOptionA, JButton theOptionB, JButton theOptionC 
			, JButton theOptionD, JPanel thePanel, JButton[][] theArray) { 
		myMaze =theMaze; 
		
		myDirection = theDirection;
		
		
		 myQuestionText= theQuestionText;
	     myOptionA= theOptionA;
		 myOptionB= theOptionB; 
		 myOptionC = theOptionC;
		 myOptionD = theOptionD; 
		 myPanel = thePanel; 
		 myArray = theArray;
	} 
	 public DirectionButton(mazeContainer theMaze, int theDirection,final  JLabel theQuestionText, JButton theOptionA, JButton theOptionB, JButton theOptionC 
				, JButton theOptionD, JPanel thePanel, JButton[][] theArray, JLabel theDirectionText) { 
			myMaze =theMaze; 
			
			myDirection = theDirection;
			
			
			 myQuestionText= theQuestionText;
		     myOptionA= theOptionA;
			 myOptionB= theOptionB; 
			 myOptionC = theOptionC;
			 myOptionD = theOptionD; 
			 myPanel = thePanel; 
			 myArray = theArray; 
			 myDirectionText = theDirectionText;
		} 
	 public DirectionButton(mazeContainer theMaze, int theDirection,final  JLabel theQuestionText, JButton theOptionA, JButton theOptionB, JButton theOptionC 
				, JButton theOptionD, JPanel thePanel, JButton[][] theArray, JLabel theDirectionText, JLabel theImage) { 
			myMaze =theMaze; 
			
			myDirection = theDirection;
			
			
			 myQuestionText= theQuestionText;
		     myOptionA= theOptionA;
			 myOptionB= theOptionB; 
			 myOptionC = theOptionC;
			 myOptionD = theOptionD; 
			 myPanel = thePanel; 
			 myArray = theArray; 
			 myDirectionText = theDirectionText; 
			 myImageLabel = theImage;
		}
	
	
	public void actionPerformed (ActionEvent e) {   
		
        
		//myDirectionText.setText("Currently Facing "+myMaze.getCurrentDoorFaceString());  
		
		
		
		// returns if the door is in questioning as movement is locked   
		
	
		if(myMaze.getCurrentDoorFace() != null && myMaze.getCurrentDoorFace().getQuestioningStatus() && myMaze.getDoorDirection() != myDirection 
				&& myMaze.getCurrentDoorFace().getBlockedStatus() == false) {  
			
	
			
			return; 
			
			
			
		}   
	
		
		myMaze.setDoorDirection(myDirection);   
		myDirectionText.setText("Currently Facing "+myMaze.getCurrentDoorFaceString()); 
		if(myMaze.getCurrentDoorFace().getBlockedStatus() == true) { 
			myPanel.setVisible(false);
		}
		if(myMaze.getCurrentDoorFace().getBlockedStatus() == false ) { 
			myPanel.setVisible(true);
		} else { 
			System.out.println("that door is blocked");
		}
		
		 if(myMaze.getCurrentRoom().checkBlockedDoors()) { 
	    	 System.out.println("game over");
	     }
		if(myMaze.getCurrentDoorFace().checkDoor()) {   
		//	int index = myMaze.getCurrrentX()
			JButton beforeMove = myArray[myMaze.getCurrentY()-1][myMaze.getCurrentX()-1];
			 beforeMove.setText("*");
			myMaze.moveFaceDirection();  
			JButton afterMove = myArray[myMaze.getCurrentY()-1][myMaze.getCurrentX()-1];
		    afterMove.setText("'*'");

			System.out.println("moved");  
			//move door direction out of range
			myMaze.setDoorDirection(5);  
			myPanel.setVisible(false);  
			myImageLabel.setVisible(false);
			myDirectionText.setText("Currently Facing "+myMaze.getCurrentDoorFaceString()); 
			return;
		} 
		
	//	 JLabel myQuestionText = (JLabel)myPanel.getComponentAt(1,1);
	 //    JButton myOptionA = (JButton)myPanel.getComponentAt(1,2); 
	//     JButton myOptionB = (JButton)myPanel.getComponentAt(1,3); 
	 //     JButton myOptionC = (JButton)myPanel.getComponentAt(1,4); 
	  //    JButton myOptionD = (JButton)myPanel.getComponentAt(1,5);
	
		if(myMaze.checkInBoundDirection(myDirection)) {  
		
			System.out.println("checked in bound x");    
			
			// likely the problem zone 
			if(myMaze.getCurrentDoorFace().getQuestion() instanceof TFQuestion) {  
				
			   
				myQuestionText.setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()+" (TF)"); 
              } else { 
			myQuestionText.setText(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()+" (MC)");  
              }  
			 
			
			
			
			File f = myMaze.getCurrentDoorFace().getQuestion().getImage();  
			try {  
				
				/*
				String url = "./fireSeekerAudio.mp3";
				
				Clip clip = AudioSystem.getClip();  
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/path/to/sounds/" + url));
				clip.open(inputStream);  
				clip.start();    */
				
			
				
			    BufferedImage picture = ImageIO.read(f);   
			    
			     myImageLabel.setIcon(new ImageIcon(picture));
			     myImageLabel.setVisible(true);
				} catch(Exception z) { 
					System.out.println("error loading image or audio"+z.getMessage());
				}
			
			System.out.println(myMaze.getCurrentDoorFace().getQuestion().getQuestionText()); 
			myOptionA.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionA());  
			System.out.println(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionA()); 
			myOptionB.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionB()); 
			myOptionC.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionC()); 
			myOptionD.setText(myMaze.getCurrentDoorFace().getQuestion().getMultipleChoiceOptionD()); 
			 
	       //sets questioning status 
	       myMaze.getCurrentDoorFace().setQuestioningStatus(true);
		} 
	
	    System.out.println(myMaze.getCurrentXYString());
	    if(myMaze.won()) { 
	    	 System.out.println("you won");
	     } 
	    
	 }
	}

