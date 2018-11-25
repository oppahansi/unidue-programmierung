/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.arrayloops;

import java.util.Arrays;

public class ArraySchreiben {

  /*
   * Diese Methode soll ein int Array der Laenge laenge erzeugen, bei dem an jeder Stelle der Index
   * steht. So soll also array[0]=0, array[1]=1, ... , array[laenge-1]=laenge-1 gelten. Dazu muss
   * man das Array mit einer Schleife durchlaufen und in jedem Schleifendurchlauf den Index an die
   * gegebene Stelle schreiben, allgemein also array[index] = index.
   */
  public static int[] macheArray(int laenge) {
    int[] array = new int[laenge];
    //hier beginnt der zu bearbeitende Bereich
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    //hier endet der zu bearbeitende Bereich
    return array;
  }

  //In der Main Methode kannst du dir auch eigene Testfaelle ausdenken und testen
  public static void main(String[] args) {
    System.out.println(
        "Hier sollte '[0]' stehen. Bei dir steht: " + Arrays.toString(macheArray(1)));
    System.out.println(
        "Hier sollte '[0, 1]' stehen. Bei dir steht: " + Arrays.toString(macheArray(2)));
    System.out.println(
        "Hier sollte '[0, 1, 2]' stehen. Bei dir steht: " + Arrays.toString(macheArray(3)));
    System.out.println(
        "Hier sollte '[0, 1, 2, 3]' stehen. Bei dir steht: " + Arrays.toString(macheArray(4)));
    System.out.println(
        "Hier sollte '[0, 1, 2, 3, 4]' stehen. Bei dir steht: " + Arrays.toString(macheArray(5)));
  }
}
