/*
 * Sunrise
 *
 * <p>Created by: Endlosschleife (Gruppe
 */
package com.oppahansi.led.ledprojekte.endlosschleife;

import ledControl.BoardController;

public class Main {

  static BoardController controller = BoardController.getBoardController();
  static Sun s = new Sun(11);
  static Flow f = new Flow();

  public static void main(String[] args) {

    while (true) {
      for (int i = 0; i < 3; i++) {
        s.move();
      }
      f.flow(controller, s);
    }
  }
}
