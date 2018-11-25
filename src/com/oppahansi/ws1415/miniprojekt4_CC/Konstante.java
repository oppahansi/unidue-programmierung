/*
 * Class has been added by oppahansi.
 *
 * <p>For learning purpose only.
 *
 * <p>Reformatted by oppahansi - Clean Code Version
 */
package com.oppahansi.ws1415.miniprojekt4_CC;

public class Konstante {

  public static final String[] AERZTE =
      new String[] {
        "Dr. Scheel Viktor",
        "Dr. Luther Christoph",
        "Dr.Schreiner Kevin",
        "Dr. " + "Goldbach Sabina",
        "Dr. Schuman Alexandra",
        "" + "Dr. David Jacob",
        "Dr. Hutton",
        "Dr. Schaueble Manfred",
        "Dr. Bohlen Alex",
        "" + "Dr.Schummacher Katharina",
        "Dr. Wagner Christian",
        "Dr.Lehman steven",
        "Dr. Laila Mansour",
        "Dr. Kamilion antonova",
        "" + "Dr. Octavia irene",
        "Dr. Thomson Emanuel",
        "Dr. Ernst Michael",
        "Dr. Severin David",
        "Dr. Maximilian Christian",
        "" + "Dr. Weber Michael",
        "Dr. Anton axel",
        "Dr. Dorloff Hamid",
        "Dr. Goldbach Daniel",
        "Dr. Petrow Erik",
        "" + "Dr. Bethofen Uwe",
        "Dr. Alfred Servantes",
        "Dr. Santos Armin",
        "Dr. Thomas Ingo",
        "Dr. Perez Alexanda"
      };

  public static final Station[] STATIONEN =
      new Station[] {
        new Station(1, "Innere Medizin", 10, 4),
        new Station(2, "Intensiv Medizin", 12, 6),
        new Station(3, "Unfallchirurgie", 12, 6),
        new Station(4, "Orthopaedie", 20, 6),
        new Station(5, "Onkologie", 8, 4),
        new Station(6, "Schlafmedizin", 4, 2),
        new Station(7, "Gynaekologie", 10, 6),
        new Station(8, "Urologie", 8, 2)
      };

  public static final Diagnose DIAGNOSEN[] =
      new Diagnose[] {
        new Diagnose("S63.0", AERZTE[1], 0, 0),
        new Diagnose("E04.09", AERZTE[0], 3, 2),
        new Diagnose("B75", AERZTE[4], 2, 0),
        new Diagnose("R12", AERZTE[5], 0, 0),
        new Diagnose("I21.9", AERZTE[4], 3, 1),
        new Diagnose("S80", AERZTE[3], 0, 0),
        new Diagnose("C93.1", AERZTE[12], 6, 1),
        new Diagnose("G47.4", AERZTE[16], 0, 0),
        new Diagnose("O04.4", AERZTE[20], 0, 0)
      };

  public static final Medikament[] MEDIKAMENTE =
      new Medikament[] {
        new Medikament("Katadolon", "Flupirtin", "Tabletten", 5.00f),
        new Medikament("Jodid", "Jod", "Tabletten", 1.54f),
        new Medikament("Axium", "Levothyroxin", "Tabletten", 14.11f),
        new Medikament("Rs2", "Radionuklide", "Spritze", 20.22f),
        new Medikament("Lthyroxin", "Eutorox", "Tabletten", 7.05f),
        new Medikament("Mebendazol", "Benzimidazolen", "Infusion", 13.55f),
        new Medikament("Retterspitz", "", "Saft", 12.5f),
        new Medikament("Godamed", "Acetylsalicylsaeure", "Tabletten", 4.5f),
        new Medikament("Anaesthesikum", "Fentanyl und Opiat", "Infusion", 4.75f),
        new Medikament("Dipidolor", "Morphin", "Infusion", 5.9f),
        new Medikament("Aktren", "Ibuprofon", "Tabletten", 6.9f),
        new Medikament("propal", "Propolis", "Creme", 7.9f),
        new Medikament("Bluttransfusion", "Blutkoerperchen", "Infusion", 250.5f),
        new Medikament("Dolgit 800", "Ibuprofon", "Tabletten", 19.78f),
        new Medikament("Vigil", "Modafin", "Tabletten", 10.7f)
      };
}
