/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 */
package com.oppahansi.ws1718.mp.mp0;
/*
 * In dieser Klasse Buch sollen die Getter und Setter fuer die Felder
 * der Klasse (title, author, yearOfPublication) implementiert werden. Die
 * Methodenheader sind bereits vorgegeben.
 * Wenn ihr meint ihr habt die Methoden korrekt implementiert, koennt ihr das
 * einfach pruefen indem ihr die Klasse von Eclipse ausfuehren lasst und die
 * Ausgabe betrachtet.
 */


public class Book {

    public String title;
    public String author;
    public int yearOfPublication;

    public void setTitle(String name) {
        // Diese Methode muss von euch veraendert werden.
        title = name;
    }

    public String getTitle() {
        // Diese Methode muss von euch veraendert werden.
        return title;
    }

    public void setAuthor(String name) {
        // Diese Methode muss von euch veraendert werden.
        author = name;
    }

    public String getAuthor() {
        // Diese Methode muss von euch veraendert werden.
        return author;
    }

    public void setYearOfPublication(int year) {
        // Diese Methode muss von euch veraendert werden.
        yearOfPublication = year;
    }

    public int getYearOfPublication() {
        // Diese Methode muss von euch veraendert werden.
        return yearOfPublication;
    }


    // Programmtest
    public static void main(String[] args) {
        String titel = "Per Anhalter durch die Galaxis";
        String author = "Douglas Adams";
        int year = 1979;
        Book book = new Book();
        book.setTitle(titel);
        book.setAuthor(author);
        book.setYearOfPublication(year);
        System.out.println("Titel den das Buch haben sollte: " + titel);
        System.out.println("Titel den das Buch hat:          " +
                book.getTitle());
        System.out.println("Author den das Buch haben sollte: " + author);
        System.out.println("Author den das Buch hat:          " +
                book.getAuthor());
        System.out.println("Erscheinungsjahr das das Buch haben sollte: " +
                year);
        System.out.println("Erscheinungsdatum das das Buch hat:         " +
                book.getYearOfPublication());
    }

}
