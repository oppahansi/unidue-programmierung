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

import java.util.Scanner;

public class NutzerSchnittstelle {

  boolean init = true;
  Scanner s;
  private Kurznachrichtendienst dienst;

  public NutzerSchnittstelle(Kurznachrichtendienst dienst) {
    this.dienst = dienst;
  }

  private void hashtabelleAusgeben() {
    if (dienst.getHashtabelle() != null) {
      int l = (int) (Math.floor(Math.log10(dienst.getHashtabelle().length)) + 1);

      System.out.println("");
      for (int i = 0; i < dienst.getHashtabelle().length; i++) {
        System.out.format("\t|%0" + l + "d|=> ", i);

        for (HashKnoten k = dienst.getHashtabelle()[i]; k != null; k = k.getNf()) {

          int a = 0;
          for (Nachrichtenzeiger z = k.getNzKopf(); z != null; z = z.getNf()) a++;

          System.out.print("#" + k.getHashtag() + " [" + a + "] => ");
        }

        System.out.println("");
      }
    }
  }

  private int benutzerEingabe() {
    int auswahl = -1;
    if (init) init = false;
    else System.out.println("");

    System.out.println("[0]  Programm Beenden");
    System.out.println("[1]  Hashtabelle ausgeben");
    System.out.println("[2]  Nachrichten mit bestimmtem Hashtag anzeigen");
    System.out.println("[3]  Beispiel aus Abbildung 1 laden (Aufgabe 2d muss implementiert sein)");
    System.out.println("[4]  Nachricht verfassen (Aufgabe 2d)");
    System.out.println("[5]  Auf Nachricht antworten (Aufgabe 2e)");
    System.out.println("[6]  Loesche Nachricht (Aufgabe 2f)");
    System.out.println("[7]  Anzahl unterschiedlicher Hashtags ermitteln (Aufgabe 3a)");
    System.out.println(
        "[8]  Anzahl von Nachrichten in der Nachrichtenstruktur ermitteln (Aufgabe 3b)");
    System.out.println(
        "[9]  Durchschnittliche Anzahl an Nachrichtenzeigern pro HashKnoten ermitteln (Aufgabe 3c)");
    System.out.println(
        "[10] Anzahl von Nachrichte mit Mindestreferenztiefe ermitteln (Aufgabe 3d)");

    while (true) {
      try {
        System.out.print("> ");
        auswahl = Integer.parseInt(s.nextLine());
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }
    return auswahl;
  }

  private void beispielLaden() {
    dienst.neueNachricht("Student 1", "Beste Vorlesung #Programmierung #WS1617");
    dienst.neueNachricht("Student2", "Mist! Das war nix... #Testat2 #Programmierung");
    dienst.antworteAufNachricht("Student 1", "Ich fands einfach", 1);
  }

  private void nachrichtenZeigen() {
    String hashtag = "";
    while (true) {
      try {
        System.out.print("\tHashtag in der Form \"#xxxxx\" eingeben:\n\t> ");
        hashtag = s.nextLine();
        if (hashtag.charAt(0) == '#') break;
        else System.out.println("\tUngueltige Eingabe. Wiederholung...\n");
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }

    if (dienst.getHashtabelle() != null) {
      for (HashKnoten k : dienst.getHashtabelle()) {
        for (HashKnoten hk = k; hk != null; hk = hk.getNf()) {
          if (hk.getHashtag().equals(hashtag.substring(1))) {
            System.out.println("");
            for (Nachrichtenzeiger z = hk.getNzKopf(); z != null; z = z.getNf()) {
              System.out.println(
                  "\t("
                      + z.getNachricht().getId()
                      + ") "
                      + z.getNachricht().getVerfasser()
                      + ": \""
                      + z.getNachricht().getInhalt()
                      + "\"");
              int ref = 0;
              for (Nachricht r = z.getNachricht().getReferenz(); r != null; r = r.getReferenz()) {
                System.out.println(
                    "\t"
                        + tabs(++ref)
                        + "|=>  "
                        + "("
                        + r.getId()
                        + ") "
                        + r.getVerfasser()
                        + ": \""
                        + r.getInhalt()
                        + "\"");
              }
            }
          }
        }
      }
    }
  }

  private String tabs(int n) {
    String s = "";
    for (int i = 0; i < n - 1; i++) {
      s += "     ";
    }
    return s;
  }

  private void a2d() {
    System.out.println("\tGeben Sie Ihren Namen ein:");
    String name = "";
    while (true) {
      try {
        System.out.print("\t> ");
        name = s.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }

    System.out.println("\tGeben Sie eine Nachricht ein:");
    String st = "";
    while (true) {
      try {
        System.out.print("\t> ");
        st = s.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }

    System.out.println("\tNachricht gespeichert");
    dienst.neueNachricht(name, st);
  }

  private void a2e() {
    System.out.println("\tGeben Sie Ihren Namen ein:");
    String name = "";
    while (true) {
      try {
        System.out.print("\t> ");
        name = s.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }

    System.out.println("\tGeben Sie die Id der Nachricht ein, auf die Sie antworten m�chten:");
    int id;
    while (true) {
      try {
        System.out.print("\t> ");
        id = Integer.parseInt(s.nextLine());
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }

    System.out.println("\tGeben Sie eine Nachricht ein:");
    String st = "";
    while (true) {
      try {
        System.out.print("\t> ");
        st = s.nextLine();
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }
    System.out.println("\tNachricht gespeichert");
    dienst.antworteAufNachricht(name, st, id);
  }

  private void a2f() {
    System.out.println("\tGeben Sie die Id der Nachricht ein, die geloescht werden soll:");
    int id;
    while (true) {
      try {
        System.out.print("\t> ");
        id = Integer.parseInt(s.nextLine());
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }
    System.out.println("\tNachricht geloescht");
    dienst.loescheNachricht(id);
  }

  private void a3a() {
    System.out.println(
        "\tAnzahl unterschiedlicher Hashtags: " + dienst.anzahlUnterschiedlicheHashtags());
  }

  private void a3b() {
    System.out.println("\tAnzahl von Nachrichten: " + dienst.anzahlNachrichten());
  }

  private void a3c() {
    System.out.println(
        "\tDurchschnittliche Anzahl an Nachrichtenzeigern pro HashKnoten: "
            + dienst.verhaeltnisZeigerZuHashKnoten());
  }

  private void a3d() {
    int n;
    System.out.println("\tGeben Sie die Referenztiefe ein:");
    while (true) {
      try {
        System.out.print("\t> ");
        n = Integer.parseInt(s.nextLine());
        break;
      } catch (Exception e) {
        System.out.println("\tUngueltige Eingabe. Wiederholung...");
      }
    }

    System.out.println(
        "\tAnzahl von Nachrichten mit Mindestreferenztiefe "
            + n
            + ": "
            + dienst.anzahlNachrichtenMindestReferenztiefe(n));
  }

  public void start() {
    s = new Scanner(System.in);

    int auswahl;

    while (true) {
      auswahl = benutzerEingabe();
      switch (auswahl) {
        case 0:
          s.close();
          System.out.println("\t Programm beendet!\n\t==================");
          return;
        case 1:
          hashtabelleAusgeben();
          break;
        case 2:
          nachrichtenZeigen();
          break;
        case 3:
          beispielLaden();
          break;
        case 4:
          a2d();
          break;
        case 5:
          a2e();
          break;
        case 6:
          a2f();
          break;
        case 7:
          a3a();
          break;
        case 8:
          a3b();
          break;
        case 9:
          a3c();
          break;
        case 10:
          a3d();
          break;
        default:
          System.out.println("\tUngueltige Eingabe. Wiederholung...");
          break;
      }
    }
  }
}
