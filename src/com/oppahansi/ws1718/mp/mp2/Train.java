/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 */
package com.oppahansi.ws1718.mp.mp2;

public class Train {

    // Kann für die Ausgabe verwendet werden
    private static final String LOCOMOTIVE = "<___|o|";

    private Waggon head;

    // a
    public int getSize() {
        if (head == null) {
            return 0;
        } else {
            int size = 0;
            Waggon currentElement = head;

            while (currentElement != null) {
                size++;
                currentElement = currentElement.getNext();
            }

            return size;
        }
    }

    // b
    public int getPassengerCount() {
        if (head == null) {
            return 0;
        } else {
            int passengers = 0;
            Waggon currentElement = head;

            while (currentElement != null) {
                passengers += currentElement.getPassengers();
                currentElement = currentElement.getNext();
            }

            return passengers;
        }
    }

    // c
    public int getCapacity() {
        if (head == null) {
            return 0;
        } else {
            int capacity = 0;
            Waggon currentElement = head;

            while (currentElement != null) {
                capacity += currentElement.getCapacity();
                currentElement = currentElement.getNext();
            }

            return capacity;
        }
    }

    // d
    public void appendWaggon(Waggon waggon) {
        if (head == null) {
            head = waggon;
        } else {
            Waggon currentElement = head;

            while (currentElement.getNext() != null) {
                currentElement = currentElement.getNext();
            }

            currentElement.setNext(waggon);
        }
    }

    // e
    public void boardPassengers(int numberOfPassengers) {
        if (head != null) {
            Waggon currentElement = head;

            while (currentElement != null && numberOfPassengers > 0) {
                int freeSlots = currentElement.getCapacity() - currentElement.getPassengers();

                if (freeSlots >= numberOfPassengers) {
                    currentElement.setPassengers(currentElement.getPassengers() + numberOfPassengers);
                    return;
                } else {
                    currentElement.setPassengers(currentElement.getPassengers() + freeSlots);
                    numberOfPassengers -= freeSlots;
                }

                currentElement = currentElement.getNext();
            }
        }
    }

    // f
    public Train uncoupleWaggons(int index) {
        if (index < 0 || index >= getSize()) {
            return null;
        } else {
            Train uncoupledTrain = new Train();
            Waggon currentElement = head;
            int counter = 0;

            while (counter < index - 1) {
                counter++;
                currentElement = currentElement.getNext();
            }

            uncoupledTrain.head = currentElement.getNext();
            currentElement.setNext(null);

            return uncoupledTrain;
        }
    }

    // g
    public void insertWaggon(Waggon waggon, int index) {
        if (index < 0 || index >= getSize()) {
            appendWaggon(waggon);
        } else if (index == 0) {
            waggon.setNext(head);
            head = waggon;
        } else {
            Waggon currentElement = head;
            int counter = 0;

            while (counter < index - 1) {
                counter++;
                currentElement = currentElement.getNext();
            }

            waggon.setNext(currentElement.getNext());
            currentElement.setNext(waggon);
        }
    }

    // h
    public void turnOver() {
        Train turnedOverTrain = new Train();

        while (true) {
            Waggon currentElement = head;
            int counter = 0;

            if (getSize() == 1) {
                turnedOverTrain.appendWaggon(head);
                break;
            }

            while (counter < getSize() - 2) {
                counter++;
                currentElement = currentElement.getNext();
            }

            turnedOverTrain.appendWaggon(currentElement.getNext());
            currentElement.setNext(null);
        }

//        Alternative mit for Schleife

//        int size = getSize();
//
//        for (int i = 0; i < size; i++) {
//            Waggon currentElement = head;
//            int counter = 0;
//
//            if (getSize() == 1) {
//                turnedOverTrain.appendWaggon(head);
//                break;
//            }
//
//            while (counter < getSize() - 2) {
//                counter++;
//                currentElement = currentElement.getNext();
//            }
//
//            turnedOverTrain.appendWaggon(currentElement.getNext());
//            currentElement.setNext(null);
//        }

        head = turnedOverTrain.head;
    }

    // i
    public void removeWaggon(Waggon waggon) {
        if (waggon.equals(head)) {
            head = head.getNext();
        } else {
            Waggon currentElement = head;

            while (currentElement != null) {
                if (currentElement.getNext() != null && currentElement.getNext().equals(waggon)) {
                    currentElement.setNext(currentElement.getNext().getNext());
                    return;
                }

                currentElement = currentElement.getNext();
            }
        }
    }

    // j
    public Waggon getWaggonAt(int index) {
        if (index < 0 || index >= getSize()) {
            return null;
        } else {
            Waggon currentElement = head;
            int counter = 0;

            while (counter < index) {
                counter++;
                currentElement = currentElement.getNext();
            }

            return currentElement;
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

}
