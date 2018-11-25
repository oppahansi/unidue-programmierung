/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung09;

import java.util.Arrays;

/* Punkt im zweidimensionalen Raum */
public class Point implements Comparable<Point> {

  // Nullpunkt
  private static final Point ZERO = new Point(0, 0);
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static void main(String[] args) {
    Point[] points =
        new Point[] {
          new Point(5, 3),
          new Point(-2, 1),
          new Point(0, 0),
          new Point(-3, -3),
          new Point(4, 2),
          new Point(9, -10),
          new Point(2, 4)
        };

    System.out.println("Unsortiert:");
    for (Point p : points) {
      System.out.println(
          String.format(
              "\t(%3d|%3d), Abstand vom Nullpunkt: %7.3f", p.x, p.y, p.getDistance(ZERO)));
    }

    // Sortiermethode aus java.util
    Arrays.sort(points);

    System.out.println("Sortiert:");
    for (Point p : points) {
      System.out.println(
          String.format(
              "\t(%3d|%3d), Abstand vom Nullpunkt: %7.3f", p.x, p.y, p.getDistance(ZERO)));
    }
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  /* Berechnet den Abstand zu Punkt p */
  public double getDistance(Point p) {
    int dx = x - p.x;
    int dy = y - p.y;

    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public int compareTo(Point point) {
    if (this.getDistance(ZERO) < point.getDistance(ZERO)) {
      return -1;
    } else if (this.getDistance(ZERO) > point.getDistance(ZERO)) {
      return 1;
    } else {
      return 0;
    }
  }
}
