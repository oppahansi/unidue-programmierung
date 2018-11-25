/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Offizielle moegliche Loesung
 *
 * <p>ledControl is located inside the res/ledControl/ folder - add it to your project as library.
 */
package com.oppahansi.ws1415.uebungsblatt07;

import ledControl.BoardController;

public class Aufgabe1 {

  static BoardController controller = BoardController.getBoardController(200);

  public static void main(String[] args) {

    Aufgabe1 A1 = new Aufgabe1();
    A1.KansasCityOstSued(0, 0);
    A1.KansasCitySuedOst(0, 0);
  }

  void KansasCityOstSued(int x, int y) {

    controller.setColor(x, y, 127, 127, 0);
    controller.updateLedStripe();
    if (x < 11) {
      KansasCityOstSued(x + 1, y);
    }
    if (y < 11) {
      KansasCityOstSued(x, y + 1);
    }

    controller.setColor(x, y, 0, 0, 0);
    controller.updateLedStripe();
  }

  void KansasCitySuedOst(int x, int y) {

    controller.setColor(x, y, 127, 127, 0);
    controller.updateLedStripe();
    if (y < 11) {
      KansasCitySuedOst(x, y + 1);
    }
    if (x < 11) {
      KansasCitySuedOst(x + 1, y);
    }
    controller.setColor(x, y, 0, 0, 0);
    controller.updateLedStripe();
  }
}
