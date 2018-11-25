/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loopsstrings;

public class HexadezimalUmwandler {

  /*
   * In dieser Methode soll der String zahl in einen String umgewandelt werden, der die gleiche Zahl
   * im Hexadezimalsystem darstellt. Im Hexadezimalsystem kann eine Zahl 16 verschiedene Ziffern
   * haben: 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F Diese Methode bekommt als Parameter eine Zahl in
   * Binaerkodierung uebergeben. Tipp: Man kann immer 4 Bits der uebergebenen Zahl in eine Ziffer
   * umwandeln. Tipp: Man beginnt die Bits von rechts zu zaehlen. Beispiele: binaerNachHex("1001")
   * --> "9" binaerNachHex("1101") --> "D" binaerNachHex("10011101") --> "9D"
   * binaerNachHex("101011") --> "2B"
   */
  public static String binaerNachHex(String zahl) {
    int decimal = binaryToDecimal(zahl);
    String result = "";

    while (decimal > 0) {
      if (decimal % 16 > 10) {
        if (decimal % 16 == 10) {
          result = "A" + result;
        } else if (decimal % 16 == 11) {
          result = "B" + result;
        } else if (decimal % 16 == 12) {
          result = "C" + result;
        } else if (decimal % 16 == 13) {
          result = "D" + result;
        } else if (decimal % 16 == 14) {
          result = "E" + result;
        } else if (decimal % 16 == 15) {
          result = "F" + result;
        }
      } else {
        result = decimal % 16 + result;
      }
      decimal /= 16;
    }

    return result;
  }

  private static int binaryToDecimal(String number) {
    int result = 0;

    for (int i = 0; i < number.length(); i++) {
      result += Integer.parseInt("" + number.charAt(number.length() - 1 - i)) * Math.pow(2, i);
    }

    return result;
  }

  /*
   * Diese Methode nimmt eine Zahl im Hexadezimalsystem an und soll diese in eine Zahl in
   * Binaerkodierung umformen. Tipp: Der Tipp aus der ersten Methode funktioniert hier auch
   * umgekehrt. Man kann jede Ziffer der Zahl in 4 Bits einzeln umformen, diese aneinanderreihen und
   * anschlie�end fuehrende Nullen wegwerfen. Beispiele: hexNachBinaer("42") --> "1000010"
   * hexNachBinaer("AB") --> "10101011" hexNachBinaer("123") --> "100100011"
   */
  public static String hexNachBinaer(String zahl) {
    int decimal = hexToDecimal(zahl);
    String result = "";

    while (decimal > 0) {
      result = decimal % 2 + result;
      decimal /= 2;
    }

    return result;
  }

  private static int hexToDecimal(String number) {
    int result = 0;

    for (int i = 0; i < number.length(); i++) {

      if (number.charAt(number.length() - 1 - i) == 'A') {
        result += 10 * Math.pow(16, i);
      } else if (number.charAt(number.length() - 1 - i) == 'B') {
        result += 11 * Math.pow(16, i);
      } else if (number.charAt(number.length() - 1 - i) == 'C') {
        result += 12 * Math.pow(16, i);
      } else if (number.charAt(number.length() - 1 - i) == 'D') {
        result += 13 * Math.pow(16, i);
      } else if (number.charAt(number.length() - 1 - i) == 'E') {
        result += 14 * Math.pow(16, i);
      } else if (number.charAt(number.length() - 1 - i) == 'F') {
        result += 15 * Math.pow(16, i);
      } else {
        result += Integer.parseInt("" + number.charAt(number.length() - 1 - i)) * Math.pow(16, i);
      }
    }

    return result;
  }

  //In der Main Methode kannst du deine Methoden testen.
  //Du kannst natuerlich auch eigene Testfaelle schreiben.
  public static void main(String[] args) {
    System.out.println(
        "Der Aufruf deiner Methode binaerNachHex mit Parameter 1001 liefert: "
            + binaerNachHex("1001"));
    System.out.println(
        "Der Aufruf deiner Methode binaerNachHex mit Parameter 1101 liefert: "
            + binaerNachHex("1101"));
    System.out.println(
        "Der Aufruf deiner Methode binaerNachHex mit Parameter 10011101 liefert: "
            + binaerNachHex("10011101"));
    System.out.println(
        "Der Aufruf deiner Methode binaerNachHex mit Parameter 101011 liefert: "
            + binaerNachHex("101011"));
    System.out.println(
        "Der Aufruf deiner Methode hexNachBinaer mit Parameter 42 liefert: " + hexNachBinaer("42"));
    System.out.println(
        "Der Aufruf deiner Methode hexNachBinaer mit Parameter AB liefert: " + hexNachBinaer("AB"));
    System.out.println(
        "Der Aufruf deiner Methode hexNachBinaer mit Parameter 123 liefert: "
            + hexNachBinaer("123"));
  }
}
