/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.strings;

public class InsertString {

  /*
   * In der Main Methode kannst du deine Methode testen. Du kannst auch eigene Testfaelle schreiben.
   */
  public static void main(String[] args) {
    InsertString insert = new InsertString();
    System.out.println(insert.insert("Halt!", "llo We", 2)); //Sollte Hallo Welt! ergeben
  }

  /*
   * Der String toInsert soll in den String string an die Stelle wo eingef�gt werden. Dabei
   * bezeichnet wo das Zeichen, an dem der String toInsert beginnt. Nach toInsert folgen dann die
   * Zeichen, die vorher in string ab dieser Stelle standen. Beispiel: insert("Halt!", "llo We", 2)
   * --> "Hallo Welt!"
   */
  public String insert(String string, String toInsert, int wo) {
    return string.substring(0, wo) + toInsert + string.substring(wo, string.length());
  }
}
