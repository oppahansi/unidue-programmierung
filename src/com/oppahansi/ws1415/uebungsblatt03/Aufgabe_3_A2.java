/*
 * Created by Rogerg Fu on 10.11.2014.
 *
 * <p>Altermative 2
 */
package com.oppahansi.ws1415.uebungsblatt03;

public class Aufgabe_3_A2 {

  public static double skalar(double[] vector1, double[] vector2) {
    double a = 0.0;
    double[] s;
    s = new double[vector1.length];
    for (int b = 0; b < vector1.length; b++) {
      s[b] = vector1[b] * vector2[b];
      a = s[b] + a;
    }
    return a;
  }

  public static void main(String[] args) {
    double[] vector1 = {1, 2, 3};
    double[] vector2 = {5, 6, 7};
    double test;
    test = skalar(vector1, vector2);
    System.out.println(test);
  }
}
