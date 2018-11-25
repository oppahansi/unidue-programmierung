/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * version 1.02
 */

package com.oppahansi.led.lightShow.example.spots;

import ledControl.BoardController;

public class MixingSpots {

  static BoardController controller;
  static Spot[] spots;
  static int[][][] colors;

  public static void main(String[] args) {
    controller = BoardController.getBoardController();
    // controller.addNetworkHost("192.168.68.211");
    spots = new Spot[3];
    // Das Array colors verwaltet unsere Farben und wird vom Controller
    // angefordert.
    colors = controller.getColors();

    // Die Spots sind die Scheinwerferlichter, die sich ueber das Board
    // bewegen.
    for (int i = 0; i < 3; i++) {
      spots[i] = new Spot(11, 11);
    }

    spots[0].setColor(127, 0, 0);
    spots[1].setColor(0, 127, 0);
    spots[2].setColor(0, 0, 127);

    spots[0].setSpeed(0.02, -1, 2);
    spots[1].setSpeed(0.033, 2, -1);
    spots[2].setSpeed(0.01, 1, 5);
    for (int i = 0; i < 3; i++) {
      spots[i].xPos = 5;
      spots[i].yPos = 5;
    }

    // Hier findet der eigentliche Programmablauf in einer Endlosschleife
    // statt.
    while (true) {
      for (int i = 0; i < 3; i++) {
        // Berechnung der aktuellen LED-Farbwerte
        // Berechnung der neuen Scheinwerferpositionen
        spots[i].move();
      }
      calculateLEDs();
    }
  }

  public static void calculateLEDs() {
    // alle LEDs aus
    controller.resetColors();

    // Neuberechnung
    for (int x = 0; x < 12; x++) {
      for (int y = 0; y < 12; y++) {
        for (int spot = 0; spot < 3; spot++) {
          double dist = spots[spot].getDistance(x, y);
          double factor = (dist > 2.5) ? 0 : (1 - dist / 2.5);
          factor = factor * factor;
          controller.addColor(
              x,
              y,
              (int) (factor * spots[spot].color[0]),
              (int) (factor * spots[spot].color[1]),
              (int) (factor * spots[spot].color[2]));
        }
      }
    }

    // Update des Bildes
    controller.updateLedStripe();
  }
}
