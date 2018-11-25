/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loops;

public class Pyramide {

  /*
   * Diese Methode soll eine Pyramide aus * zurueckgeben. Dabei wird mit n die breite der untersten
   * Reihe angegeben. Als n wird immer eine ungerade Zahl angegeben. Eine Pyramide sieht wie folgt
   * aus: * *** ***** Diese wird so erstellt, dass in der obersten Zeile 1 * ist, in der
   * darunterliegenden 3 *,... in der (n/2+1)ten Zeile (die unterste Zeile) kommmen n *. Vor dem
   * ersten * in jeder Zeile muessen noch Leerzeichen eingesetzt werden, damit die Sterne jeder
   * Zeile in der Mitte stehen. Nach dem letzten Stern in jeder Zeile kommt ein Zeilenumbruch, dann
   * beginnt die n�chste Zeile. Nach der letzten Zeile folgt KEIN Zeilenumbruch mehr. Das Zeichen
   * Zeilenumbruch ist das Folgende: \n
   */
  public static String machePyramide(int n) {
    String result = "";
    int spaceCounter = 0;

    while (n > 0) {

      for (int i = 0; i < n; i++) {
        result = "*" + result;
      }

      for (int i = 0; i < spaceCounter; i++) {
        result = " " + result;
      }

      if (n > 1) {
        result = "\n" + result;
      }

      spaceCounter++;
      n -= 2;
    }

    return result;
  }

  /* Beispielmethode. So sieht die Loesung fuer n=5 aus. */
  public static String beispiel() {
    return "  *\n ***\n*****";
  }

  /*
   * In der Main Methode kannst du deine eigene Methode testen. Du kannst natuerlich auch eigene
   * Testfaelle schreiben.
   */
  public static void main(String[] args) {
    System.out.println(beispiel());
    System.out.println();
    System.out.println(machePyramide(1));
    System.out.println();
    System.out.println(machePyramide(3));
    System.out.println();
    System.out.println(machePyramide(5));
    System.out.println();
    System.out.println(machePyramide(7));
  }
}
