/*
 * Created by Rogerg Fu
 *
 * <p>Eine mögliche Lösung für die Aufgabe 1 aus dem Uebungsblatt 2
 *
 * <p>Alternative 1
 */
package com.oppahansi.ws1415.uebungsblatt02;

import java.util.Scanner;

public class Aufgabe_1_A1 {

  static char eingabe() { //vorgegebene Methode vom Übungsblatt zum einlesen einer char varriablen
    Scanner s = new Scanner(System.in);
    String param = s.next();
    s.close();
    return param.charAt(0);
  }

  static String test() {
    Scanner s = new Scanner(System.in);
    String param = s.next();
    s.close();
    return param;
  }

  public static void main(String[] args) {

    char Eingabe;
    int x;

    System.out.println(
        "Bitte geben Sie den Buchstaben ein, dessen Position im Alphabet Sie wissen möchsten.");

    Eingabe = eingabe(); //speichert das eingegebene Zeichen in "Eingabe"
    x = (int) Eingabe; //speichert den ZAHLENWERT des Zeichens in x

    /*
     * das Zeichen "a" hat den Zahlenwert 65 ("A" 97), das Zeichen "z" den Zahlenwert 90 ("Z" 122 nun wird überprüft, ob es sich bei dem eingegebenen
     * Zeichen überhaupt um einen Buchstaben handelt. Wenn dem so ist, wird 64 (vom Zahlenwert abgezogen (weil a wäre ja der erste Buchstabe
     * und 65-64=1) und das eingegebene Zeichen und die Stelle im Alphabet ausgegeben.
     */

    if (65 <= x && x <= 90) {
      System.out.println("" + Eingabe + " ist der " + (x - 64) + ". Buchstabe im Alphabet.");
    } else if (97 <= x && x <= 122) {
      x =
          x
              - 32; //da der Zahlenwert von "A" um 32 höher ist als der von "a" wird x hier um 32 verkleinert
      System.out.println("" + Eingabe + " ist der " + (x - 64) + ". Buchstabe im Alphabet.");
    } else {
      System.out.println("ungültige Eingabe");
    }
  }
}
