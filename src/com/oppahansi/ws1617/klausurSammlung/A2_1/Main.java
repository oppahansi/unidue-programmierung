/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_1;

public class Main {
  public static void main(String[] args) {

    //AUFGABE 2.1 a
    int[] AnF = new int[15];
    int[] AbF = new int[15];
    int[] AbR = new int[15];
    AnF[1] = 19;
    for (int i = 2; i < AnF.length; i++) {
      AnF[i] = AnF[i - 1] + 21;
    }
    AbF[0] = 0;
    for (int i = 1; i < AbF.length - 1; i++) {
      AbF[i] = AbF[i - 1] + 21;
    }
    AbR[1] = 28;
    for (int i = 2; i < AbR.length; i++) {
      AbR[i] = AbR[i - 1] + 21;
    }

    //AUFGABE 2.1 b
    int[][] tAnF = new int[15][31];
    int[][] tAbF = new int[15][31];
    int[][] tAbR = new int[15][31];
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 31; j++) {
        tAnF[i][j] = AnF[i] + zusatzdauer('x', true, i, j + 1, 5);
        tAbF[i][j] = AbF[i] + zusatzdauer('x', true, i, j + 1, 5);
        tAbR[i][j] = AbR[i] + zusatzdauer('x', true, i, j + 1, 5);
      }
    }

    //AUFGABE 2.1 c
    int anzahl = 0;
    for (int i = 0; i < 15; i++) {
      if (tAbR[i][9] - tAnF[i][9] > 0) {
        anzahl++;
      }
    }
    System.out.println(anzahl);

    //AUFGABE 2.1 d
    int[] stadt = new int[15];
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 31; j++) {
        if (tAbR[i][j] - tAnF[i][j] > 0) {
          stadt[i]++;
        }
      }
    }
    for (int i = 0; i < 15; i++) {
      if (stadt[i] > 16) {
        System.out.println(i);
      }
    }
  }

  private static int zusatzdauer(char c, boolean b, int i, int j, int k) {

    return 0;
  }
}
