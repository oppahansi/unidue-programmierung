/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung01;

// Rechteck
//
// Flaecheninhalt und Umfang sind zwei Eigenschaften, die man fuer ein Rechteck
// berechnen kann. Dabei ergibt sich die Flaeche aus der Gleichung
// F = a * b
// und der Umfang aus
// A = 2 * (a + b)
//
// Vervollstaendigen Sie die beiden Methoden getArea (Berechnung des
// Flaecheninhalts) und getPerimeter (Berechnung des Umfangs)!

public class Rectangle {

  public static int getArea(int a, int b) {
    int area = a * b;

    // return a * b;                       // Kurze version

    return area;
  }

  public static int getPerimeter(int a, int b) {
    int perimeter = 2 * (a + b);

    // return 2 * (a + b);                 // Kurze version

    return perimeter;
  }

  public static void main(String[] args) {
    int w = 10;
    int h = 5;

    int area = getArea(w, h);
    int perimeter = getPerimeter(w, h);

    System.out.println(
        "Ein Rechteck mit der Breite "
            + w
            + " und der Hoehe "
            + h
            + " hat einen Flaecheninhalt von "
            + area
            + " und einen Umfang von "
            + perimeter
            + ". (50 Flaecheninhalt und 30 Umfang ist korrekt)");
  }
}
