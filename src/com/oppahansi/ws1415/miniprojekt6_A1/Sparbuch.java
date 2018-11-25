/*
 * Created by: Institute for Computer Science and Business Information Systems University
 * Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved by Alex Oppa Hansi
 *
 * <p>Alternative 1
 */
package com.oppahansi.ws1415.miniprojekt6_A1;

public class Sparbuch extends SparKonto {

  public Sparbuch(int kontoNr, double kontoStand, Konto bankKonto) {
    super(kontoNr, kontoStand, bankKonto, 0.05);
  }
}
