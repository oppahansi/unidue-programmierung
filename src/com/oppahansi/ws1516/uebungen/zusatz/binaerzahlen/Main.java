/*
 * Created by: Oppa Hansi
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1516.uebungen.zusatz.binaerzahlen;

// 3)
public class Main {

  public static void main(String[] args) {
    Binary test1 = new Binary(10);
    Binary test2 = new Binary(100);

    System.out.println("10 as binary is:  " + test1.toString() + "  (1010 expected)");
    System.out.println("100 as binary is:  " + test2.toString() + "  ( expected)");

    System.out.println("\n1010 as decimal number is:  " + test1.toInt("1010") + "  (10 expected)");
    System.out.println(
        "1100100 as decimal number is:  " + test1.toInt("1100100") + "  (100 expected)");

    Binary test3 = new Binary(25);
    Binary test4 = new Binary(40);

    System.out.println("\n25 as binary is:  " + test3.toString() + "  (11001 expected)");
    System.out.println("25 as binary is:  " + test4.toString() + "  (101000 expected)");
    System.out.println(
        "101000 bitwise OR 11001 is:  "
            + test1.bitwiseOr(test3.toString(), test4.toString())
            + "  (111001 expected)");

    String binary1 = "100101";
    String binary2 = "110001";

    System.out.println(
        "100101 bitwise AND 110001 is:  "
            + test1.bitwiseAnd(binary1, binary2)
            + "  (100001 expected)");

    System.out.println(
        "\n100101 bitwise ADD 110001 is:  "
            + test1.bitwiseAdd(binary1, binary2)
            + "  (1010110 expected)");
  }
}
