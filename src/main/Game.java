package main;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import graphics.Ball;
import graphics.Entities;
import graphics.Entity;
import graphics.Racket;
import graphics.Screen;
import utils.Utils;

public class Game implements Runnable {

	private boolean running = false;
	private boolean paused = false;
	
	private Thread gameThread;

	private Screen screen;

	public Game(Screen screen) {
		this.screen = screen;
		
	}

	public void update() {
		for(Entity e : Entities.entities) {
			e.update();
		}

		if(checkCollision(Entities.racket, Entities.ball)) {
			if(Entities.racket.isSkippedCollision()) {
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
		Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getRadius()*2, b.getRadius()*2);
		
		return rRect.intersects(bRect) ? true : false;
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
		 stop();
	}

	public void pPressed() {
		if(!paused) pause();
		 else resume();
	}
	
	@Override
	public void run() {
		while (running) {
			if(!paused) {
				Utils.sleep(30);
				update();
				render();				
			} else {
				Utils.sleep(100);
			}
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
		if (!running)
			return;
		running = false;
		gameThread.interrupt();
	}
	
	public void pause() {
		paused = true;
		System.out.println("pause");
	}
	
	public void resume() {
		paused = false;
		System.out.println("resume");
	}
}
