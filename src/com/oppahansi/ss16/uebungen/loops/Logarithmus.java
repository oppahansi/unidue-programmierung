/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.loops;

public class Logarithmus {

  /*
   * Diese Methode soll den Logarithmus zur Basis 2 von zahl berechnen und zurueckgeben. Der
   * Logarithmus zur Basis 2 ist diejenige Zahl, mit der man 2 potenzieren muss, um zahl zu
   * erhalten. In Zeichen: log(zahl)=x <=> 2^x=zahl. Du kannst bei dieser Aufgabe davon ausgehen,
   * dass das Ergebnis immer eine ganze Zahl sein wird. Man kann zur Loesung dieser Aufgabe zum
   * Einen komplizierte Verfahren zur Annaeherung nutzen, da wir aber wissen, dass das Ergebnis
   * ganzzahlig sein muss, kann man auch in einer geeigneten Schleife jede Zahl ueberpruefen, ob
   * diese das Ergebnis ist und, sobald das Ergebnis gefunden wurde, diese zurueckgeben. Noch ein
   * Hinweis: Mit der Funktion Math.pow(double basis, double exponent) kann man basis^exponent
   * berechnen. Diese Funktion gibt aber einen double zurueck, also muss das Ergebnis noch in einen
   * int umgewandelt werden. Es gibt aber auch noch andere Moeglichkeiten, die Potenz einer Zahl zu
   * berechnen. Beispiele: logarithmus(2) --> 1 (2^1=2) logarithmus(4) --> 2 (2^2=4) logarithmus(16)
   * --> 4 (2^4=16)
   */
  public static int logarithmus(int zahl) {
    int result = 0;

    while (zahl > 1) {
      zahl /= 2;
      result++;
    }

    return result;
  }

  /*
   * In Main Methode kannst du deine Methode testen. Dazu kannst du auch eigene Testfaelle
   * schreiben. Beachte dabei aber, dass das erwartete Ergebnis eine ganze Zahl ist, anders
   * formuliert: Beachte, dass du als Parameter nur Zahlen der Form 2^x uebergibst, wobei x eine
   * gannze Zahl ist.
   */
  public static void main(String[] args) {
    System.out.println(logarithmus(2)); //Erwartetes Ergebnis: 1
    System.out.println(logarithmus(4)); //Erwartetes Ergebnis: 2
    System.out.println(logarithmus(8)); //Erwartetes Ergebnis: 3
    System.out.println(logarithmus(16)); //Erwartetes Ergebnis: 4
  }
}
