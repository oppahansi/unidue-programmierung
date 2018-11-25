/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.miniprojekt.mp1.a1;

public class Miniprojekt1 {

  public static void main(String[] s) {
    Miniprojekt1 m1 = new Miniprojekt1();

    System.out.println("R(5|4) liegt innerhalb der Flaeche: " + m1.enthaeltPunkt(5, 4));
    System.out.println("Erwarteter Wert: \t\t\t\t\t\t\t\t\t\tfalse \n");

    System.out.println("S(-5|12) liegt innerhalb der Flaeche: " + m1.enthaeltPunkt(-5, 12));
    System.out.println("Erwarteter Wert: \t\t\t\t\t\t\t\t\t\t\tfalse \n");

    System.out.println("Flaeche Kreis Radius 3: " + m1.kreisFlaeche(3));
    System.out.println("Erwarteter Wert: \t\t\t\t28.274333882308138 \n");

    System.out.println("Umfang Kreis Radius 4,2: \t" + m1.kreisUmfang(4.2));
    System.out.println("Erwarteter Wert: \t\t\t\t\t26.389378290154262 \n");

    System.out.println(
        "Kreis Radius 6 kleiner Rechteck 2 mal 3: \t" + m1.kreisKleinerRechteck(6, 2, 3));
    System.out.println("Erwarteter Wert: \t\t\t\t\t\t\t\t\t\t\t\t\tfalse \n");

    System.out.println("Laenge (-1,5) (2,-1): " + m1.laenge(2, -1, -1, 5));
    System.out.println("Erwarteter Wert: \t\t\t6.708203932499369 \n");

    System.out.println("Aufruf von funktion1 mit x = 2 liefert den Wert: \t" + m1.funktion1(2));
    System.out.println("Erwarteter Wert: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0.0 \n");

    System.out.println("Aufruf von funktion2 mit x = 4 liefert den Wert: " + m1.funktion2(4));
    System.out.println("Erwarteter Wert: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-1.0 \n");
  }

  public boolean enthaeltPunkt(int x, int y) {
    return (x >= 2 && x <= 14 && y <= 3 && y >= -15);
  }

  public double kreisFlaeche(double radius) {
    return Math.PI * Math.pow(radius, 2);
  }

  public double kreisUmfang(double radius) {
    return Math.PI * 2 * radius;
  }

  public double rechteckFlaeche(double laenge, double breite) {
    return laenge * breite;
  }

  public boolean kreisKleinerRechteck(double radius, double laenge, double breite) {
    return (kreisFlaeche(radius) < rechteckFlaeche(laenge, breite));
  }

  public double laenge(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  public double funktion1(double x) {
    return (Math.pow(x, 2) - 5 * x + 6) / (x + 2);
  }

  public double funktion2(double x) {
    return (Math.sqrt(Math.pow(x - 3, 3))) / (x - 5);
  }
}
