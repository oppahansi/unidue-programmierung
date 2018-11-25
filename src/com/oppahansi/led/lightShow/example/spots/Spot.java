/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.led.lightShow.example.spots;

public class Spot {

  final double X_MAX, Y_MAX;
  double xPos, yPos;
  double dx, dy;
  int[] color;

  public Spot(double xMax, double yMax) {
    X_MAX = xMax;
    Y_MAX = yMax;
    color = new int[3];
  }

  public void setSpeed(double speed, double dx, double dy) {
    this.dx = Math.sqrt(dx * dx + dy * dy) * dx * speed;
    this.dy = Math.sqrt(dx * dx + dy * dy) * dy * speed;
  }

  public void setColor(int r, int g, int b) {
    color[0] = r;
    color[1] = g;
    color[2] = b;
  }

  public double getDistance(double x, double y) {
    return Math.sqrt((x - xPos) * (x - xPos) + (y - yPos) * (y - yPos));
  }

  public void move() {
    xPos += dx;
    yPos += dy;
    if (xPos > X_MAX || xPos < 0) {
      dx = -dx;
    }
    if (yPos > Y_MAX || yPos < 0) {
      dy = -dy;
    }
  }
}
