/*
 * Tic Tac Toe
 *
 * <p>Created by: Group Flipworks
 *
 * <p>Bedienung:
 *
 * <p>Numpad: Ziffern 789 1. Reihe 456 2. Reihe 123 3. Reihe 0 Reset
 *
 * <p>oder umgekehrt. Jedenfalls entsprechen die Ziffern am Numpad den Feldern.
 *
 * <p>Ohne Numpad: Ziffern 123456789 entsprechen den Feldern angefangen oben links. 0 Reset.
 */
package com.oppahansi.led.ledprojekte.flipworks;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TicTacToe {

  static KeyBuffer input;
  static int[] Farbe = {127, 0, 0};
  static int[] EinsX = {0, 1, 2};
  static int[] EinsY = {1, 2, 3};
  static int[] ZweiX = {4, 5, 6};
  static int[] ZweiY = {1, 2, 3};
  static int[] DreiX = {8, 9, 10};
  static int[] DreiY = {1, 2, 3};
  static int[] VierX = {0, 1, 2};
  static int[] VierY = {5, 6, 7};
  static int[] FuenfX = {4, 5, 6};
  static int[] FuenfY = {5, 6, 7};
  static int[] SechsX = {8, 9, 10};
  static int[] SechsY = {5, 6, 7};
  static int[] SiebenX = {0, 1, 2};
  static int[] SiebenY = {9, 10, 11};
  static int[] AchtX = {4, 5, 6};
  static int[] AchtY = {9, 10, 11};
  static int[] NeunX = {8, 9, 10};
  static int[] NeunY = {9, 10, 11};
  static int[] Siegbedingung = {0, 0, 0, 0, 0, 0, 0, 0, 0};
  BoardController controller = BoardController.getBoardController();

  public static void main(String[] args) {

    BoardController controller = BoardController.getBoardController();
    input = controller.getKeyBuffer();

    for (int x = 0; x < controller.getWidth() - 1; x++) {
      for (int y = 1; y < controller.getHeight(); y++) {
        controller.setColor(x, y, 30, 30, 30);
      }
    }
    controller.updateLedStripe();
    for (int x = 0; x < controller.getWidth() - 1; x++) {
      controller.setColor(x, 4, 0, 0, 127);
      controller.setColor(x, 8, 0, 0, 127);
      controller.setColor(x, 0, 0, 0, 0);
    }
    for (int y = 0; y < controller.getHeight(); y++) {
      controller.setColor(3, y, 0, 0, 127);
      controller.setColor(7, y, 0, 0, 127);
      controller.setColor(11, y, 0, 0, 0);
    }
    controller.setColor(3, 0, 0, 0, 0);
    controller.setColor(7, 0, 0, 0, 0);
    controller.updateLedStripe();
    while (true) {
      KeypadInput(input.pop());
    }
  }

  public static void Siegerermittlung() {
    for (int i = 1; i < 3; i++) {
      if (Siegbedingung[0] == i && Siegbedingung[1] == i && Siegbedingung[2] == i) {
        Sieg(1);
      } else if (Siegbedingung[3] == i && Siegbedingung[4] == i && Siegbedingung[5] == i) {
        Sieg(1);
      } else if (Siegbedingung[6] == i && Siegbedingung[7] == i && Siegbedingung[8] == i) {
        Sieg(1);
      } else if (Siegbedingung[0] == i && Siegbedingung[3] == i && Siegbedingung[6] == i) {
        Sieg(2);
      } else if (Siegbedingung[1] == i && Siegbedingung[4] == i && Siegbedingung[7] == i) {
        Sieg(2);
      } else if (Siegbedingung[2] == i && Siegbedingung[5] == i && Siegbedingung[8] == i) {
        Sieg(2);
      } else if (Siegbedingung[0] == i && Siegbedingung[4] == i && Siegbedingung[8] == i) {
        Sieg(3);
      } else if (Siegbedingung[2] == i && Siegbedingung[4] == i && Siegbedingung[6] == i) {
        Sieg(3);
      }
    }
  }

  public static void Sieg(int Animation) {
    BoardController controller = BoardController.getBoardController();
    if (Animation == 1) {
      for (int x = 0; x < controller.getWidth(); x++) {
        for (int y = 0; y < controller.getHeight(); y++) {
          controller.setColor(x, y, Farbe);
        }
        controller.updateLedStripe();
      }
      JOptionPane.showMessageDialog(null, "Spiel beendet. Dr�cke 0 f�r einen Neustart.");
    } else if (Animation == 2) {
      for (int y = 0; y < controller.getHeight(); y++) {
        for (int x = 0; x < controller.getWidth(); x++) {
          controller.setColor(x, y, Farbe);
        }
        controller.updateLedStripe();
      }
      JOptionPane.showMessageDialog(null, "Spiel beendet. Dr�cke 0 f�r einen Neustart.");
    } else if (Animation == 3) {
      for (int x = 0; x < controller.getWidth(); x++) {
        for (int y = 0; y < controller.getHeight(); y++) {
          controller.setColor(x, y, Farbe);
        }
      }
      controller.updateLedStripe();
      JOptionPane.showMessageDialog(null, "Spiel beendet. Dr�cke 0 f�r einen Neustart.");
    } else {
    }
  }

  public static void FeldSetzen(int[] X, int[] Y, int[] Farbe) {
    BoardController controller = BoardController.getBoardController();
    /*
     * for (int i = 0; i < X.length; i++) { for (int k = 0; k < Y.length;
     * k++) { controller.setColor(X[i], Y[k], Farbe);
     * controller.updateLedStripe(); } }
     */
    if (Farbe[0] == 127) {
      controller.setColor(X[0], Y[0], Farbe);
      controller.setColor(X[0], Y[2], Farbe);
      controller.setColor(X[1], Y[1], Farbe);
      controller.setColor(X[2], Y[0], Farbe);
      controller.setColor(X[2], Y[2], Farbe);
      controller.updateLedStripe();
    } else {
      controller.setColor(X[0], Y[1], Farbe);
      controller.setColor(X[1], Y[0], Farbe);
      controller.setColor(X[1], Y[2], Farbe);
      controller.setColor(X[2], Y[1], Farbe);

      controller.setColor(X[0], Y[0], Farbe);
      controller.setColor(X[0], Y[2], Farbe);
      controller.setColor(X[2], Y[2], Farbe);
      controller.setColor(X[2], Y[0], Farbe);

      controller.updateLedStripe();
    }

    Siegerermittlung();
    ChangeColor(Farbe);
  }

  public static void ChangeColor(int[] Farbe) {
    if (Farbe[0] == 0) {
      Farbe[0] = 127;
      Farbe[1] = 0;
      Farbe[2] = 0;
    } else {
      Farbe[0] = 0;
      Farbe[1] = 127;
      Farbe[2] = 0;
    }
  }

  public static void KeypadInput(KeyEvent event) {
    if (event != null) {
      if (event.getID() == KeyEvent.KEY_PRESSED) {
        switch (event.getKeyCode()) {
          case KeyEvent.VK_0:
          case KeyEvent.VK_NUMPAD0:
            for (int i = 0; i < Siegbedingung.length; i++) {
              Siegbedingung[i] = 0;
            }
            Farbe[0] = 127;
            Farbe[1] = 0;
            Farbe[2] = 0;
            TicTacToe.main(null);
          case KeyEvent.VK_1:
          case KeyEvent.VK_NUMPAD7:
            if (Siegbedingung[0] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[0] = 1;
                FeldSetzen(EinsX, EinsY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[0] = 2;
                FeldSetzen(EinsX, EinsY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_2:
          case KeyEvent.VK_NUMPAD8:
            if (Siegbedingung[1] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[1] = 1;
                FeldSetzen(ZweiX, ZweiY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[1] = 2;
                FeldSetzen(ZweiX, ZweiY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_3:
          case KeyEvent.VK_NUMPAD9:
            if (Siegbedingung[2] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[2] = 1;
                FeldSetzen(DreiX, DreiY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[2] = 2;
                FeldSetzen(DreiX, DreiY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_4:
          case KeyEvent.VK_NUMPAD4:
            if (Siegbedingung[3] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[3] = 1;
                FeldSetzen(VierX, VierY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[3] = 2;
                FeldSetzen(VierX, VierY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_5:
          case KeyEvent.VK_NUMPAD5:
            if (Siegbedingung[4] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[4] = 1;
                FeldSetzen(FuenfX, FuenfY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[4] = 2;
                FeldSetzen(FuenfX, FuenfY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_6:
          case KeyEvent.VK_NUMPAD6:
            if (Siegbedingung[5] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[5] = 1;
                FeldSetzen(SechsX, SechsY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[5] = 2;
                FeldSetzen(SechsX, SechsY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_7:
          case KeyEvent.VK_NUMPAD1:
            if (Siegbedingung[6] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[6] = 1;
                FeldSetzen(SiebenX, SiebenY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[6] = 2;
                FeldSetzen(SiebenX, SiebenY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_8:
          case KeyEvent.VK_NUMPAD2:
            if (Siegbedingung[7] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[7] = 1;
                FeldSetzen(AchtX, AchtY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[7] = 2;
                FeldSetzen(AchtX, AchtY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          case KeyEvent.VK_9:
          case KeyEvent.VK_NUMPAD3:
            if (Siegbedingung[8] == 0) {
              if (Farbe[0] == 127) {
                Siegbedingung[8] = 1;
                FeldSetzen(NeunX, NeunY, Farbe);
              } else if (Farbe[0] == 0) {
                Siegbedingung[8] = 2;
                FeldSetzen(NeunX, NeunY, Farbe);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Das Feld ist belegt.");
            }
            break;
          default:
            JOptionPane.showMessageDialog(null, "Die Eingabe ist ung�ltig.");
        }
      }
    }
  }
}
