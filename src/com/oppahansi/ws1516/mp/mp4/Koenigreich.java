/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp4;

import java.util.ArrayList;

public class Koenigreich {

  private Person spitze;

  //Aufgabe 1
  public Koenigreich(String koenig) {
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

    for (Person anArray : array) {
      k.geburt(anArray);
    }

    Person[] array2 = k.volkszaehlung();

    for (Person anArray25 : array2) {
      anArray25.vorstellen();
    }

    System.out.println("\nEs wird exekutiert:\n");

    k.exekution("Antonia");

    array2 = k.volkszaehlung();

    for (Person anArray24 : array2) {
      anArray24.vorstellen();
    }

    System.out.println("\nNun startet die Suche1:\n");

    array2 = k.suche("Sigfried", null);

    for (Person anArray23 : array2) {
      anArray23.vorstellen();
    }

    System.out.println("\nNun startet die Suche2:\n");

    array2 = k.suche(null, Rang.BUERGER);

    for (Person anArray22 : array2) {
      anArray22.vorstellen();
    }

    System.out.println("\nNun startet die Suche3:\n");

    array2 = k.suche("Klee", Rang.ARBEITER);

    for (Person anArray21 : array2) {
      anArray21.vorstellen();
    }

    System.out.println("\nNun folgt die Revolution:\n");

    k.revolution(array[9]);
    array2 = k.volkszaehlung();

    for (Person anArray2 : array2) {
      anArray2.vorstellen();
    }
  }

  //Aufgabe 2
  public void geburt(Person person) {
    if (person != null) {
      if (person.getIstMaennlich()) {
        if (spitze.getLinks() == null) {
          spitze.setLinks(person);
        } else {
          fuegePersonEin(spitze, spitze.getLinks(), person);
        }
      } else {
        if (spitze.getRechts() == null) {
          spitze.setRechts(person);
        } else {
          fuegePersonEin(spitze, spitze.getRechts(), person);
        }
      }
    }
  }

  private void fuegePersonEin(final Person prev, final Person spitze, final Person person) {
    if (spitze.getRang().ordinal() < person.getRang().ordinal()) {
      prev.setLinks(person);
      person.setLinks(spitze);
    } else if (spitze.getRang().ordinal() > person.getRang().ordinal()) {
      if (spitze.getLinks() == null) {
        spitze.setLinks(person);
      } else {
        fuegePersonEin(spitze, spitze.getLinks(), person);
      }
    } else if (spitze.getRang().ordinal() == person.getRang().ordinal()) {
      if (spitze.getRechts() == null) {
        spitze.setRechts(person);
      } else {
        fuegePersonEin(spitze, spitze.getRechts(), person);
      }
    }
  }

  //Aufgabe 3
  public Person[] volkszaehlung() {
    Person[] volk = new Person[getPersonenAnzahl(spitze)];
    ArrayList<Person> volkList = new ArrayList<>();
    volkEinreihen(spitze, volkList);

    return sortiereVolk(volkList.toArray(volk));
  }

  private int getPersonenAnzahl(Person spitze) {
    int links = (spitze.getLinks() != null) ? getPersonenAnzahl(spitze.getLinks()) : 0;
    int rechts = (spitze.getRechts() != null) ? getPersonenAnzahl(spitze.getRechts()) : 0;
    return 1 + links + rechts;
  }

  private void volkEinreihen(Person spitze, ArrayList<Person> list) {
    if (spitze != null) {
      list.add(spitze);
      volkEinreihen(spitze.getLinks(), list);
      volkEinreihen(spitze.getRechts(), list);
    } else {
      list.sort(
          (person1, person2) ->
              Integer.compare(person2.getRang().ordinal(), person1.getRang().ordinal()));
    }
  }

  private Person[] sortiereVolk(Person[] volk) {
    Person[] sortedVolk = new Person[volk.length];
    int i = 0;

    for (Person currentPerson : volk) {
      if (currentPerson.getIstMaennlich()) {
        sortedVolk[i] = currentPerson;
        i++;
      }
    }
    for (Person currentPerson : volk) {
      if (!currentPerson.getIstMaennlich()) {
        sortedVolk[i] = currentPerson;
        i++;
      }
    }

    return sortedVolk;
  }

  //Aufgabe 4
  public Person[] suche(String name, Rang rang) {
    if (name == null && rang == null) {
      return null;
    } else {
      return getGesuchtenArray(volkszaehlung(), name, rang);
    }
  }

  private Person[] getGesuchtenArray(Person[] volk, String name, Rang rang) {
    ArrayList<Person> list = new ArrayList<>();
    Person[] ergebnis = new Person[0];

    if (name == null) {
      for (Person currentPerson : volk) {
        if (currentPerson.getRang() == rang) {
          list.add(currentPerson);
        }
      }

      return list.toArray(ergebnis);
    } else if (rang == null) {
      for (Person currentPerson : volk) {
        if (currentPerson.getName().compareTo(name) == 0) {
          list.add(currentPerson);
        }
      }

      return list.toArray(ergebnis);
    } else {
      for (Person currentPerson : volk) {
        if (currentPerson.getName().compareTo(name) == 0 && currentPerson.getRang() == rang) {
          list.add(currentPerson);
        }
      }
      return list.toArray(ergebnis);
    }
  }

  //Aufgabe 5
  public void exekution(String name) {
    if (name != null && spitze != null) {
      Person[] volk = volkszaehlung();
      toetePerson(volk, name);
    }
  }

  private void toetePerson(Person[] volk, String name) {
    for (int i = 1; i < volk.length; i++) {
      if (volk[i].getName().compareTo(name) == 0) {
        Person vorgaenger = getVorgaenger(volk, volk[i]);

        if (vorgaenger.getRechts().equals(volk[i])) {
          if (volk[i].getLinks() != null && volk[i].getRechts() == null) {
            vorgaenger.setRechts(volk[i].getLinks());
          } else if (volk[i].getLinks() == null && volk[i].getRechts() != null) {
            vorgaenger.setRechts(volk[i].getRechts());
          } else if (volk[i].getLinks() != null && volk[i].getRechts() != null) {
            vorgaenger.setRechts(volk[i].getRechts());
            vorgaenger.getRechts().setLinks(volk[i].getLinks());
          } else if (volk[i].getLinks() == null && volk[i].getRechts() == null) {
            vorgaenger.setRechts(null);
          }
        } else if (vorgaenger.getLinks().equals(volk[i])) {
          if (volk[i].getLinks() != null && volk[i].getRechts() == null) {
            vorgaenger.setLinks(volk[i].getLinks());
          } else if (volk[i].getLinks() == null && volk[i].getRechts() != null) {
            vorgaenger.setLinks(volk[i].getRechts());
          } else if (volk[i].getLinks() != null && volk[i].getRechts() != null) {
            vorgaenger.setLinks(volk[i].getRechts());
            vorgaenger.getLinks().setLinks(volk[i].getLinks());
          } else if (volk[i].getLinks() == null && volk[i].getRechts() == null) {
            vorgaenger.setLinks(null);
          }
        }

        break;
      }
    }
  }

  private Person getVorgaenger(Person[] volk, Person geloescht) {
    for (Person currentPerson : volk) {
      if (currentPerson.getLinks() != null && currentPerson.getLinks().equals(geloescht)
          || currentPerson.getRechts() != null && currentPerson.getRechts().equals(geloescht)) {
        return currentPerson;
      }
    }

    return geloescht;
  }

  //Aufgabe 6
  public void revolution(Person person) {
    if (person != null) {
      Person[] volk = volkszaehlung();
      toetePerson(volk, person.getName());
      loeschNachbarn(volk);
      spitze = person;

      for (int i = 1; i < volk.length; i++) {
        if (volk[i] != null) {
          revolutionsGeburt(volk[i]);
        }
      }
    }
  }

  private void loeschNachbarn(Person[] volk) {
    for (Person currentPerson : volk) {
      if (currentPerson != null) {
        currentPerson.setLinks(null);
        currentPerson.setRechts(null);
      }
    }
  }

  private void revolutionsGeburt(Person person) {
    if (person != null) {
      if (person.getIstMaennlich()) {
        if (spitze.getLinks() == null) {
          spitze.setLinks(person);
        } else {
          revolutionsEinfuegen(spitze, spitze.getLinks(), person);
        }
      } else {
        if (spitze.getRechts() == null) {
          spitze.setRechts(person);
        } else {
          revolutionsEinfuegen(spitze, spitze.getRechts(), person);
        }
      }
    }
  }

  private void revolutionsEinfuegen(Person prev, Person spitze, Person person) {
    if (spitze.getRang().ordinal() > person.getRang().ordinal()) {
      prev.setLinks(person);
      person.setLinks(spitze);
    } else if (spitze.getRang().ordinal() < person.getRang().ordinal()) {
      if (spitze.getLinks() == null) {
        spitze.setLinks(person);
      } else {
        revolutionsEinfuegen(spitze, spitze.getLinks(), person);
      }
    } else if (spitze.getRang().ordinal() == person.getRang().ordinal()) {
      if (spitze.getRechts() == null) {
        spitze.setRechts(person);
      } else {
        revolutionsEinfuegen(spitze, spitze.getRechts(), person);
      }
    }
  }
}
