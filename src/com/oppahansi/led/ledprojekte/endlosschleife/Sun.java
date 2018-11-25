/*
 * Sunrise
 *
 * <p>Created by: Endlosschleife (Gruppe
 */
package com.oppahansi.led.ledprojekte.endlosschleife;

public class Sun {

  final double Y_MAX;

  // Position der Sonne
  double xPos, yPos;

  // Faktor um den die Position erh�ht wird
  double dy;

  // Farbe der Sonne
  int[] color = {127, 100, 0};

  // Konstruktor an den die Position der Sonne �bermittelt wird
  public Sun(double yMax) {
    dy = 0.015; // Geschwindigkeit der Sonne
    Y_MAX = yMax;
    xPos = 6;
    yPos = 0;
  }

  public double getDistance(double x, double y) {
    return Math.sqrt((x - xPos) * (x - xPos) + (y - yPos) * (y - yPos));
  }
  // yPos wird um += dy erh�ht f�r die Bewegung der Sonne :je gr��er dy, desto schneller die Sonne
  // dy= -dy sorgt daf�r das die Sonne wieder aufsteigt sobald yPos negativ wird

  public void move() {

    yPos += dy;
    if (yPos > Y_MAX || yPos < 0) {
      dy = -dy;
    }
  }
}
