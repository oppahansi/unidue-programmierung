/* Created by oppahansi on 24.11.2014. */
package com.oppahansi.ws1415.uebungsblatt04;

public class Bicycle_A1 {

  // diese Variablen sollte man als private declarieren
  // public in diesem Fall wegen der Aufgabenstellung
  // nicht merken
  public String color;
  public String type;
  public int wheelSize;
  public int bicycleGears;
  public int price;

  public Bicycle_A1() {
    // Das ist ein Standartkonstruktor, den man nicht erstellen braucht
    // Dieser wird immer verwendet, falls kein Konstruktor definiert wird.
  }

  public Bicycle_A1(String type, String color, int wheelSize, int bicycleGears, int price) {
    this.type = type;
    this.color = color;
    this.wheelSize = wheelSize;
    this.bicycleGears = bicycleGears;
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getWheelSize() {
    return wheelSize;
  }

  public void setWheelSize(int wheelSize) {
    this.wheelSize = wheelSize;
  }

  public int getBicycleGears() {
    return bicycleGears;
  }

  public void setBicycleGears(int bicycleGears) {
    this.bicycleGears = bicycleGears;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void printDetails() {
    System.out.println("Type: \t\t\t\t\t\t" + getType());
    System.out.println("Color: \t\t\t\t\t\t" + getColor());
    System.out.println("Wheelsize: \t\t\t\t" + getWheelSize());
    System.out.println("Bicycle gears: \t\t" + getBicycleGears());
    System.out.println("Price: \t\t\t\t\t\t" + getPrice());
  }
}
