package graphics;

import java.awt.Color;
import java.awt.Graphics;

import config.Config;
import utils.Utils;

public class Ball extends Entity {

	private int radius;

	private int speedX, speedY;

	private int counter;

	public Ball(int x, int y, Color color, int radius) {
		super(x, y, color);
		this.radius = radius;
		this.speedX = Utils.randomWithNegative(Config.BALL_SPEED_RANGE);
		this.speedY = Utils.randomWithNegative(Config.BALL_SPEED_RANGE);
		counter = 0;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 2 * radius, 2 * radius);
		g.drawString("" + counter, 180, 20);
	}

	@Override
	public void update() {
		boolean wall = false;
		// walls
		// wall top
		if (this.y <= 0 && speedY < 0) {
			wall = true;
			setY(0);
			setSpeedY(-speedY);

		}
		// wall bottom
		else if (this.y + 2 * radius >= Config.SCREEN_HEIGHT && speedY > 0) {
			wall = true;
			setY(Config.SCREEN_HEIGHT - 2 * radius);
			setSpeedY(-speedY);

		}

		//wall left
		if (this.x <= 0 && speedX < 0) {
			wall = true;
			incrementCounter();
			setX(0);
			setSpeedX(-speedX);

		} 
		//wall right
		else if (this.x + 2 * radius >= Config.SCREEN_WIDTH && speedX > 0) {
			wall = true;
			setX(Config.SCREEN_WIDTH - 2 * radius);
			setSpeedX(-speedX);
		}

		if (!wall) {
			this.x += speedX;
			this.y += speedY;
		}
	}

	public void setSpeedX(int speed) {
		this.speedX = speed;
	}

	public void setSpeedY(int speed) {
		this.speedY = speed;
	}

	public int getRadius() {
		return radius;
	}

	public void incrementCounter() {
		counter++;
	}
}