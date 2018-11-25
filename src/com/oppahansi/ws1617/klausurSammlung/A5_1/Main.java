/* Shared by Tornike K. */
package com.oppahansi.ws1617.klausurSammlung.A5_1;

public class Main {

  public static void main(String[] args) {
    Transportmittel[] t = new Transportmittel[5];
    t[0] = new Flugzeug("Flugzeug", "Lufthansa");
    t[1] = new LKW("LKW", "AA22", 30);

    t[0].ausgabe();
    t[1].ausgabe();
  }
}
