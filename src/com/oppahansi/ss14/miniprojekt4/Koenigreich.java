package com.oppahansi.ss14.miniprojekt4;

public class Koenigreich {

  Person spitze;

  //Aufgabe 1
  public Koenigreich(String koenig) {
    //Bitte hier Code einfuegen.
    this.spitze = new Person(koenig, Rang.KOENIG, null, null, true);
  }

  public static void main(String[] args) {
    Koenigreich k = new Koenigreich("Arthur");
    Person array[] = new Person[15];

    array[0] = new Person("Andi", Rang.BUERGER, null, null, true);
    array[1] = new Person("Gabrielle", Rang.FUERST, null, null, false);
    array[2] = new Person("Sigfried", Rang.FUERST, null, null, true);
    array[3] = new Person("Anton", Rang.FUERST, null, null, true);
    array[4] = new Person("Sigfried", Rang.BUERGER, null, null, true);
    array[5] = new Person("Fiona", Rang.FUERST, null, null, false);
    array[6] = new Person("Richard", Rang.FUERST, null, null, true);
    array[7] = new Person("Antonia", Rang.FUERST, null, null, false);
    array[8] = new Person("Peter", Rang.BUERGER, null, null, true);
    array[9] = new Person("Klee", Rang.ARBEITER, null, null, true);
    array[10] = new Person("Susi", Rang.ARBEITER, null, null, false);
    array[11] = new Person("Nelli", Rang.ARBEITER, null, null, false);
    array[12] = new Person("Sigi", Rang.ARBEITER, null, null, true);
    array[13] = new Person("Pia", Rang.ARBEITER, null, null, false);
    array[14] = new Person("Susanne", Rang.BUERGER, null, null, false);

    for (int i = 0; i < array.length; i++) {
      k.geburt(array[i]);
    }

    Person[] array2 = k.volkszaehlung();

    for (int i = 0; i < array2.length; i++) {
      array2[i].vorstellen();
    }

    System.out.println("\nEs wird exekutiert:\n");

    k.exekution("Antonia");

    array2 = k.volkszaehlung();

    for (int i = 0; i < array2.length; i++) {
      array2[i].vorstellen();
    }

    System.out.println("\nNun startet die Suche1:\n");

    array2 = k.suche("Sigfried", null);
    System.out.println((array2 == null ? true : false));
    for (int i = 0; i < array2.length; i++) {
      System.out.println(i);
      array2[i].vorstellen();
    }

    System.out.println("\nNun startet die Suche2:\n");

    array2 = k.suche(null, Rang.BUERGER);

    for (int i = 0; i < array2.length; i++) {
      array2[i].vorstellen();
    }

    System.out.println("\nNun startet die Suche3:\n");

    array2 = k.suche("Klee", Rang.ARBEITER);

    for (int i = 0; i < array2.length; i++) {
      array2[i].vorstellen();
    }

    System.out.println("\nNun folgt die Revolution:\n");

    k.revolution(array[9]);
    array2 = k.volkszaehlung();

    for (int i = 0; i < array2.length; i++) {
      array2[i].vorstellen();
    }
  }

  //Aufgabe 2
  public void geburt(Person person) {
    //Bitte hier Code einfuegen.
    if (person != null && person.getRang().ordinal() != spitze.getRang().ordinal()) {
      if (person.getIstMaennlich()) {
        spitze.setLinks(einfuegen(person, spitze.getLinks()));
      } else {
        spitze.setRechts(einfuegen(person, spitze.getRechts()));
      }
    }
  }

  private Person einfuegen(Person person, Person teilBaum) {
    if (teilBaum == null) {
      return person;
    } else {
      if (person.getRang().ordinal() < teilBaum.getRang().ordinal()) {
        teilBaum.setLinks(einfuegen(person, teilBaum.getLinks()));
        return teilBaum;
      } else {
        if (person.getRang().ordinal() == teilBaum.getRang().ordinal()) {
          teilBaum.setRechts(einfuegen(person, teilBaum.getRechts()));
          return teilBaum;
        } else {
          person.setLinks(teilBaum);
          return person;
        }
      }
    }
  }

  //Aufgabe 3
  public Person[] volkszaehlung() {
    //Bitte hier Code einfuegen.
    Person[] wurzel = {spitze};
    Person[] linkerTeilBaum = zerlegen(spitze.getLinks());
    Person[] rechterTeilBaum = zerlegen(spitze.getRechts());

    return zusammen(zusammen(wurzel, linkerTeilBaum), rechterTeilBaum);
  }

  private Person[] zerlegen(Person teilBaum) {
    if (teilBaum == null) {
      return new Person[0];
    } else {
      Person[] hier = {teilBaum};
      Person[] rechts = zerlegen(teilBaum.getRechts());
      Person[] links = zerlegen(teilBaum.getLinks());
      hier = zusammen(hier, rechts);
      hier = zusammen(hier, links);
      return hier;
    }
  }

  private Person[] zusammen(Person[] a, Person[] b) {
    Person[] zusammen = new Person[a.length + b.length];

    for (int i = 0; i < a.length; i++) {
      zusammen[i] = a[i];
    }

    for (int i = 0; i < b.length; i++) {
      zusammen[a.length + i] = b[i];
    }

    return zusammen;
  }

  //Aufgabe 4
  public Person[] suche(String name, Rang rang) {
    //Bitte hier Code einfuegen.
    Person[] suchArray = this.volkszaehlung();
    Person[] gefunden = new Person[0];

    if (name == null && rang != null) {
      for (int i = 0; i < suchArray.length; i++) {
        if (suchArray[i].getRang().ordinal() == rang.ordinal()) {
          Person[] treffer = {suchArray[i]};
          gefunden = zusammen(gefunden, treffer);
        }
      }
    } else if (rang == null && name != null) {
      for (int i = 0; i < suchArray.length; i++) {
        if (suchArray[i].getName().compareTo(name) == 0) {
          Person[] treffer = {suchArray[i]};
          gefunden = zusammen(gefunden, treffer);
        }
      }
    } else if (name != null && rang != null) {
      for (int i = 0; i < suchArray.length; i++) {
        if (suchArray[i].getName().compareTo(name) == 0
            && suchArray[i].getRang().ordinal() == rang.ordinal()) {
          Person[] treffer = {suchArray[i]};
          gefunden = zusammen(gefunden, treffer);
        }
      }
    }
    return gefunden.length > 0 ? gefunden : null;
  }

  //Aufgabe 5
  public void exekution(String name) {
    //Bitte hier Code einfuegen.
    if (name.compareTo(spitze.getName()) == 0) {

    } else {
      spitze.setLinks(entfernen(name, spitze.getLinks()));
      spitze.setRechts(entfernen(name, spitze.getRechts()));
    }
  }

  private Person entfernen(String name, Person teilBaum) {
    if (teilBaum != null) {
      if (teilBaum.getName().compareTo(name) == 0) {
        if (teilBaum.getRechts() == null) {
          return entfernen(name, teilBaum.getLinks());
        } else {
          teilBaum.getRechts().setLinks(teilBaum.getLinks());
          return entfernen(name, teilBaum);
        }
      } else {
        teilBaum.setLinks(entfernen(name, teilBaum.getLinks()));
        teilBaum.setRechts(entfernen(name, teilBaum.getRechts()));
        return teilBaum;
      }
    } else {
      return null;
    }
  }

  //Aufgabe 6
  public void revolution(Person person) {
    //Bitte hier Code einfuegen.
    if (person != null) {
      entfernen(person, spitze);

      Person[] volk = this.volkszaehlung();

      for (int i = 0; i < volk.length; i++) {
        volk[i].setLinks(null);
        volk[i].setRechts(null);
      }

      this.spitze = person;

      person.setLinks(null);
      person.setRechts(null);

      for (int i = 0; i < volk.length; i++) {
        if (volk[i].getIstMaennlich()) {
          spitze.setLinks(einfuegenNeu(volk[i], spitze.getLinks()));
        } else {
          spitze.setRechts(einfuegenNeu(volk[i], spitze.getRechts()));
        }
      }
    }
  }

  private Person einfuegenNeu(Person person, Person teilBaum) {
    if (teilBaum == null) {
      return person;
    } else {
      if (person.getRang().ordinal() > teilBaum.getRang().ordinal()) {
        teilBaum.setLinks(einfuegen(person, teilBaum.getLinks()));
        return teilBaum;
      } else {
        if (person.getRang().ordinal() == teilBaum.getRang().ordinal()) {
          teilBaum.setRechts(einfuegen(person, teilBaum.getRechts()));
          return teilBaum;
        } else {
          person.setLinks(teilBaum);
          return person;
        }
      }
    }
  }

  private Person entfernen(Person person, Person teilBaum) {
    if (teilBaum != null) {
      if (teilBaum == person) {
        if (teilBaum.getRechts() == null) {
          return entfernen(person, teilBaum.getLinks());
        } else {
          teilBaum.getRechts().setLinks(teilBaum.getLinks());
          return entfernen(person, teilBaum.getRechts());
        }
      } else {
        teilBaum.setLinks(entfernen(person, teilBaum.getLinks()));
        teilBaum.setRechts(entfernen(person, teilBaum.getRechts()));
        return teilBaum;
      }
    } else {
      return null;
    }
  }
}
