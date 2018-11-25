/*
 * Sunrise
 *
 * <p>Created by: Endlosschleife (Gruppe
 */
package com.oppahansi.led.ledprojekte.endlosschleife;

import ledControl.BoardController;

public class Flow {

  static Background bg = new Background();

  public static void flow(BoardController bc, Sun s) {

    if (s.yPos >= 8) {
      bg.night(bc);
    } else {
      bg.day(bc, (int) s.yPos);
    }

    // Neuberechnung
    for (int x = 0; x < 11; x++) {
      for (int y = 0; y < 11; y++) {
        for (int sun = 0; sun < 5; sun++) {
          double dist = s.getDistance(x, y);
          double factor = (dist > 2.5) ? 0 : (1 - dist / 2.5);
          factor *= factor;
          bc.addColor(
              x,
              y,
              (int) (factor * s.color[0]),
              (int) (factor * s.color[1]),
              (int) (factor * s.color[2]));
        }
      }
    }

    // Wasser hervorheben
    bg.water(bc, s.yPos);

    // Update des Bildes
    bc.updateLedStripe();
  }
}
