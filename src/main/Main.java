package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import config.Config;
import graphics.Ball;
import graphics.Racket;
import graphics.Screen;
import input.Keys;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static Game game;
	public static Screen screen;
	public static Keys keys;

	public static void main(String[] args) {
		createInstances();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		startGame();
	}

	private static void createInstances() {
		
		screen = new Screen();
		
		game = new Game(screen);
		
		keys = new Keys(game);
	}

	private static void startGame() {
		game.start();
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//screen.setBorder(new EmptyBorder(5, 5, 5, 5));
		//screen.setLayout(new BorderLayout(0, 0));
		screen.setBounds(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		add(screen);
		addKeyListener(keys);
	}

}
