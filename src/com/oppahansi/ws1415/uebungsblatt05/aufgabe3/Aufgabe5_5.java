/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt05.aufgabe3;

class Aufgabe5_5 {

  public static void main(String[] s) {
    QuadratischeGleichung q = new QuadratischeGleichung();
    q.a = 1;
    q.b = 0;
    q.c = 2;

    System.out.println(q.funktionswert(-3));
    System.out.println(q.pruefe(-4, 18));
    System.out.println(q.pruefe(0, 0));
  }
}

class QuadratischeGleichung {

  double a, b, c;

  double funktionswert(double x) {
    return a * x * x + b * x + c;
  }

  boolean pruefe(double x, double y1) {
    double y2 = funktionswert(x);
    double delta = y1 - y2;
    double maxdelta = 0.000000000001d;
    if (delta < maxdelta && delta > -maxdelta) {
      return true;
    } else {
      return false;
    }
  }
}
