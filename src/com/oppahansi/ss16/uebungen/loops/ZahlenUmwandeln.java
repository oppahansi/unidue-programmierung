/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loops;

public class ZahlenUmwandeln {

  public static void main(String[] args) { // main-Methode von Oppa Hansi

    System.out.println(
        "binaerNachDezimal(\"101010\") --> 42 : Dein Ergebnis: " + binaerNachDezimal("101010"));
    System.out.println(
        "binaerNachDezimal(\"111\") --> 7 : Dein Ergebnis: " + binaerNachDezimal("111"));
    System.out.println(
        "binaerNachDezimal(\"1000\") --> 8 : Dein Ergebnis: " + binaerNachDezimal("1000"));
    System.out.println();
    System.out.println(
        "dezimalNachBinaer(\"42\") --> 101010 : Dein Ergebnis: " + dezimalNachBinaer("42"));
    System.out.println(
        "dezimalNachBinaer(\"7\") --> 111 : Dein Ergebnis: " + dezimalNachBinaer("7"));
    System.out.println(
        "dezimalNachBinaer(\"8\") --> 1000 : Dein Ergebnis: " + dezimalNachBinaer("8"));
  }

  /*
   * Diese Methode soll die uebergeben Zahl in Binaerdarstellung in die gleiche Zahl in
   * Dezimaldarstellung umwandeln. Dazu muss jede Ziffer der Zahl mit 2^(nummer der Ziffer)
   * multipliziert werden und anschlie�end die Summe gebildet werden. Dabei ist die rechte Ziffer
   * der Zahl Nr.0, die links davon Nr.1, ... Tipp: Es gibt auch einen Trick, wie man das Problem
   * einfacher loesen kann. Wer ihn kennt, darf ihn anwenden, wer ihn nicht kennt, macht es wie
   * beschrieben. Die Zahlen werden hier als Strings uebergeben und sollen auch wieder als String
   * zurueckgegeben werden. Beispiel: binaerNachDezimal("101010") --> "42" binaerNachDezimal("111")
   * --> "7" binaerNachDezimal("1000") --> "8"
   */
  public static String binaerNachDezimal(String zahl) {
    // Trickmethode:
    //return "" + Integer.parseInt(zahl, 2);

    int result = 0;

    for (int i = 0; i < zahl.length(); i++) {
      result += Integer.parseInt("" + zahl.charAt(zahl.length() - 1 - i)) * Math.pow(2, i);
    }

    return "" + result;
  }

  /*
   * Diese Methode soll eine gegebene Zahl in Dezimaldarstellung in die gleiche Zahl in
   * Binaerdarstellung umwandeln. Dazu kann man die gegebene Zahl immer wieder durch 2 teilen und
   * anschlie�end betrachten, ob dabei ein Rest entstanden ist. Dieser Rest ist dann die jeweilige
   * Ziffer der neuen Zahl, wobei der Rest, der zum Schluss entstanden ist, die 1. Ziffer der Zahl
   * ist und der Rest, der zuerst entstanden ist, die letzte Ziffer der Zahl ist. Auch hier gibt es
   * einen Trick, der das Ganze einfacher macht, aber an dieser Stelle nicht verraten wird. Ebenso
   * wie in der ersten Aufgabe werden hier die Zahlen als String uebergeben und sollen so auch
   * zurueckgegeben werden. Beispiele: dezimalNachBinaer("42") --> "101010" dezimalNachBinaer("7")
   * --> "111" dezimalNachBinaer("8") --> "1000"
   */
  public static String dezimalNachBinaer(
      String zahl) { // man sollte hier einfach int übergeben anstatt String :) ...
    int number = Integer.parseInt(zahl);
    String result = "";

    while (number > 0) {
      result = number % 2 + result;
      number /= 2;
    }

    return result;
  }
}
