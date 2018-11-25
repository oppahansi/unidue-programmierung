/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A2_3;

public class Main {

  public static void main(String[] args) {
    char[] p = new char[] {'S', 'c', 'h', 'm', 'e', 'r', 'z'};
    char[] q = new char[] {'S', 's', 'h', 'm', 'f', 'r', 'z'};
    System.out.println(c(p, q, 122));
  }

  static boolean a(char[] p, char z) {
    if (p == null) {
      return false;
    } else {
      for (int i = 0; i < p.length; i++) {
        if (p[i] != z) {
          return false;
        }
      }
    }
    return true;
  }

  static boolean b(int[] s) {
    for (int i = 0; i < s.length; i += 2) {
      for (int j = 1; j < s.length; j += 2) {
        if (s[i] >= s[j]) {
          return false;
        }
      }
    }
    return true;
  }

  static boolean c(char[] p, char[] q, int n) {
    for (int i = 0; i < p.length - n; i++) {
      for (int j = 0; j < q.length - n; j++) {
        boolean b = true;
        for (int x = 0; x < n; x++) {
          if (p[i + x] != q[i + x]) {
            b = false;
          }
        }
        if (b) {
          return true;
        }
      }
    }
    return false;
  }
}
