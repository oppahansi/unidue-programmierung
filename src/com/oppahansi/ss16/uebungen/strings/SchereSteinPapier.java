/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.strings;

public class SchereSteinPapier {

  /*
   * Diese Methode soll zur�ckgeben, welches Symbol nach den Schere Stein Papier Regeln gegen das
   * �bergebene Symbol gewinnen w�rde. Schere schl�gt Papier, Papier schl�gt Stein, Stein schl�gt
   * Schere. Entsprechend soll die Methode beim Aufruf gewinner("Papier")--> "Schere"
   * gewinner("Stein") --> "Papier" gewinner("Schere")--> "Stein" zur�ckgeben
   */
  public static String gewinner(String symbol) {
    return null;
  }

  //Main Methode zum �berpr�fen, darf auch ver�ndert werden
  public static void main(String[] args) {
    System.out.println("Gegen Schere gewinnt: " + gewinner("Schere") + " (Richtig ist Stein)");
    System.out.println("Gegen Stein gewinnt: " + gewinner("Stein") + " (Richtig ist Papier)");
    System.out.println("Gegen Papier gewinnt: " + gewinner("Papier") + " (Richtig ist Schere)");
  }
}
