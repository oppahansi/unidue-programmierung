/* Created by oppahansi on 24.11.2014. */
package com.oppahansi.ws1415.uebungsblatt04;

public class Aufgabe3_A1 {

  public static void main(String[] args) {
    Bicycle_A1[] bicycleArray = new Bicycle_A1[3];
    bicycleArray[0] = new Bicycle_A1("green", "street", 26, 3, 150);
    bicycleArray[1] = new Bicycle_A1();
    bicycleArray[1].color = "blue";
    bicycleArray[1].type = "children";
    bicycleArray[1].wheelSize = 16;
    bicycleArray[1].bicycleGears = 1;
    bicycleArray[1].price = 75;
    bicycleArray[2] = new Bicycle_A1();
    bicycleArray[2].setColor("red");
    bicycleArray[2].setType("professional");
    bicycleArray[2].setWheelSize(28);
    bicycleArray[2].setBicycleGears(21);
    bicycleArray[2].setPrice(10000);

    for (int i = 0; i < bicycleArray.length; i++) {
      System.out.println("Bicycle " + (i + 1) + ":");
      bicycleArray[i].printDetails();
      System.out.println();
    }
  }
}
