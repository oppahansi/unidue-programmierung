package com.oppahansi.ss14.woche2;

/*
 * Schauen Sie Sich die Methoden der Klasse Car an, damit Sie die Methoden der
 * Klasse MeanPerson erfolgreich implementieren koennen.
 * Diese Klasse soll von Ihnen NICHT veraendert werden!
 */

public class Car {

  private String manufacturer;
  private String model;
  private int value;
  private boolean damaged;

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
    damaged = false;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  /*
   * Uebliche Setter und Getter
   * Das Feld damaged hat keinen normalen Setter.
   * Es wird durch die Methoden crash und repair gesetzt.
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

  /*
   * Diese Methode ist kein Standardgetter, da sie in Abhaengigkeit anderer
   * Felder von Car steht. Der Rueckgabewert ist nicht allein durch das Feld
   * value festgelegt.
   * Der Wert eines Autos ist natuerlich niedriger, wenn es beschaedigt ist.
   */
  public int getValue() {
    if (damaged) {
      return value / 2;
    } else {
      return value;
    }
  }

  public void setValue(int newValue) {
    value = newValue;
  }

  /*
   * Diese Methode ist aufzurufen, wenn das Auto einen Unfall baut.
   */
  public void crash() {
    damaged = true;
  }

  /*
   * Der Getter fuer das Feld damaged. Die Benennung entspricht nicht der
   * Ihnen aus der Vorlesung bekannten Konvention, ist aber dennoch sinnvoll.
   */
  public boolean isDamaged() {
    return damaged;
  }

  /*
   * Die Kosten fuer die Reparatur des Autos. Wenn das Auto unbeschaedigt ist,
   * existieren keine Reparaturkosten und der Rueckgabewert ist folglich 0.
   */
  public int getRepairCost() {
    if (damaged) {
      return value / 2;
    } else {
      return 0;
    }
  }

  /*
   * Mit dieser Methode wird ein Auto wieder repariert.
   * Die Kosten der Reparatur werden von der Methode als Integer zurueck
   * gegeben. Beachten Sie, dass zur Berechnung der Kosten die bereits zuvor
   * implementierte Methode getRepairCost verwendet wird.
   */
  public int repair() {
    int repairCost = getRepairCost();
    damaged = false;
    return repairCost;
  }
}
