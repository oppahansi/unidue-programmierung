/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * Dieses Programm demonstriert die Verwendung des InputBuffers fuer das
 * LEDBoard. Der BoardController stellt zu diesem Zweck ein Objekt des Typs
 * KeyBuffer zur Verfuegung.
 *
 * Die im KeyBuffer abgelegten Objekte sind sogenannte KeyEvents:
 * http://docs.oracle.com/javase/6/docs/api/java/awt/event/KeyEvent.html
 *
 * Es gibt drei verschiedene Arten von KeyEvents:
 * Die ersten beiden sind KEY_PRESSED und KEY_RELEASED. Diese beiden Events
 * werden generiert, wenn eine Taste gedrueckt wird (Halten einer Taste bewirkt
 * die wiederholte Generierung des Events) (KEY_PRESSED) bzw. losgelassen wird
 * (KEY_RELEASED). In beiden Faellen kann man sich mit der Methode
 * KeyEvent.getKeyCode() eine Konstante vom Typ Integer zurueckgeben lassen, die
 * anzeigt, welche Taste das Ereignis ausgeloest hat. VK_A zB markiert die
 * Taste a, VK_ENTER markiert die Eingabetaste. Eine vollstaendige Auflistung
 * ist unter dem obigen Link zu finden.
 *
 * Der dritte und letzte Ereignistyp ist KEY_TYPED.
 * Dieses Event wird generiert, wenn ein wiedergebbares Zeichen registriert
 * wurde. Das Halten von Shift und das waehrenddessen erfolgende Druecken der
 * Taste 'a' wuerde zB ein KEY_TYPED-Event mit dem Buchstaben 'A' erzeugen.
 * Das alleinige Druecken und loslassen der Shift-Taste wuerde kein KEY_TYPED-
 * Event erzeugen. Wenn ein KEY_TYPED-Event vorliegt, kann das gelesene Zeichen
 * mittels KeyEvent.getKeyChar() abgerufen werden. Die Rueckgabe ist vom Typ
 * char. Dieser Eventtyp ist nuetzlich, wenn ihr zB eine dynamisch erzeugte
 * Laufschrift programmieren wollt.
 *
 *
 * In diesem Programm werden die Pfeiltasten verwendet um einen roten Punkt
 * ueber das Board zu bewegen.
 */

package com.oppahansi.led.lightShow.tutorial;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import java.awt.event.KeyEvent;

public class TutorialInput00_MovingDot {

  private static BoardController controller;
  // Der KeyBuffer in dem die Tastatureingaben zwischengespeichert werden.
  private static KeyBuffer buffer;
  // In den beiden Variablen xPos und yPos wird die Position des roten Punktes
  // gespeichert.
  private static int xPos, yPos;

  public static void main(String[] args) {
    // Den Boardcontroller anfordern
    controller = BoardController.getBoardController();
    // Danach den KeyBuffer anfordern
    buffer = controller.getKeyBuffer();
    // Startposition des Punktes festlegen
    xPos = 5;
    yPos = 5;

    // In einer Endlosschleife das Programm laufen lassen. Das Programm wird
    // trotzdem beendet, sobald der Benutzer es schliesst.
    // Zwei Dinge werden in der Schleife getan:
    // 1. a) Das letzte KeyEvent wird aus dem Buffer gelesen
    //    b) Es wird geprueft, ob ueberhaupt eine Tastatureingabe vorliegt.
    //    c) Wenn eine Eingabe vorliegt, wird geprueft, ob es sich um ein
    //       KEY_PRESSED-Event handelt, da dieses Programm nur auf das
    //       druecken, nicht auf das loslassen einer Taste reagieren soll.
    //    d) Wenn ein KEY_PRESSED-Event vorliegt, wird geprueft, ob es sich
    //       um eine der vier Pfeiltasten handelt, um dann
    //    e) gegebenenfalls die Position des roten Punktes anzupassen.
    // 2. Das Bild wird neu gezeichnet.
    while (true) {
      // 1. a)
      KeyEvent event = buffer.pop();
      // 1. b)
      if (event != null) {
        // 1.c)
        if (event.getID() == KeyEvent.KEY_PRESSED) {
          // 1.d)
          switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
              // der rote Punkt soll bewegt werden. Das darf nur dann
              // geschehen, wenn der Punkt sich dadurch nicht ueber
              // Bildrand hinaus bewegt
              if (yPos > 0) {
                // 1.e)
                yPos--;
              }
              break;
            case KeyEvent.VK_DOWN:
              // Pruefung auf den Bildrand
              if (yPos < 11) {
                // 1.e)
                yPos++;
              }
              break;
            case KeyEvent.VK_LEFT:
              // Pruefung auf den Bildrand
              if (xPos > 0) {
                // 1.e)
                xPos--;
              }
              break;
            case KeyEvent.VK_RIGHT:
              // Pruefung auf den Bildrand
              if (xPos < 11) {
                // 1.e)
                xPos++;
              }
              break;
            default:
          }
        }
      }

      // 2.
      // Zuruecksetzen des Bildes
      controller.resetColors();
      // Zeichnen des roten Punktes an der gespeicherten Position
      controller.setColor(xPos, yPos, 127, 0, 0);
      // Darstellung des neu gezeichneten Bildes auf dem Board
      controller.updateLedStripe();
    }
  }
}
