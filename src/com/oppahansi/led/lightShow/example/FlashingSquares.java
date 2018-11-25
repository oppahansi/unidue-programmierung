/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * In dieser Demo kann man den Einsatz von BoardController.sleep(int ms) sehen.
 * Ohne die Nutzung dieser Methode wuerde das Bild zu schnell neu aufgebaut.
 */

package com.oppahansi.led.lightShow.example;

import ledControl.BoardController;

import java.util.Random;

public class FlashingSquares {

  static BoardController controller;
  static int[][][] colors;
  static int[] sizes = new int[] {6, 4, 3, 2, 1};
  static int[][] squareColors =
      new int[][] {
        {0, 0, 127},
        {0, 127, 0},
        {0, 127, 127},
        {127, 0, 0},
        {127, 0, 127},
        {127, 127, 0},
        {0, 0, 0}
      };
  static int pauseMsec = 333;

  public static void main(String[] args) {
    if (args.length > 0) {
      pauseMsec = Integer.parseInt(args[0]);
    }
    Random rng = new Random();
    controller = BoardController.getBoardController();
    colors = controller.getColors();
    while (true) {
      for (int i = 0; i < 10; i++) {
        squares(sizes[i / 2], squareColors[rng.nextInt(7)], i); // Setzen der Farben
        controller.sleep(pauseMsec); // Abwarten damit das Bild nicht zu schnell wechselt
        controller.updateLedStripe(); // Update des Bilds
      }
    }
  }

  public static void squares(int size, int[] colors, int inverse) {
    for (int x = 0; x < 12; x++) {
      for (int y = 0; y < 12; y++) {
        for (int color = 0; color < 3; color++) {
          FlashingSquares.colors[x][y][color] =
              (((x / size) + (y / size) + inverse) % 2 == 0) ? 127 : colors[color];
        }
      }
    }
  }
}
