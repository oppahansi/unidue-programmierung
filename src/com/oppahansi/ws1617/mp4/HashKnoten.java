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

public class HashKnoten {
  private String hashtag;
  private HashKnoten nf;
  private Nachrichtenzeiger nzKopf;

  // TODO AUFGABE 1c
  public HashKnoten(String hashtag, Nachricht nachricht) {
    this.hashtag = hashtag;
    nzKopf = new Nachrichtenzeiger(nachricht);
  }

  public String getHashtag() {
    return hashtag;
  }

  public void setHashtag(String hashtag) {
    this.hashtag = hashtag;
  }

  public HashKnoten getNf() {
    return nf;
  }

  public void setNf(HashKnoten nf) {
    this.nf = nf;
  }

  public Nachrichtenzeiger getNzKopf() {
    return nzKopf;
  }

  public void setNzKopf(Nachrichtenzeiger nzKopf) {
    this.nzKopf = nzKopf;
  }

  // TODO AUFGABE 1d
  public void fuegeNachrichtEin(Nachricht nachricht) {
    Nachrichtenzeiger tmp = new Nachrichtenzeiger(nachricht);
    tmp.setNf(nzKopf);
    nzKopf = tmp;
  }
}
