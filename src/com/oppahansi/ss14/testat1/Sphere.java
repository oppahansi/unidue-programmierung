package com.oppahansi.ss14.testat1;

public class Sphere {

  private Point location;
  private double radius;

  public Sphere() {}

  public Sphere(Point initLocation, double initRadius) {
    // Aufgabe 3
    location = initLocation;
    radius = initRadius;
  }

  public static void main(String[] args) {
    Point a = new Point(0.0, 0.0, 0.0);
    Point b = new Point(2.0, -2.0, -1.0);
    System.out.println(
        "Der Abstand zwischen Punkt A("
            + a.getX()
            + "|"
            + a.getY()
            + "|"
            + a.getZ()
            + ") und Punkt B("
            + b.getX()
            + "|"
            + b.getY()
            + "|"
            + b.getZ()
            + ") betr?gt "
            + a.getDistance(b)
            + ".");

    Sphere s = new Sphere(a, 4.0);
    Sphere t = new Sphere(b, 1.0);

    System.out.println("Kugel S enth?lt Kugel T: " + s.contains(t));
  }

  public boolean contains(Sphere sphere) {
    // Aufgabe 4

    double distance = getLocation().getDistance(sphere.getLocation());
    double r1ur2 = getRadius() + sphere.getRadius();
    if (distance <= r1ur2) {
      return true;

    } else {
      return false;
    }
  }

  public boolean intersects(Sphere sphere) {
    if (true) {
      return true;

    } else {
      return false;
    }
  }

  public Point getLocation() {
    return location;
  }

  public void setLocation(Point location) {
    this.location = location;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }
}
