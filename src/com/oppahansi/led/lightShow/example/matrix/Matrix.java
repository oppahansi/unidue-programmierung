/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.led.lightShow.example.matrix;

import ledControl.BoardController;

import java.util.ArrayList;
import java.util.Random;

public class Matrix {

  public static void main(String[] args) {
    BoardController controller = BoardController.getBoardController();
    // controller.addNetworkHost("192.168.68.210");
    // list of sparks
    ArrayList<Spark> sparks = new ArrayList<>();
    Random rng = new Random();
    while (true) {
      controller.resetColors();
      // change the values to control how often new sparks are generated
      if (rng.nextInt(10) < 8) {
        // Change the rngParameters to change the occurrence rate of
        // red/blue sparks.
        // red/blue sparks are only generated, when the variables
        // red/blue have the value 0.
        int red = rng.nextInt(500);
        int blue = rng.nextInt(100);
        // outcomment the next line to enable blue sparks
        blue = 1;
        // generate a new spark
        Spark spark =
            new Spark(
                controller,
                (double) (rng.nextInt(12)),
                0.,
                0.,
                1.,
                (double) ((2 + rng.nextInt(5)) / 7.),
                rng.nextInt(4) + 4,
                rng.nextDouble(),
                new int[] {
                  (red == 0 && blue != 0) ? 127 : 0,
                  (red != 0 && blue != 0) ? 127 : 0,
                  blue == 0 ? 127 : 0
                });
        // add the new spark to the list of sparks
        sparks.add(spark);
      }

      // paint and move all sparks
      for (Spark s : sparks) {
        s.paint();
        s.move();
      }
      controller.updateLedStripe();

      // if any spark has left the board remove it from the list of sparks
      for (int i = 0; i < sparks.size(); i++) {
        if (!sparks.get(i).isOnBoard()) {
          sparks.remove(i);
          i--;
        }
      }
    }
  }
}
