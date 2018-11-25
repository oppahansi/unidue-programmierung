package com.oppahansi.ss14.miniprojekt1;

/* Beschreibt einen Punkt im zweidimensionalen Koordinatensystem mit x- und y-Wert */
public class Point {

  // Koordinaten
  private double x;
  private double y;

  public Point() {}

  public Point(double initX, double initY) {
    this.x = initX;
    this.y = initY;
  }

  public double getX() {
    return x;
  }

  public void setX(double newX) {
    this.x = newX;
  }

  public double getY() {
    return y;
  }

  public void setY(double newY) {
    this.y = newY;
  }

  public double getDistance(Point p) {
    return Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2));
  }
}
