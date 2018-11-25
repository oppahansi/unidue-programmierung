/* Created by oppahansi on 07.11.2014. */
package com.oppahansi.ws1415.uebungsblatt03;

public class Aufgabe_2_A1 {

  private static final int STANDARTWERT_SONST = 0;
  private static final int[] ARRAY_2 = {1, 2, 6, 1, -3, 2, 6};
  private static final int[] ARRAY_1 = {-10, 12, 21};
  private static int maxLaenge;
  private static int summe;

  public static void main(String[] args) {
    System.out.println(berechneDifferenz(ARRAY_1, ARRAY_2));
  }

  private static int berechneDifferenz(int[] array_1, int[] array_2) {
    if (array_1 == null || array_2 == null) {
      return -1;
    } else {
      if (array_1.length <= array_2.length) {
        return berechneDifferenzArray1Kleiner(array_1, array_2);
      } else {
        return berechneDifferenzArray2Kleiner(array_1, array_2);
      }
    }
  }

  private static int berechneDifferenzArray1Kleiner(int[] array_1, int[] array_2) {
    maxLaenge = array_2.length;
    int[] ergebnis = new int[maxLaenge];
    for (int i = 0; i < maxLaenge; i++) {
      if (i < array_1.length) {
        ergebnis[i] = (array_1[i] - array_2[i]);
      } else {
        ergebnis[i] = (STANDARTWERT_SONST - array_2[i]);
      }
    }
    return berechneDifferenzSumme(ergebnis);
  }

  private static int berechneDifferenzArray2Kleiner(int[] array_1, int[] array_2) {
    maxLaenge = array_1.length;
    int[] ergebnis = new int[maxLaenge];
    for (int i = 0; i < maxLaenge; i++) {
      if (i < array_2.length) {
        ergebnis[i] = (array_1[i] - array_2[i]);
      } else {
        ergebnis[i] = (array_1[i] - STANDARTWERT_SONST);
      }
    }
    return berechneDifferenzSumme(ergebnis);
  }

  private static int berechneDifferenzSumme(int[] arrayDifferenz) {
    for (int wert : arrayDifferenz) {
      if (wert < 0) {
        summe += (-1) * wert;
      } else {
        summe += wert;
      }
    }
    return summe;
  }
}
