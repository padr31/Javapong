package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.Game;

public class Keys extends KeyAdapter {

	private Game game;

	public Keys(Game game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			game.upPressed();
			break;
		case KeyEvent.VK_DOWN:
			game.downPressed();
			break;
		case KeyEvent.VK_ESCAPE:
			game.escPressed();
			break;
		case KeyEvent.VK_P:
			game.pPressed();
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			game.upReleased();
			break;
		case KeyEvent.VK_DOWN:
			game.downReleased();
			break;
		}
	}

}
