/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loopsstrings;

public class CaesarChiffrierung {

  /*
   * Diese Methode soll den String was mit der Zahl zahl verschluesseln. Zunaechst einmal wird jedem
   * Buchstaben genau ein Wert zugeordnet. A=1, B=2, C=3, ... , Y=25, Z=26 a=1, b=2, c=3, ... ,
   * y=25, z=26 Der Buchstabe entspricht immer genau dem zugehoerigen Wert, ungeachtet Gross- oder
   * Kleinschreibung. Um einen Buchstaben nun mit der Zahl zu verschluesseln, wird auf den Wert des
   * Buchstaben diese Zahl addiert. Das Ergebnis ist dann der neue Buchstabe. Hierbei ist der
   * Buchstabe nach Z wieder A. Ein Grossbuchstabe wird immer mit einem Grossbuchstaben
   * verschluesselt und ein Kleinbuchstabe immer mit einem Kleinbuchstaben. Es werden nur Buchstaben
   * verschluesselt. Sonderzeichen werden dabei ignoriert. Beispiele: verschluessel("abcd", 1) -->
   * "bcde" verschluessel("wxyz", 2) --> "yzab" verschluessel("Hallo Welt!", 3) --> "Kdoor Zhow!"
   */
  public static String verschluessel(String was, int zahl) {
    int lowerCaseMin = 97;
    int lowerCaseMax = 122;
    int upperCaseMin = 65;
    int upperCaseMax = 90;

    String result = "";
    String special = "!\"§$%&/()=?`#'*+~-_.:,;{[]}^°<>|´ ";

    for (int i = 0; i < was.length(); i++) {
      if (Character.isUpperCase(was.charAt(i))) {
        if ((int) was.charAt(i) + zahl > upperCaseMax) {
          result += (char) (upperCaseMin + (upperCaseMax - (int) was.charAt(i) + zahl));
        } else {
          result += (char) ((int) was.charAt(i) + zahl);
        }
      } else if (special.contains("" + was.charAt(i))) {
        result += was.charAt(i);
      } else {
        if ((int) was.charAt(i) + zahl > lowerCaseMax) {
          result += (char) (lowerCaseMin + (lowerCaseMax - (int) was.charAt(i) + zahl));
        } else {
          result += (char) ((int) was.charAt(i) + zahl);
        }
      }
    }

    return result;
  }

  /*
   * Diese Methode soll einen verschluesselten String was mit der Zahl zahl wieder entschluesseln.
   * Dabei muss die zahl wieder von jedem Buchstaben abgezogen werden. Auch hier ist der Buchstabe
   * vor A ein Z. Ausserdem wird aus einem Grossbuchstaben nach dem Entschluesseln wieder ein
   * Grossbuchstabe und aus einem Kleinbuchstaben auch wieder ein Kleinbuchstabe. Wenn beide
   * Methoden richtig funktionieren sollte gelten: entschluessel(verschluessel(was, zahl),
   * zahl).equals(was) == true bei beliebigem String was und beliebigem int zahl.
   */
  public static String entschluessel(String was, int zahl) {
    int lowerCaseMin = 97;
    int lowerCaseMax = 122;
    int upperCaseMin = 65;
    int upperCaseMax = 90;

    String result = "";
    String special = "!\"§$%&/()=?`#'*+~-_.:,;{[]}^°<>|´ ";

    for (int i = 0; i < was.length(); i++) {
      if (Character.isUpperCase(was.charAt(i))) {
        if ((int) was.charAt(i) - zahl < upperCaseMin) {
          result += (char) (upperCaseMax - (upperCaseMin - ((int) was.charAt(i) - zahl)));
        } else {
          result += (char) ((int) was.charAt(i) - zahl);
        }
      } else if (special.contains("" + was.charAt(i))) {
        result += was.charAt(i);
      } else {
        if ((int) was.charAt(i) - zahl < lowerCaseMin) {
          result += (char) (lowerCaseMax - (lowerCaseMin - ((int) was.charAt(i) - zahl)));
        } else {
          result += (char) ((int) was.charAt(i) - zahl);
        }
      }
    }

    return result;
  }

  /* Die Main Methode. Du kannst dir hier verschiedene Testfaelle ausdenken und testen. */
  public static void main(String[] args) {
    System.out.println(
        "Wenn man den String \"abcd\" mit der Zahl 1 verschluesselt, sollte das Ergebnis \"bcde\" lauten."
            + "\nDeine Methode gibt Folgendes zurueck: "
            + verschluessel("abcd", 1));
    System.out.println(
        "Wenn man den String \"wxyz\" mit der Zahl 2 verschluesselt, sollte das Ergebnis \"yzab\" lauten."
            + "\nDeine Methode gibt Folgendes zurueck: "
            + verschluessel("wxyz", 2));
    System.out.println(
        "Wenn man den String \"Hallo Welt!\" mit der Zahl 3 verschluesselt, sollte das Ergebnis \"Kdoor Zhow!\" lauten."
            + "\nDeine Methode gibt Folgendes zurueck: "
            + verschluessel("Hallo Welt!", 3));
    System.out.println(
        "Wenn man den String \"bcde\" mit der Zahl 1 entschluesselt, sollte das Ergebnis \"abcd\" lauten."
            + "\nDeine Methode gibt Folgendes zurueck: "
            + entschluessel("bcde", 1));
    System.out.println(
        "Wenn man den String \"yzab\" mit der Zahl 2 entschluesselt, sollte das Ergebnis \"wxyz\" lauten."
            + "\nDeine Methode gibt Folgendes zurueck: "
            + entschluessel("yzab", 2));
    System.out.println(
        "Wenn man den String \"Kdoor Zhow!\" mit der Zahl 3 entschluesselt, sollte das Ergebnis \"Hallo Welt!\" lauten."
            + "\nDeine Methode gibt Folgendes zurueck: "
            + entschluessel("Kdoor Zhow!", 3));
  }
}
