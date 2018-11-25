/*
 * Sunrise
 *
 * <p>Created by: Endlosschleife (Gruppe
 */
package com.oppahansi.led.ledprojekte.endlosschleife;

import ledControl.BoardController;

public class Background {

  /*
   * F�rbt den Himmel in Tageslicht
   */
  public void day(BoardController bc, int factor) {

    int a = 127 - (factor * 9);

    // Himmel faerben
    for (int x = 0; x < bc.getWidth(); x++) {
      for (int y = 0; y < 8; y++) {
        bc.setColor(x, y, a, 50, 0);
      }
    }
  }

  /*
   * F�rbt den Himmel in schwarz
   */
  public void night(BoardController bc) {

    // Himmel faerben
    for (int x = 0; x < bc.getWidth(); x++) {
      for (int y = 0; y < 8; y++) {
        bc.setColor(x, y, 0, 0, 0);
      }
    }
  }

  /*
   * F�gt Wasser ein
   */
  public void water(BoardController bc, double factor) {

    // helle Reihe
    int[] a = {0, 80, 127};

    // dunkle Reihe
    int[] b = {0, 0, 127};

    // Wasser faerben
    for (int x = 0; x < bc.getWidth(); x++) {
      for (int y = 8; y < bc.getHeight(); y++) {
        if (y % 2 == 1) {
          bc.setColor(x, y, a);
        } else {
          bc.setColor(x, y, b);
        }
      }
    }
  }
}
