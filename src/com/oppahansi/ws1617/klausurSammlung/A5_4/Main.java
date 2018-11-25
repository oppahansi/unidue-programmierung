/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_4;

public class Main {
  public static void main(String[] args) {

    Person Oma = new Person("Oma", null, null);
    Person Silke = new Person("Silke", null, Oma);
    Person Sven = new Person("Sven", null, null);
    Person Tina = new Person("Tina", Silke, Sven);
    Person Theo = new Person("Theo", Silke, Sven);
    new Person("Halbschwester", Sven, null);

    System.out.println(Theo.Name + " " + Theo.Vater.Name + " " + Theo.Mutter.Name);
    System.out.println(Silke.Name + " " + Silke.Kinder[0].Name);
    System.out.println(Tina.Name + " " + Tina.Kinder);

    Person[] o = Theo.Oma(Theo);
    System.out.println(o + " " + o[0].Name + " " + o[1]);
    System.out.println(Theo.Anzahl(Theo));
  }
}
