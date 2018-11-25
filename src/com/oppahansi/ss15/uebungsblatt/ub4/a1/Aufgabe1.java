/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.uebungsblatt.ub4.a1;

public class Aufgabe1 {

  public static void main(String[] args) {
    int[] p1 = {3, 5, 2, 2, 2, 2, 6, 6, 6};
    int[] p2 = {7, 6, 5, 9, 6, 9, 6, 2, 6, 6};
    int[] s1 = {2, 5, 2, 6, 3, 6, 2, 6, 1, 7};
    char[] abc0 = {'a', 'a', 'a', 'a', 'a', 'a'};
    char[] abc1 = {'F', 'i', 'n', 'g', 'e', 'r'};
    char[] abc2 = {'W', 'e', 'i', 'n', 'g', 'l', 'a', 's'};

    Aufgabe1 s = new Aufgabe1();

    System.out.println("Aufgabe 1 ");
    System.out.println("a) " + s.aufeinander(p1, 4) + "\nErwarteter Wert: true");
    System.out.println("b) " + s.nMalVorkommt(p2, 2) + "\nErwarteter Wert: true");
    System.out.println("c) " + s.minVorkommt(p2, 5) + "\nErwarteter Wert: true");
    System.out.println("d) " + s.verschiedenVorkommt(p2, 2) + "\nErwarteter Wert: 2");
    System.out.println("e) " + s.gleich(abc0, 'a') + "\nErwarteter Wert: true");
    System.out.println("f) " + s.index(s1) + "\nErwarteter Wert: true");
    System.out.println("g) " + s.aufeinander(abc1, abc2, 5) + "\nErwarteter Wert: false");
  }

  public boolean aufeinander(int[] p, int n) {
    int counter;
    int currentNumber;

    for (int i = 0; i < p.length; i++) {
      counter = 0;
      currentNumber = p[i];
      for (int j = i; j < p.length - 1; j++) {
        if (currentNumber == p[j + 1]) {
          counter++;
        } else {
          break;
        }
      }
      if (counter == n - 1) {
        return true;
      }
    }
    return false;
  }

  public boolean nMalVorkommt(int[] p, int n) {
    int counter;
    int currentNumber;

    for (int i = 0; i < p.length; i++) {
      counter = 0;
      currentNumber = p[i];
      for (int j = i; j < p.length - 1; j++) {
        if (currentNumber == p[j + 1]) {
          counter++;
        }
      }
      if (counter == n - 1) {
        return true;
      }
    }
    return false;
  }

  public boolean minVorkommt(int[] p, int n) {
    int counter;
    int currentNumber;

    for (int i = 0; i < p.length; i++) {
      counter = 0;
      currentNumber = p[i];
      for (int j = i; j < p.length - 1; j++) {
        if (currentNumber == p[j + 1]) {
          counter++;
        }
      }
      if (counter >= n - 1) {
        return true;
      }
    }
    return false;
  }

  public int verschiedenVorkommt(int[] p, int n) {
    int counter;
    int counterDifferent = 0;
    int currentNumber;

    for (int i = 0; i < p.length; i++) {
      counter = 0;
      currentNumber = p[i];
      for (int j = i; j < p.length - 1; j++) {
        if (currentNumber == p[j + 1]) {
          counter++;
        }
      }
      if (counter == n - 1) {
        counterDifferent++;
      }
    }
    return counterDifferent;
  }

  public boolean gleich(char[] p, char z) {
    for (char current : p) {
      if (current != z) {
        return false;
      }
    }
    return true;
  }

  public boolean index(int[] s) {
    for (int i = 0; i < s.length; i += 2) {
      for (int j = i + 1; j < s.length; j += 2) {
        if (s[i] >= s[j]) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean aufeinander(char[] p, char[] q, int n) {
    int counter;

    if (p.length > q.length) {
      for (int i = 0; i < q.length; i++) {
        for (int j = 0; j < p.length; j++) {
          counter = 0;
          for (int k = j, l = i; k < j + n && k < q.length && l < q.length; k++, l++) {
            if (q[l] == p[k]) {
              counter++;
            }
          }
          if (counter == n) {
            return true;
          }
        }
      }
    } else {
      for (int i = 0; i < p.length; i++) {
        for (int j = 0; j < q.length; j++) {
          counter = 0;
          for (int k = j, l = i; k < j + n && k < p.length && l < p.length; k++, l++) {
            if (p[l] == q[k]) {
              counter++;
            }
          }
          if (counter == n) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
