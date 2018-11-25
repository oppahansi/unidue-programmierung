/* Created by oppahansi on 07.11.2014. */
package com.oppahansi.ws1415.uebungsblatt03;

public class Aufgabe_1_A1 {

  private static final int UNTERGRENZE = 100;
  private static final int OBERGRENZE = 500;
  private static final int VIELFACHE_1 = 9;
  private static final int VIELFACHE_2 = 17;
  private static int counter = UNTERGRENZE;

  public static void main(String[] args) {
    System.out.println("Mit FOR-SCHLEIFE: \n");
    for (int i = UNTERGRENZE; i <= OBERGRENZE; i++) {
      if (i % VIELFACHE_1 == 0) {
        System.out.println(i + " is ein Vielfaches von " + VIELFACHE_1 + ".");
      }
      if (i % VIELFACHE_2 == 0) {
        System.out.println(i + " is ein Vielfaches von " + VIELFACHE_2 + ".");
      }
    }

    System.out.println("\nMit WHILE-SCHLEIFE: \n");
    while (counter <= OBERGRENZE) {
      if (counter % VIELFACHE_1 == 0) {
        System.out.println(counter + " is ein Vielfaches von " + VIELFACHE_1 + ".");
      }
      if (counter % VIELFACHE_2 == 0) {
        System.out.println(counter + " is ein Vielfaches von " + VIELFACHE_2 + ".");
      }
      counter++;
    }
  }
}
