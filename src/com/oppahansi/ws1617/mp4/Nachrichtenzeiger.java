/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Mark K. Possible solution - there are other ways to solve these tasks.
 *
 * <p>https://www.youtube.com/watch?v=Y17UNx-sODE - Stream recording
 */
package com.oppahansi.ws1617.mp4;

public class Nachrichtenzeiger {
  private Nachricht nachricht;
  private Nachrichtenzeiger nf;

  // TODO AUFGABE 1b
  public Nachrichtenzeiger(Nachricht nachricht) {
    this.nachricht = nachricht;
    nf = null;
  }

  public Nachricht getNachricht() {
    return nachricht;
  }

  public void setNachricht(Nachricht nachricht) {
    this.nachricht = nachricht;
  }

  public Nachrichtenzeiger getNf() {
    return nf;
  }

  public void setNf(Nachrichtenzeiger nf) {
    this.nf = nf;
  }
}
