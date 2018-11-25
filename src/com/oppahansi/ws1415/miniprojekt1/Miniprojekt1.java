/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1415.miniprojekt1;

public class Miniprojekt1 {

  public static void main(String args[]) {
    Miniprojekt1 m1 = new Miniprojekt1();

    System.out.println("Aufruf von funktion1 mit x=2 liefert den Wert: " + m1.funktion1(2));
    System.out.println("Aufruf von funktion2 mit x=6 liefert den Wert: " + m1.funktion2(6));
    System.out.println(
        "Aufruf von funktion3 mit x=49 und y= 27 liefert den Wert: " + m1.funktion3(49, 27));
    System.out.println(
        "Aufruf von funktion4 mit x=27, y=10 und z=10 liefert den Wert:"
            + m1.funktion4(27, 10, 10));
    System.out.println("Aufruf von garpf1 mit x= -1 liefert den Wert:" + m1.graph1(-1));
    System.out.println("Aufruf von graph2 mit x=3 liefert den Wert:" + m1.graph2(3));
  }

  public double funktion1(double x) {
    double zaehler = Math.pow(x, 2) - (5 * x) + 6;
    double nenner = x + 2;
    return zaehler / nenner;
  }

  public double funktion2(double x) {
    double zaehler = Math.sqrt(Math.pow((x - 3), 3));
    double nenner = x - 5;
    return zaehler / nenner;
  }

  public double funktion3(double x, double y) {
    return 5 * logarithmus(Math.sqrt(x) + Math.cbrt(y));
  }

  public double funktion4(double x, double y, double z) {
    double zaehler = wurzel(5, Math.pow(x, 3)) + wurzel(3, Math.pow(y, 2));
    double nenner = Math.pow(z, 2);
    return logarithmus(zaehler / nenner);
  }

  public float graph1(float x) {
    if (x > 0) {
      return 1;
    } else if (x == 0) {
      return 0;
    } else {
      return -1;
    }
  }

  public float graph2(float x) {
    if (x <= 1) {
      return -x;
    } else {
      return 2 - x;
    }
  }

  public double wurzel(double n_wurzel, double term) {
    return Math.pow(term, 1 / n_wurzel);
  }

  public double logarithmus(double x) {
    return Math.log10(x);
  }
}
