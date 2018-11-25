package com.oppahansi.ss14.eigeneaufgaben;

/*
 * Lustiges Zahlenraten
 * ---------------------
 * Erraten Sie die Zufahlszahl in moeglichst wenigen Schritten!
 * Die Zahl kann zwischen 1 und 100 liegen
 *
 * Bitte eine Zahl eingeben:                                            // hier wird auf die Usereingabe gewartet
 * 50                                                                                           // hier hat der User die 50 eingegeben
 *
 * Die gesuchte Zahl ist kleiner!                                       // Feedback, ob die gesuchte Zahl kleiner oder groesser ist
 *
 * Bitte eine Zahl eingeben:                                            // N�chster Versuch etc...
 * 25
 *
 * Die gesuchte Zahl ist groesser!
 *
 * Bitte eine Zahl eingeben:
 *
 * ...
 * ...
 *
 * 41
 *
 * Sie haben die gesuchte Zahl gefunden!                        // Gesuchte Zahl gefunden
 * Sie haben die 41 in 7 Versuchen gefunden.            // Gesuchte Zahl ausgeben und die Anzahl an Versuchen anzeigen
 *
 * (Weiter spielen? (j = Ja. | n = Nein.)                       // (Optional: Implementierung der Abfrage f�r ein Neues Spiel))
 *
 *
 * ---------------------------------------------------------------------------------------------------------------
 *
 * Eine Zufallszahl erstellt man mit:
 *
 * Random zufall = new Random();
 * zufallZahl = 0 + zufall.nextInt(100 - 0 + 1);        // 0 ist die Untergrenze , 100 ist die Obergrenze
 * man kann es auch so schreiben:
 * zufallsZahl = untergrenze + zufall.nextInt(obergrenze - untergrenze + korrektur);
 *
 * Usereingaben entgegen nehmen mit:
 *
 * Scanner s = new Scanner(System.in);
 *
 * s.nextInt(); // int einlesen
 * s.next();            // String einlesen
 *
 * Letzter Tipp:
 * while-Schleifen benutzen :)
 *
 */

public class ZahlenRatenUngeloest {

  /*
   * Hier das Minispiel implementieren.
   */
  public static void main(String[] args) {}
}
