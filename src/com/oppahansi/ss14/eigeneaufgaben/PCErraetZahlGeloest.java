package com.oppahansi.ss14.eigeneaufgaben;

/*
 * Code written by Oppa Hansi, oppahansi on pastebin.
 */

import java.util.Random;
import java.util.Scanner;

public class PCErraetZahlGeloest {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    Random zufall = new Random();
    boolean aktiv = true;

    int untergrenze;
    int obergrenze;
    int compZahl = 0;
    int zaehler = 1;

    String antwort = "";

    while (aktiv) {
      System.out.print("Bitte Untergrenze angeben: ");
      untergrenze = s.nextInt();
      System.out.println();
      System.out.print("Bitte Obergrenze angeben: ");
      obergrenze = s.nextInt();
      System.out.println();
      System.out.println("Bitte geben Sie nach jedem Versuch g, k oder r an.");
      System.out.println("g: Die Zahl ist groesser.");
      System.out.println("k: Die Zahl ist kleiner.");
      System.out.println("r: Die Zahl ist richtig.");
      System.out.println("\n\n");

      zaehler = 1;

      while (antwort.compareTo("r") != 0) {
        compZahl = untergrenze + zufall.nextInt(obergrenze - untergrenze + 1);

        if (compZahl == untergrenze || compZahl == obergrenze) {
          continue;
        }

        System.out.print(zaehler + ". Versuch: " + compZahl + "\n");
        antwort = s.next();

        if (antwort.compareTo("g") == 0) {
          untergrenze = compZahl;
          zaehler++;
        } else if (antwort.compareTo("k") == 0) {
          obergrenze = compZahl;
          zaehler++;
        }
      }

      System.out.println("Die gesuchte Zahl ist also die " + compZahl + "!");
      aktiv = false;
    }
  }
}
