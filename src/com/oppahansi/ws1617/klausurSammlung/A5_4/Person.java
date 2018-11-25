/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_4;

public class Person {
  String Name;
  Person Vater, Mutter;
  Person[] Kinder;

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

  //AUFGABE 5.4 a
  void trage_Kind_ein(Person Kind) {
    Person[] k = this.Kinder;

    if (k == null) {
      Kinder = new Person[1];
    } else {
      Kinder = new Person[k.length + 1];
    }
    for (int i = 0; i < Kinder.length - 1; i++) {
      Kinder[i] = k[i];
    }
    Kinder[Kinder.length - 1] = Kind;
  }

  //AUFGABE 5.4 c
  Person[] Oma(Person p) {
    Person[] aus = new Person[2];
    if (p.Vater.Mutter != null) {
      aus[0] = p.Vater.Mutter;
    }
    if (p.Mutter.Mutter != null) {
      aus[1] = p.Mutter.Mutter;
    }
    return aus;
  }

  //AUFGABE 5.4 d
  int Anzahl(Person p) {
    Person[] v = p.Vater.Kinder;
    Person[] m = p.Mutter.Kinder;
    int aus = 0;

    for (int i = 0; i < v.length; i++) {
      boolean x = true;
      for (int j = 0; j < m.length; j++) {
        if (v[i].equals(m[j])) {
          x = false;
        }
      }
      if (x) {
        aus++;
      }
    }

    return aus + m.length - (v.length - aus);
  }
}
