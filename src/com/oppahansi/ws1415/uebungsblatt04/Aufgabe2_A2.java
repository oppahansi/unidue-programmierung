/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by oppahansi.
 *
 * <p>Alternative 2
 *
 * <p>Main-Methode/printList-Methode created by oppahansi.
 */
package com.oppahansi.ws1415.uebungsblatt04;

public class Aufgabe2_A2 {

  public static void main(String[] args) {
    Liste_A2 list = new Liste_A2();
    System.out.println("Liste ohne Inhalt: ");
    printList(list);
    System.out.println("Neue Liste erstellen und mit 5 Elementen füllen.");
    list.einfuegen(1);
    list.einfuegen(2);
    list.einfuegen(3);
    list.einfuegen(4);
    list.einfuegen(5);
    printList(list);
    System.out.println("Neues Element mit der Zahl 10 an der Stelle 3 hinzufuegen");
    list.hinzufuegen(new Element(10), 3);
    printList(list);
    System.out.println("5. Element entfernen");
    list.entferne(5);
    printList(list);
  }

  private static void printList(Liste_A2 list) {
    System.out.print("--> " + " ");
    Element element = list.Kopf;
    while (element != null) {
      System.out.print(element.Zahl + " ");
      element = element.Nf;
    }
    System.out.println();
  }
}
