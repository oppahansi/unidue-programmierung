/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Eine mögliche Lösung für die Aufgabe 3 aus dem Uebungsblatt 1
 *
 * <p>Alternative 1
 */
package com.oppahansi.ws1415.uebungsblatt01;

public class Aufgabe_3_A1 {

  public static void main(String[] args) {

    int a = 1, b = 1;
    String c = "2";

    String ergebnisText;

    ergebnisText = "";
    //		ergebnisText += (a - b);
    ergebnisText = ergebnisText + (a - b);
    ergebnisText += " ist das erste Ergebnis, ";

    int cAlsInt = Integer.parseInt(c);

    ergebnisText += ((a + b) * cAlsInt);
    ergebnisText += " ist das zweite Ergebnis ";

    ergebnisText += ((double) a / (double) b) * (b * b * b);

    ergebnisText += " ist das dritte Ergebnis ";

    ergebnisText += (double) cAlsInt / ((long) (a + 65535) * (long) (65535 + b));

    // Ergänzen Sie den Quellcode hier!

    System.out.println(ergebnisText);
  }
}
