package graphics;

import java.util.ArrayList;
import java.util.List;

import config.Config;

public class Entities {

  public static List<Entity> entities = new ArrayList<Entity>();

  public static Ball ball;
  public static Racket racket;
  public static Border border;

  static {
    racket = new Racket(0, 0, Config.RACKET_COLOR, 5, 20);
    ball = new Ball(50, 50, Config.BALL_COLOR, 10);
    border = new Border(0, 0, Config.BORDER_COLOR, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

    entities.add(ball);
    entities.add(racket);
    entities.add(border);
  }
}
