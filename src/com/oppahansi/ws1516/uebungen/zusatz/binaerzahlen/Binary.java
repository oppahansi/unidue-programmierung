/*
 * Created by: Oppa Hansi
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1516.uebungen.zusatz.binaerzahlen;

import java.util.ArrayList;
import java.util.Collections;

public class Binary {

  private int[] number;

  // 2)
  public Binary(int number) {
    this.number = toBinary(number);
  }

  private int[] toBinary(int number) {
    return getBinaryArray(getBinaryList(number));
  }

  private ArrayList<Integer> getBinaryList(int number) {
    ArrayList<Integer> binaryList = new ArrayList<>();

    while (number > 0) {
      if (number % 2 == 0) {
        binaryList.add(0);
      } else {
        binaryList.add(1);
      }
      number /= 2;
    }

    Collections.reverse(binaryList);

    return binaryList;
  }

  private int[] getBinaryArray(ArrayList<Integer> binaryList) {
    int[] binaryArray = new int[binaryList.size()];

    for (int i = 0; i < binaryList.size(); i++) {
      binaryArray[i] = binaryList.get(i);
    }

    return binaryArray;
  }

  // 5)
  public int toInt(String binary) {
    int result = 0;

    for (int i = binary.length(); i > 0; i--) {
      result += ((Integer.parseInt(binary.charAt(i - 1) + "") * Math.pow(2, binary.length() - i)));
    }
    return result;
  }

  // 7)
  public String bitwiseOr(String binary1, String binary2) {
    String binaryNormal = (binary1.length() > binary2.length()) ? binary1 : binary2;
    String binaryFilled =
        (binary1.length() > binary2.length())
            ? fill(binary2, binary1.length())
            : fill(binary1, binary2.length());

    String result = "";

    for (int i = binaryNormal.length() - 1; i >= 0; i--) {
      if (binaryNormal.charAt(i) == '1' || binaryFilled.charAt(i) == '1') {
        result = "1" + result;
      } else {
        result = "0" + result;
      }
    }

    return result;
  }

  private String fill(String binary, int fullLength) {
    while (binary.length() != fullLength) {
      binary = "0" + binary;
    }
    return binary;
  }

  // 8)
  public String bitwiseAnd(String binary1, String binary2) {
    String binaryNormal = (binary1.length() > binary2.length()) ? binary1 : binary2;
    String binaryFilled =
        (binary1.length() > binary2.length())
            ? fill(binary2, binary1.length())
            : fill(binary1, binary2.length());

    String result = "";

    for (int i = binaryNormal.length() - 1; i >= 0; i--) {
      if (binaryNormal.charAt(i) == '1' && binaryFilled.charAt(i) == '1') {
        result = "1" + result;
      } else {
        result = "0" + result;
      }
    }

    return result;
  }

  // 9)
  public String bitwiseAdd(String binary1, String binary2) {
    String binaryNormal = (binary1.length() > binary2.length()) ? binary1 : binary2;
    String binaryFilled =
        (binary1.length() > binary2.length())
            ? fill(binary2, binary1.length())
            : fill(binary1, binary2.length());

    String result = "";
    String overflow = "";

    for (int i = binaryNormal.length() - 1; i >= 0; i--) {
      if (binaryNormal.charAt(i) == '1' && binaryFilled.charAt(i) == '1') {
        if (overflow.isEmpty()) {
          result = "0" + result;
          overflow = "1";
        } else {
          result = "1" + result;
          overflow = "";
        }
      } else if (binaryNormal.charAt(i) == '1' && binaryFilled.charAt(i) == '0'
          || binaryNormal.charAt(i) == '0' && binaryFilled.charAt(i) == '1') {
        if (overflow.isEmpty()) {
          result = "1" + result;
        } else {
          result = "0" + result;
          overflow = "";
        }
      } else {
        if (overflow.isEmpty()) {
          result = "0" + result;
        } else {
          result = "1" + result;
          overflow = "";
        }
      }
    }

    return overflow + result;
  }

  // 4)
  @Override
  public String toString() {
    String toStringNumber = "";
    for (Integer currentNumber : number) {
      toStringNumber += currentNumber;
    }
    return toStringNumber;
  }

  public int[] getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = toBinary(number);
  }
}
