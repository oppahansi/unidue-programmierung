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

public class Kurznachrichtendienst {

  private static HashKnoten[] hashtabelle;
  private int nachrichtenId = 0;

  // TODO AUFGABE 2a
  public Kurznachrichtendienst(int hashlaenge) {
    this.hashtabelle = new HashKnoten[hashlaenge];
  }

  public int getNachrichtenId() {
    return nachrichtenId;
  }

  public void setNachrichtenId(int nachrichtenId) {
    this.nachrichtenId = nachrichtenId;
  }

  public HashKnoten[] getHashtabelle() {
    return hashtabelle;
  }

  public void setHashtabelle(HashKnoten[] hashtabelle) {
    this.hashtabelle = hashtabelle;
  }

  // TODO AUFGABE 2b
  public int hashfunktion(String s) {
    int hashwert = 1;
    for (int i = 0; i <= s.length() - 1; i++) {
      hashwert += s.charAt(i) * savePow(i);
    }
    hashwert %= hashtabelle.length;
    return hashwert < 0 ? hashwert + hashtabelle.length : hashwert;
  }

  private int savePow(int i) {
    int tmp = 1;
    for (int j = 0; j < i; j++) {
      tmp = (tmp * 256) % hashtabelle.length;
    }
    //  if(tmp<0) return tmp+hashtabelle.length; return tmp;
    return tmp < 0 ? tmp + hashtabelle.length : tmp;
  }

  // TODO AUFGABE 2c
  public void sortiereNachrichtEin(Nachricht nachricht) {
    for (String hashtag : nachricht.getHashTags()) {
      int hash = hashfunktion(hashtag);
      if (hashtabelle[hash] == null) {
        HashKnoten tmp = new HashKnoten(hashtag, nachricht);
        hashtabelle[hash] = tmp;
      } else {
        if (hashtag.compareTo(hashtabelle[hash].getHashtag()) < 0) {
          HashKnoten tmp = new HashKnoten(hashtag, nachricht);
          tmp.setNf(hashtabelle[hash]);
          hashtabelle[hash] = tmp;
        } else {
          HashKnoten current = hashtabelle[hash];
          while (current != null) {
            if (hashtag.compareTo(current.getHashtag()) == 0) {
              current.fuegeNachrichtEin(nachricht);
              break;
            } else {
              if (current.getNf() != null && hashtag.compareTo(current.getNf().getHashtag()) < 0) {
                HashKnoten tmp = new HashKnoten(hashtag, nachricht);
                tmp.setNf(current.getNf());
                current.setNf(tmp);
                break;
              } else {
                if (current.getNf() == null) {
                  current.setNf(new HashKnoten(hashtag, nachricht));
                  break;
                }
              }
            }
            current = current.getNf();
          }
        }
      }
    }
  }

  // TODO AUFGABE 2d
  public void neueNachricht(String verfasser, String inhalt) {
    sortiereNachrichtEin(new Nachricht(verfasser, inhalt, nachrichtenId));
    nachrichtenId++;
  }

  // TODO AUFGABE 2e
  public void antworteAufNachricht(String verfasser, String inhalt, int id) {
    Nachricht neueNachricht = new Nachricht(verfasser, inhalt, nachrichtenId++);
    Nachricht other = getMessageByID(id);
    if (other != null) {
      String[] allHashtags =
          new String[neueNachricht.getHashTags().length + other.getHashTags().length];
      for (int i = 0; i < other.getHashTags().length; i++) allHashtags[i] = other.getHashTags()[i];
      for (int i = 0; i < neueNachricht.getHashTags().length; i++)
        allHashtags[i + other.getHashTags().length] = neueNachricht.getHashTags()[i];
      neueNachricht.setHashTags(allHashtags);
    }
    sortiereNachrichtEin(neueNachricht);
  }

  private Nachricht getMessageByID(int id) {
    Nachrichtenzeiger[] nz = getAllNachrichtenzeiger();
    for (Nachrichtenzeiger single : nz) {
      if (single.getNachricht().getId() == id) return single.getNachricht();
    }
    return null;
  }

  private Nachrichtenzeiger[] getAllNachrichtenzeiger() {
    int counter = 0;
    for (HashKnoten hashknotenKopf : hashtabelle) {
      HashKnoten hashknoten = hashknotenKopf;
      while (hashknoten != null) {
        Nachrichtenzeiger nz = hashknoten.getNzKopf();
        while (nz != null) {
          nz = nz.getNf();
          counter++;
        }
        hashknoten = hashknoten.getNf();
      }
    }
    Nachrichtenzeiger[] allNZ = new Nachrichtenzeiger[counter];
    counter = 0;
    for (HashKnoten hashknotenKopf : hashtabelle) {
      HashKnoten hashknoten = hashknotenKopf;
      while (hashknoten != null) {
        Nachrichtenzeiger nz = hashknoten.getNzKopf();
        while (nz != null) {
          nz = nz.getNf();
          allNZ[counter] = nz;
          counter++;
        }
        hashknoten = hashknoten.getNf();
      }
    }
    return allNZ;
  }

  // TODO AUFGABE 2f
  public void loescheNachricht(int id) {
    Nachricht toBeDeleted = getMessageByID(id);
    if (hasReference(toBeDeleted)) {
      //toBeDeleted.setReferenz(null);
      String newMessage = "<geloeschte Nachricht>";
      for (String hashtag : toBeDeleted.getHashTags()) newMessage += " #" + hashtag;
      toBeDeleted.setInhalt(newMessage);
    } else {
      for (HashKnoten hashknoten : hashtabelle) {
        HashKnoten currentHK = hashknoten;
        while (currentHK != null) {
          Nachrichtenzeiger nz = currentHK.getNzKopf();
          while (nz != null) {
            if (nz.getNachricht() == toBeDeleted) { //am Kopf des Hashknoten
              currentHK.setNzKopf(nz.getNf());
            } else {
              if (nz.getNf() != null && nz.getNachricht() == toBeDeleted) {
                nz.setNf(nz.getNf().getNf());
              }
              nz = nz.getNf();
            }
            if (currentHK.getNzKopf() == null) {
              deleteEmptyHK(currentHK);
            }
            currentHK = currentHK.getNf();
          }
        }
      }
      if (toBeDeleted.getReferenz() != null) {
        if (toBeDeleted.getReferenz().getInhalt().contains("<geloeschte Nachricht>")) {
          loescheNachricht(toBeDeleted.getReferenz().getId());
        }
      }
    }
  }

  private void deleteEmptyHK(HashKnoten currentHK) {
    HashKnoten hashknoten = hashtabelle[hashfunktion(currentHK.getHashtag())];
    if (hashknoten == currentHK)
      hashtabelle[hashfunktion(currentHK.getHashtag())] = currentHK.getNf();
    else {
      while (hashknoten != null) {
        if (hashknoten.getNf() == currentHK) {
          hashknoten.setNf(hashknoten.getNf().getNf());
        }
        hashknoten = hashknoten.getNf();
      }
    }
  }

  private boolean hasReference(Nachricht toBeDeleted) {
    Nachrichtenzeiger[] allNZ = getAllNachrichtenzeiger();
    for (Nachrichtenzeiger nz : allNZ) {
      if (nz.getNachricht().getReferenz() == toBeDeleted) return true;
    }
    return false;
  }

  // TODO AUFGABE 3a
  public int anzahlUnterschiedlicheHashtags() {
    int counter = 0;
    for (HashKnoten HKTabelle : hashtabelle) {
      HashKnoten hashknoten = HKTabelle;
      while (hashknoten != null) {
        counter++;
        hashknoten = hashknoten.getNf();
      }
    }
    return counter;
  }

  // TODO AUFGABE 3b
  public int anzahlNachrichten() {
    Nachrichtenzeiger[] allNZ = getAllNachrichtenzeiger();
    Nachricht[] tmp = new Nachricht[allNZ.length];
    for (Nachrichtenzeiger currentNZ : allNZ) {
      for (int i = 0; i < tmp.length; i++) {
        if (tmp[i] == null) {
          tmp[i] = currentNZ.getNachricht();
          break;
        } else {
          if (tmp[i] == currentNZ.getNachricht()) break;
        }
      }
    }
    int counter = 0;
    for (Nachricht nachricht : tmp) {
      if (nachricht != null) counter++;
    }
    return counter;
  }

  // TODO AUFGABE 3c
  public double verhaeltnisZeigerZuHashKnoten() {
    int counter = anzahlUnterschiedlicheHashtags();
    double anzahlNZ = getAllNachrichtenzeiger().length * 1.0;
    if (anzahlNZ == 0 || counter == 0) return -1;
    else return anzahlNZ / (counter * 1.0);
  }

  // TODO Aufgabe 3d
  public int anzahlNachrichtenMindestReferenztiefe(int n) {
    Nachrichtenzeiger[] allNZ = getAllNachrichtenzeiger();
    Nachricht[] tmp = new Nachricht[allNZ.length];
    for (Nachrichtenzeiger currentNZ : allNZ) {
      for (int i = 0; i < tmp.length; i++) {
        if (tmp[i] == null) {
          tmp[i] = currentNZ.getNachricht();
          break;
        } else {
          if (tmp[i] == currentNZ.getNachricht()) break;
        }
      }
    }
    int counter = 0;
    for (Nachricht nachricht : tmp) {
      if (getReferenceDepth(nachricht) >= n) counter++;
    }
    return counter;
  }

  private int getReferenceDepth(Nachricht nachricht) {
    if (nachricht == null) return -1;
    return getReferenceDepth(nachricht, 0);
  }

  private int getReferenceDepth(Nachricht nachricht, int i) {
    if (nachricht.getReferenz() == null) return i;
    else {
      i++;
      return getReferenceDepth(nachricht, i);
    }
  }

  private int getRefenceDepth2(Nachricht nachricht) {
    if (nachricht == null) return -1;
    if (nachricht.getReferenz() == null) return 0;
    else {
      return getRefenceDepth2(nachricht) + 1;
    }
  }
}
