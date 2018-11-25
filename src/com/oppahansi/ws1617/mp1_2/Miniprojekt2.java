/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1617.mp1_2;

import java.util.Arrays;

public class Miniprojekt2 {
  /*
   * Wichtig: Die Methodensignatur darf nicht veraendert werden.
   */
  public Miniprojekt2() {}

  public static void main(String[] args) {
    Miniprojekt2 mini2 = new Miniprojekt2();
    int tag = 0;

    int[][] mittlereStundenproduktion =
        new int[][] {
          {
            0, 392, 533, 26, 635, 39, 693, 496, 690, 281, 903, 529, 121, 29, 345, 325, 195, 226,
            290, 311, 369, 344, 107, 201
          },
          {
            473, 869, 449, 419, 235, 253, 47, 914, 580, 148, 806, 827, 50, 298, 406, 252, 205, 213,
            47, 193, 140, 278, 251, 7
          },
          {
            240, 349, 543, 421, 168, 180, 421, 495, 157, 86, 169, 250, 349, 60, 247, 83, 499, 145,
            272, 266, 15, 610, 228, 647
          },
          {
            241, 438, 99, 405, 723, 499, 320, 265, 240, 150, 927, 301, 146, 48, 400, 458, 18, 164,
            63, 48, 239, 25, 512, 7
          },
          {
            686, 113, 495, 565, 845, 46, 929, 710, 38, 177, 873, 760, 197, 30, 124, 34, 58, 177,
            164, 533, 394, 360, 605, 634
          },
          {
            874, 486, 220, 228, 451, 397, 126, 300, 161, 892, 738, 656, 168, 177, 28, 393, 51, 165,
            42, 228, 363, 96, 526, 319
          },
          {
            445, 168, 315, 251, 283, 746, 565, 787, 437, 748, 826, 346, 42, 304, 321, 197, 101, 308,
            182, 665, 133, 673, 654, 657
          },
          {
            44, 1, 673, 123, 895, 522, 30, 791, 535, 232, 116, 458, 450, 486, 362, 64, 320, 434, 15,
            16, 681, 527, 53, 623
          },
          {
            218, 257, 605, 22, 140, 620, 694, 433, 866, 825, 168, 812, 261, 104, 186, 501, 256, 298,
            121, 290, 308, 468, 235, 224
          },
          {
            866, 733, 922, 637, 328, 141, 462, 348, 645, 658, 402, 334, 210, 399, 368, 417, 119, 94,
            284, 121, 503, 554, 668, 535
          }
        };

    int[][] stundenproduktion =
        new int[][] {
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          },
          {
            120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200,
            200, 200, 200, 200, 120, 120, 120
          }
        };

    // Aufgabe 1)
    System.out.println("Aufgabe 1) sollTeile(5) : " + mini2.sollTeile(5));
    System.out.println("Aufgabe 1) sollTeile(12) : " + mini2.sollTeile(12));
    System.out.println("Aufgabe 1) sollTeile(21) : " + mini2.sollTeile(21));
    /*
     * Erwartete Loesung: Aufgabe 1) sollTeile(5)150 Aufgabe 1)
     * sollTeile(12)200 Aufgabe 1) sollTeile(21)120
     */

    // Aufgabe 2)
    double[] stundenprod = mini2.mittlereStdProduktionSchicht(stundenproduktion, 0);
    System.out.println("Aufgabe 2) mittlereStdProduktionSchicht");
    mini2.ausgabeA(stundenprod);
    /*
     * Erwartete Loesung: [150.0] [200.0] [120.0]
     */

    double[] stundenprod2 = mini2.mittlereStdProduktionSchicht(mittlereStundenproduktion, 5);
    System.out.println("Aufgabe 2) mittlereStdProduktionSchicht");
    mini2.ausgabeA(stundenprod2);
    /*
     * Erwartete Loesung: [467.14285714285717] [179.44444444444446]
     * [300.375]
     */

    // Aufgabe 3)
    int[] tagesProduction = mini2.tagesproduktion(mittlereStundenproduktion);
    System.out.println("Aufgabe 3) tagesproduktion");
    mini2.ausgabeA(tagesProduction);
    /*
    * Erwartete Loesung:
       [8080]
             [8360]
             [6900]
             [6736]
             [9547]
             [8085]
             [10154]
             [8451]
             [8912]
             [10748]
    */

    // Aufgabe 4)
    int[] istSollVergleich = mini2.istSollVergleich(mittlereStundenproduktion);
    System.out.println("Aufgabe 4) istSollVergleich");
    mini2.ausgabeA(istSollVergleich);
    /*
    * Erwartete Loesung:
       [4270]
             [4550]
             [3090]
             [2926]
             [5737]
             [4275]
             [6344]
             [4641]
             [5102]
             [6938]
    */

    // Aufgabe 5)
    int minMittlereStdProd = mini2.minMittlereStdProd(mittlereStundenproduktion, 1);
    System.out.println("Aufgabe 5) minMittlereStdProd\n" + minMittlereStdProd);
    /*
    * Erwartete Loesung:
             1
    */

    // Aufgabe 6)
    int maxMittlereStdProd = mini2.maxMittlereStdProd(mittlereStundenproduktion, 1);
    System.out.println("Aufgabe 6) maxMittlereStdProd\n" + maxMittlereStdProd);
    /*
    * Erwartete Loesung:
             0
    */

    // Aufgabe 7)
    int[] minSchichtProd = mini2.minSchichtProd(mittlereStundenproduktion);
    System.out.println("Aufgabe 7) minSchichtProd");
    mini2.ausgabeA(minSchichtProd);
    /*
    * Erwartete Loesung:
             [3]
             [1]
             [1584]
    */

    // Aufgabe 8)
    int[] maxSchichtProd = mini2.maxSchichtProd(mittlereStundenproduktion);
    System.out.println("Aufgabe 8) maxSchichtProd");
    mini2.ausgabeA(maxSchichtProd);
    /*
    * Erwartete Loesung:
             [6]
             [0]
             [4455]
    */

    // Aufgabe 9)
    int[] differentStdProd = mini2.differentStdProd(mittlereStundenproduktion, 2);
    System.out.println("Aufgabe 9) differentStdProd");
    mini2.ausgabeA(differentStdProd);
    /*
    * Erwartete Loesung:
             [15]
             [60]
             [83]
             [86]
             [145]
             [157]
             [168]
             [169]
             [180]
             [228]
             [240]
             [247]
             [250]
             [266]
             [272]
             [349]
             [421]
             [495]
             [499]
             [543]
             [610]
             [647]
    */

    // Aufgabe 10)
    int secondStundeProd = mini2.secondStundeProd(mittlereStundenproduktion, 0);
    System.out.println("Aufgabe 10) secondStundeProd\n" + secondStundeProd);
    /*
    * Erwartete Loesung:
             866
    */

    // Aufgabe 11)
    int[] maxProfitMargin = mini2.maxProfitMargin(mittlereStundenproduktion);
    System.out.println("Aufgabe 11) maxProfitMargin");
    mini2.ausgabeA(maxProfitMargin);
    /*
    * Erwartete Loesung:
             [4]
             [6]
             [929]
    */

    // Aufgabe 12)
    int[] maxLostSchicht = mini2.maxLostSchicht(mittlereStundenproduktion);
    System.out.println("Aufgabe 12) maxLostSchicht");
    mini2.ausgabeA(maxLostSchicht);
    /*
    * Erwartete Loesung:
             [7]
             [1]
             [-185]
    */
  }

  // Aufgabe 1
  public int sollTeile(int Stunde) {
    if (Stunde >= 5 && Stunde < 12) {
      return 150;
    } else if (Stunde >= 12 && Stunde < 21) {
      return 200;
    } else {
      return 120;
    }
  }

  // Aufgabe 2
  public double[] mittlereStdProduktionSchicht(int[][] stundenproduktion, int tag) {
    double[] ergebnis = new double[3];

    for (int i = 0; i < stundenproduktion[tag].length; i++) {
      if (i >= 5 && i < 12) {
        ergebnis[0] += stundenproduktion[tag][i];
      } else if (i >= 12 && i < 21) {
        ergebnis[1] += stundenproduktion[tag][i];
      } else if (i >= 21 && i <= 23) {
        ergebnis[2] += stundenproduktion[tag][i];
      } else {
        ergebnis[2] += stundenproduktion[tag + 1][i];
      }
    }

    ergebnis[0] = ergebnis[0] / 7.0;
    ergebnis[1] = ergebnis[1] / 9.0;
    ergebnis[2] = ergebnis[2] / 8.0;

    return ergebnis;
  }

  // Aufgabe 3
  public int[] tagesproduktion(int[][] stundenproduktion) {
    int[] ergebnis = new int[stundenproduktion.length];

    for (int i = 0; i < stundenproduktion.length; i++) {
      for (int j = 0; j < stundenproduktion[i].length; j++) {
        ergebnis[i] += stundenproduktion[i][j];
      }
    }

    return ergebnis;
  }

  // Aufgabe 4
  public int[] istSollVergleich(int[][] stundenproduktion) {
    int[] ergebnis = new int[stundenproduktion.length];

    for (int i = 0; i < stundenproduktion.length; i++) {
      for (int j = 0; j < stundenproduktion[i].length; j++) {
        ergebnis[i] += stundenproduktion[i][j] - sollTeile(j);
      }
    }

    return ergebnis;
  }

  // Aufgabe 5
  public int minMittlereStdProd(int[][] stundenproduktion, int tag) {
    double[] schichten = mittlereStdProduktionSchicht(stundenproduktion, tag);
    double vergleichswert = schichten[0];
    int schicht = -1;

    for (int i = 0; i < schichten.length; i++) {
      if (vergleichswert > schichten[i]) {
        vergleichswert = schichten[i];
        schicht = i;
      }
    }

    return schicht;
  }

  // Aufgabe 6
  public int maxMittlereStdProd(int[][] stundenproduktion, int tag) {
    double[] schichten = mittlereStdProduktionSchicht(stundenproduktion, tag);
    double vergleichswert = schichten[0];
    int schicht = -1;

    for (int i = 0; i < schichten.length; i++) {
      if (vergleichswert <= schichten[i]) {
        vergleichswert = schichten[i];
        schicht = i;
      }
    }

    return schicht;
  }

  // Aufgabe 7
  public int[] minSchichtProd(int[][] stundenproduktion) {
    double[][] tagesSchichten = new double[8][3];
    int tag = 0;
    int minSchicht = 0;

    for (int i = 0; i < tagesSchichten.length; i++) {
      tagesSchichten[i] = tagesProduktonen(stundenproduktion, i + 1);
    }

    int schichten = (int) tagesSchichten[1][1];

    for (int i = 0; i < tagesSchichten.length; i++) {
      for (int j = 0; j < tagesSchichten[i].length; j++) {
        if (i == 7 && j == 2) {

        } else {
          if (schichten > tagesSchichten[i][j]) {
            tag = i + 1;
            minSchicht = j;
            schichten = (int) tagesSchichten[i][j];
          }
        }
      }
    }

    return new int[] {tag, minSchicht, schichten};
  }

  public double[] tagesProduktonen(int[][] stundenproduktion, int tag) {
    double[] ergebnis = new double[3];

    for (int i = 0; i < stundenproduktion[tag].length; i++) {
      if (i >= 5 && i < 12) {
        ergebnis[0] += stundenproduktion[tag][i];
      } else if (i >= 12 && i < 21) {
        ergebnis[1] += stundenproduktion[tag][i];
      } else if (i >= 21 && i <= 23) {
        ergebnis[2] += stundenproduktion[tag][i];
      } else {
        ergebnis[2] += stundenproduktion[tag + 1][i];
      }
    }

    return ergebnis;
  }

  // Aufgabe 8
  public int[] maxSchichtProd(int[][] stundenproduktion) {
    double[][] tagesSchichten = new double[8][3];
    int tag = 0;
    int minSchicht = 0;

    for (int i = 0; i < tagesSchichten.length; i++) {
      tagesSchichten[i] = tagesProduktonen(stundenproduktion, i + 1);
    }

    int schichten = (int) tagesSchichten[1][1];

    for (int i = 0; i < tagesSchichten.length; i++) {
      for (int j = 0; j < tagesSchichten[i].length; j++) {
        if (i == 7 && j == 2) {

        } else {
          if (schichten <= tagesSchichten[i][j]) {
            tag = i + 1;
            minSchicht = j;
            schichten = (int) tagesSchichten[i][j];
          }
        }
      }
    }

    return new int[] {tag, minSchicht, schichten};
  }

  // Aufgabe 9
  public int[] differentStdProd(int[][] stundenproduktion, int tag) {
    int[] temp = new int[stundenproduktion[0].length];

    for (int j = 0; j < stundenproduktion[tag].length; j++) {
      temp[j] = stundenproduktion[tag][j];
    }

    int zaehler = 0;

    for (int i = 0; i < temp.length - 1; i++) {
      for (int j = i + 1; j < temp.length; j++) {
        if (temp[i] == temp[j] && temp[i] != Integer.MAX_VALUE) {
          temp[j] = Integer.MAX_VALUE;
          zaehler++;
        }
      }
    }

    int[] ergebnis = new int[temp.length - zaehler];

    zaehler = 0;

    for (int i = 0; i < temp.length; i++) {
      if (temp[i] != Integer.MAX_VALUE) {
        ergebnis[zaehler] = temp[i];
        zaehler++;
      }
    }

    Arrays.sort(ergebnis);

    return ergebnis;
  }

  // Aufgabe 10
  public int secondStundeProd(int[][] stundenproduktion, int std) {
    int max = stundenproduktion[0][std];
    int secondMax = 0;

    for (int i = 0; i < stundenproduktion.length; i++) {
      if (max < stundenproduktion[i][std]) {
        max = stundenproduktion[i][std];
      }
    }

    for (int i = 0; i < stundenproduktion.length; i++) {
      if (secondMax < stundenproduktion[i][std] && stundenproduktion[i][std] < max) {
        secondMax = stundenproduktion[i][std];
      }
    }

    return secondMax;
  }

  // Aufgabe 11
  public int[] maxProfitMargin(int[][] stundenproduktion) {
    int tag = 0;
    int std = 0;
    int maxProfit = 0;

    for (int i = 1; i < stundenproduktion.length - 1; i++) {
      for (int j = 1; j < stundenproduktion[i].length - 1; j++) {
        if (stundenproduktion[i][j] > stundenproduktion[i - 1][j - 1]
            && stundenproduktion[i][j] > stundenproduktion[i][j - 1]
            && stundenproduktion[i][j] > stundenproduktion[i + 1][j - 1]
            && stundenproduktion[i][j] > stundenproduktion[i - 1][j]
            && stundenproduktion[i][j] > stundenproduktion[i + 1][j]
            && stundenproduktion[i][j] > stundenproduktion[i - 1][j + 1]
            && stundenproduktion[i][j] > stundenproduktion[i][j + 1]
            && stundenproduktion[i][j] > stundenproduktion[i + 1][j + 1]
            && maxProfit <= stundenproduktion[i][j]) {
          tag = i;
          std = j;
          maxProfit = stundenproduktion[i][j];
        }
      }
    }

    return new int[] {tag, std, maxProfit};
  }

  // Aufgabe 12
  public int[] maxLostSchicht(int[][] stundenproduktion) {
    int tag = 0;
    int schicht = 0;
    int maxLostDif = 0;

    for (int i = 1; i < stundenproduktion.length - 1; i++) {
      for (int j = 1; j < stundenproduktion[i].length - 1; j++) {
        if (stundenproduktion[i][j] - sollTeile(j) <= maxLostDif) {
          tag = i;

          if (sollTeile(j) == 150) {
            schicht = 0;
          } else if (sollTeile(j) == 200) {
            schicht = 1;
          } else {
            schicht = 2;
          }

          maxLostDif = stundenproduktion[i][j] - sollTeile(j);
        }
      }
    }

    return new int[] {tag, schicht, maxLostDif};
  }

  public void ausgabeA(int[][] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      for (int i = 0; i < array.length; i++) {
        System.out.println(Arrays.toString(array[i]));
      }
    }
  }

  public void ausgabeA(int[] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      for (int i = 0; i < array.length; i++) System.out.println("[" + array[i] + "]");
    }
  }

  public void ausgabeA(double[] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      for (int i = 0; i < array.length; i++) System.out.println("[" + array[i] + "]");
    }
  }
}
