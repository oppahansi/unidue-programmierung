package com.oppahansi.ss14.woche5;

import java.util.Random;

/*
 * Diese Klasse soll von Ihnen NICHT veraendert werden!
 */

public class Car {

  private static Random rng = new Random();

  private String manufacturer;
  private String model;
  private int value;
  private boolean damagedEngine;
  private boolean damagedWindow;
  private boolean damagedChassis;

  /*
   * Der Standardkonstruktor der Klasse Car.
   * Wenn Sie ein Objekt der Klasse Car erzeugen, haben die Felder die unten
   * zu sehenden Werte, bis sie durch die Setter oder andere Methoden
   * geaendert werden.
   */
  public Car() {
    manufacturer = "Ludolf";
    model = "Rostlaube 500";
    value = 1000;
    damagedEngine = false;
    damagedWindow = false;
    damagedChassis = false;
  }

  /*
   * Konstruktor mit dem alle Herstellungseigenschaften auf Wunschwerte
   * gesetzt werden.
   */
  public Car(String manufacturer, String model, int value) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.value = value;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  /*
   * Uebliche Setter und Getter
   * Die Felder damaged*** haben keine normalen Setter.
   * Sie werden durch die Methoden crash und repair gesetzt.
   */
  public void setManufacturer(String newManufacturer) {
    manufacturer = newManufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String newModel) {
    model = newModel;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int newValue) {
    value = newValue;
  }

  /*
   * Diese Methode ist aufzurufen, wenn das Auto einen Unfall baut.
   */
  public void crash() {
    damagedEngine = rng.nextInt(2) == 1;
    damagedWindow = rng.nextInt(2) == 1;
    damagedChassis = rng.nextInt(2) == 1;
    if (!(damagedEngine || damagedWindow || damagedChassis)) {
      damagedChassis = true;
    }
  }

  public boolean isDamaged() {
    return (damagedEngine || damagedWindow || damagedChassis);
  }

  public boolean damagedEngine() {
    return damagedEngine;
  }

  public boolean damagedWindow() {
    return damagedWindow;
  }

  public boolean damagedChassis() {
    return damagedChassis;
  }

  /*
   * Mit dieser Methode wird ein Auto wieder repariert.
   */
  public void repair() {
    damagedEngine = false;
    damagedWindow = false;
    damagedChassis = false;
  }
}
