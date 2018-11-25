/*
 * Created by: Institut fuer Informatik und Wirtschaftsinformatik, Universitaet Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.uebungen.basics;

// Begruessung
//
// Die Methode greeting soll eine Begruessung abhaengig vom als Parameter
// uebergebenen Namen zurueckgeben. Vervollstaendigen Sie die Methode
// greeting so, dass sie folgenden Aufrufbeispielen genuegt:
//
// greeting("Anton") --> "Hallo, Anton!"
// greeting("Barbara") --> "Hallo, Barbara!"
// greeting("Christoph") --> "Hallo, Christoph!"
//
// Hinweis: Wenn Sie das Programm ausfuehren, kuennen Sie einen Namen eingeben und so Ihre Implementierung testen.

import java.util.Scanner;

public class Greeting {

  // ----- diese Methode veraendern -----
  public static String greeting(String name) {
    //String greeting = name;
    //return greeting;

    return name;
  }

  private static String getName() {
    System.out.print("Name: ");

    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    scanner.close();

    return name;
  }

  public static void main(String[] args) {
    String name = getName();
    System.out.println(greeting(name));
  }
}
