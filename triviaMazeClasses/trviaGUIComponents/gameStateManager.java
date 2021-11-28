package trviaGUIComponents;

import java.util.ArrayList;

public class gameStateManager {

  /**
   * Using Array List to store the game states.
   */
  private ArrayList<gameState> gameStates;

  /**
   * the value to represent the current state.
   */
  private int currentState;

  public static final int MENU_STATE = 0;
  public final int TRIVIA_MAZE_STATE = 1;

  public gameStateManager() {
    gameStates = new ArrayList<gameState>();

    currentState = MENU_STATE;
    gameStates.add(new gameMenu(this));
    gameStates.add(new triviaGUI(this));
  }

  public void setState(int state) {
    currentState = state;
    gameStates.get(currentState).init();
  }

  public void update() {
    gameStates.get(currentState).update();
  }

  public void draw(java.awt.Graphics2D g) {
    gameStates.get(currentState).draw(g);
  }

  public void keyPressed(int k) {
    gameStates.get(currentState).keyPressed(k);
  }

  public void keyReleased(int k) {
    gameStates.get(currentState).keyReleased(k);
  }

}
