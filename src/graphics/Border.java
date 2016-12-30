package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Border extends Entity {

  private int width, height;

  public Border(int x, int y, Color color, int width, int height) {
    super(x, y, color);
    this.width = width;
    this.height = height;
  }

  @Override
  public void update() {

  }

  @Override
  public void paint(Graphics g) {
    g.setColor(color);
    g.drawRect(x, y, width - 1, height - 1);
  }

}
