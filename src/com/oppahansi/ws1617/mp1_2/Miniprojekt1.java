/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp1_2;

public class Miniprojekt1 {

  public static double endNote(int noteUebung, int noteAusarbeitung, int noteVortrag) {
    double summe = (noteUebung + noteAusarbeitung * 3 + noteVortrag * 2);
    double ergebnis = summe / 6;
    return ergebnis;
  }

  public static double tarif1(int min) {
    double grundgebuehr = 7.99;
    double proMinute = 0.37;
    double summe = grundgebuehr + (min * proMinute);
    return summe;
  }

  public static double tarif2(int min) {
    double grundgebuehr = 19.95;
    double proMinute = 0.25;
    double freiMinuten = 30;
    double summe = grundgebuehr + ((min - freiMinuten) * proMinute);
    return summe;
  }

  public static double tarif3(int min) {
    double grundgebuehr = 24.95;
    double proMinute = 0.19;
    double freiMinuten = 50;
    double summe = grundgebuehr + ((min - freiMinuten) * proMinute);
    return summe;
  }

  public static boolean tripel(int a, int b, int c) {
    double a2 = a * a;
    double b2 = b * b;
    double c2 = c * c; // Math.pow(c, 2);
    boolean vergleich = (a2 + b2 == c2);
    return vergleich;
  }

  public static boolean checkEven(int zahl) {
    if (zahl % 2 == 0) {
      return true;
    } else {
      return false;
    }

    // return zahl % 2 == 0;
  }

  public static boolean checkOdd(int zahl) {
    if (zahl % 2 != 0) {
      return true;
    } else {
      return false;
    }

    // return zahl % 2 != 0;
  }

  public static boolean schaltjahr(int jahr) {
    if (jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0)) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean enthaeltPunkt(int x, int y) {
    if (x > 2 && x < 14 && y < 3 && y > -15) {
      return true;
    } else {
      return false;
    }
  }

  public static double kreisFlaeche(double radius) {
    double flaeche = Math.PI * Math.pow(radius, 2);
    // return flaeche;
    return Math.PI * Math.pow(radius, 2);
  }

  public static double kreisUmfang(double radius) {
    double umfang = Math.PI * 2 * radius;
    // return umfang;
    return Math.PI * 2 * radius;
  }

  public static double rechteckFlaeche(double laenge, double breite) {
    return laenge * breite;
  }

  public static boolean kreisKleinerRechteck(double radius, double laenge, double breite) {
    double kreisFlaeche = kreisFlaeche(radius);
    double rechteckFlaeche = rechteckFlaeche(laenge, breite);
    return kreisFlaeche < rechteckFlaeche;
  }

  public static double steigung(double xA, double yA, double xB, double yB) {
    double y = yA - yB;
    double x = xA - xB;
    // double m = y / x;
    return y / x;
  }

  public static double rechteck1VergleicheRechteck2(double l1, double b1, double l2, double b2) {
    double rechteck1 = rechteckFlaeche(l1, b1);
    double rechteck2 = rechteckFlaeche(l2, b2);

    return rechteck1 / rechteck2;
  }

  public static void main(String[] s) {
    System.out.println(
        "Die Endnode von dem Student mit Uebung(70), Ausarbeitung(50) und Vortrag(70): (60 ware richtig): "
            + endNote(70, 50, 70));
    System.out.println("Tarif 1 kostet im Monat f�r 100 Gespr�chsminuten: (44.99) " + tarif1(100));
    System.out.println("Tarif 2 kostet im Monat f�r 130 Gespr�chsminuten: (44.95) " + tarif2(130));
    System.out.println("Tarif 3 kostet im Monat f�r 150 Gespr�chsminuten: (43.95) " + tarif3(150));
    System.out.println("Die Rueckgabe sollte true sein: " + tripel(20, 21, 29));
    System.out.println("Die Rueckgabe sollte false sein: " + tripel(1, 2, 3));
    System.out.println("Sollte true zurueckgeben: " + checkEven(42));
    System.out.println("Sollte false zurueckgeben: " + checkEven(27));
    System.out.println("Sollte true zurueckgeben: " + checkOdd(33));
    System.out.println("Sollte false zurueckgeben: " + checkOdd(36));
    System.out.println("2016 ist ein Schaltjahr: " + schaltjahr(2016) + " (true waere richtig) ");
    System.out.println("2004 ist ein Schaltjahr: " + schaltjahr(2004) + " (true waere richtig) ");
    System.out.println(
        "R(5|4) liegt innerhalb der Flaeche? Sollte false zurueckgeben:  " + enthaeltPunkt(5, 4));
    System.out.println(
        "S(-5|-12) liegt innerhalb der Flaeche? Sollte false zurueckgeben:  "
            + enthaeltPunkt(-5, -12));
    System.out.println("Flaeche Kreis Radius 3: " + kreisFlaeche(3));
    System.out.println("Umfang Kreis Radius 3: " + kreisUmfang(3));
    System.out.println(
        "Ist die Flaeche einen Kreises mit Radius 6 kleiner als die Flaeche eines Rechtecks mit laenge 2 und Breite 3? Sollte false zurueckgeben:  "
            + kreisKleinerRechteck(6, 2, 3));
    System.out.println(
        "Die Steigung der Geraden AB mit A(2,2) und (4,6) ist 2: " + steigung(2, 2, 4, 6));
    System.out.println(
        "Die Flaeche von Rechteck1 mit der Laenge 3 und Breite 4 ist groesser als die Flaeche von Rechteck2 mit der Laenge 2 und Breite 3 mit dem Faktor 2: "
            + rechteck1VergleicheRechteck2(3, 4, 2, 3));
  }
}
