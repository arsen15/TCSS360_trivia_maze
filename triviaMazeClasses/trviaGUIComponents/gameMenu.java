package trviaGUIComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Ryan. Arsen, Phuc
 * 
 */
public class gameMenu extends gameState {
	
/**
   * 
   */
  private static final long serialVersionUID = -7944824268026497271L;

private int currentChoice = 0;
	
	private String [] options = {
			"START",
			"LOAD",
			"OPTIONS",
			"QUIT"
	};
	
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	public gameMenu(gameStateManager gameStateManager) {
		this.gameStateManager = gameStateManager;
		
		try {

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);
			font = new Font("Arial", Font.PLAIN, 12);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		System.out.println("IN IT");
		
	}

	@Override
	public void update() {
		// maybe add animation in the future
		
	}

	@Override
	public void draw(Graphics2D theG) {
		
		//draw the title
		theG.setColor(titleColor);
		theG.setFont(titleFont);
		theG.drawString("Game", 80, 70);
				
		// drawing the menu options
		theG.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				theG.setColor(Color.WHITE);
			} else {
				theG.setColor(Color.RED);
			}
			theG.drawString(options[i], 145, 140 + i * 15);
		}
	}
	
	private void select() {
		if (currentChoice == 0) {
			//start
			gameStateManager.setState(gameStateManager.TRIVIA_MAZE_STATE);
			System.out.println("CHOSE START");
			
			
		}
		if (currentChoice == 1) {
			//load 
		  System.out.println("CHOSE LOAD");
		}
		if (currentChoice == 2) {
			//options
		  System.out.println("CHOSE OPTIONS");
		}
		if (currentChoice == 3) {
			//quit 
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
}
