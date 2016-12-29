package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import config.Config;

public class Screen extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Screen() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.drawRect(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		
		for(Entity e : Entities.entities) {
			e.paint(g);
		}
	}
}
