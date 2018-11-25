package com.oppahansi.ss14.miniprojekt5;

public class Miniprojekt5 {

  public static void main(String[] args) {
    final Person[] persons =
        new Person[] {
          new Student("Paul", "Schmidt", 1963),
          new Student("Petra", "Meier", 1987),
          new Doctor("Humpty", "Dumpty", 1976),
          new Doctor("Alfons", "Beppo", 1966),
          new Student("Jeanette", "Kaufmann", 1990)
        };

    PersonPrinter printer = new BulletPersonPrinter();
    printer.printNames(persons);

    System.out.println("----------");

    printer = new HtmlPersonPrinter();
    printer.printNames(persons);
  }
}
