package game.state;

import java.awt.Graphics;
import java.awt.Rectangle;

import graphics.Ball;
import graphics.Entities;
import graphics.Entity;
import graphics.Racket;
import utils.Utils;

public class PlayState implements State{

  @Override
  public void update() {
    for (Entity e : Entities.entities) {
      e.update();
    }

    if (checkCollision(Entities.racket, Entities.ball)) {
      if (Entities.racket.isSkippedCollision()) {
        Entities.racket.incrementCount();
        Entities.racket.skippedCollision(false);
      }
      Entities.ball.setSpeedX(Utils.randomPositive(3));
      Entities.ball.setSpeedY(Utils.randomWithNegative(3));
    } else {
      Entities.racket.skippedCollision(true);
    }
  }
  
  private boolean checkCollision(Racket r, Ball b) {
    Rectangle rRect = new Rectangle(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getRadius() * 2, b.getRadius() * 2);

    return rRect.intersects(bRect) ? true : false;
  }

  @Override
  public void paint(Graphics g) {
    for (Entity e : Entities.entities) {
      e.paint(g);
    }
  }

}
