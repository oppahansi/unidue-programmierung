/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 */
package com.oppahansi.ws1415.uebungsblatt10;

class Person {

  String Name;
  String Vorname;
  String Adresse;
  int Alter;

  public static void main(String args[]) {
    Person[] personen = new Person[6];
    personen[0] = new Arzt("Muster", "Hans", "Duesseldorf", 37, "Chirurgie", 308);
    personen[1] = new Arzt("Meier", "Michael", "Muenchen", 34, "Kardiologie", 534);
    personen[2] = new Patient("Schulze", "Markus", "Hamburg", 31, "Beinbruch", 803);
    personen[3] = new Patient("Wagner", "Egon", "Dresden", 38, "Reisekrankheit", 23);
    personen[4] = new Arzt("Mueller", "Alexander", "Essen", 35, "HNO", 409);
    personen[5] = new Patient("Mertens", "Oliver", "Kassel", 40, "Heuschnupfen", 129);
    for (int i = 0; i < personen.length; i++) {
      personen[i].print();
    }
  }

  void print() {
    System.out.println("Name: " + Name);
    System.out.println("Vorname: " + Vorname);
    System.out.println("Adresse: " + Adresse);
    System.out.println("Alter: " + Alter);
  }
}

class Arzt extends Person {

  String Fachgebiet;
  int Bueronummer;

  Arzt(String n, String v, String a, int c, String f, int b) {
    Name = n;
    Vorname = v;
    Adresse = a;
    Alter = c;
    Fachgebiet = f;
    Bueronummer = b;
  }

  void print() {
    super.print();
    System.out.println("Fachgebiet: " + Fachgebiet);
    System.out.println("Bueronummer: " + Bueronummer);
    System.out.println();
  }
}

class Patient extends Person {

  String Diagnose;
  int Zimmernummer;

  Patient(String n, String v, String a, int c, String d, int z) {
    Name = n;
    Vorname = v;
    Adresse = a;
    Alter = c;
    Diagnose = d;
    Zimmernummer = z;
  }

  void print() {
    super.print();
    System.out.println("Diagnose: " + Diagnose);
    System.out.println("Zimmernummer: " + Zimmernummer);
    System.out.println();
  }
}

/*
Beim Ausgeben sind keine Typecasts notwendig. Die print() Methoden der
Unterklassen �berschreiben die print() Methode der Oberklasse Person. In
der main Methode wird also die print Methode aufgerufen, die zum Typ der
Objekte geh�rt (also der Unterklassen Arzt bzw. Patient), nicht aber die
Methode die zum Typ der Variable geh�rt (Person).
Anmerkung: Die �berschriebenen Methoden der Oberklasse k�nnen jedoch
aus den Methoden der Unterklassen heraus mittels super aufgerufen werden.
*/
