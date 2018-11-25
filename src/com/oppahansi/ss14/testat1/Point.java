package com.oppahansi.ss14.testat1;

public class Point {

  private double x;
  private double y;
  private double z;

  public Point() {}

  public Point(double initX, double initY, double initZ) {
    // Aufgabe 1
    x = initX;
    y = initY;
    z = initZ;
  }

  public double getDistance(Point p) {
    // Aufgabe 2
    return Math.sqrt(
        Math.pow(p.getX() - getX(), 2)
            + Math.pow(p.getY() - getY(), 2)
            + Math.pow(p.getZ() - getZ(), 2));
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getZ() {
    return z;
  }

  public void setZ(double z) {
    this.z = z;
  }
}
