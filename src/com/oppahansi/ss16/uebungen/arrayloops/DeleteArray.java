/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.arrayloops;

import java.util.Arrays;

public class DeleteArray {

  /*
   * Diese Methode soll jede Zahl im uebergebenen Array mit 0 ueberschreiben. Die Laenge des Arrays
   * soll dabei nicht veraendert werden, es soll aber nach dem Aufruf nur ausschliesslich 0
   * enthalten. Tipp: Eine Schleife hilft hier, in jedem Durchlauf muss dann array[index] = 0
   * gesetzt werden.
   */
  public static void delete(int[] array) {
    //hier beginnt der zu bearbeitende Bereich
    for (int i = 0; i < array.length; i++) {
      array[i] = 0;
    }
    //hier endet der zu bearbeitende Bereich
  }

  //In der main Methode kannst du deine eigene Methode testen
  //Du darfst dir auch selber Testfaelle ausdenken
  public static void main(String[] args) {
    int[] test = new int[] {1, 2, 3, 4, 5};
    System.out.println("Vorher: " + Arrays.toString(test));
    delete(test);
    System.out.println("Nachher: " + Arrays.toString(test));
  }
}
