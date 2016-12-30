package main;

import game.Game;
import game.state.PlayState;
import graphics.Entities;
import graphics.Screen;
import input.Keys;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utils.Utils;
import config.Config;

public class Main extends JFrame {

  private static final long serialVersionUID = 1L;

  public static Game game;
  public static Screen screen;
  public static Keys keys;
  private JTextField textField;

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
    game.setState(new PlayState());

    keys = new Keys(game);
  }

  private static void startGame() {
    game.start();
  }

  public Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    // screen.setBorder(new EmptyBorder(5, 5, 5, 5));
    // screen.setLayout(new BorderLayout(0, 0));
    screen.setBounds(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
    getContentPane().add(screen);
    getContentPane().setLayout(null);

    textField = new JTextField();
    textField.setBounds(338, 32, 86, 20);
    getContentPane().add(textField);
    textField.setColumns(10);
    textField.addKeyListener(keys);

    JButton btnApply = new JButton("Apply");
    btnApply.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String s = textField.getText();
        if(Utils.isInteger(s)) {
            Config.BALL_LIVES = Integer.parseInt(s);
            Entities.ball.setLives(Config.BALL_LIVES);    
        }
      }
    });
    btnApply.setBounds(338, 55, 86, 23);
    btnApply.addKeyListener(keys);
    getContentPane().add(btnApply);

    JLabel lblLives = new JLabel("Lives");
    lblLives.setBounds(354, 11, 59, 14);
    lblLives.addKeyListener(keys);
    getContentPane().add(lblLives);

    JButton btnRestart = new JButton("Restart");
    btnRestart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        game.restart();
      }
    });
    btnRestart.setBounds(338, 150, 86, 23);
    btnRestart.addKeyListener(keys);
    getContentPane().add(btnRestart);

    JButton btnPause = new JButton("Pause");
    btnPause.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        game.pause();
      }
    });
    btnPause.setBounds(338, 91, 86, 23);
    btnPause.addKeyListener(keys);
    getContentPane().add(btnPause);

    JButton btnResume = new JButton("Resume");
    btnResume.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        game.resume();
      }
    });
    btnResume.setBounds(338, 113, 86, 23);
    btnResume.addKeyListener(keys);
    getContentPane().add(btnResume);

    addKeyListener(keys);
    screen.addKeyListener(keys);
  }
}
