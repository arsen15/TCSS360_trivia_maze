import javax.swing.JPanel;

public abstract class gameState extends JPanel {
  
  /**
   * 
   */
  private static final long serialVersionUID = 7910777262693610840L;
  protected gameStateManager gameStateManager;
  
  public abstract void init();
  public abstract void update();
  public abstract void draw(java.awt.Graphics2D g);
  public abstract void keyPressed(int k);
  public abstract void keyReleased(int k);

}
