package com.oppahansi.ss14.sep.uebungsaufgabe;

public class MatrixChar {
  /* Datenstruktur der Matrix realisiert mit zweidimensionalen String Array
   */

  char[][] matrix;

  public static void main(String args[]) {
    MatrixChar m = new MatrixChar();
    m.erzeugematrix(9);

    m.fuegein('E', 2, 2);
    m.fuegein('S', 1, 3);
    m.fuegein('S', 2, 3);
    m.fuegein('E', 2, 4);
    m.fuegein('E', 3, 3);

    m.fuegein('M', 4, 2);
    m.fuegein('E', 5, 2);
    m.fuegein('R', 6, 2);
    m.fuegein('L', 2, 5);
    m.fuegein('E', 4, 3);
    m.fuegein('N', 4, 4);
    m.fuegein('S', 4, 5);
    m.fuegein('A', 4, 6);
    m.fuegein('A', 2, 7);
    m.fuegein('R', 3, 7);
    m.fuegein('R', 4, 7);
    m.fuegein('A', 5, 7);
    m.fuegein('Y', 6, 7);
    m.fuegein('Q', 5, 5);

    m.fuegein('L', 5, 8);
    m.fuegein('B', 6, 1);
    m.fuegein('A', 6, 3);
    m.fuegein('T', 6, 4);
    m.fuegein('E', 6, 5);
    m.fuegein('N', 6, 6);
    m.ausgabe();
    System.out.println("Die L�sung sollte wie folgt aussehen :");
    System.out.println("Ist das Wort ESEL in der Spalte vorhanden :true");
    System.out.println("Ist das Wort ESEL in der Zeile vorhanden :false");
    System.out.println("Ist das Wort EIMER in der Spalte vorhanden :false");
    System.out.println("Ist das Wort EIMER in der Zeile vorhanden :false");
    System.out.println("Ist das Wort SSE in der Spalte vorhanden :false");
    System.out.println("Ist das Wort SSE in der Zeile vorhanden :true");
    System.out.println("Ist das Wort MENSA in der Spalte vorhanden :true");
    System.out.println("Ist das Wort MENSA in der Zeile vorhanden :false");
    System.out.println("Ist das Wort QUAL in der Spalte vorhanden :false");
    System.out.println("Ist das Wort QUAL in der Zeile vorhanden :false");
    System.out.println("Ist das Wort ARRAY in der Spalte vorhanden :false");
    System.out.println("Ist das Wort ARRAY in der Zeile vorhanden :true");
    System.out.println("Ist das Wort BRATEN in der Spalte vorhanden :true");
    System.out.println("Ist das Wort BRATEN in der Zeile vorhanden :false");
  }

  public void erzeugematrix(int groesse)

        /* Die Methode erzeugt die Matrix mit der L�nge "groesse"
         * Hinweis: zum Adressieren der Matrix das erste Feld hat den Index 0 !!!
         */

      {
    int puffer;
    matrix = new char[groesse][groesse];
    for (int i = 0; i < groesse; i++) {

      for (int j = 0; j < groesse; j++) {
        puffer = (i + j) % 26 + 65;

        matrix[i][j] = (char) puffer;
      }
    }
  }

  public void fuegein(char chr, int positionY, int positionX)

        /* f�gt einen Character(Buchstaben) in die Matrix ein an der Stelle "positionX"(horizontal), "positionY" (vertikal)
         */

      {
    matrix[positionX][positionY] = chr;
  }

  public void ausgabe()

        //* Die Methode veranschaulicht die Matrix auf dem Bildschirm

      {
    int ssumme = 0;
    for (int x = 0; x < matrix.length; x++) {
      for (int y = 0; y < matrix.length; y++) {
        System.out.print(matrix[x][y] + " ");
      }
      System.out.println();
    }
  }

  public boolean findeWortSP(String wort)

        //* Sucht in den Spalten von oben nach unten nach dem Wort

      {

    //* Hier ist der Code f�r die Aufagbe zu implementieren
    return false;
  }

  public boolean findeWortZE(String wort)

        //* Sucht in den Zeilen von links nach rechts nach dem Wort
      {

    //* Hier ist der Code f�r die Aufagbe zu implementieren
    return false;
  }
}
