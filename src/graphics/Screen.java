package graphics;

import java.awt.Graphics;

import javax.swing.JPanel;

import main.Main;

public class Screen extends JPanel {

  private static final long serialVersionUID = 1L;

  public Screen() {
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    if (Main.game.getState() != null)
      Main.game.getState().paint(g);
  }
}
