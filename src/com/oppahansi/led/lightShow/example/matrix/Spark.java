/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.led.lightShow.example.matrix;

import ledControl.BoardController;

public class Spark {

  private BoardController board;
  // position of the spark
  private double xpos, ypos;
  // normalized direction
  private double xdir, ydir;
  private double speed;
  // number of dots the spark consists of
  private int length;
  // how bright the spark should be
  private double intensity;
  // color of the spark
  private int[] color;
  // false if any part of the spark is still on the board, true otherwise
  private boolean offBoard;

  public Spark(
      BoardController board,
      double xpos,
      double ypos,
      double xdir,
      double ydir,
      double speed,
      int length,
      double intensity,
      int[] color) {
    this.board = board;
    this.xpos = xpos;
    this.ypos = ypos;
    // normalize direction
    double dirLength = Math.sqrt(xdir * xdir + ydir * ydir);
    this.xdir = xdir / dirLength;
    this.ydir = ydir / dirLength;
    this.speed = speed;
    this.length = length;
    this.intensity = intensity;
    this.color = color;
    offBoard = false;
  }

  // move the spark in the direction specified in the constructor
  // the higher the speed, the larger the distance covered by the movement
  public void move() {
    xpos += speed * xdir;
    ypos += speed * ydir;
  }

  // paint the dot on the board
  public void paint() {
    // position of current dot
    double dotx = xpos, doty = ypos;
    int x, y;
    // first we assume all dots are outside the board
    offBoard = true;
    // now check for every dot where it is, starting with leading dot that
    // is also the brightest dot
    // if its position is on the board, paint it
    for (int n = length; n > 0; n--) {
      // adjust foating point coordinates to the integer-coordinates of
      // the board
      x = (int) (Math.round(dotx));
      y = (int) (Math.round(doty));
      // check if the current dot is on the board
      if (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight()) {
        // Paint the dot.
        // Use maxColor in case there are already other sparks painted
        // at the same position.
        // n/(double)length is used to lessen the brightness from the
        // first to the last dot.
        board.maxColor(
            x,
            y,
            new int[] {
              (int) (color[0] * intensity * (n / (double) length)),
              (int) (color[1] * intensity * (n / (double) length)),
              (int) (color[2] * intensity * (n / (double) length))
            });
        // since we just found a dot, a part of the spark is still on
        // the board, so offboard should be false.
        offBoard = false;
      }
      // find the next dot's position in the opposite movement direction.
      dotx -= xdir;
      doty -= ydir;
    }
  }

  public boolean isOnBoard() {
    return !offBoard;
  }
}
