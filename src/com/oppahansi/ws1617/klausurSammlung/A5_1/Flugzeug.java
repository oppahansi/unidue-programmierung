/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_1;

public class Flugzeug extends Transportmittel {

  String Fluggesellschaft;

  Flugzeug(String Bezeichnung, String Fluggesellschaft) {
    super(Bezeichnung);
    this.Fluggesellschaft = Fluggesellschaft;
  }

  public void ausgabe() {
    System.out.println(Bezeichnung + " " + Fluggesellschaft);
  }
}
