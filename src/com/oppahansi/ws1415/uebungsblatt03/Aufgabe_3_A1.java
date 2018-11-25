/*
 * Created by oppahansi on 07.11.2014.
 *
 * <p>Loesung wird am 17.11.14 hochgeladen.
 */
package com.oppahansi.ws1415.uebungsblatt03;

public class Aufgabe_3_A1 {

  private static final double[] VEKTOR_A = {1, 2, 3};
  private static final double[] VEKTOR_B = {5, 6, 7};
  private static double skalarprodukt;

  public static void main(String[] args) {
    System.out.println(berechneSkalarprodukt(VEKTOR_A, VEKTOR_B));
  }

  private static double berechneSkalarprodukt(double[] VEKTOR_A, double[] VEKTOR_B) {
    for (int i = 0; i < VEKTOR_A.length; i++) {
      skalarprodukt += (VEKTOR_A[i] * VEKTOR_B[i]);
    }
    return skalarprodukt;
  }
}
