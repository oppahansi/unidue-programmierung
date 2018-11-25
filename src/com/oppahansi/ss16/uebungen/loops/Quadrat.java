/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loops;

public class Quadrat {

  /*
   * Diese Methode soll ein Quadrat aus * zurueckgeben in Form eines Strings mit der angegebenen
   * Kantenlaenge. Diese Quadrat soll dann zum Beispiel wie folgt aus sehen: ***** ***** ***** *****
   * ***** Also eine Reihe aus kantenlaenge *, dann ein Zeilenumbruch, dann eine weitere Reihe, ...
   * Am Ende des Strings steht KEIN Zeilenumbruch mehr. Das Zeichen fuer einen Zeilenumbruch ist
   * dieses hier: \n (ein \ gefolgt von einem n)
   */
  public static String macheQuadrat(int kantenlaenge) {
    String row = "";
    String result = "";

    for (int i = 0; i < kantenlaenge; i++) {
      row += "*";
    }

    for (int i = 0; i < kantenlaenge; i++) {
      result += row;
      if (i != kantenlaenge - 1) {
        result += "\n";
      }
    }

    return result;
  }

  /* Beispielmethode So sieht die korrekte Loesung fuer kantenlaenge = 2 aus. */
  public static String beispiel() {
    return "**\n**";
  }

  /*
   * Die main Methode. Hier kannst du deine Methode testen. Du kannst auch eigene Testfaelle
   * schreiben.
   */
  public static void main(String[] args) {
    System.out.println(beispiel());
    System.out.println();
    System.out.println(macheQuadrat(1));
    System.out.println();
    System.out.println(macheQuadrat(2));
    System.out.println();
    System.out.println(macheQuadrat(3));
    System.out.println();
    System.out.println(macheQuadrat(4));
    System.out.println();
    System.out.println(macheQuadrat(5));
    System.out.println();
  }
}
