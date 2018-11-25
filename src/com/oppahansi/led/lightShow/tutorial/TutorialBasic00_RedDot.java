/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * Dieses Programm demonstriert die einfachst moegliche Verwendung des
 * LED-Boards. Ein roter Punkt wird mitten auf dem Board platziert und
 * angezeigt.
 */

package com.oppahansi.led.lightShow.tutorial;

import ledControl.BoardController;

public class TutorialBasic00_RedDot {

  public static void main(String[] args) {
    // Boardcontroller anfordern
    BoardController controller = BoardController.getBoardController();

    // Roten Punkt setzen
    controller.setColor(5, 5, 127, 0, 0);

    // das bislang gemalte Bild anzeigen
    controller.updateLedStripe();
  }
}
