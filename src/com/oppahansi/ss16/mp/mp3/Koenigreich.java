/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss16.mp.mp3;

public class Koenigreich {

  Person spitze;

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

    for (int i = 0; i < array2.length; i++) {
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
    if (spitze != null && person.getRang().ordinal() != Rang.KOENIG.ordinal()) {
      if (person.getIstMaennlich()) {
        if (spitze.getLinks() == null) {
          spitze.setLinks(person);
        } else {
          insertPerson(spitze, spitze.getLinks(), person);
        }
      } else {
        if (spitze.getRechts() == null) {
          spitze.setRechts(person);
        } else {
          insertPerson(spitze, spitze.getRechts(), person);
        }
      }
    }
  }

  private void insertPerson(Person previous, Person root, Person person) {
    if (root.getRang().ordinal() < person.getRang().ordinal()) {
      if (previous.getLinks().equals(root)) {
        previous.setLinks(person);
        person.setLinks(root);
      } else {
        previous.setRechts(person);
        person.setLinks(root);
      }
    } else if (root.getRang().ordinal() == person.getRang().ordinal()) {
      if (root.getRechts() == null) {
        root.setRechts(person);
      } else {
        insertPerson(root, root.getRechts(), person);
      }
    } else if (root.getRang().ordinal() > person.getRang().ordinal()) {
      if (root.getLinks() == null) {
        root.setLinks(person);
      } else {
        insertPerson(root, root.getLinks(), person);
      }
    }
  }

  //Aufgabe 3
  public Person[] volkszaehlung() {
    Person[] root = {spitze};
    Person[] left = divide(spitze.getLinks());
    Person[] right = divide(spitze.getRechts());

    return merge(merge(root, left), right);
  }

  private Person[] divide(Person root) {
    if (root == null) {
      return new Person[0];
    } else {
      Person[] here = {root};
      Person[] right = divide(root.getRechts());
      Person[] left = divide(root.getLinks());

      here = merge(here, right);
      here = merge(here, left);

      return here;
    }
  }

  private Person[] merge(Person[] x, Person[] y) {
    Person[] merge = new Person[x.length + y.length];

    System.arraycopy(x, 0, merge, 0, x.length);
    System.arraycopy(y, 0, merge, x.length, y.length);

    return merge;
  }

  //Aufgabe 4
  public Person[] suche(String name, Rang rang) {
    if (name == null && rang == null) {
      return null;
    } else if (name != null && rang == null) {
      Person[] people = volkszaehlung();
      Person[] result = new Person[0];

      for (Person currentPerson : people) {
        if (currentPerson.getName().contentEquals(name)) {
          result = merge(result, new Person[] {currentPerson});
        }
      }
      return result;
    } else if (name == null) {
      Person[] people = volkszaehlung();
      Person[] result = new Person[0];

      for (Person currentPerson : people) {
        if (currentPerson.getRang().ordinal() == rang.ordinal()) {
          result = merge(result, new Person[] {currentPerson});
        }
      }
      return result;
    } else {
      Person[] people = volkszaehlung();
      Person[] result = new Person[0];

      for (Person currentPerson : people) {
        if (currentPerson.getName().contentEquals(name)
            && currentPerson.getRang().ordinal() == rang.ordinal()) {
          result = merge(result, new Person[] {currentPerson});
        }
      }
      return result;
    }
  }

  //Aufgabe 5
  public void exekution(String name) {
    if (!spitze.getName().contentEquals(name)) {
      spitze.setLinks(execute(spitze.getLinks(), name));
      spitze.setRechts(execute(spitze.getRechts(), name));
    }
  }

  private Person execute(Person root, String name) {
    if (root != null) {
      if (root.getName().compareTo(name) == 0) {
        if (root.getRechts() == null) {
          return execute(root.getLinks(), name);
        } else {
          root.getRechts().setLinks(root.getLinks());
          return execute(root, name);
        }
      } else {
        root.setLinks(execute(root.getLinks(), name));
        root.setRechts(execute(root.getRechts(), name));
        return root;
      }
    } else {
      return null;
    }
  }

  //Aufgabe 6
  public void revolution(Person person) {
    Person[] people = volkszaehlung();

    for (Person currentPerson : people) {
      if (currentPerson != null) {
        currentPerson.setLinks(null);
        currentPerson.setRechts(null);
      }
    }

    people[0] = null;

    for (int i = 0; i < people.length; i++) {
      if (people[i] != null && people[i].getName().contentEquals(person.getName())) {
        people[i] = null;
      }
    }

    spitze = person;

    for (int i = 0; i < people.length; i++) {
      if (people[i] != null) {
        revolutionGeburt(people[i]);
      }
    }
  }

  public void revolutionGeburt(Person person) {
    if (spitze != null && person.getRang().ordinal() != Rang.KOENIG.ordinal()) {
      if (person.getIstMaennlich()) {
        if (spitze.getLinks() == null) {
          spitze.setLinks(person);
        } else {
          revolutionInsertPerson(spitze, spitze.getLinks(), person);
        }
      } else {
        if (spitze.getRechts() == null) {
          spitze.setRechts(person);
        } else {
          revolutionInsertPerson(spitze, spitze.getRechts(), person);
        }
      }
    }
  }

  private void revolutionInsertPerson(Person previous, Person root, Person person) {
    if (root.getRang().ordinal() > person.getRang().ordinal()) {
      if (previous.getLinks().equals(root)) {
        previous.setLinks(person);
        person.setLinks(root);
      } else {
        previous.setRechts(person);
        person.setLinks(root);
      }
    } else if (root.getRang().ordinal() == person.getRang().ordinal()) {
      if (root.getRechts() == null) {
        root.setRechts(person);
      } else {
        insertPerson(root, root.getRechts(), person);
      }
    } else if (root.getRang().ordinal() < person.getRang().ordinal()) {
      if (root.getLinks() == null) {
        root.setLinks(person);
      } else {
        insertPerson(root, root.getLinks(), person);
      }
    }
  }
}
