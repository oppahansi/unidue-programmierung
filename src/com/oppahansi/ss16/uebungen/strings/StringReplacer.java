/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.strings;

public class StringReplacer {

  /*
   * Diese Methode den uebergebenen String s zuerst umwandeln und dann zurueckgeben. Dabei soll sie
   * jeden in s vorkommenden TeilString toReplace durch replace ersetzen. Dabei wird von links nach
   * rechts vorgegangen. Beispiel: replace("Hazzo Wezt", "z", "l")-->"Hallo Welt" replace("Wer das
   * liest ist doof", "ist doof", "macht diese Aufgabe")-->"Wer das liest macht diese Aufgabe"
   */
  public static String replace(String s, String toReplace, String replace) {
    return null;
  }

  /* Die Main Methode. hier kannst du deine Methode testen. */
  public static void main(String[] args) {
    System.out.println("Diese Ausgabe solle Hallo Welt sein: " + replace("Hazzo Wezt", "z", "l"));
    System.out.println(
        "Diese Ausgabe solle Wer das liest macht diese Aufgabe sein: "
            + replace("Wer das liest ist doof", "ist doof", "macht diese Aufgabe"));
  }
}
