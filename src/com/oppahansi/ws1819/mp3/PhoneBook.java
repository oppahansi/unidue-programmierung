/*
 * Created by: University of Duisburg-Essen, paluno -The Ruhr Institute for Software Technology
 *
 * <p>For learning purpose only.
 *
 */
package com.oppahansi.ws1819.mp3;

import java.util.Arrays;

public class PhoneBook {

    private Person root;

    // NICHT aendern
    public PhoneBook() {
        //Dieser Konstruktor darf von Ihnen nicht veraendert werden.
        //Falls Sie einen weiteren Konstruktor benoetigen, so koennen Sie diesen jedoch gerne hinzufuegen.
    }

    // Aufgabe 1
    // Die Methodensignatur darf NICHT geaendert werden
    public void insertPerson(String lastName, String firstName, int number, boolean married) {
        root = insertPerson(root, new Person(lastName, firstName, number, married));
    }

    // Rueckgabetyp und Parametrisierung dieser Methode duerfen geaendert werden!
    private Person insertPerson(Person currentRoot, Person newPerson) {
        if (currentRoot == null) {
            return newPerson;
        }

        if (compareTwoPersons(newPerson, currentRoot) < 0) {
            currentRoot.setLeftSuccessor(insertPerson(currentRoot.getLeftSuccessor(), newPerson));
        } else if (compareTwoPersons(newPerson, currentRoot) > 0) {
            currentRoot.setRightSuccessor(insertPerson(currentRoot.getRightSuccessor(), newPerson));
        } else {
            return currentRoot;
        }

        return currentRoot;
    }

    // Aufgabe 2
    // Die Methodensignatur darf NICHT geaendert werden
    public boolean findPerson(String lastName, String firstName, int number) {
        return findPerson(new Person(lastName, firstName, number, false), root);
    }

    // Rueckgabetyp und Parametrisierung dieser Methode duerfen geaendert werden!
    private boolean findPerson(Person wanted, Person currentRoot) {
        if (currentRoot == null) {
            return false;
        }

        int comparisonResult = compareTwoPersons(wanted, currentRoot);
        if (comparisonResult == 0) {
            return true;
        }

        return comparisonResult < 0 ?
                findPerson(wanted, currentRoot.getLeftSuccessor()) :
                findPerson(wanted, currentRoot.getRightSuccessor());
    }

    // Aufgabe 3
    // Die Methodensignatur darf NICHT geaendert werden
    public int countAllPersons() {
        return countAllPersons(root);
    }

    // Rueckgabetyp und Parametrisierung dieser Methode duerfen geaendert werden!
    public int countAllPersons(Person currentRoot) {
        if (currentRoot == null) return 0;
        return 1 + countAllPersons(currentRoot.getLeftSuccessor()) + countAllPersons(currentRoot.getRightSuccessor());
    }

    // Aufgabe 4
    // Die Methodensignatur darf NICHT geaendert werden
    public Person[] findAllPersonsByFirstName(String firstName) {
        if (firstName == null) {
            return null;
        } else {
            Person[] people = phoneBookToArray();
            Person[] result = new Person[0];

            for (Person currentPerson : people) {
                if (currentPerson.getFirstName().compareTo(firstName) == 0) {
                    result = merge(result, new Person[] { currentPerson });
                }
            }

            return result;
        }
    }

    // Rueckgabetyp und Parametrisierung dieser Methode duerfen geaendert werden!
    private Person[] findAllPersonsByFirstName(String firstName, Person currentNode) {
        return null;
    }

    private Person[] phoneBookToArray() {
        Person[] tree = { root };
        Person[] left = divide(root.getLeftSuccessor());
        Person[] right = divide(root.getRightSuccessor());

        return merge(merge(tree, left), right);
    }

    private Person[] divide(Person currentRoot) {
        if (currentRoot == null) {
            return new Person[0];
        } else {
            Person[] currentTree = { currentRoot };
            Person[] right = divide(currentRoot.getRightSuccessor());
            Person[] left = divide(currentRoot.getLeftSuccessor());

            currentTree = merge(currentTree, right);
            currentTree = merge(currentTree, left);

            return currentTree;
        }
    }

    private Person[] merge(Person[] currentTree, Person[] partialTree) {
        Person[] merged = new Person[currentTree.length + partialTree.length];

        for (int i = 0; i < currentTree.length; i++) {
            merged[i] = currentTree[i];
        }
        for (int i = currentTree.length; i < currentTree.length + partialTree.length; i++) {
            merged[i] = partialTree[i - currentTree.length];
        }

        return merged;
    }

    // Aufgabe 5
    // Die Methodensignatur darf NICHT geaendert werden
    public void marryTheHochzeits() {
        marryTheHochzeits(root);
    }

    // Rueckgabetyp und Parametrisierung dieser Methode duerfen geaendert werden!
    private void marryTheHochzeits(Person currentRoot) {
        if (currentRoot != null) {
            marryTheHochzeits(currentRoot.getLeftSuccessor());
            if (currentRoot.getLastName().compareTo("Hochzeit") == 0) currentRoot.setMarried(true);
            marryTheHochzeits(currentRoot.getRightSuccessor());
        }
    }

    // Aufgabe 6
    // Die Methodensignatur darf NICHT geaendert werden
    public void removePersonFromPhoneBook(String lastName, String firstName, int number) {
        root = removePersonFromPhoneBook(new Person(lastName, firstName, number, false), root);
    }

    // Rueckgabetyp und Parametrisierung dieser Methode duerfen geaendert werden!
    private Person removePersonFromPhoneBook(Person personToRemove, Person currentRoot) {
        if (currentRoot == null) {
            return null;
        }

        if (compareTwoPersons(personToRemove, currentRoot) == 0) {
            // Case 1: no children
            if (currentRoot.getLeftSuccessor() == null && currentRoot.getRightSuccessor() == null) {
                return null;
            }

            // Case 2: only 1 child
            if (currentRoot.getRightSuccessor() == null) {
                return currentRoot.getLeftSuccessor();
            }
            if (currentRoot.getLeftSuccessor() == null) {
                return currentRoot.getRightSuccessor();
            }

            // Case 3: 2 children
            Person smallestPerson = findSmallest(currentRoot.getRightSuccessor());
            currentRoot = smallestPerson;
            currentRoot.setRightSuccessor(removePersonFromPhoneBook(currentRoot.getRightSuccessor(), smallestPerson));

            return currentRoot;
        }

        if (compareTwoPersons(personToRemove, currentRoot) < 0) {
            currentRoot.setLeftSuccessor(removePersonFromPhoneBook(personToRemove, currentRoot.getLeftSuccessor()));
            return currentRoot;
        }

        currentRoot.setRightSuccessor(removePersonFromPhoneBook(personToRemove, currentRoot.getRightSuccessor()));
        return currentRoot;
    }

    private Person findSmallest(Person currentRoot) {
        return currentRoot.getLeftSuccessor() == null ? currentRoot : findSmallest(currentRoot.getLeftSuccessor());
    }

    // Aufgabe 7
    // Die Methodensignatur darf NICHT geaendert werden
    public void changePerson(String lastName, String firstName, int number, String newLastname) {
        Person newPerson = new Person(newLastname, firstName, number, true);
        removePersonFromPhoneBook(lastName, firstName, number);
        insertPerson(root, newPerson);
    }

    // Rueckgabetyp und Parametrisierung dieser Methode duerfen geaendert werden!
    private void changePerson(String lastName, String firstName, int number, String newLastname, Person currentNode) {

    }

    //Diese Methode vergleicht zwei Objekte vom Typ Person im Sinne der Sortierkriterien des Telefonbuchs.
    //Keiner der Parameter darf null sein!
    //Folgende Rueckgabewerte sind moeglich:
    // * 0, wenn person1 und person2 gleich sind
    // * Negative Zahl, wenn person1 im Sinne des Sortierkriteriums kleiner ist als person2
    // * Positive Zahl, wenn person1 im Sinne des Sortierkriteriums groesser ist als person2
    private int compareTwoPersons(Person person1, Person person2) {
        if (person1.getLastName().compareToIgnoreCase(person2.getLastName()) != 0) {
            return person1.getLastName().compareToIgnoreCase(person2.getLastName());
        }
        if (person1.getFirstName().compareToIgnoreCase(person2.getFirstName()) != 0) {
            return person1.getFirstName().compareToIgnoreCase(person2.getFirstName());
        }
        return person1.getNumber() - person2.getNumber();
    }

    //Diese Methode funktioniert wie die obige, nur dass Sie den Nachnamen, den Vornamen und die
    //Telefonnummer der ersten Person als Parameter uebergeben koennen.
    private int compareTwoPersons(String lastName, String firstName, int number, Person person2) {
        if (lastName.compareToIgnoreCase(person2.getLastName()) != 0) {
            return lastName.compareToIgnoreCase(person2.getLastName());
        }
        if (firstName.compareToIgnoreCase(person2.getFirstName()) != 0) {
            return firstName.compareToIgnoreCase(person2.getFirstName());
        }
        return number - person2.getNumber();
    }

    // Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
    private void printTree() {
        printNode(0, root, "root");
    }

    // Hilfsmethode um den Baum auf der Konsole ausgeben zu koennen
    // verwendet Rekursion
    private void printNode(int depth, Person currentNode, String position) {
        if (currentNode != null) {
            printNode(depth + 1, currentNode.getRightSuccessor(), "right");
            String indentation = "";
            for (int i = 0; i < depth; i++) {
                indentation += "         ";
            }
            System.out.println(indentation + "- " + position + ":" + depth + ": " + currentNode);
            printNode(depth + 1, currentNode.getLeftSuccessor(), "left");
        }
    }

    public static void main(String[] args) {
        //Die folgenden Methoden testen einzeln die Zu bearbeitenden Aufgaben. Sie koennen diese einzeln
        //aus- und einkommentieren, falls Sie erst Teile der Loesung programmiert haben.
        testInsertPerson();
        testFindPerson();
        testCountPersons();
        testFindPersons();
        testMarryTheHochzeits();
        testRemovePersonFromPhoneBook();
        testChangePerson();
    }

    private static void testInsertPerson() {
        //Erzeuge Personen
        Person person1 = new Person("Meier", "Rainer", 123456, false);
        Person person2 = new Person("Maier", "Reiner", 123356, false);
        Person person3 = new Person("Meier", "Reiner", 123556, false);
        Person person4 = new Person("Neuberg", "Tina", 123466, false);
        Person person5 = new Person("Lutz", "Michaela", 123856, false);
        Person person6 = new Person("Fischer", "Bernd", 113456, false);
        Person person7 = new Person("Otto", "Josephine", 123999, false);
        Person person8 = new Person("Bertram", "Heinz", 123456, false);
        Person person9 = new Person("Martens", "Nicole", 838396, false);
        Person person10 = new Person("Nahles", "Andrea", 793256, false);

        Person testPerson = new Person("Gauck", "Beate", 654456, false);

        person1.setLeftSuccessor(person2);
        person1.setRightSuccessor(person3);
        person3.setRightSuccessor(person4);
        person2.setLeftSuccessor(person5);
        person5.setLeftSuccessor(person6);
        person4.setRightSuccessor(person7);
        person6.setLeftSuccessor(person8);
        person2.setRightSuccessor(person9);
        person4.setLeftSuccessor(person10);

        PhoneBook pb = new PhoneBook();
        pb.root = person1;

        System.out.println("====================================== Teste insertPerson() ======================================");
        System.out.println("Erwartete Ausgabe:");
        person6.setRightSuccessor(testPerson);
        pb.printTree();
        person6.setRightSuccessor(null);

        System.out.println("");
        System.out.println("====================================================================================================");
        System.out.println("");
        System.out.println("Ihre Ausgabe:");
        pb.insertPerson("Gauck", "Beate", 654456, false);
        pb.printTree();
        System.out.println("");
    }

    private static void testFindPerson() {
        Person person1 = new Person("Merkel", "Angela", 111111, false);
        Person person2 = new Person("Merkel", "Angela", 111110, false);
        Person person3 = new Person("Merkel", "Angela", 123556, false);
        Person person4 = new Person("Merkel", "Ingo", 123466, false);
        Person person5 = new Person("Merkel", "Adam", 123856, false);
        Person person6 = new Person("Merkel", "Bernd", 113456, false);

        Person person7 = new Person("Merkel", "Angela", 113456, false);

        person1.setLeftSuccessor(person2);
        person1.setRightSuccessor(person3);
        person3.setRightSuccessor(person4);
        person2.setLeftSuccessor(person5);
        person4.setLeftSuccessor(person6);

        PhoneBook pb = new PhoneBook();
        pb.root = person1;

        System.out.println("====================================== Teste findPerson() ======================================");
        System.out.println("");
        pb.printTree();
        System.out.println("");
        System.out.println("Suche Person: " + person6);
        System.out.println("Erwartete Ausgabe: true");
        System.out.println("Ihre Ausgabe: " + pb.findPerson(person6.getLastName(), person6.getFirstName(), person6.getNumber()));
        System.out.println("");
        System.out.println("Suche Person: " + person7);
        System.out.println("Erwartete Ausgabe: false");
        System.out.println("Ihre Ausgabe: " + pb.findPerson(person7.getLastName(), person7.getFirstName(), person7.getNumber()));
        System.out.println("");
    }

    private static void testCountPersons() {
        Person person1 = new Person("Meier", "Rainer", 123456, false);
        Person person2 = new Person("Maier", "Reiner", 123356, false);
        Person person3 = new Person("Meier", "Reiner", 123556, false);
        Person person4 = new Person("Neuberg", "Tina", 123466, false);
        Person person5 = new Person("Lutz", "Michaela", 123856, false);
        Person person6 = new Person("Fischer", "Bernd", 113456, false);

        person1.setLeftSuccessor(person2);
        person1.setRightSuccessor(person3);
        person3.setRightSuccessor(person4);
        person2.setLeftSuccessor(person5);
        person5.setLeftSuccessor(person6);

        PhoneBook pb = new PhoneBook();
        pb.root = person1;

        System.out.println("====================================== Teste countPerson() ======================================");
        System.out.println("");
        pb.printTree();
        System.out.println("");
        System.out.println("Erwartete Ausgabe: 6");
        System.out.println("Ihre Ausgabe: " + pb.countAllPersons());
    }

    private static void testFindPersons() {
        Person person1 = new Person("Meier", "Rainer", 123457, false);
        Person person2 = new Person("Meier", "Rainer", 123456, false);
        Person person3 = new Person("Neumann", "Rainer", 123456, false);
        Person person4 = new Person("Mustermann", "Max", 123456, false);
        Person person5 = new Person("Otto", "Reiner", 123456, false);
        Person person6 = new Person("Fischer", "Oskar", 123456, false);

        person1.setLeftSuccessor(person2);
        person1.setRightSuccessor(person3);
        person2.setLeftSuccessor(person6);
        person3.setLeftSuccessor(person4);
        person3.setRightSuccessor(person5);

        PhoneBook pb = new PhoneBook();
        pb.root = person1;

        Person[] testArray = new Person[3];
        testArray[0] = person2;
        testArray[1] = person1;
        testArray[2] = person3;


        System.out.println("================================= Teste findAllPersonsByFirstName() =================================");
        System.out.println("");
        pb.printTree();
        System.out.println("");
        System.out.println("Suche Person mit Vornamen: Rainer");
        System.out.println("Erwartete Ausgabe: " + Arrays.deepToString(testArray));
        System.out.println(Arrays.deepToString(testArray));
        System.out.println("Ihre Ausgabe: " + Arrays.deepToString(pb.findAllPersonsByFirstName("Rainer")));

    }

    private static void testMarryTheHochzeits() {
        Person person1 = new Person("Meier", "Rainer", 123456, false);
        Person person2 = new Person("Hochzeit", "Reiner", 123356, true);
        Person person3 = new Person("Meier", "Reiner", 123556, false);
        Person person4 = new Person("Fischer", "Bernd", 113456, false);
        Person person5 = new Person("Hochzeit", "Otto", 123356, true);
        Person person6 = new Person("Hochzeit", "Zacharias", 123356, true);

        person1.setLeftSuccessor(person2);
        person1.setRightSuccessor(person3);
        person2.setLeftSuccessor(person4);
        person4.setRightSuccessor(person5);
        person2.setRightSuccessor(person6);

        PhoneBook pb = new PhoneBook();
        pb.root = person1;

        System.out.println("====================================== Teste marryTheHochzeits() ======================================");
        System.out.println("");
        System.out.println("Erwartete Ausgabe:");
        pb.printTree();
        System.out.println("");
        System.out.println("====================================================================================================");
        System.out.println("");
        System.out.println("Ihre Ausgabe:");
        person2.setMarried(false);
        person5.setMarried(false);
        person6.setMarried(false);
        pb.marryTheHochzeits();
        pb.printTree();
        System.out.println("");
    }

    private static void testRemovePersonFromPhoneBook() {
        Person person1 = new Person("Meier", "Rainer", 123456, false);
        Person person2 = new Person("Maier", "Reiner", 123356, false);
        Person person3 = new Person("Meier", "Reiner", 123556, false);
        Person person4 = new Person("Neuberg", "Tina", 123466, false);
        Person person5 = new Person("Lutz", "Michaela", 123856, false);
        Person person6 = new Person("Fischer", "Bernd", 113456, false);

        person1.setLeftSuccessor(person2);
        person1.setRightSuccessor(person3);
        person3.setRightSuccessor(person4);
        person2.setLeftSuccessor(person5);
        person5.setLeftSuccessor(person6);

        PhoneBook pb = new PhoneBook();
        pb.root = person1;

        System.out.println("====================================== Teste removePersonFromPhoneBook() ======================================");
        System.out.println("");
        pb.printTree();
        System.out.println("");
        System.out.println("L�sche Person: " + person2);
        person1.setLeftSuccessor(person5);
        System.out.println("Erwartete Ausgabe:");
        System.out.println("");
        pb.printTree();
        System.out.println("====================================================================================================");
        person1.setLeftSuccessor(person2);
        System.out.println("");
        System.out.println("Ihre Ausgabe:");
        System.out.println("");
        pb.removePersonFromPhoneBook("Maier", "Reiner", 123356);
        pb.printTree();

    }

    private static void testChangePerson() {
        Person person1 = new Person("Meier", "Rainer", 123456, false);
        Person person2 = new Person("Maier", "Reiner", 123356, false);
        Person person3 = new Person("Meier", "Reiner", 123556, false);
        Person person4 = new Person("Neuberg", "Tina", 123466, false);
        Person person5 = new Person("Lutz", "Michaela", 123856, false);
        Person person6 = new Person("Fischer", "Bernd", 113456, false);

        person1.setLeftSuccessor(person2);
        person1.setRightSuccessor(person3);
        person3.setRightSuccessor(person4);
        person2.setLeftSuccessor(person5);
        person5.setLeftSuccessor(person6);

        PhoneBook pb = new PhoneBook();
        pb.root = person1;

        System.out.println("====================================== Teste changePerson() ======================================");
        System.out.println("");
        pb.printTree();
        System.out.println("");
        System.out.println("�ndere Nachnamen von Person: " + person2 + " zu 'Zock'");
        person2.setLastName("Zock");
        person1.setLeftSuccessor(person5);
        person4.setRightSuccessor(person2);
        person2.setLeftSuccessor(null);
        System.out.println("Erwartete Ausgabe:");
        System.out.println("");
        pb.printTree();
        System.out.println("====================================================================================================");
        person2.setLastName("Maier");
        person1.setLeftSuccessor(person2);
        person4.setRightSuccessor(null);
        person2.setLeftSuccessor(person5);
        System.out.println("");
        System.out.println("Ihre Ausgabe:");
        System.out.println("");
        pb.changePerson("Maier", "Reiner", 123356, "Zock");
        pb.printTree();
    }

}
