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

public class Aufgabe2 {

  BoardController controller = BoardController.getBoardController(2);
  private Knoten wurzel;

  public static void main(String[] args) {

    Aufgabe2 s = new Aufgabe2();

    int[][] color = {
      {98, 0, 0},
      {113, 0, 0},
      {127, 0, 0},
      {98, 0, 0},
      {41, 0, 0},
      {31, 0, 0},
      {0, 0, 93},
      {0, 0, 120},
      {0, 122, 0},
      {0, 82, 0},
      {22, 17, 3},
      {22, 117, 3},
      {2, 127, 113},
      {2, 31, 13},
      {2, 31, 14},
      {2, 64, 13},
      {2, 64, 14}
    };

    Knoten temp = s.getRoot();

    if (temp == null) {
      temp = new Knoten();
      s.setRoot(temp);
    }
    // Aufgabe 2a)
    s.erzeugeQuadtree(color);
    // Aufgabe 2b)
    s.zeichneQuadtree();
  }

  // Aufgabe 2b)
  private void zeichneQuadtree() {

    Knoten temp = this.getRoot();
    if (temp != null) {
      this.zeichneQuadtree(temp, 0, 8, 0, 8);
    }
  }

  // Aufgabe 2a)
  public void erzeugeQuadtree(int[][] color) {
    for (int i = 0; i < color.length; i++) {
      insertNode(color[i]);
    }
  }

  public void insertNode(int[] color) {

    Knoten temp = this.getRoot();
    Knoten Mutter, Kind = temp;

    if (color[0] > 0 && color[1] == 0 && color[2] == 0) {
      Kind = Kind.nodes[0];

    } else if (color[0] == 0 && color[1] > 0 && color[2] == 0) {
      Kind = Kind.nodes[1];

    } else if (color[0] == 0 && color[1] == 0 && color[2] > 0) {
      Kind = Kind.nodes[2];

    } else if (color[0] > 0 && color[1] > 0 && color[2] > 0) {
      Kind = Kind.nodes[3];
    }

    int gruppenweite;
    int colorvalue = 0;
    for (int i = 0; i < color.length; i++) {
      if (colorvalue < color[i]) {
        colorvalue = color[i];
      }
    }
    // nach der while Schleife enden wir immer an einem Blatt-Knoten
    do {
      Mutter = Kind;

      gruppenweite = (Mutter.maxValue - Mutter.minValue + 1) / 4;

      if (Mutter.checkColor(color)) {
        Kind = null;
      } else if (colorvalue <= (Mutter.minValue + gruppenweite) - 1
          && colorvalue >= Mutter.minValue) {
        Kind = Kind.nodes[0];
      } else if (colorvalue <= (Mutter.minValue + 2 * gruppenweite) - 1
          && colorvalue >= gruppenweite) {
        Kind = Kind.nodes[1];
      } else if (colorvalue <= (Mutter.minValue + 3 * gruppenweite) - 1
          && colorvalue >= 2 * gruppenweite) {
        Kind = Kind.nodes[2];
      } else if (colorvalue <= (Mutter.minValue + 4 * gruppenweite) - 1
          && colorvalue >= 3 * gruppenweite) {
        Kind = Kind.nodes[3];
      }

    } while (Kind != null);

    if (!Mutter.checkColor(color)) {

      gruppenweite = (Mutter.maxValue - Mutter.minValue + 1) / 4;

      if (colorvalue <= (Mutter.minValue + gruppenweite) - 1 && colorvalue >= Mutter.minValue) {

        Mutter.nodes[0] = new Knoten(color);
        Mutter.nodes[0].setMinMaxValue(Mutter.minValue, (Mutter.minValue + gruppenweite) - 1);

      } else if (colorvalue <= (Mutter.minValue + 2 * gruppenweite) - 1
          && colorvalue >= gruppenweite) {

        Mutter.nodes[1] = new Knoten(color);
        Mutter.nodes[1].setMinMaxValue(gruppenweite, (Mutter.minValue + 2 * gruppenweite) - 1);

      } else if (colorvalue <= (Mutter.minValue + 3 * gruppenweite) - 1
          && colorvalue >= 2 * gruppenweite) {

        Mutter.nodes[2] = new Knoten(color);
        Mutter.nodes[2].setMinMaxValue(2 * gruppenweite, (Mutter.minValue + 3 * gruppenweite) - 1);

      } else if (colorvalue <= (Mutter.minValue + 4 * gruppenweite) - 1
          && colorvalue >= 3 * gruppenweite) {

        Mutter.nodes[3] = new Knoten(color);
        Mutter.nodes[3].setMinMaxValue(3 * gruppenweite, (Mutter.minValue + 4 * gruppenweite) - 1);
      }
    }
  }

  // Aufgabe 2b)
  private void zeichneQuadtree(Knoten k, int xMin, int xMax, int yMin, int yMax) {

    if (k != null && xMax - xMin > -1) {

      int xMitte = (xMax - xMin) / 2 + xMin;
      int yMitte = (yMax - yMin) / 2 + yMin;
      this.zeichneQuadrad(k.getColor(), xMin, xMax, yMin, yMax);
      System.out.println(
          " Knoten  Color: " + k.getRed() + ", " + k.getGreen() + ", " + k.getBlue());
      zeichneQuadtree(k.nodes[0], xMin, xMitte, yMin, yMitte);
      zeichneQuadtree(k.nodes[1], xMitte, xMax, yMin, yMitte);
      zeichneQuadtree(k.nodes[2], xMin, xMitte, yMitte, yMax);
      zeichneQuadtree(k.nodes[3], xMitte, xMax, yMitte, yMax);
    }
  }

  private void zeichneQuadrad(int[] color, int xMin, int xMax, int yMin, int yMax) {

    for (int x = xMin; x < xMax; x++) {
      for (int y = yMin; y < yMax; y++) {
        controller.setColor(x, y, color);
      }
    }
    controller.updateLedStripe();
  }

  public Knoten getRoot() {
    return wurzel;
  }

  public void setRoot(Knoten k) {
    wurzel = k;
  }
}

class Knoten {

  Knoten[] nodes;
  int minValue, maxValue;
  private int[] color;

  public Knoten(int[] color) {
    this.setColor(color);
    nodes = new Knoten[4];
  }

  public Knoten() {
    nodes = new Knoten[4];
    this.setColor(new int[] {77, 77, 77});
    nodes[0] = new Knoten(new int[] {127, 0, 0});
    nodes[0].setMinMaxValue(0, 127);
    nodes[1] = new Knoten(new int[] {0, 127, 0});
    nodes[1].setMinMaxValue(0, 127);
    nodes[2] = new Knoten(new int[] {0, 0, 127});
    nodes[2].setMinMaxValue(0, 127);
    nodes[3] = new Knoten(new int[] {127, 127, 127});
    nodes[3].setMinMaxValue(0, 127);
  }

  public void setMinMaxValue(int minValue, int maxValue) {
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  public int getMinValue() {
    return minValue;
  }

  public int getMaxValue() {
    return maxValue;
  }

  public int[] getColor() {
    return this.color;
  }

  public void setColor(int[] color) {
    this.color = color;
  }

  public boolean checkColor(int[] color) {

    int temp = 0;
    for (int i = 0; i < this.color.length; i++) {
      if (this.color[i] == color[i]) {
        temp++;
      }
    }

    if (temp == color.length) {
      return true;
    } else {
      return false;
    }
  }

  public int getRed() {

    return color[0];
  }

  public int getGreen() {
    return color[1];
  }

  public int getBlue() {
    return color[2];
  }
}
