/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_5;

public class Main {
  private static int[] lastzugs;
  private static int[] rads;

  static void main(String[] args) {

    int[][] schaden = new int[53][24];
    for (int i = 0; i < lastzugs.length; i++) {
      schaden[lastzugs[i] - 1][rads[i] - 1]++;
    }

    int s[] = new int[53];
    for (int i = 0; i < schaden.length; i++) {
      for (int j = 0; j < schaden[0].length; j++) {
        s[i] += schaden[i][j];
      }
    }
    int max = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] > max) {
        max = s[i];
      }
    }
    for (int i = 0; i < schaden.length; i++) {
      if (s[i] == max) {
        System.out.println(i + 1);
      }
    }

    int x = 53 * 24;
    for (int i = 0; i < 120; i++) {
      for (int j = i + 1; j < 121; j++) {
        if (lastzugs[i] == lastzugs[j] && rads[i] == rads[j]) {
          x--;
        }
      }
    }
    System.out.println(x);
  }
}
