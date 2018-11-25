/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub5.a1;

public class Aufgabe1 {

  public static void main(String[] args) {
    int[] p1 = {11, 13, 13, 24, 77, 89, 90, 91, 92};
    int[] p2 = {12, 14, 15, 19, 26, 29, 33, 52, 56, 76};
    int[] p3 = {12, 14, 15, 19, 23, 29, 46, 53, 76};

    Aufgabe1 s = new Aufgabe1();

    System.out.println("Aufgabe 1 ");
    System.out.print("a) ");

    int produkt[] = s.produkt(p1, p2);

    for (int aProdukt : produkt) {
      System.out.print(aProdukt + " ");
    }

    System.out.println("\nb) " + s.mittel(p2));
    System.out.print("c) ");

    int merge[] = s.merge(p1, p2);

    for (int aMerge : merge) {
      System.out.print(aMerge + " ");
    }

    System.out.print("\nd) ");

    Liste list = s.ArrayToList(p2, p3);
    Element listElement = list.getKopf();

    while (listElement != null) {
      System.out.print(listElement.getZahl() + " ");
      listElement = listElement.getNf();
    }
  }

  // a)
  public int[] produkt(int[] p, int[] q) {
    int[] result = getFittingArray(p, q);

    for (int i = 0; i < result.length; i++) {
      if (i < p.length && i < q.length) {
        result[i] = p[i] * q[i];
      } else {
        result[i] = 0;
      }
    }

    return result;
  }

  private int[] getFittingArray(int[] first, int[] second) {
    if (first.length <= second.length) {
      return new int[second.length];
    } else {
      return new int[first.length];
    }
  }

  // b)
  public boolean mittel(int[] p) {
    int average = 0;

    for (Integer currentElement : p) {
      average += currentElement;
    }

    average /= p.length;

    for (Integer currentElement : p) {
      if (average == currentElement) {
        return true;
      }
    }

    return false;
  }

  // c)
  public int[] merge(int[] p, int[] q) {
    int[] result = new int[p.length + q.length];
    result = insertNumbers(result, p);
    result = insertNumbers(result, q);
    int switchNumber;

    for (int i = 1; i < result.length; i++) {
      for (int j = i; j < result.length; j++) {
        if (result[i] > result[j]) {
          switchNumber = result[i];
          result[i] = result[j];
          result[j] = switchNumber;
        }
      }
    }

    return result;
  }

  private int[] insertNumbers(int[] numbers, int[] newNumbers) {
    int index = 0;
    for (int i = 0; i < numbers.length && index < newNumbers.length; i++) {
      if (numbers[i] == 0) {
        numbers[i] = newNumbers[index];
        index++;
      }
    }
    return numbers;
  }

  // d)
  public Liste ArrayToList(int[] a, int[] b) {
    Liste numbers = new Liste();
    int[] numbersArray = merge(a, b);
    int lastNumber = -1;

    for (Integer currentNumber : numbersArray) {
      if (currentNumber > 10 && currentNumber < 99 && lastNumber != currentNumber) {
        numbers.insertElement(new Element(currentNumber));
      }
      lastNumber = currentNumber;
    }

    return numbers;
  }
}
