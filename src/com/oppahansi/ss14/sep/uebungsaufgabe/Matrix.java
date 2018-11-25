package com.oppahansi.ss14.sep.uebungsaufgabe;

public class Matrix {
  /* Datenstruktur der Matrix realisiert mit zweidimensionalen Integer Array
   */

  int[][] matrix;

  public static void main(String args[]) {
    Matrix m = new Matrix();
    m.erzeugematrix(5);
    m.fuegein(3, 1, 1);
    m.fuegein(4, 1, 3);
    m.fuegein(7, 1, 4);
    m.fuegein(2, 0, 4);
    m.fuegein(1, 4, 4);
    m.fuegein(9, 3, 3);
    m.fuegein(10, 2, 2);
    m.fuegein(15, 4, 2);
    m.fuegein(6, 3, 0);
    m.fuegein(5, 0, 0);
    System.out.println("Die L�sung sollte wie folgt aussehen :");
    System.out.println("Die Summe der Spalte 0 betraegt :7");
    System.out.println("Die Summe der Spalte 1 betraegt :14");
    System.out.println("Die Summe der Spalte 2 betraegt :10");
    System.out.println("Die Summe der Spalte 3 betraegt :15");
    System.out.println("Die Summe der Spalte 4 betraegt :16");
    System.out.println("Die Gesamtsume der Matrix betraegt :62");

    m.spaltensumme();
    m.gesamtsumme();
  }

  public void erzeugematrix(int groesse)

        /* Die Methode erzeugt die Matrix mit der L�nge "groesse"
         * Hinweis: zum Adressieren der Matrix das erste Feld hat den Index 0 !!!
         */

      {
    matrix = new int[groesse][groesse];
    for (int i = 0; i < groesse; i++) {
      for (int j = 0; j < groesse; j++) {
        matrix[i][j] = 0; //Alle Felder der Matrix werden mit 0 initialisiert
      }
    }
  }

  public void fuegein(int zahl, int positionX, int positionY)

        /* f�gt eine Zahl in die Matrix ein an der Stelle "positionX"(horizontal), "positionY" (vertikal)
         */

      {
    matrix[positionX][positionY] = zahl;
  }

  public void spaltensumme() {

    //* Hier ist der Code f�r die Aufagbe zu implementieren

  }

  public void gesamtsumme() {

    //* Hier ist der Code f�r die Aufagbe zu implementieren

  }
}
