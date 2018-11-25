/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub2.a1;

public class Uebungsblatt2 {

  /*
  Wer mit ueben moechte, kann den Code in den Methoden zwischen {..} loeschen
  und dann selbst ausprobieren und diese Klasse einfach ausfuehren.
   */
  public static void main(String[] args) {
    System.out.println("Aufgabe 1:");
    System.out.println("0000 hat den Dezimalwert: " + doTastOne(true, true, true, false));
    System.out.println("Erwartet: 0\n");
    System.out.println("0101 hat den Dezimalwert : " + doTastOne(false, true, false, true));
    System.out.println("Erwartet: 5\n");
    System.out.println("1110 hat den Dezimalwert: " + doTastOne(true, true, true, false));
    System.out.println("Erwartet: 14\n");

    System.out.println("Aufgabe 2:");
    doTaskTwo(100, 500);
    System.out.println("Erwartet: \nFor: 153 306 459\nWhile: 153 306 459\n");

    System.out.println("Aufgabe 3:");
    System.out.println("Facultaet von 3 ist: " + doTaskThree(3));
    System.out.println("Facultaet von 6 ist: " + doTaskThree(6));
    System.out.println("Facultaet von 9 ist: " + doTaskThree(9));
    System.out.println("Erwartet: 6 - 720 - 362880");
  }

  // Aufgabe 1
  public static int doTastOne(boolean d0, boolean d1, boolean d2, boolean d3) {
    int solution = 0;

    if (d3) {
      solution += 1;
    }
    if (d2) {
      solution += 2;
    }
    if (d1) {
      solution += 4;
    }
    if (d0) {
      solution += 8;
    }

    return solution;
  }

  // Aufgabe 2
  public static void doTaskTwo(int start, int end) {
    System.out.print("For: ");
    for (int i = start; i <= end; i++) {
      if (i % 9 == 0 && i % 17 == 0) {
        System.out.print(i + " ");
      }
    }

    System.out.println();

    System.out.print("While: ");
    int counter = start;
    while (counter <= end) {
      if (counter % 9 == 0 && counter % 17 == 0) {
        System.out.print(counter + " ");
      }
      counter++;
    }

    System.out.println();
  }

  // Aufgabe 3
  public static int doTaskThree(int faculty) {
    int solution = 1;

    if (faculty == 0) {
      return 1;
    } else {
      for (int i = 1; i <= faculty; i++) {
        solution *= i;
      }

      return solution;
    }
  }
}
