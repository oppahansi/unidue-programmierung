//L�sung erarbeitet: Artur
//Kommentiert: TtheKrysler
//Copyright Miniprojekt: Paluno

package com.oppahansi.ws1516.mp.mp2_A1;

import java.util.Arrays;

public class Matrix {

  private int[][] values;

  public Matrix(int[][] initialValues) {
    //Konstruktor setzen damit wir die Matrix m und n mit Werten bef�llen die schon vorgegeben sind
    this.values = initialValues;
  }

  public static void main(String[] args) {
    Matrix m = new Matrix(new int[][] {{2, 4, 5}, {3, 7, 2}, {-2, 0, 1}, {5, 1, 1}});

    System.out.println("Neue Matrix m erzeugt. Matrix m:");
    // Erwartete Ausgabe:
    // 4x3:
    // [2, 4, 5]
    // [3, 7, 2]
    // [-2, 0, 1]
    // [5, 1, 1]
    m.print();

    System.out.println("------------------------------------------------------------------");

    Matrix n = new Matrix(new int[][] {{1, 0, -1}, {1, 3, 3}, {-2, -4, 1}, {0, 0, 1}});

    System.out.println("Neue Matrix n erzeugt. Matrix n:");
    // Erwartete Ausgabe:
    // 4x3:
    // [1, 0, -1]
    // [1, 3, 3]
    // [-2, -4, 1]
    // [0, 0, 1]
    n.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Skalarmultiplikation von Matrix n mit dem Wert -1. Matrix n:");
    n.scalarMultiplication(-1);
    // Erwartete Ausgabe:
    // 4x3:
    // [-1, 0, 1]
    // [-1, -3, -3]
    // [2, 4, -1]
    // [0, 0, -1]
    n.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Matrix n wird zu Matrix m addiert. Matrix m:");
    m.add(n);
    // Erwartete Ausgabe:
    // 4x3:
    // [1, 4, 6]
    // [2, 4, -1]
    // [0, 4, 0]
    // [5, 1, 0]
    m.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Spaltenvektor mit Index 1 von Matrix m:");
    int[] columnVector = m.getColumnVector(1);
    // Erwartete Ausgabe:
    // [4, 4, 4, 1]
    System.out.println(Arrays.toString(columnVector));

    System.out.println("------------------------------------------------------------------");

    System.out.println("Vergleich von Matrix m mit Matrix n:");
    // Erwartete Ausgabe:
    // false
    System.out.println(m.isEqualTo(n));

    System.out.println("------------------------------------------------------------------");

    Matrix o = new Matrix(new int[][] {{1, 4, 6}, {2, 4, -1}, {0, 4, 0}, {5, 1, 0}});

    System.out.println("Neue Matrix o erzeugt. Matrix o:");
    // Erwartete Ausgabe:
    // 4x3:
    // [1, 4, 6]
    // [2, 4, -1]
    // [0, 4, 0]
    // [5, 1, 0]
    o.print();

    System.out.println("------------------------------------------------------------------");

    System.out.println("Vergleich von Matrix o mit Matrix m:");
    // Erwartete Ausgabe:
    // true
    System.out.println(o.isEqualTo(m));

    System.out.println("------------------------------------------------------------------");

    System.out.println("Transponieren von Matrix o. Matrix o:");
    o.transpose();
    // Erwartete Ausgabe:
    // 3x4:
    // [1, 2, 0, 5]
    // [4, 4, 4, 1]
    // [6, -1, 0, 0]
    o.print();
  }

  public void scalarMultiplication(int c) {

    //da wir eine 4x3 Matrix haben und diese mit Skalar (-1) multiplizieren m�chten,
    //m�ssen wir das Array welches sich dahinter verbirgt so auslesen, damit wir
    //die L�nge f�r Zeile und Spalte seperat haben. Dies ist mit 2 For-Schleifen
    //getan. (Es ist auch anders m�glich!!!)

    for (int i = 0; i < values.length; i++) { //values.length = L�nge der Zeilen
      for (int j = 0; j < values[0].length; j++) { //values[0].length = L�nge der Spalten
        //hier wurden jetzt die L�nge der Spalten und Zeilen ausgelesen, was f�r eine
        //Multiplikation wichtig ist

        values[i][j] = values[i][j] * c;
        //die Werte aus der For-Schleife wurden in [i] und [j] gespeichert
        //Jetzt sagen wir der Methode was sie zutun hat:
        //N�here informationen zur Skalarmultiplikation siehe "Lineare Algebra"
        //values(Werte) [i(L�nge Spalten)] [j(L�nge Zeilen)] = values[i][j] *(multipliziert) mit c
        //der Wert c ist in der main-Methode schon vorgegeben, das hei�t wir m�ssen ihn
        //nur �bernehmen
      }
    }
  }

  public void add(Matrix m) {
    //hier soll die Matrix n mit der Matrix m addiert werden.
    //(N�here informationen zur Addition von Matrizen siehe "Lineare Algebra")

    //Wir holen uns wieder die L�nge der Spalten und Zeilen mit der For-Schleife
    for (int i = 0; i < values.length; i++) { //L�nge der Zeilen
      for (int j = 0; j < values[0].length; j++) { //L�nge der Spalten

        values[i][j] = values[i][j] + m.values[i][j];
        //nun addieren wir die Matrix n mit Matrix m;
        //Die Werte der Matrix n befinden sich in values[i][j] und die Werte der
        //m befinden sich in m.values[i][j] (Wobei i und j nur die L�nge Zeilen und Spalten ist.
        //Die Werte der Matrizen sind in diesem Miniprojekt vorgeben in der Main-Methode und durch
        //den Konstruktor in values geladen.
      }
    }
  }

  public int[] getColumnVector(int col) {
    //hier soll der Spaltenvektor einer Matrize ausgeben werden
    //welche Spalte ist in der Variable "col" definiert (siehe Main-Methode)
    //Anmerkung: Egal was gefordert ist denkt immer daran:
    //ein Array mit der L�nge [2] f�ngt bei [0] an gefolgt von der [1].
    //die [0] ist quasi der erste Wert und die [1] der zweite

    //hier errichte ich mir eine Hilfsvariable
    int hilfe = values.length;
    //diese soll mir ddie L�nge der Spalte auslesen und sie in "hilfe" speichern

    //hier errichte ich mir ein Hilfsarray welches ich loesung nenne
    int[] loesung = new int[hilfe];
    //das Array loesung = ein neues Array mit der L�nge [hilfe]
    //meiner Ansicht nach die beste Methode um die dynamik zu behalten und einen
    //outofbounderies zu entgehen.

    //damit ich auf die Werte zugreifen kann mache ich wieder eine For-Schleife
    for (int i = 0; i < hilfe; i++) {

      //und sage nun der Methode:
      //loesung(mein Hilfsarray) mit der L�nge[i] bekommt die Werte von
      //Matrix(values) mit der L�nge[i] und der Spalte[col]
      loesung[i] = values[i][col];
    }

    //das ganze Returnen und da habt ihr die L�sung :-)
    return loesung;
  }

  public boolean isEqualTo(Matrix m) {
    //In dieser Methode soll �berpr�ft werden ob die aufgerufene Matrix mit der Matrtrix �bereinstimmt
    //Dies ist der Fall wenn Matrix A und Matrix B die gleiche anzahl an Spalten und Zeilen haben.
    //Bsp: 	Matrix A = 4x3 und Matrix B = 4x3; das passt also :-) --> "true"
    //Bsp2:	Matrix A = 3x3 und Matrix B = 4x3; das passt also nicht --> "false"

    //Wir machen also eine IF-then-else Bedingung.
    //Man k�nnte theoretisch mit: if (Matrix A = Matrix B) arbeiten, jedoch hier haben wir es anders gemacht
    //um ein bi�chen Arbeit zu sparen :-)

    //Wir vergleichen also nicht auf Gleichheit, sondern auf "UNGLEICHHEIT"
    //1.Schritt: Erkl�rung hier als Pseudo Code
    //Pseudo-Code: 	wenn(if) (Spaltenl�nge Matrix n ungleich Spaltenl�nge Matrix m ist ODER
    //						 (Zeilenl�nge Matrix n ungleich Zeilenl�nge ist) wenn ja, return "false"
    if (values[0].length != m.values[0].length || values.length != m.values.length) {
      return false;
    }
    //sollte das jetzt der Fall sein, wird sofort "false" zur�ckgegeben und die Methode wird beendet

    else //andernfalls(also wenn die obere Bedingung "true" ist, was hier der Fall ist:
    {
      //Spaltenl�nge lesen
      for (int i = 0; i < values.length; i++) {
        //Zeilenl�nge lesen
        for (int k = 0; k < values[0].length; k++) {
          //vergleichen ob Zeilen und Spalten Matrix n "UNGLEICH" Matrix m ist, wenn ja return false
          if (values[i][k] != m.values[i][k]) {
            return false;
          }
        }
      }
    }
    //andernfalls return true
    return true;
  }

  // --------------------------------------------------------------

  public void transpose() {
    //hier soll die Matrix transponiert werden, das hei�t wir kippen die Matrix
    //Bsp: Matrix vorher 4x3 --> Matrix nachher 3x4;
    //Anm: Bei einer NxN Matrix ist dies nicht so kompliziert wie folgt beschrieben :-)

    //Als erstes errichten wir uns ein Hilfsarray 3x4 (denn das wollen wir ja erreichen.
    int[][] loesung = new int[values[0].length][values.length];
    //Wir errichten das Array also mit der Zeilen(3) und der L�nge der Spalten(4)
    //Also genau umgekehrt als das Ursprungsarray

    //Dann lesen wir die L�nge in unser Hilfsarray ein mit den 2 For-Schleifen
    for (int i = 0; i < loesung.length; i++) {
      for (int k = 0; k < loesung[0].length; k++) {

        //Nun transponieren wir indem wir sagen das unser Hilfsarray[Zeile][Spalte]
        //genau gleich sein soll wie die Ursprungsmatri[Spalte][Zeile]
        //Man hat also getauscht
        loesung[i][k] = values[k][i];
      }
    }

    //und hier sagen wir einfach das values jetzt = loesung ist.
    values = loesung;
  }

  private void print() {
    if (values == null) {
      System.out.println("null");
    } else {
      System.out.printf("%dx%x:%n", values.length, values[0].length);

      for (int[] row : values) {
        System.out.println(Arrays.toString(row));
      }
    }
  }
}
