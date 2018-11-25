package com.oppahansi.ss14.miniprojekt1;

/*
 * Definiert einen Kreis �ber einen Radius und einem Mittelpunkt in einem zweidimensionalen
 * Koordinatensystem
 */
public class Circle {

  // Mittelpunkt des Kreises
  private Point location;
  private double radius;

  public Circle() {}

  public Circle(Point initLocation, double initRadius) {
    this.location = initLocation;
    this.radius = initRadius;
  }

  public static Circle fromPoints(Point center, Point p) {
    Circle circle = new Circle();

    // An dieser Stelle das circle-Objekt bearbeiten
    circle.setLocation(center);
    circle.setRadius(center.getDistance(p));

    return circle;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double newRadius) {
    this.radius = newRadius;
  }

  public Point getLocation() {
    return location;
  }

  public void setLocation(Point newLocation) {
    this.location = newLocation;
  }

  // Durchmesser
  public double getDiameter() {
    return 2 * radius;
  }

  // Umfang
  public double getCircumference() {
    return 2 * Math.PI * radius;
  }

  // Fl�che
  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }

  public boolean containsPoint(Point point) {
    if (location.getDistance(point) <= radius) {
      return true;
    } else {
      return false;
    }
  }
}
