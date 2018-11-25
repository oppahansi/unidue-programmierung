/*
 * Created by: Diaoliu https://github.com/Diaoliu/Rekursive-Datenstrukturen
 *
 * <p>For learning purpose only.
 *
 * <p>Modified by oppahansi (refactored the code) No code changes has been made.
 */
package com.oppahansi.ws1415.klausuraufgaben.klass;

class Person {

  String Name; // Name der Person.
  Person Vater, Mutter; // Verweise auf Person-Objekte, die Eltern darstellen.
  Person[] Kinder; // Verweise auf Person-Objekte, die Kinder darstellen.

  Person(String Name, Person Vater, Person Mutter) {
    this.Name = Name;
    this.Vater = Vater;
    this.Mutter = Mutter;
    if (Vater != null) {
      Vater.trage_Kind_ein(this);
    }
    if (Mutter != null) {
      Mutter.trage_Kind_ein(this);
    }
  }

  public static void main(String[] args) {
    Person Silke = new Person("Silke", null, null);
    Person Sven = new Person("Sven", null, null);
    Person Tina = new Person("Tina", Silke, Sven);
    Person Theo = new Person("Theo", Silke, Sven);
  }

  void trage_Kind_ein(Person Kind) {
    Person[] k = this.Kinder;
    if (k == null) {
      Kinder = new Person[1];
      Kinder[0] = Kind;
    } else {
      Kinder = new Person[k.length + 1];
      for (int i = 0; i < Kinder.length - 1; i++) {
        Kinder[i] = k[i];
        Kinder[Kinder.length - 1] = Kind;
      }
    }
  }
}
