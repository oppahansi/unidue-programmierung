package com.oppahansi.ss14.gameoflife;

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
  public GameOfLife(int sizeX, int sizeY) {
    this.board = new byte[sizeX][sizeY];
  }

  /* Gibt das Feld board zurück (wird für die Anzeige innerhalb der GameOfLifeGUI benötigt) */
  public byte[][] getBoard() {
    return board;
  }

  /* Weist jeder Zelle innerhalb des Spielfelds einen zufälligen Wert zu */
  public void shuffleBoard() {
    // Hinweis: Die Methode getRandomNumber() kann verwendet werden, um eine
    // Zufallszahl (0 oder 1) zu erhalten
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = getRandomNumber();
      }
    }
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
    if (x > 2 * board.length) {
      return translateX(x - board.length);

    } else if (x > board.length) {
      return x % board.length;
    } else if (x == board.length) {
      return 0;
    } else if (x < 0) {
      x *= -1;
      return translateX(board.length - x);
    } else {
      return x;
    }
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
    if (y > 2 * board[0].length) {
      return translateY(y - board[0].length);

    } else if (y > board[0].length) {
      return y % board[0].length;

    } else if (y == board[0].length) {
      return 0;
    } else if (y < 0) {
      y *= -1;
      return translateY(board[0].length - y);
    } else {
      return y;
    }
  }

  /* Gibt zurück, ob die Zelle mit dem Index (posX,posY) lebendig ist. */
  public boolean isAlive(int posX, int posY) {
    boolean alive = false;

    if (board[posX][posY] == 1) {
      alive = true;
    } else {
      alive = false;
    }

    return alive;
  }

  /* Gibt die Anzahl der lebendigen Nachbarzellen einer Zelle mit dem Index (posX, posY) zurück. */
  public int countNeighbours(int posX, int posY) {
    // Sonderfälle an den Rändern beachten!
    int counter = 0;
    if (board[translateX(posX - 1)][translateY(posY)] == 1) {
      counter++;
    }
    if (board[translateX(posX - 1)][translateY(posY - 1)] == 1) {
      counter++;
    }
    if (board[translateX(posX)][translateY(posY - 1)] == 1) {
      counter++;
    }
    if (board[translateX(posX + 1)][translateY(posY - 1)] == 1) {
      counter++;
    }
    if (board[translateX(posX + 1)][translateY(posY)] == 1) {
      counter++;
    }
    if (board[translateX(posX + 1)][translateY(posY + 1)] == 1) {
      counter++;
    }
    if (board[translateX(posX)][translateY(posY + 1)] == 1) {
      counter++;
    }
    if (board[translateX(posX - 1)][translateY(posY + 1)] == 1) {
      counter++;
    }

    return counter;
  }

  // ------------------------------------------------------------------

  /* Berechnet die nächste Generation */
  public void step() {
    // Auf Basis des aktuellen Zustands von board soll die nächste
    // Generation berechnet werden. Dazu muss für die jeweiligen Zellen
    // die Anzahl der lebendigen Nachbarn gezählt und die entsprechenden
    // Regeln angewendet werden.
    byte[][] nextGenBoard = new byte[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (isAlive(i, j) && countNeighbours(i, j) < 2) {
          nextGenBoard[i][j] = 0;
        } else if (isAlive(i, j) && (countNeighbours(i, j) == 2 || countNeighbours(i, j) == 3)) {
          nextGenBoard[i][j] = 1;
        } else if (isAlive(i, j) && countNeighbours(i, j) > 3) {
          nextGenBoard[i][j] = 0;
        } else if (!isAlive(i, j) && countNeighbours(i, j) == 3) {
          nextGenBoard[i][j] = 1;
        }
      }
    }
    board = nextGenBoard;
  }

  private byte getRandomNumber() {
    return random.nextBoolean() ? (byte) 1 : 0;
  }
}
