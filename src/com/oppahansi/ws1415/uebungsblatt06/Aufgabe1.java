/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt06;

public class Aufgabe1 {

  public static void main(String[] args) {
    char[] abc = {
      'a', 'b', 'c', 'e', 'g', 'h', 'i', 'j', 'k', 'J', 'K', 'L', 'M', 'P', 's', 't', 'u', 'v', 'w',
      'x', 'y', 'z', 'A', 'B', 'C', 'D', 'F', 'H', 'I', 'l', 'm', 'n', 'o', 'r', 'Q', 'R', 'S', 'T',
      'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    Aufgabe1 s = new Aufgabe1();
    charListe liste = new charListe();

    System.out.println("Unsortiertes Alphabet:");
    s.ausgabe(abc);
    System.out.println("Sortiertes Alphabet:");
    s.sortiere(abc);
    s.ausgabe(abc);

    liste.erzeugen(abc);
    liste.ausgabe();
  }

  public void sortiere(char[] abc) {

    int minpos;

    for (int i = 0; i < abc.length; i++) {
      minpos = i;
      for (int k = i + 1; k < abc.length; k++) {
        if ((int) abc[k] < (int) abc[minpos]) {
          minpos = k;
        }
      }
      if (minpos > i) {
        vertausche(i, minpos, abc);
      }
    }
  }

  private void vertausche(int i, int k, char[] abc) {

    char ablage = abc[i];
    abc[i] = abc[k];
    abc[k] = ablage;
  }

  public void ausgabe(char[] abc) {

    for (int i = 0; i < abc.length; i++) {
      System.out.print(abc[i] + " ");
    }
    System.out.println("");
  }
}

class charListe {

  private charElement kopf;

  public charListe() {
    kopf = new charElement(' ', ' ');
    kopf.nachfolger = null;
  }

  public void erzeugen(char[] abc) {
    charElement temp = kopf;
    for (int i = 0; i < abc.length; i++) {
      for (int k = i + 1; k < abc.length; k++) {
        if ((int) abc[i] == ((int) abc[k] - 32)) { // Wenn sowohl der
          // Gro�- als auch
          // Kleinbuchstabe
          // vorhanden ist

          if (temp.UpperCase == ' ' && temp.LowerCase == ' ') {
            temp.UpperCase = abc[i];
            temp.LowerCase = abc[k];

          } else {

            temp.nachfolger = new charElement(abc[i], abc[k]); // Erzeugen
            // des neuen
            // Char-Elementes
            temp = temp.nachfolger;
          }
        }
      }
    }
  }

  public void ausgabe() {
    System.out.println("\nListe:");
    charElement temp = kopf;
    while (temp != null) {
      temp.ausgabe();
      temp = temp.nachfolger;
    }
    System.out.print("Ende");
  }
}

class charElement {

  char UpperCase; // Der Gro�buchstabe als Char-Variable
  char LowerCase; // Der Kleinbuchstabe als Char-Variable
  charElement nachfolger;

  public charElement(char UpperCase, char LowerCase) {
    this.UpperCase = UpperCase;
    this.LowerCase = LowerCase;
  }

  public void ausgabe() {
    System.out.print("[" + UpperCase + LowerCase + "] ");
  }
}
