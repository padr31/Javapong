package game.state;

import graphics.Entities;
import graphics.Entity;

import java.awt.Graphics;

import config.Config;

public class PauseState implements State {

  @Override
  public void update() {
    
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Config.GAME_OVER_TEXT_COLOR);
    g.setFont(Config.GAME_OVER_FONT);
    g.drawString("GAME PAUSED!", Config.SCREEN_WIDTH/3, Config.SCREEN_HEIGHT/2);
    g.drawString("press resume to play", Config.SCREEN_WIDTH/3-15, Config.SCREEN_HEIGHT/2+20);
    for (Entity e : Entities.entities) {
      e.paint(g);
    }
  }

}
