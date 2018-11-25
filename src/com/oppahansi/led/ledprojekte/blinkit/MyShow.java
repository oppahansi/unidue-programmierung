/*
 * Blink It - Demenzbremse
 *
 * <p>Created by: Jan-Hendrick H.
 */
package com.oppahansi.led.ledprojekte.blinkit;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import java.awt.event.KeyEvent;
import java.util.Random;

//Klappt auch ohne KeyEvent?

public class MyShow {

  private static BoardController controller;
  private static KeyBuffer buffer;
  private static int[] moves;
  private static int score;
  private static int number = 0;
  private static Random rand = new Random();
  private static KeyEvent event;
  private static int l = 0;
  private static int r = 0; //red
  private static int g = 0; //green
  private static int b = 0; //blue

  //Mittels dieser Metode lässt sich ein Array vom Typ Integer verlängern
  private static int[] ArrayVerlaengern(int[] array) {
    int[] copy = new int[array.length + 1];
    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }
    return copy;
  }

  //Diese Methode lässt per übergebenen Parameter einen von den 4 Blinker leuchten.
  //Die 1 steht für OBEN, die 2 für LINKS, die 3 für UNTEN und die 4 für RECHTS
  private static void turnOn(int side) {
    switch (side) {
        //Oben
      case 1:
        l = 0;
        r = 100;
        g = 0;
        b = 0;

        for (int i = 3; i < 9; i++) {
          controller.setColor(i, l, r, g, b); //RAND (Außen 6LEDs)
          controller.setColor(i, l + 1, r, g, b); //RAND +1
          controller.setColor(i, l + 2, r, g, b); //RAND +2
        }
        for (int i = 4; i < 8; i++) {
          controller.setColor(i, l + 3, r, g, b); //RAND+3	(nur 4LEDs)
        }
        //RAND +4   (nur 2LEDs)
        controller.setColor(5, l + 4, r, g, b);
        controller.setColor(6, l + 4, r, g, b);
        controller.updateLedStripe();
        break;

        //Links
      case 2:
        l = 0;
        r = 0;
        g = 100;
        b = 0;

        for (int i = 3; i < 9; i++) {
          controller.setColor(l, i, r, g, b); //RAND (Außen 6LEDs)
          controller.setColor(l + 1, i, r, g, b); //RAND +1
          controller.setColor(l + 2, i, r, g, b); //RAND +2
        }
        for (int i = 3; i < 7; i++) {
          controller.setColor(l + 3, i + 1, r, g, b);
          ; //RAND+3	(nur 4LEDs)
        }

        //RAND +4   (nur 2LEDs)
        controller.setColor(l + 4, 5, r, g, b);
        controller.setColor(l + 4, 6, r, g, b);
        controller.updateLedStripe();
        break;

        //Unten
      case 3:
        l = 11;
        r = 0;
        g = 0;
        b = 100;

        for (int i = 3; i < 9; i++) {
          controller.setColor(i, l, r, g, b); //RAND (Außen 6LEDs)
          controller.setColor(i, l - 1, r, g, b); //RAND +1
          controller.setColor(i, l - 2, r, g, b); //RAND +2
        }
        for (int i = 3; i < 7; i++) {
          controller.setColor(i + 1, l - 3, r, g, b); //RAND+3	(nur 4LEDs)
        }

        //RAND +4 (nur 2LEDs)
        controller.setColor(5, l - 4, r, g, b);
        controller.setColor(6, l - 4, r, g, b);
        controller.updateLedStripe();
        break;

        //Rechts
      case 4:
        l = 11;
        r = 100;
        g = 100;
        b = 100;

        for (int i = 3; i < 9; i++) {
          controller.setColor(l, i, r, g, b); //RAND (Außen 6LEDs)
          controller.setColor(l - 1, i, r, g, b); //RAND +1
          controller.setColor(l - 2, i, r, g, b); //RAND +2
        }
        for (int i = 3; i < 7; i++) {
          controller.setColor(l - 3, i + 1, r, g, b); //RAND+3	(nur 4LEDs)
        }

        //RAND +4 (nur 2LEDs)
        controller.setColor(l - 4, 5, r, g, b);
        controller.setColor(l - 4, 6, r, g, b);
        controller.updateLedStripe();
        break;
    }
  }

  //Diese Methode setzt den Bildschirm auf den Standard-Bildschirm zurück, auf dem StandardBildschirm sieht man lediglich die 4 Blinker (nur schwach leuchtend)
  private static void turnOff() {
    controller.setBackgroundColor(10, 10, 10);
    controller.resetColors();
    /* *****************OBEN************************** */
    l = 0;
    r = 30;
    g = 0;
    b = 0;

    for (int i = 3; i < 9; i++) {
      controller.setColor(i, l, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(i, l + 1, r, g, b); //RAND +1
      controller.setColor(i, l + 2, r, g, b); //RAND +2
    }
    for (int i = 4; i < 8; i++) {
      controller.setColor(i, l + 3, r, g, b); //RAND+3	(nur 4LEDs)
    }
    //RAND +4   (nur 2LEDs)
    controller.setColor(5, l + 4, r, g, b);
    controller.setColor(6, l + 4, r, g, b);
    /* *****************LINKS************************** */
    l = 0;
    r = 0;
    g = 30;
    b = 0;

    for (int i = 3; i < 9; i++) {
      controller.setColor(l, i, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(l + 1, i, r, g, b); //RAND +1
      controller.setColor(l + 2, i, r, g, b); //RAND +2
    }
    for (int i = 3; i < 7; i++) {
      controller.setColor(l + 3, i + 1, r, g, b);
      ; //RAND+3	(nur 4LEDs)
    }

    //RAND +4   (nur 2LEDs)
    controller.setColor(l + 4, 5, r, g, b);
    controller.setColor(l + 4, 6, r, g, b);
    /* *****************UNTEN************************** */
    l = 11;
    r = 0;
    g = 0;
    b = 30;

    for (int i = 3; i < 9; i++) {
      controller.setColor(i, l, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(i, l - 1, r, g, b); //RAND +1
      controller.setColor(i, l - 2, r, g, b); //RAND +2
    }
    for (int i = 3; i < 7; i++) {
      controller.setColor(i + 1, l - 3, r, g, b); //RAND+3	(nur 4LEDs)
    }

    //RAND +4 (nur 2LEDs)
    controller.setColor(5, l - 4, r, g, b);
    controller.setColor(6, l - 4, r, g, b);
    /* *****************RECHTS************************** */
    l = 11;
    r = 30;
    g = 30;
    b = 30;

    for (int i = 3; i < 9; i++) {
      controller.setColor(l, i, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(l - 1, i, r, g, b); //RAND +1
      controller.setColor(l - 2, i, r, g, b); //RAND +2
    }
    for (int i = 3; i < 7; i++) {
      controller.setColor(l - 3, i + 1, r, g, b); //RAND+3	(nur 4LEDs)
    }

    //RAND +4 (nur 2LEDs)
    controller.setColor(l - 4, 5, r, g, b);
    controller.setColor(l - 4, 6, r, g, b);
    controller.updateLedStripe();
  }

  //Diese Methode signalisiert dem Spieler, dass er alle Farben korrekt wusste(grün) und das Programm ihm nun die nächste Kombination vorspielt oder dass er verloren hat (rot)
  private static void result(boolean win) {
    l = 0;
    r = 0;
    g = 0;
    b = 0;
    if (win == true) {
      g = 100;
    } else {
      r = 100;
    }
    //OBEN
    controller.sleep(500);
    for (int i = 3; i < 9; i++) {
      controller.setColor(i, l, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(i, l + 1, r, g, b); //RAND +1
      controller.setColor(i, l + 2, r, g, b); //RAND +2
    }
    for (int i = 4; i < 8; i++) {
      controller.setColor(i, l + 3, r, g, b); //RAND+3	(nur 4LEDs)
    }
    //RAND +4   (nur 2LEDs)
    controller.setColor(5, l + 4, r, g, b);
    controller.setColor(6, l + 4, r, g, b);

    //LINKS
    for (int i = 3; i < 9; i++) {
      controller.setColor(l, i, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(l + 1, i, r, g, b); //RAND +1
      controller.setColor(l + 2, i, r, g, b); //RAND +2
    }
    for (int i = 3; i < 7; i++) {
      controller.setColor(l + 3, i + 1, r, g, b);
      ; //RAND+3	(nur 4LEDs)
    }

    //RAND +4   (nur 2LEDs)
    controller.setColor(l + 4, 5, r, g, b);
    controller.setColor(l + 4, 6, r, g, b);

    //UNTEN
    l = 11;
    for (int i = 3; i < 9; i++) {
      controller.setColor(i, l, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(i, l - 1, r, g, b); //RAND +1
      controller.setColor(i, l - 2, r, g, b); //RAND +2
    }
    for (int i = 3; i < 7; i++) {
      controller.setColor(i + 1, l - 3, r, g, b); //RAND+3	(nur 4LEDs)
    }

    //RAND +4 (nur 2LEDs)
    controller.setColor(5, l - 4, r, g, b);
    controller.setColor(6, l - 4, r, g, b);

    //RECHTS
    for (int i = 3; i < 9; i++) {
      controller.setColor(l, i, r, g, b); //RAND (Außen 6LEDs)
      controller.setColor(l - 1, i, r, g, b); //RAND +1
      controller.setColor(l - 2, i, r, g, b); //RAND +2
    }
    for (int i = 3; i < 7; i++) {
      controller.setColor(l - 3, i + 1, r, g, b); //RAND+3	(nur 4LEDs)
    }

    //RAND +4 (nur 2LEDs)
    controller.setColor(l - 4, 5, r, g, b);
    controller.setColor(l - 4, 6, r, g, b);
    controller.updateLedStripe();
    controller.sleep(1200);
    turnOff();
    controller.sleep(800);
  }

  //StartBildschirm (Play,Exit) - Diese Methode zeigt je nachdem, welche Option man genommen hat, Play oder Exit an (Optische Hervorhebung)
  private static void menu(boolean choose) {
    int p = 0;
    int e = 0;
    ;
    if (choose == true) {
      e = 60;
    } else {
      p = 60;
    }

    l = 0;
    r = 0;
    g = 0;
    b = 0;
    //PLAY-ZEICHEN
    //Senkrechte Linien
    for (int i = 0; i < 6; i++) {
      controller.setColor(0, i, 100 - p, g, b); //P
      controller.setColor(3, i, r, 100 - p, b); //L
      controller.setColor(6, i, r, g, 100 - p); //A
      controller.setColor(8, i, r, g, 100 - p); //A
    }
    //Buchstabe P
    controller.setColor(1, 0, 100 - p, g, b);
    controller.setColor(2, 0, 100 - p, g, b);
    controller.setColor(2, 1, 100 - p, g, b);
    controller.setColor(2, 2, 100 - p, g, b);
    controller.setColor(1, 2, 100 - p, g, b);
    //Buchstabe L
    controller.setColor(4, 5, r, 100 - p, b);
    controller.setColor(5, 5, r, 100 - p, b);
    //Buchstabe A
    controller.setColor(7, 0, r, g, 100 - p);
    controller.setColor(7, 3, r, g, 100 - p);
    //Buchstabe Y
    controller.setColor(9, 0, 100 - p, 100 - p, b);
    controller.setColor(9, 1, 100 - p, 100 - p, b);
    controller.setColor(9, 2, 100 - p, 100 - p, b);
    controller.setColor(10, 2, 100 - p, 100 - p, b);
    controller.setColor(10, 3, 100 - p, 100 - p, b);
    controller.setColor(10, 4, 100 - p, 100 - p, b);
    controller.setColor(10, 5, 100 - p, 100 - p, b);
    controller.setColor(11, 0, 100 - p, 100 - p, b);
    controller.setColor(11, 1, 100 - p, 100 - p, b);
    controller.setColor(11, 2, 100 - p, 100 - p, b);

    //EXIT-ZEICHEN
    //Senkrechte Linien
    for (int i = 6; i < 12; i++) {
      controller.setColor(0, i, 100 - e, 100 - e, b); //E
      controller.setColor(7, i, r, 100 - e, b); //I
      controller.setColor(10, i, 100 - e, g, b); //T
    }
    //Buchstabe E
    for (int i = 6; i < 10; i = i + 2) {
      controller.setColor(1, i, 100 - e, 100 - e, b);
      controller.setColor(2, i, 100 - e, 100 - e, b);
    }
    controller.setColor(1, 11, 100 - e, 100 - e, b);
    controller.setColor(2, 11, 100 - e, 100 - e, b);
    //Buchstabe X
    controller.setColor(3, 6, r, g, 100 - e);
    controller.setColor(3, 7, r, g, 100 - e);
    controller.setColor(5, 6, r, g, 100 - e);
    controller.setColor(5, 7, r, g, 100 - e);
    controller.setColor(4, 8, r, g, 100 - e);
    controller.setColor(4, 9, r, g, 100 - e);
    controller.setColor(3, 10, r, g, 100 - e);
    controller.setColor(3, 11, r, g, 100 - e);
    controller.setColor(5, 10, r, g, 100 - e);
    controller.setColor(5, 11, r, g, 100 - e);
    //Buchstabe T
    controller.setColor(9, 6, 100 - e, g, b);
    controller.setColor(10, 6, 100 - e, g, b);
    controller.setColor(11, 6, 100 - e, g, b);

    controller.updateLedStripe();
  }

  //Das Startmenü
  private static boolean menu() {
    controller.setBackgroundColor(0, 0, 0); //Der Hintergrund wird zurückgesetzt
    controller.resetColors();
    boolean choose = true; //choose speichert, ob das Feld Play oder Exit angezeigt wird
    menu(true); //Es wird das Feld PLAY angezeigt
    while (true) { //Endlosschleife
      event = buffer.pop(); //
      if (event != null) { //Es wird geprüft, ob eine Eingabe vorliegt
        if (event.getID()
            == KeyEvent.KEY_RELEASED) { //Dann wird geprüft, ob der Eingabetyp ein KEY_RELEASED ist
          buffer
              .clear(); //Der Buffer wird geleert, um Doppelklicks oder Mehrfachklicks zu verhindern
          switch (event
              .getKeyCode()) { //Die Switch Anweisung überprüft nun, ob die richtige Taste gedrückt wurde
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W: //Wenn Pfeil hoch ODER W gedrückt wird
              choose = true; //choose wird true
              menu(true); //Play wird angezeigt ( -Optisch hervorgehoben)
              break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S: //Wenn Pfeil runter oder S gedrückt wird
              choose = false; //Choose wird false
              menu(false); //Exit wird hervorgehoben
              break;
            case KeyEvent.VK_ENTER: //Wenn Enter
              if (choose == true) { //Wenn choose= true (Play ist hervorgehoben)
                return true; //Gib true zurück
              } else { //Wenn choose==false (Exit ist hervorgehoben)
                return false; //Gib false zurück
              }
          }
        }
      }
    }
  }

  //Endlosschleife (Das Hauptprogramm)
  private static void game() {
    moves = new int[0];
    turnOff();
    controller.sleep(1000);
    while (true) {
      //Alle Blinker durchlaufen lassen
      for (int count = 0; count < moves.length; count++) {
        turnOn(moves[count]);
        controller.sleep(800);
        turnOff();
        controller.sleep(800);
      }
      //Neuen Blinker hinzufügen
      number = rand.nextInt(4) + 1;
      turnOn(number);
      controller.sleep(800);
      turnOff();
      controller.sleep(800);

      //Neuen Blinker speichern
      moves = ArrayVerlaengern(moves);
      moves[moves.length - 1] = number;

      //Hier muss noch der Übergang hin

      //Der Buffer wird gelöscht, da erst Eingaben ab jetzt zählen
      buffer.clear();
      //Nun prüfen wir die Eingaben
      for (int count = 0; count < moves.length; count++) {

        //Die Eingabe wird in der Variable "event" gespeichert  und das letzte Ereignis wird entfernt

        event = buffer.pop();

        //Es wird geprüft, ob eine Eingabe vorliegt
        if (event != null) {
          //Dann wird geprüft, ob der Eingabetyp ein KEY_RELEASED ist
          if (event.getID() == KeyEvent.KEY_RELEASED) {
            //Der Buffer wird geleert, um Doppelklicks oder Mehrfachklicks zu verhindern
            buffer.clear();
            //Die Switch Anweisung überprüft nun, ob die richtige Taste gedrückt wurde
            switch (event.getKeyCode()) {
              case KeyEvent.VK_UP:
                if (moves[count] != 1) {
                  result(false);
                  score = moves.length - 1;
                  System.out.println("Sie haben " + score + " Züge erreicht!");
                  return;
                } else {
                  turnOff();
                  turnOn(moves[count]);
                  controller.sleep(600);
                  turnOff();
                }
                break;
              case KeyEvent.VK_LEFT:
                if (moves[count] != 2) {
                  result(false);
                  score = moves.length - 1;
                  System.out.println("Sie haben " + score + " Züge erreicht!");
                  return;
                } else {
                  turnOff();
                  turnOn(moves[count]);
                  controller.sleep(600);
                  turnOff();
                }
                break;
              case KeyEvent.VK_DOWN:
                if (moves[count] != 3) {
                  result(false);
                  score = moves.length - 1;
                  System.out.println("Sie haben " + score + " Züge erreicht!");
                  return;
                } else {
                  turnOff();
                  turnOn(moves[count]);
                  controller.sleep(600);
                  turnOff();
                }
                break;
              case KeyEvent.VK_RIGHT:
                if (moves[count] != 4) {
                  result(false);
                  score = moves.length - 1;
                  System.out.println("Sie haben " + score + " Züge erreicht!");
                  return;
                } else {
                  turnOff();
                  turnOn(moves[count]);
                  controller.sleep(600);
                  turnOff();
                }
                break;
              default:
            }
          }
          //Wenn noch keine Eingabe getätigt wurde, die gültig ist, dann wird diese Schleife "endlos", indem count immer wieder mit -1 addiert wird.
          else {
            count--;
          }
        } else {
          count--;
        }
        if (count == moves.length - 1) {
          result(true);
        }
      }
    }
  }

  public static void main(String[] args) {
    //BoardController anfordern
    controller = BoardController.getBoardController();
    //KeyBuffer anfordern
    buffer = controller.getKeyBuffer();

    while (true) {
      if (menu() == true) {
        game();
      } else {
        System.exit(0);
      }
    }
  }
}
