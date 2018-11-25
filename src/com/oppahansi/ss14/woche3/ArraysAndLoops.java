package com.oppahansi.ss14.woche3;
/*
 * In dieser Aufgabe soll das Zusammenspiel von Arrays und For-Schleifen geuebt
 * werden. In den meisten Methoden ist dem Parameter elements das Schluessel-
 * wort "final" vorgestellt. Das bedeutet, dass das Array in der Methode nur
 * gelesen, nicht aber beschrieben werden darf.
 */

public class ArraysAndLoops {

  // Diese Methode soll die Elemente des als Parameter (elements) uebergebenen
  // addieren und die Gesamtsumme zurueckgeben
  public static int sum(final int[] elements) {
    if (elements == null) {
      return -1;
    } else {
      int sum = 0;

      for (int i = 0; i < elements.length; i++) {
        sum += elements[i];
      }

      return sum;
    }
  }

  // Diese Methode soll in einem als Parameter (elements) uebergebenen Array
  // das groesste Element finden. Rueckgabewert soll das Produkt aus dem
  // groessten Element und dem Index des groessten Elements sein.
  // Beispiel: Eingabe   = {2, 13, 56, 44, 5}
  //           Rueckgabe = 56 (groesstes Element) * 2 (Index von 56) = 112
  // Nicht vergessen, dass die Indizierung in einem Array mit 0 beginnt!
  public static int maxElement(final int[] elements) {
    if (elements == null) {
      return -1;
    } else {
      int prod = 0;
      int index = 0;
      if (elements[0] < 0) {
        prod = elements[0];
      }
      for (int i = 0; i < elements.length; i++) {
        if (elements[i] > prod) {
          prod = elements[i];
          index = i;
        }
      }

      return prod * index;
    }
  }

  // Diese Methode soll ein Array zurueckgeben, in dem alle Elemente des
  // uebergebenen Arrays dupliziert wurden und in der gleichen Reihenfolge
  // wie im Originalarray stehen. Beispiel:
  // Ubergeben wird ein Array der Form {4, 16, 8},
  // Das zurueckgegebene Array soll dann {4, 4, 16, 16, 8, 8} beinhalten.
  public static int[] duplicateElements(final int[] elements) {
    if (elements == null) {
      return null;
    } else {
      int[] newArray = new int[elements.length * 2];

      for (int i = 0; i < elements.length; i++) {
        for (int j = i; j < i + 1; j++) {
          newArray[j * 2] = elements[i];
          newArray[j * 2 + 1] = elements[i];
        }
      }

      return newArray;
    }
  }

  // Diese Methode soll zu einem uebergebenen Array ein neues Array zurueck
  // geben, in dem zu jedem Element des Ausgangsarrays das Quadrat steht.
  // Beispiel: Eingabe   = {4,  12,  7}
  //           Rueckgabe = {16, 144, 49}
  public static int[] getSquares(final int[] elements) {
    if (elements == null) {
      return null;
    } else {
      int[] newArray = new int[elements.length];

      for (int i = 0; i < newArray.length; i++) {
        newArray[i] = (int) Math.pow(elements[i], 2);
      }

      return newArray;
    }
  }

  // Diese Methode soll in einem uebergebenen Array die Reihenfolge der
  // Elemente umkehren.
  // Beispiel: Eingabe   = {4,  12,  7, 18}
  //           Rueckgabe = {18,  7, 12, 4}
  // ACHTUNG: Diese Methode hat keine Rueckgabe. Das Array Elements soll
  // nach Ausfuehrung der Methode das Ergebnis beinhalten.
  public static void reverseArray(int[] elements) {
    if (elements == null) {

    } else {
      int[] newArray = new int[elements.length];
      for (int i = elements.length - 1; i >= 0; i--) {
        newArray[elements.length - 1 - i] = elements[i];
      }
      for (int i = 0; i < elements.length; i++) {
        elements[i] = newArray[i];
      }
    }
  }

  // Hier koennt ihr eure Methoden testen
  public static void main(String[] args) {}
}
