package trviaGUIComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class gameMenu extends gameState {
	
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
		// TODO Auto-generated method stub
		
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
			
		}
		if (currentChoice == 1) {
			//load 
			
		}
		if (currentChoice == 2) {
			//options
			
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
