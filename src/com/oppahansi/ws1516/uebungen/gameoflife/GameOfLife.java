/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.uebungen.gameoflife;

import java.util.Random;

public class GameOfLife {

  final Random random = new Random();
  // Spielfeld mit [ZEILEN][SPALTEN]. Hat ein Element den Wert 1, lebt die
  // Zelle in dem entsprechenden Feld. Hat sie den Wert 0, ist sie tot
  private byte[][] board;

  /*
   * Konstruktor initialisiert das Feld board als neues byte-Array der Größe sizeX x sizeY
   *
   * @param sizeX Anzahl der Spalten des Spielfelds
   * @param sizeY Anzahl der Zeilen des Spielfelds
   */
  public GameOfLife(int sizeX, int sizeY) {}

  /* Gibt das Feld board zurück (wird für die Anzeige innerhalb der GameOfLifeGUI benötigt) */
  public byte[][] getBoard() {
    return board;
  }

  /* Weist jeder Zelle innerhalb des Spielfelds einen zufälligen Wert zu */
  public void shuffleBoard() {
    // Hinweis: Die Methode getRandomNumber() kann verwendet werden, um eine
    // Zufallszahl (0 oder 1) zu erhalten
  }

  /*
   * HILFSMETHODE
   *
   * <p>Bildet eine x-Koordinate, die eigentlich außerhalb des board-Bereiches liegt, auf die
   * entsprechende Koordinate innerhalb des Spielfelds ab. Dies ist notwendig, um dem Feld die Form
   * eines Torus zu geben (der linke Rand "klebt" sozusagen am rechten Rand).
   *
   * <p>Beispiel: Angenommen, das Spielfeld hat 4 Spalten: - translateX(0) -> 0 - translateX(1) -> 1
   * - translateX(12) -> 0 - translateX(19) -> 3 - translateX(-1) -> 3 - translateX(-2) -> 2 -
   * translateX(-4) -> 0 - translateX(-5) -> 3
   */
  private int translateX(int x) {
    // Der Körper dieser Methode ist nur ein Dummy, damit diese Klasse
    // kompiliert.
    //
    // Hinweis: Zur Implementierung dieser Methode gemäß der obigen
    // Spezifikation kann der Modulo-Operator (%) hilfreich sein.
    return x;
  }

  /*
   * HILFSMETHODE
   *
   * <p>Bildet eine y-Koordinate, die eigentlich außerhalb des board-Bereiches liegt, auf die
   * entsprechende Koordinate innerhalb des Spielfelds ab. Dies ist notwendig, um dem Feld die Form
   * eines Torus zu geben (der obere Rand "klebt" sozusagen am unteren Rand).
   *
   * <p>Beispiel: Angenommen, das Spielfeld hat 5 Zeilen: - translateY(0) -> 0 - translateY(1) -> 1
   * - translateY(12) -> 2 - translateY(19) -> 4 - translateY(-1) -> 4 - translateY(-2) -> 3 -
   * translateY(-4) -> 1 - translateY(-6) -> 4
   */
  private int translateY(int y) {
    // Der Körper dieser Methode ist nur ein Dummy, damit diese Klasse
    // kompiliert.
    //
    // Hinweis: Zur Implementierung dieser Methode gemäß der obigen
    // Spezifikation kann der Modulo-Operator (%) hilfreich sein.
    return y;
  }

  /* Gibt zurück, ob die Zelle mit dem Index (posX,posY) lebendig ist. */
  public boolean isAlive(int posX, int posY) {
    return false;
  }

  /* Gibt die Anzahl der lebendigen Nachbarzellen einer Zelle mit dem Index (posX, posY) zurück. */
  public int countNeighbours(int posX, int posY) {
    // Sonderfälle an den Rändern beachten!
    return 0;
  }

  // ------------------------------------------------------------------

  /* Berechnet die nächste Generation */
  public void step() {
    // Auf Basis des aktuellen Zustands von board soll die nächste
    // Generation berechnet werden. Dazu muss für die jeweiligen Zellen
    // die Anzahl der lebendigen Nachbarn gezählt und die entsprechenden
    // Regeln angewendet werden.
  }

  private byte getRandomNumber() {
    return random.nextBoolean() ? (byte) 1 : 0;
  }
}
