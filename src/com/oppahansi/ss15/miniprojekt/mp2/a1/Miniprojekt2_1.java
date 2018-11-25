/*
 * Created by: Institut f�r Informatik und Wirtschaftsinformatik, Universit�t Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Implementation by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ss15.miniprojekt.mp2.a1;

import java.util.Arrays;

public class Miniprojekt2_1 {
  /*
   * Wichtig:
   * Die Methodensignatur darf nicht veraendert werden.
   */

  int[][] sollTeile;

  //Aufgabe 1a
  public Miniprojekt2_1() {
    sollTeile = new int[10][24];

    for (int i = 0; i < sollTeile.length; i++) {
      for (int j = 0; j < sollTeile[i].length; j++) {
        if (j < 12) {
          sollTeile[i][j] = 937;
        } else if (j > 11 && j < 19) {
          sollTeile[i][j] = 503;
        } else {
          sollTeile[i][j] = 700;
        }
      }
    }
  }

  public static void main(String[] args) {
    Miniprojekt2_1 mini2 = new Miniprojekt2_1();

    int tag = 0;

    int[][] stundenproduktion =
        new int[][] {
          {
            108, 471, 794, 123, 587, 901, 252, 714, 273, 391, 259, 629, 368, 86, 293, 106, 469, 117,
            336, 110, 508, 480, 488, 190
          },
          {
            81, 928, 727, 394, 354, 385, 831, 926, 386, 555, 141, 894, 239, 423, 388, 47, 55, 250,
            267, 489, 687, 547, 232, 608
          },
          {
            847, 798, 678, 632, 315, 400, 335, 651, 813, 218, 615, 930, 286, 23, 11, 307, 297, 333,
            51, 622, 613, 8, 315, 101
          },
          {
            352, 259, 751, 443, 153, 412, 119, 448, 544, 290, 432, 876, 51, 99, 279, 258, 164, 66,
            436, 206, 138, 595, 283, 502
          },
          {
            586, 864, 238, 341, 728, 826, 5, 649, 146, 196, 205, 581, 333, 153, 134, 344, 33, 39,
            195, 398, 8, 86, 193, 291
          },
          {
            516, 419, 696, 662, 135, 213, 386, 768, 900, 191, 33, 881, 199, 126, 37, 102, 477, 335,
            415, 233, 540, 60, 245, 306
          },
          {
            601, 356, 867, 820, 864, 701, 524, 217, 740, 301, 191, 876, 378, 37, 246, 433, 351, 91,
            237, 241, 429, 110, 41, 174
          },
          {
            312, 144, 372, 195, 62, 402, 608, 112, 59, 592, 453, 98, 11, 193, 414, 476, 156, 114,
            495, 53, 603, 22, 215, 28
          },
          {
            882, 777, 586, 111, 501, 155, 601, 263, 270, 846, 456, 197, 493, 258, 96, 417, 234, 277,
            132, 483, 402, 215, 578, 235
          },
          {
            104, 550, 114, 92, 121, 140, 803, 260, 120, 670, 536, 21, 422, 393, 182, 108, 194, 77,
            162, 22, 606, 505, 258, 190
          }
        };

    double[] stundenprod = mini2.mittlereStundenproduktion(stundenproduktion, tag);

    /*System.out.println("--- Task 1a) --- \nYour solution:");
    mini2.ausgabeA(mini2.sollTeile);
    System.out.println("\nExpected Solution:\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n"
      + "[937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 937, 503, 503, 503, 503, 503, 503, 503, 700, 700, 700, 700, 700]\n");
    */

    System.out.println("--- Task 1b) --- \nYour solution:");
    mini2.ausgabeA(stundenprod);
    System.out.println("\nExpected Solution:\n[458.5]\n[253.57142857142858]\n[355.2]\n");

    System.out.println("--- Task 1c) --- \nYour solution:");
    int[] tagesProd = mini2.tagesproduktion(stundenproduktion);
    mini2.ausgabeA(tagesProd);
    System.out.println(
        "\nExpected Solution:\n[9053]\n[10834]\n[10199]\n[8156]\n[7572]\n[8875]\n[9826]\n[6189]\n[9465]\n[6650"
            + "]\n");

    System.out.println("--- Task 1d) --- \nYour solution:");
    int[] sollIstV = mini2.istSollVergleich(stundenproduktion, tag + 2);
    mini2.ausgabeA(sollIstV);
    System.out.println("\nExpected Solution:\n[-4012]\n[-2213]\n[-1841]\n");

    System.out.println("--- Task 1e) --- \nYour solution:");
    int avgStudProdAmkleinsten = mini2.minMittlereStudProd(stundenproduktion, tag);
    System.out.println("avgStudProd-->" + avgStudProdAmkleinsten);
    System.out.println("\nExpected Solution:\navgStudProd-->1");
  }

  //Aufgabe 1b
  public double[] mittlereStundenproduktion(int[][] stundenproduktion, int tag) {
    double[] result = new double[3];

    for (int i = 0; i < stundenproduktion[tag].length; i++) {
      if (i < 12) {
        result[0] += stundenproduktion[tag][i] / 12.0;
      } else if (i > 11 && i < 19) {
        result[1] += stundenproduktion[tag][i] / 7.0;
      } else {
        result[2] += stundenproduktion[tag][i] / 5.0;
      }
    }

    return result;
  }

  //Aufgabe 1c
  public int[] tagesproduktion(int[][] stundenproduktion) {
    int[] result = new int[10];

    for (int i = 0; i < stundenproduktion.length; i++) {
      for (int j = 0; j < stundenproduktion[i].length; j++) {
        result[i] += stundenproduktion[i][j];
      }
    }

    return result;
  }

  //Aufgabe 1d
  public int[] istSollVergleich(int[][] stundenproduktion, int tag) {
    int[] result = new int[3];

    for (int i = 0; i < stundenproduktion[tag].length; i++) {
      if (i < 12) {
        result[0] += (stundenproduktion[tag][i] - sollTeile[tag][i]);
      } else if (i > 11 && i < 19) {
        result[1] += (stundenproduktion[tag][i] - sollTeile[tag][i]);
      } else {
        result[2] += (stundenproduktion[tag][i] - sollTeile[tag][i]);
      }
    }

    return result;
  }

  //Aufgabe 1e
  public int minMittlereStudProd(int[][] stundenproduktion, int tag) {
    int[] result = new int[3];

    for (int i = 0; i < stundenproduktion[tag].length; i++) {
      if (i < 12) {
        result[0] += stundenproduktion[tag][i] / 12;
      } else if (i > 11 && i < 19) {
        result[1] += stundenproduktion[tag][i] / 7;
      } else {
        result[2] += stundenproduktion[tag][i] / 5;
      }
    }

    return getShiftWithMinProduktion(result);
  }

  private int getShiftWithMinProduktion(int[] values) {
    if (values[0] <= values[1] && values[0] <= values[2]) {
      return 0;
    } else if (values[1] <= values[2] && values[1] <= values[0]) {
      return 1;
    } else {
      return 2;
    }
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
      for (int i = 0; i < array.length; i++) {
        System.out.println("[" + array[i] + "]");
      }
    }
  }

  public void ausgabeA(double[] array) {
    if (array == null) {
      System.out.println("null");
    } else {
      for (int i = 0; i < array.length; i++) {
        System.out.println("[" + array[i] + "]");
      }
    }
  }
}
