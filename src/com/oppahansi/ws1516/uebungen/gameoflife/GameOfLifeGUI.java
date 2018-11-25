/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameOfLifeGUI extends JFrame {

  // Parameter für Größe des Spielfeldes
  private static final int BOARD_SIZE_X = 40;
  private static final int BOARD_SIZE_Y = 30;

  // ----------- Änderungen unterhalb dieser Linie auf eigene Gefahr :-)

  private static final long serialVersionUID = 4970941941640737543L;

  private GameOfLife game;
  private GamePanel gamePanel;
  private JLabel generationsLabel;

  private int generation;

  public GameOfLifeGUI() {
    super("Game Of Life");

    initialize();
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | UnsupportedLookAndFeelException e) {

      System.err.println(
          "System Look-And-Feel konnte nicht gesetzt werden. Dies hat jedoch nur optische Auswirkungen.");
    }

    new GameOfLifeGUI();
  }

  private void initialize() {
    game = new GameOfLife(BOARD_SIZE_X, BOARD_SIZE_Y);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    final JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BorderLayout());

    gamePanel = new GamePanel(game);

    final JPanel labelPanel = new JPanel();
    generationsLabel = new JLabel();
    updateGenerationsLabel();
    labelPanel.add(generationsLabel);

    add(gamePanel, BorderLayout.PAGE_START);
    add(generationsLabel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.PAGE_END);

    final JButton stepButton = new JButton("Nächste Generation");
    final JButton randomBoardButton = new JButton("Zufälliges Board");
    final JButton showNeighboursButton = new JButton("Anzahl Nachbarn einblenden");

    stepButton.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent arg0) {
            game.step();
            gamePanel.repaint();

            generation++;
            updateGenerationsLabel();
          }
        });

    stepButton.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            game.step();
            gamePanel.repaint();

            generation++;
            updateGenerationsLabel();
          }
        });

    randomBoardButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            game.shuffleBoard();
            gamePanel.repaint();

            generation = 0;
            updateGenerationsLabel();
          }
        });

    showNeighboursButton.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
            gamePanel.setShowNeighbours(!gamePanel.isShowNeighbours());
            gamePanel.repaint();

            if (gamePanel.isShowNeighbours()) {
              showNeighboursButton.setText("Anzahl Nachbarn ausblenden");
            } else {
              showNeighboursButton.setText("Anzahl Nachbarn einblenden");
            }
          }
        });

    buttonPanel.add(stepButton, BorderLayout.PAGE_START);
    buttonPanel.add(randomBoardButton, BorderLayout.CENTER);
    buttonPanel.add(showNeighboursButton, BorderLayout.PAGE_END);

    game.shuffleBoard();

    setResizable(false);

    pack();
    setVisible(true);
  }

  private void updateGenerationsLabel() {
    generationsLabel.setText("Generation: " + generation);
  }

  private static class GamePanel extends JPanel {

    private static final long serialVersionUID = -1790824421232430438L;
    private static final int FIELD_SIZE = 20;
    private GameOfLife game;
    private boolean showNeighbours;

    public GamePanel(final GameOfLife game) {
      super();

      this.game = game;
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(
          game.getBoard().length * FIELD_SIZE + 1, game.getBoard()[0].length * FIELD_SIZE + 1);
    }

    @Override
    public void paint(Graphics g) {
      super.paint(g);

      // background
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, getWidth(), getHeight());

      final byte[][] board = game.getBoard();

      // lines
      final int fieldsX = board.length;
      final int fieldsY = board[0].length;

      g.setColor(Color.BLACK);

      for (int x = 0; x <= fieldsX; x++) {
        g.drawLine(x * FIELD_SIZE, 0, x * FIELD_SIZE, this.getHeight());
      }

      for (int y = 0; y <= fieldsY; y++) {
        g.drawLine(0, y * FIELD_SIZE, this.getWidth(), y * FIELD_SIZE);
      }

      // fields
      for (int x = 0; x < fieldsX; x++) {
        for (int y = 0; y < fieldsY; y++) {
          if (game.isAlive(x, y)) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x * FIELD_SIZE + 1, y * FIELD_SIZE + 1, FIELD_SIZE - 1, FIELD_SIZE - 1);
          }

          if (showNeighbours) {
            g.setColor(Color.RED);
            g.drawString("" + game.countNeighbours(x, y), x * FIELD_SIZE + 7, y * FIELD_SIZE + 15);
          }
        }
      }
    }

    public boolean isShowNeighbours() {
      return showNeighbours;
    }

    public void setShowNeighbours(boolean showNeighbours) {
      this.showNeighbours = showNeighbours;
    }
  }
}
