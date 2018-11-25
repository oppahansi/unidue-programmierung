/*
 * ShootdaLED
 *
 * <p>Created by: Penfifteen (Gruppe)
 *
 * <p>Bedienung: Pfeiltasten.
 */
package com.oppahansi.led.ledprojekte.penfifteen;

import ledControl.BoardController;

import java.awt.event.KeyEvent;
import java.util.Random;

public class ShootdaLED {

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
  static ledControl.gui.KeyBuffer input;

  static int[] ledtest = new int[10];
  static int points;

  // Timer
  static int myTimer = 0;
  static int myTimer2 = 0;
  static int changeTimer = 16;

  static int random;
  // Coordinates wand
  static int xS = 11;
  static int yS = 0;

  // Coordinates Enterprise - Starting Position
  static int y = 11;
  static int x = 5;

  // Shooting
  static int ySh = y - 1;
  static int xSh;

  // booleans
  static boolean isShoot = false;
  static boolean isWallHit = false;

  // Colors
  static int[] wandColor = new int[] {100, 50, 100};
  static int[] shootColor = new int[] {100, 100, 50};
  static int[] enterpriseColor = new int[] {100, 80, 40};
  static int[] black = new int[] {0, 0, 0};

  public static void main(String[] args) {

    controller = BoardController.getBoardController();

    input = controller.getKeyBuffer();
    colors = new int[12][3];
    lights = new int[12];
    rng = new Random();
    random = myRandom(0, 11);

    game();
  }

  public static void restart() {
    myTimer = 0;
    myTimer2 = 0;
    changeTimer = 20;
    xS = 11;
    yS = 0;
    y = 11;
    x = 5;
    isShoot = false;
    isWallHit = false;

    input = controller.getKeyBuffer();
    colors = new int[12][3];
    lights = new int[12];
    rng = new Random();
    random = myRandom(0, 11);

    game();
  }

  public static void drawEnterprise(int y, int x, int[] color) {

    controller.setColor(ShootdaLED.x, ShootdaLED.y, color[0], color[0], color[2]);
  }

  public static void move(KeyEvent event) {

    if (event != null) {
      if (event.getID() == KeyEvent.KEY_PRESSED) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT && x > 0) {

          drawEnterprise(x, enterpriseGetY(), black);
          enterpriseSetX(enterpriseGetX() - 1);
          drawEnterprise(x, enterpriseGetY(), enterpriseColor);
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT && x < 11) {

          drawEnterprise(x, enterpriseGetY(), black);
          enterpriseSetX(enterpriseGetX() + 1);
          drawEnterprise(x, enterpriseGetY(), enterpriseColor);
        }
        if (event.getKeyCode() == KeyEvent.VK_UP && y > 2) {

          drawEnterprise(x, enterpriseGetY(), black);
          enterpriseSetY(enterpriseGetY() - 1);
          drawEnterprise(x, enterpriseGetY(), enterpriseColor);
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN && y < 11) {

          drawEnterprise(x, enterpriseGetY(), black);
          enterpriseSetY(enterpriseGetY() + 1);
          drawEnterprise(x, enterpriseGetY(), enterpriseColor);
        }
      }
    }
  }

  // Zeichnet die Wand
  public static void drawWand(int yS, int a, int b, int c) {

    if (yS < 12 && yS >= 0) {
      // zeichnet die Wand bis zu einem Zufallspunkt
      for (int i = 0; i < random; i++) {
        controller.setColor(i, yS, a, b, c);
      }

      // zeichnet die Wand weiter ab Zufallspunkt+2, somit entsteht das
      // Loch
      for (int i = random + 1; i < controller.getHeight(); i++) {
        controller.setColor(i, yS, a, b, c);
      }
    }
  }

  // Zeichnet den zerst�rbaren Bereich
  public static void drawBreak(int yS, int a, int b, int c) {

    if (yS < 12 && yS >= 0) {
      for (int i = random; i < controller.getHeight(); ) {
        controller.setColor(i, yS, a, b, c);

        break;
      }
    }
  }

  public static void createShoot() {

    ShootdaLED.ySh = ShootdaLED.y - 1;
    controller.setColor(ShootdaLED.x, ShootdaLED.ySh, 100, 100, 100);
    ShootdaLED.xSh = ShootdaLED.x;
    isShoot = true;
  }

  public static void moveShoot() {

    controller.setColor(ShootdaLED.xSh, ShootdaLED.ySh, 0, 0, 0);
    controller.setColor(ShootdaLED.xSh, ShootdaLED.ySh - 1, 100, 100, 100);
    if (ySh == 1) {
      controller.setColor(ShootdaLED.xSh, ShootdaLED.ySh - 1, 0, 0, 0);
    }
    ShootdaLED.ySh--;

    if (ySh == yS || ySh <= 0) {
      isShoot = false;
      if (xSh == random) {
        isWallHit = true;
      }

      if (xSh != random) {
        controller.setColor(ShootdaLED.xSh, ShootdaLED.ySh, 100, 0, 0);
        if (ySh == 0) {
          controller.setColor(ShootdaLED.xSh, ShootdaLED.ySh, 0, 0, 0);
        }
      }
    }
  }

  // Bewegt die Wand nach unten
  public static void moveWand(int yS) {

    if (yS < controller.getHeight()) {
      drawWand(yS, 0, 0, 0);
      drawBreak(yS, 0, 0, 0);

      if (isWallHit == false) {
        drawBreak(yS + 1, 100, 80, 40);
      } else {
        drawBreak(yS + 1, 0, 0, 0);
      }

      drawWand(yS + 1, 100, 0, 0);

      yS++;
      wandSetY(yS);

    } else {
      wandSetY(-1);
      random = myRandom(0, 11);
      isWallHit = false;
      // jede neue Wand wird schneller -> +Schwierigkeit
      if (changeTimer > 2) {
        changeTimer = changeTimer - 2;
      }
    }
  }

  // startet das Spiel sobald Space gedr�ckt wird
  public static void game() {

    drawEnterprise(ShootdaLED.x, ShootdaLED.y, enterpriseColor);
    drawWand(yS, 100, 0, 0);
    drawBreak(yS, 100, 80, 40);
    controller.updateLedStripe();

    while (true) {
      KeyEvent key = input.pop();
      if (key != null) {
        if (key.getID() == KeyEvent.KEY_PRESSED) {
          {
            break;
          }
        }
        controller.updateLedStripe();
      }
    }
    while (shipAlive()) {
      KeyEvent event = input.pop();
      if (isShoot == false) {
        if (event != null) {
          if (event.getID() == KeyEvent.KEY_PRESSED) {

            if (event.getKeyCode() == KeyEvent.VK_SPACE) {
              createShoot();
            }
          }
        }
      }

      move(event);

      if (myTimer > changeTimer) {

        moveWand(yS);
        myTimer = 0;
      } else {
        myTimer++;
      }

      if (myTimer2 > 10) {

        if (isShoot == true) {
          moveShoot();
        }
      } else {
        myTimer2++;
      }

      controller.updateLedStripe();
    }
    controller.resetColors();
    controller.updateLedStripe();

    restart();
  }

  public static boolean shipAlive() {

    if (isWallHit == true && x == random && yS == y) {
      return true;
    }
    if (isWallHit == true && x != random && yS == y) {
      return false;
    }
    if (ShootdaLED.y != ShootdaLED.yS) {
      return true;
    }
    return false;
  }

  // Random Berechnung f�rs Loch
  public static int myRandom(int low, int high) {
    return (int) (Math.random() * (high - low) + low);
  }

  // Wand getter&setter
  public static void wandSetY(int yS) {
    ShootdaLED.yS = yS;
  }

  public static int wandGetY() {
    return ShootdaLED.yS;
  }

  public static void wandSetX(int xS) {
    ShootdaLED.xS = xS;
  }

  public static int wandGetX() {
    return ShootdaLED.xS;
  }

  // Wand getter&setter
  public static void enterpriseSetY(int y) {
    ShootdaLED.y = y;
  }

  public static int enterpriseGetY() {
    return ShootdaLED.y;
  }

  public static void enterpriseSetX(int x) {
    ShootdaLED.x = x;
  }

  public static int enterpriseGetX() {
    return ShootdaLED.x;
  }
}
