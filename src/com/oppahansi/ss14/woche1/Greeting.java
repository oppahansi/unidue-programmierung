package com.oppahansi.ss14.woche1;

// Begr��ung
//
// Die Methode greeting soll eine Begr��ung abh�ngig vom als Parameter
// �bergebenen Namen zur�ckgeben. Vervollst�ndigen Sie die Methode
// greeting so, dass sie folgenden Aufrufbeispielen gen�gt:
//
// greeting("Anton") --> "Hallo, Anton!"
// greeting("Barbara") --> "Hallo, Barbara!"
// greeting("Christoph") --> "Hallo, Christoph!"
//
// Hinweis: Wenn Sie das Programm ausf�hren, k�nnen Sie einen Namen eingeben und so Ihre Implementierung testen.

import java.util.Scanner;

public class Greeting {

  // ----- diese Methode ver�ndern -----
  public static String greeting(String name) {
    return "Hallo, " + name + "!";
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
