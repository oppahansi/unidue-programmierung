/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * Dieses Programm demonstriert die Verwendung des InputBuffers fuer das
 * LEDBoard. Der BoardController stellt zu diesem Zweck ein Objekt des Typs
 * KeyBuffer zur Verfuegung. Wenn ein KeyBuffer verwendet wird, oeffnet der
 * Rechner auf dem der Keybuffer gestartet wird ein Emulatorfenster, falls das
 * nicht ohnehin schon angefordert wurde. Wenn das Emulatorfenster fokussiert
 * ist, werden alle Tastatureingaben angefangen und im KeyBuffer abgelegt.
 *
 * Die im KeyBuffer abgelegten Objekte sind sogenannte KeyEvents.
 * http://docs.oracle.com/javase/6/docs/api/java/awt/event/KeyEvent.html
 * Es gibt drei verschiedene Arten von KeyEvents.
 *
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
 * Das Programm unten wertet alle Tastendruecke der Tasten 0-9 aus und erzeugt
 * bunte LED-Balken der eingegebenen Laenge (0-9).
 */

package com.oppahansi.led.lightShow.tutorial;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import java.util.Random;

public class TutorialInput01_RandomColumns {

  static final int[][] COLORS =
      new int[][] {
        {127, 127, 127},
        {127, 127, 0},
        {127, 0, 127},
        {127, 0, 0},
        {0, 127, 127},
        {0, 127, 0},
        {0, 0, 127}
      };
  static int[][] colors;
  static int[] lights;
  static int current_row;
  static Random rng;
  static BoardController controller;
  static KeyBuffer input;

  public static void main(String[] args) {
    controller = BoardController.getBoardController();

    // an dieser Stelle wird der KeyBuffer angefordert. Er kann nun jederzeit
    // ausgelesen werden.
    // Fuer die Verwendung des KeyBuffers ist der zusaetzliche Import in
    // Zeile 42 noetig.
    input = controller.getKeyBuffer();
    colors = new int[12][3];
    lights = new int[12];
    rng = new Random();
    while (true) {
      // in einer eigenen Methode wird hier geprueft,
      // ob auf eine erfolgte Tastatureingabe reagiert werden muss.
      // Mit KeyBuffer.pop() wird das am laengsten zurueckliegende Event
      // zurueckgegeben und aus dem Puffer geloescht.
      // In diesem Fall wird das Ereignis direkt als Parameter uebergeben.
      processInput(input.pop());
      draw();
    }
  }

  public static void processInput(java.awt.event.KeyEvent event) {

    // Als erstes muss geprueft werden, ob ueberhaupt ein Tastaturereignis
    // stattgefunden hat.
    if (event != null) {

      // Ist das der Fall, wird hier geprueft, ob das Event von einem
      // fuer uns interessanten Typ ist.
      if (event.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {

        // Ist auch das der Fall, wird geprueft, ob eine der
        // interessanten Tasten gedrueckt wurde (0-9).
        // Da wir ein KEY_PRESSED-Event verarbeiten, muessen wir die
        // Methode getKeyCode() und nicht getKeyChar() verwenden.
        // Da es sich um Integerwerte handelt, kann man arithmetische
        // Vergleiche und ein paar andere Tricks verwenden.
        if (event.getKeyCode() >= java.awt.event.KeyEvent.VK_0
            && event.getKeyCode() <= java.awt.event.KeyEvent.VK_9) {

          // Wenn tatsaechlich eine Zahl gedrueckt wurde, ziehen wir
          // von der erhaltenen Konstante die Konstante fuer die Taste
          // 0 ab. Da die Zahltastenkonstanten aufeinanderfolgen,
          // koennen wir so direkt an den gewuenschten Zahlwert kommen,
          // ohne uns um die eigentlichen Konstantenwerte kuemmern zu
          // muessen.
          lights[current_row] = event.getKeyCode() - java.awt.event.KeyEvent.VK_0;
          colors[current_row] = COLORS[rng.nextInt(7)];
          current_row = (current_row + 1) % controller.getHeight();
        }
      }
    }
  }

  public static void draw() {
    for (int y = 0; y < controller.getHeight(); y++) {
      for (int x = 0; x < lights[y]; x++) {
        controller.setColor(x, y, colors[y][0], colors[y][1], colors[y][2]);
      }
    }
    controller.updateLedStripe();
  }
}
