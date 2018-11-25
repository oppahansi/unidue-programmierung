/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp3;

public class Train {

  // Kann für die Ausgabe verwendet werden
  private static final String LOCOMOTIVE = "<___|o|";

  private Waggon head;

  public int getSize() {
    if (getHead() == null) {
      return 0;
    } else {
      return countWaggons();
    }
  }

  private int countWaggons() {
    Waggon currentWaggon = getHead();
    int size = 0;

    while (currentWaggon != null) {
      size++;
      currentWaggon = currentWaggon.getNext();
    }

    return size;
  }

  public int getPassengerCount() {
    if (getSize() == 0) {
      return 0;
    } else {
      return countPassengers();
    }
  }

  private int countPassengers() {
    Waggon currentWaggon = getHead();
    int passengersSum = 0;

    while (currentWaggon != null) {
      passengersSum += currentWaggon.getPassengers();
      currentWaggon = currentWaggon.getNext();
    }

    return passengersSum;
  }

  public int getCapacity() {
    if (getSize() == 0) {
      return 0;
    } else {
      return calculateCapacity();
    }
  }

  private int calculateCapacity() {
    Waggon currentWaggon = getHead();
    int capacity = 0;

    while (currentWaggon != null) {
      capacity += currentWaggon.getCapacity();
      currentWaggon = currentWaggon.getNext();
    }

    return capacity;
  }

  public void appendWaggon(Waggon waggon) {
    if (getHead() == null) {
      setHead(waggon);
    } else {
      if (getSize() == 1) {
        getHead().setNext(waggon);
      } else {
        if (getSize() > 1) {
          getLastWaggon().setNext(waggon);
        }
      }
    }
  }

  private Waggon getLastWaggon() {
    if (getSize() == 1) {
      return getHead();
    } else {
      Waggon currentWagon = getHead();

      while (currentWagon.getNext() != null) {
        currentWagon = currentWagon.getNext();
      }

      return currentWagon;
    }
  }

  public void boardPassengers(int numberOfPassengers) {
    if (getHead() != null && numberOfPassengers > 0) {
      Waggon currentWaggon = getFirstWaggonWithFreeSlots();

      while (currentWaggon != null) {
        if (numberOfPassengers > 0) {
          int freeSlots = currentWaggon.getCapacity() - currentWaggon.getPassengers();

          if (freeSlots >= numberOfPassengers) {
            currentWaggon.setPassengers(currentWaggon.getPassengers() + numberOfPassengers);
            break;
          } else {
            currentWaggon.setPassengers(currentWaggon.getCapacity());
            numberOfPassengers -= freeSlots;
          }
        } else {
          break;
        }

        currentWaggon = currentWaggon.getNext();
      }
    }
  }

  private Waggon getFirstWaggonWithFreeSlots() {
    Waggon currentWaggon = getHead();

    while (currentWaggon != null) {
      if (currentWaggon.getCapacity() - currentWaggon.getPassengers() > 0) {
        return currentWaggon;
      }

      currentWaggon = currentWaggon.getNext();
    }

    return null;
  }

  public Train uncoupleWaggons(int index) {
    if (index > 0 && index < getSize()) {
      Train newTrain = new Train();
      Waggon lastWaggonInTrain = getWaggonAt(index - 1);

      newTrain.setHead(lastWaggonInTrain.getNext());
      lastWaggonInTrain.setNext(null);

      return newTrain;
    } else {
      return null;
    }
  }

  public void insertWaggon(Waggon waggon, int index) {
    if (index >= getSize()) {
      appendWaggon(waggon);
    } else if (index >= 0 && index <= getSize() - 1) {
      if (index == 0) {
        Waggon next = getHead();
        setHead(waggon);
        getHead().setNext(next);
      } else {
        Waggon next = getWaggonAt(index - 1);
        waggon.setNext(next.getNext());
        next.setNext(waggon);
      }
    }
  }

  public void turnOver() {
    Train turnedOverTrain = new Train();

    for (int i = getSize() - 1; i >= 0; i--) {
      turnedOverTrain.appendWaggon(getLastWaggon());
      removeWaggon(getLastWaggon());
    }

    setHead(turnedOverTrain.getHead());
  }

  public void removeWaggon(Waggon waggon) {
    if (waggon != null && getSize() > 0) {
      int waggonsPosition = getIndexByWaggon(waggon);

      if (waggonsPosition != -1) {
        if (waggonsPosition == 0) {
          setHead(getHead().getNext());
        } else if (waggonsPosition == getSize() - 1 && getSize() == 2) {
          getHead().setNext(null);
        } else {
          Waggon prev = getWaggonAt(waggonsPosition - 1);
          Waggon next = getWaggonAt(waggonsPosition + 1);
          prev.setNext(next);
        }
      }
    }
  }

  private int getIndexByWaggon(Waggon waggon) {
    if (waggon != null) {
      if (waggon.equals(getHead())) {
        return 0;
      } else if (waggon.equals(getLastWaggon())) {
        return getSize() - 1;
      } else {
        Waggon currentWaggon = getHead().getNext();
        int position = 1;

        while (currentWaggon != null) {
          if (currentWaggon.equals(waggon)) {
            return position;
          }

          position++;
          currentWaggon = currentWaggon.getNext();
        }

        return -1;
      }
    } else {
      return -1;
    }
  }

  public Waggon getWaggonAt(int index) {
    if (index < 0 && index >= getSize()) {
      return null;
    } else {
      if (index == 0) {
        return getHead();
      } else if (index == getSize() - 1) {
        return getLastWaggon();
      } else {
        Waggon currentWagon = getHead();
        int position = 0;

        while (position != index && currentWagon != null) {
          position++;
          currentWagon = currentWagon.getNext();
        }

        return currentWagon;
      }
    }
  }

  @Override
  public String toString() {
    if (getSize() == 0) {
      return LOCOMOTIVE;
    }

    StringBuilder str = new StringBuilder(LOCOMOTIVE);

    Waggon pointer = head;
    while (pointer != null) {
      str.append(" <---> ");
      str.append(pointer.getName());
      pointer = pointer.getNext();
    }

    return str.toString();
  }

  public Waggon getHead() {
    return head;
  }

  public void setHead(final Waggon head) {
    this.head = head;
  }
}
