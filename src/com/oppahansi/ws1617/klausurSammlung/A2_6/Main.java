/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_6;

public class Main {

  public static void main(String[] args) {}

  //AUFGABE 2.6 a
  float sum(float[][] s, int m, int n) {
    float aus = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        aus += s[i][j];
      }
    }
    return aus;
  }

  //AUFGABE 2.6 b
  int abstand(float[][] s, int n, int m, int i, int j) {
    if (i < j) {
      return i;
    } else {
      return j;
    }
  }

  //AUFGABE 2.6 c
  char Typ(float[][] s, int n, int m, int i, int j) {
    if (abstand(s, n, m, i, j) % 2 == 0) {
      return 'A';
    } else {
      return 'B';
    }
  }

  //AUFGABE 2.6 d
  float SumA(float[][] s, int n, int m) {
    float aus = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (abstand(s, n, m, i, j) % 2 == 0) {
          aus += s[i][j];
        }
      }
    }
    return aus;
  }

  //AUFGABE 2.6 e
  int AnzA(float[][] s, int n, int m) {
    // nicht vollstaendig
    return -1; // implement a proper method, do not forget a return type - Oppa
  }
}
