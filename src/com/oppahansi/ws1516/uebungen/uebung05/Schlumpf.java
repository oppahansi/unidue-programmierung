/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.uebung05;

public class Schlumpf {

  public static int MINIMAL_GROESSE = 8;
  public static int MAXIMAL_GROESSE = 20;

  public String name;
  public int groesse;

  public Schlumpf(String name, int groesse) {
    this.name = name;
    this.groesse = groesse;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGroesse() {
    return groesse;
  }

  public void setGroesse(int groesse) {
    this.groesse = groesse;
  }
}
