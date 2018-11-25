package com.oppahansi.ss14.woche3;

/*
 * In dieser Klasse soll eine erste einfache Verwendung der for-Schleife
 * geuebt werden. Der Kopf der for-Schleife besteht und dem Schluesselwort for,
 * sowie der Initialisierung, der Abbruchbedingung und dem Inkrement, gefolgt
 * von einem Befehlsblock:
 *
 *   for(Initialisierung; Abbruchbedingung; Inkrement){
 *   	// durch die Schleife wiederholt auszufuehrender Code
 *   }
 *
 *   Die einzelnen zu implementierenden Methoden gehen auf die oben genannten
 *   verschiedenen Bestandteile des Schleifenkopfes ein.
 */

public class ForLoop {

  // In dieser Methode sollen alle Zahlen von 0 bis N (Parameter number) mit
  // Hilfe der for-Schleife summiert und das Ergebnis zurueckgegeben werden.
  // Mit dem Parameter 4 soll also das Ergebnis die Summe aller Zahlen bis 4
  // betragen. 1 + 2 + 3 + 4 = 10 sollte die Rueckgabe sein.
  public static int sumUpToN(int number) {
    int sum = 0;
    // Hier kommt ihre Schleife hin

    for (int i = 1; i <= number; i++) {
      sum += i;
    }

    return sum;
  }

  // In dieser Methode sollen die geraden Zahlen bis einschliesslich  N
  // addiert und die Summe zurueckgegeben werden. Fuer die Parameter 6 und 7
  // waeren also die Zahlen 2, 4 und 6 zu addieren. Die Rueckgabe waere
  // 2 + 4 + 6 = 12
  // Es bietet sich an die Inkrementanweisung der for-Schleife entsprechend
  // anzupassen.
  public static int sumOfEvenNumbersUpToN(int number) {
    int sum = 0;
    // Hier kommt ihre Schleife hin
    if (number == 0 || number < 0) {
      return sum;
    } else {
      for (int i = 1; i <= number; i++) {
        if (i % 2 == 0) {
          sum += i;
        }
      }

      return sum;
    }
  }

  // Diese Methode soll aehnlich wie sumUpToN funktionieren, jedoch ist das
  // erste zu addierende Element nicht auf 1 festgelegt, sondern wird durch
  // den Parameter numberA bestimmt. Die Summe aller Zahlen von A (Parameter
  // numberA) bis B (Parameter numberB) soll zurueckgegeben werden.
  // Fuer die Parameter (4,6) ware der korrekte Rueckgabewert
  // 4 + 5 + 6 = 15
  // Hier bietet sich eine geschickte Initialisierungsanweisung der Schleife
  // an.
  public static int sumFromAtoB(int numberA, int numberB) {
    int sum = 0;
    // Hier kommt ihre Schleife hin
    if (numberA == 0 || numberB == 0 || numberA < 0 || numberB < 0) {
      return sum;
    } else {
      for (int i = numberA; i <= numberB; i++) {
        sum += i;
      }

      return sum;
    }
  }

  // Diese Methode soll wieder die Zahlen von 1 bis N (Parameter number)
  // addieren und das Ergebnis zurueckgeben. Sollte das Ergebnis groesser als
  // das Limit sein, soll die letzte Zahl in der Reihe der Summen zurueck-
  // gegeben werden, die nicht ueber dem Limit liegt.
  // Fuer die Parameter (5, 9) beispielsweise soll die Ausgabe 6 sein, denn:
  // 1 = 1 , limit nicht ueberschritten
  // 1 + 2 = 3 , limit nicht ueberschritten
  // 1 + 2 + 3 = 6, limit nicht ueberschritten
  // 1 + 2 + 3 + 4 = 10, limit ist ueberschritten, also soll der vorherige
  // Wert 6 die Rueckgabe sein.
  // Hier hilft eine gut gewaehlte Abbruchbedingung.
  public static int sumUpToNWithMax(int number, int limit) {
    int sum = 0;

    for (int i = 1; i <= number; i++) {
      if (sum + i < limit) {
        sum += i;
      }
    }

    return sum;
  }

  // Diese Methode soll Potenzen ganzer Zahlen bilden. Als Parameter werden
  // Basis und der Exponent uebergeben. Fuer die Parameter (2,5) waere also
  // 32 die erwartete Rueckgabe.
  // Fuer die Parameter (x, 0) ware 1 die korrekte Rueckgabe.
  public static int power(int base, int exponent) {
    // Hier kommt ihr Code hin
    if (exponent == 0) {
      return 1;
    } else {
      int prod = 1;
      for (int i = 1; i <= exponent; i++) {
        prod *= base;
      }

      return prod;
    }
  }

  public static void main(String[] args) {
    // Testen Sie hier Ihre Methoden
    System.out.println("Rueckgabe des Aufrufs sumUpToN(4): " + sumUpToN(4));
    System.out.println("Erwartete Rueckgabe              : 10");
    System.out.println("");

    System.out.println(
        "Rueckgabe des Aufrufs sumOfEvenNumbersUpToN(7): " + sumOfEvenNumbersUpToN(7));
    System.out.println("Erwartete Rueckgabe                          : 12");
    System.out.println("");

    System.out.println("Rueckgabe des Aufrufs sumFromAtoB(4, 6): " + sumFromAtoB(4, 6));
    System.out.println("Erwartete Rueckgabe                    : 15");
    System.out.println("");

    System.out.println("Rueckgabe des Aufrufs sumUpToNWithMax(5, 9): " + sumUpToNWithMax(5, 9));
    System.out.println("Erwartete Rueckgabe                        : 6");
    System.out.println("");

    System.out.println("Rueckgabe des Aufrufs power(2, 5): " + power(2, 5));
    System.out.println("Erwartete Rueckgabe              : 32");
  }
}
