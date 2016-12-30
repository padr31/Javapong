package graphics;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {

  protected int x, y;

  protected Color color;

  public Entity(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }


  public abstract void update();

  public abstract void paint(Graphics g);
}
