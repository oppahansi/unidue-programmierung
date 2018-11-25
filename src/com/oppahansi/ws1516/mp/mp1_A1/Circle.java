/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>Solved by Ya Sin. For learning purpose only.
 */
package com.oppahansi.ws1516.mp.mp1_A1;

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
    circle.location = center;
    circle.radius =
        Math.sqrt(Math.pow(p.getX() - center.getX(), 2) + Math.pow(p.getY() - center.getY(), 2));

    return circle;
  }

  public double getRadius() {

    return this.radius;
  }

  public void setRadius(double newRadius) {
    this.radius = newRadius;
  }

  public Point getLocation() {
    return this.location;
  }

  public void setLocation(Point newLocation) {
    this.location = newLocation;
  }

  // Durchmesser
  public double getDiameter() {

    return 2 * this.radius;
  }

  // Umfang
  public double getCircumference() {

    return Math.PI * getDiameter();
  }

  // Fl�che
  public double getArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  public boolean containsPoint(Point point) {
    if ((location.getX() - radius) < point.getX()
        && point.getX() < (location.getX() + radius)
        && (location.getY() - radius) < point.getY()
        && point.getY() < (location.getY() + radius)) {
      return true;
    } else {
      return false;
    }
  }
}
