/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 */
package com.oppahansi.ws1718.mp.mp3;

public class Koenigreich {

    Person spitze;

    //Aufgabe 1
    public Koenigreich(String koenig) {
        
    }

    //Aufgabe 2
    public void geburt(Person person) {
        
    }

    //Aufgabe 3
    public Person[] volkszaehlung() {
        //Bitte hier Code einfuegen.
        return null;
    }

    //Aufgabe 4
    public Person[] suche(String name, Rang rang) {
        //Bitte hier Code einfuegen.
        return null;
    }

    //Aufgabe 5
    public void exekution(String name) {
        //Bitte hier Code einfuegen.
    }

    //Aufgabe 6
    public void revolution(Person person) {
        //Bitte hier Code einfuegen.
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
}
