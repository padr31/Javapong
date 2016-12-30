package game;

import game.state.GameOverState;
import game.state.PauseState;
import game.state.PlayState;
import game.state.State;
import graphics.Entities;
import graphics.Screen;
import utils.Utils;

public class Game implements Runnable {

  private boolean running = false;
  private boolean paused = false;

  private Thread gameThread;

  private Screen screen;

  private State state;

  public Game(Screen screen) {
    this.screen = screen;

  }

  public void update() {
    if (Entities.ball.getLives() <= 0) {
      setState(new GameOverState());
    }
    state.update();
  }

  public void render() {
    screen.repaint();
  }

  public void upPressed() {
    Entities.racket.setSpeed(-6);
  }

  public void upReleased() {
    Entities.racket.setSpeed(0);
  }

  public void downPressed() {
    Entities.racket.setSpeed(6);
  }

  public void downReleased() {
    Entities.racket.setSpeed(0);
  }

  public void escPressed() {
    setState(new GameOverState());
  }

  public void pPressed() {
    if (!paused)
      pause();
    else
      resume();
  }

  @Override
  public void run() {
    while (running) {
      Utils.sleep(30);
      update();
      render();
    }
  }

  public void start() {
    if (running)
      return;
    running = true;
    gameThread = new Thread(this);
    gameThread.start();
  }

  public void stop() {
    Utils.sleep(50);
    if (!running)
      return;
    running = false;
    gameThread.interrupt();
    try {
      gameThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void restart() {
    running = false;
    Utils.sleep(50);
    stop();
    Entities.ball.reset();
    Entities.racket.reset();
    setState(new PlayState());
    start();
  }

  public void pause() {
    if(paused) return;
    paused = true;
    setState(new PauseState());
    System.out.println("pause");
  }

  public void resume() {
    if(!paused) return;
    paused = false;
    setState(new PlayState());
    System.out.println("resume");
  }

  public void setState(State state) {
    this.state = state;
  }

  public State getState() {
    return this.state;
  }
}
