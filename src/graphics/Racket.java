package graphics;

import java.awt.Color;
import java.awt.Graphics;

import config.Config;

public class Racket extends Entity {

  private int speed;

  private int counter;
  private int topScore;

  private boolean skippedCollision = false;

  private int width, height;

  public Racket(int x, int y, Color color, int width, int height) {
    super(x, y, color);
    this.width = width;
    this.height = height;
    counter = 0;
    topScore = 0;
  }

  public void paint(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y, width, height);
    g.drawString("Score: " + getCounter(), 180, 40);
    g.drawString("Top score: " + getTopScore(), 180, 60);
  }

  private int getTopScore() {
    return topScore;
  }

  public void update() {
    if (this.y <= 0 && speed < 0) {
      this.y = 0;
    } else if (this.y >= Config.SCREEN_HEIGHT - height && speed > 0) {
      this.y = Config.SCREEN_HEIGHT - height;
    } else {
      this.y += speed;
    }

  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void incrementCount() {
    counter++;
    if (counter >= topScore)
      topScore = counter;
  }

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  public boolean isSkippedCollision() {
    return skippedCollision;
  }

  public void skippedCollision(boolean skippedCollision) {
    this.skippedCollision = skippedCollision;
  }

  public void reset() {
    counter = 0;
  }
}
