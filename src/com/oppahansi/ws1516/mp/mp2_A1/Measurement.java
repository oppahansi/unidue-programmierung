//L�sung erarbeitet: Artur
//Kommentiert: TtheKrysler
//Copyright Miniprojekt: Paluno

package com.oppahansi.ws1516.mp.mp2_A1;

import java.util.Arrays;

public class Measurement {

  private int[] data;

  public Measurement() {
    //Initialisieren des data-Array mit der L�nge "0"

    data = new int[0];
    //hier benutzen wir das data, welches schon in der private Methode deklariert ist 	// Variable, keine Methode.
    //data = neues Array der L�nge [0];
  }

  public static void main(String[] args) {
    Measurement m = new Measurement();
    System.out.println("Neues Measurement-Objekt m erzeugt. m:");
    // ErwarteteAusgabe:
    // []
    m.printData();

    System.out.println("------------------------------------------------------------------");

    m.addValue(85);
    System.out.println("Hinzufügen eines neuen Wertes. m:");
    // Erwartete Ausgabe:
    // [85]
    m.printData();

    System.out.println("------------------------------------------------------------------");

    m.addValues(new int[] {58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93});
    System.out.println("Hinzuzfügen einer Menge von Werten. m:");
    // Erwartete Ausgabe:
    // [85, 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93]
    m.printData();

    System.out.println("------------------------------------------------------------------");

    int minimumValue = m.getMinimumValue();
    System.out.println("Minimaler Wert der Messreihe m:");
    // Erwartete Ausgabe: 58
    System.out.println(minimumValue);

    System.out.println("------------------------------------------------------------------");

    int[] valuesAbove78 = m.getValuesAboveThreshold(78);
    System.out.println("Messwerte über 78:");
    // Erwartete Ausgabe:
    // [85, 93, 81, 79, 81, 93]
    System.out.println(Arrays.toString(valuesAbove78));

    System.out.println("------------------------------------------------------------------");

    int[] valuesAbove93 = m.getValuesAboveThreshold(93);
    System.out.println("Messwerte über 93:");
    // Erwartete Ausgabe:
    // []
    System.out.println(Arrays.toString(valuesAbove93));
  }

  public void addValue(int value) {
    //Wir wollen das vorhandene Data-Array um einen Wert erweitern

    //Ich errichte hier ein Hilfsarray um die Werte aus dem data-Array darin zu speichern
    int[] hilfsarray = new int[data.length];
    //hilfsarray = neues int[mit der L�nge von Data]

    //Jetzt bestimmen wir mit der For-Schleife die tats�chliche L�nge des Arrays
    for (int i = 0; i < data.length; i++) {

      //danach setzen wir die Werte von data ind das hilfsarray ein
      hilfsarray[i] = data[i];

      //damit ist das erstmal zwischengespeichert
    }

    //hier deklarieren wir uns die Hilfsvariable "neueLaenge"  // + initialisieren
    //denn wir wissen, wir sollen einen Wert dem Array hinzuf�gen
    int neueLaenge = data.length + 1;
    //neueLaenge   = die L�nge des Array Data plus 1 mehr (wir wollen ja nur einen Wert einlesen und erweitern)

    //jetzt sagen wir das Array data wird ein neues Array mit der L�nge aus unserer Hilfsvariable
    //"neueLaenge"
    data = new int[neueLaenge];

    for (int j = 0; j < hilfsarray.length; j++) {
      data[j] = hilfsarray[j];
    }
    data[data.length - 1] = value;
  }

  public void addValues(int[] values) {
    //Hier sollen noch mehr Werte dem Array hinzugef�gt werden.
    //Wir wissen das das Array momentan so aussieht: [85]
    //Nun sollen Werte hinzugef�gt werden der Menge "X"
    //Zu beachten ist dabei allerdings, das der erste Wert welcher schon vorhanden ist beibehalten wird

    //Anm: Wir k�nnen unser schon erstelltes Hilfsarray aus der vorherigen Aufgabe nicht mehr verwenden,
    //da dieses nur f�r die Methode der Aufgabe gilt 			// nur in der Methode sichtbar ist

    //Also deklarieren wir das Array nochmal:
    int[] hilfsarray = new int[data.length];
    //           = neues Array [mit der L�nge von Data]
    //						(wir wissen die L�nge ist [1] und der Wert [85];

    //hier wieder die tats�chliche L�nge des hilfsarrays festlegen
    for (int i = 0; i < data.length; i++) {
      //und in [i] gespeichert. Hilfsarray[L�nge data] = data[l�nge data]
      hilfsarray[i] = data[i];
    }

    //jetz wieder eine Hilfsvariable deklarieren welche wir als neueLaenge bezeichnen.
    //diese ergibt sich aus der L�nge von data PLUS der L�nge der Werte "values" welche wir hinzuf�gen wollen
    //Anm: Das is wichtig, damit wir den schon vorhandenen einzelnen Wert nicht l�schen sonder behalten
    int neueLaenge = data.length + values.length;

    //dann data wieder neu initialisieren mit der "neueLaenge"
    data = new int[neueLaenge];

    //L�nge des Hilfsarrays z�hlen
    for (int j = 0; j < hilfsarray.length; j++) {
      //und in [j] speichern.
      data[j] = hilfsarray[j];
    }
    //Jetzt die Werte von "values" z�hlen und in k speichern
    for (int k = 0; k < values.length; k++) {

      data[hilfsarray.length + k] = values[k];
      //hier passiert das wichtigste, data[hilfsarray.length] beinhaltet nur die werte aus dem urspr�nglichen
      //Data Array. Jedoch wird dieses Data array erweitert um die Anzahl der in der Variable k gespeicherten
      //Zahl. Danach werde die Werte aus "values" an das data array hinzugef�gt.
    }
  }

  public int getMinimumValue() {
    //bestimmen des minimalsten Wertes in dem Array

    //Wir erstellen eine Hilfsvariable "hilfe" mit dem Maximalen Integer Wert.
    //Anm: Erkl�rung siehe Vorlesung
    int hilfe = Integer.MAX_VALUE;

    //jetzt die L�nge von data auslesen
    for (int i = 0; i < data.length; i++) {

      //und eine Bedingung schreiben die uns den kleinsten Wert ausgibt
      if (data[i] <= hilfe) {
        //Was macht diese Bedingung:
        //Dadurch das wir hier den niedrigsten Wert suchen, setzen wir die Variable hilfe
        //auf den h�chstm�glichen Wert f�r INTEGER-Zahlen.
        //durch die If-Bedingung sucht das Programm jetzt die kleinste Zahl aus den Werten von data und
        //gibt diese zur�ck

        //diesen Wert in hilfe speichern
        hilfe = data[i];
      }
    }
    //und hier wird dann der Wer zur�ckgegeben
    return hilfe;
  }

  // --------------------------------------------------------------

  public int[] getValuesAboveThreshold(int threshold) {

    int hilfe = 0;

    for (int i = 0; i < data.length; i++) {
      if (data[i] > threshold) {
        hilfe++;
      }
    }

    int[] loesung = new int[hilfe];
    int counter = 0;
    for (int j = 0; j < loesung.length; j++) {
      while (counter < data.length) {
        if (data[counter] > threshold) {
          loesung[j] = data[counter];
          counter++;
          break;
        }
        counter++;
      }
    }
    return loesung;
  }

  public void printData() {
    System.out.println(Arrays.toString(data));
  }
}
