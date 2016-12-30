package game.state;

import java.awt.Graphics;

public interface State {
  
  public void update();
  
  public void paint(Graphics g);
}
