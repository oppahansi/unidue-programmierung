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

public class Nachricht {

  private int id;
  private String inhalt;
  private String verfasser;
  private String[] hashTags;
  private Nachricht referenz;

  // TODO AUFGABE 1a
  public Nachricht(String verfasser, String inhalt, int id) {
    this.verfasser = verfasser;
    this.inhalt = inhalt;
    this.id = id;
    String[] tmp = inhalt.split(" "); //"hallo mein name ist bla #HT1 #HT2 #HT3"
    String allHashtags = "";
    for (String word : tmp) if (word.charAt(0) == '#') allHashtags += word; //"#HT1#HT2#HT3"
    if (allHashtags != "") allHashtags = allHashtags.substring(1);
    this.hashTags = allHashtags.split("#");
  }

  public int getId() {
    return id;
  }

  public String getInhalt() {
    return inhalt;
  }

  public void setInhalt(String inhalt) {
    this.inhalt = inhalt;
  }

  public String getVerfasser() {
    return verfasser;
  }

  public void setVerfasser(String verfasser) {
    this.verfasser = verfasser;
  }

  public String[] getHashTags() {
    return hashTags;
  }

  public void setHashTags(String[] hashTags) {
    this.hashTags = hashTags;
  }

  public Nachricht getReferenz() {
    return referenz;
  }

  public void setReferenz(Nachricht referenz) {
    this.referenz = referenz;
  }
}
