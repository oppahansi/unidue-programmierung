/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp1;

/*
 * Definiert einen Kreis ueber einen Radius und einem Mittelpunkt in einem zweidimensionalen
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
    return radius * 2;
  }

  // Umfang
  public double getCircumference() {
    return Math.PI * getDiameter();
  }

  // Flaeche
  public double getArea() {
    return Math.PI * Math.pow(getRadius(), 2);
  }

  public boolean containsPoint(Point point) {
    return getLocation().getDistance(point) < getRadius();
  }
}
