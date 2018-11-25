package com.oppahansi.ss14.woche1;

// Rechteck
//
// Fl�cheninhalt und Umfang sind zwei Eigenschaften, die man f�r ein Rechteck
// berechnen kann. Dabei ergibt sich die Fl�che aus der Gleichung
// F = a * b
// und der Umfang aus
// A = 2 * (a + b)
//
// Vervollst�ndigen Sie die beiden Methoden getArea (Berechnung des
// Fl�cheninhalts) und getPerimeter (Berechnung des Umfangs)!

public class Rectangle {

  public static int getArea(int a, int b) {
    return (a <= 0 || b <= 0) ? 0 : a * b;
  }

  public static int getPerimeter(int a, int b) {
    return (a <= 0 || b <= 0) ? 0 : 2 * (a + b);
  }

  public static void main(String[] args) {
    int w = 10;
    int h = 5;

    int area = getArea(w, h);
    int perimeter = getPerimeter(w, h);

    System.out.println(
        "Ein Rechteck mit der Breite "
            + w
            + " und der H�he "
            + h
            + " hat einen Fl�cheninhalt von "
            + area
            + " und einen Umfang von "
            + perimeter
            + ".");
  }
}
