package config;

import java.awt.Color;
import java.awt.Font;

public class Config {

  public static final int SCREEN_WIDTH = 300;
  public static final int SCREEN_HEIGHT = 200;

  public static final Color BALL_COLOR = Color.ORANGE;
  public static final Color RACKET_COLOR = Color.GREEN;
  public static final Color BORDER_COLOR = Color.black;
  public static final Color GAME_OVER_TEXT_COLOR = Color.BLACK;

  public static final int RACKET_SPEED = 3;

  public static final int DEFAULT_BALL_LIVES = 10;
  public static int BALL_LIVES = 10;

  // max speed, speed is from 1 to value of this range
  public static final int BALL_SPEED_RANGE = 5;

  public static final Font GAME_OVER_FONT = new Font("Arial", 12, 12);
}