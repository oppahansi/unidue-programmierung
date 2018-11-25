/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Mark K. Possible solution - there are other ways to solve these tasks.
 *
 * <p>https://www.youtube.com/watch?v=Y17UNx-sODE - Stream recording
 */
package com.oppahansi.ws1617.mp4;

public class Miniprojekt4 {
  public static void main(String[] args) {

    // Ergaenzen Sie bei Bedarf hier weitere Methodenaufrufe zum Testen von Aufgabe 1. Kommentieren Sie in dem Fall die unteren drei
    // Zeilen vorlaeufig aus!

    Kurznachrichtendienst dienst = new Kurznachrichtendienst(7);
    NutzerSchnittstelle userInterface = new NutzerSchnittstelle(dienst);
    userInterface.start();
  }
}
