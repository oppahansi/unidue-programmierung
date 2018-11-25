/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp6;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Miniprojekt6 {

  public static void main(String[] args) {
    Database db = new InMemoryDatabase();

    System.out.println(
        String.format(
            "Neue Datenbank 'db' erzeugt. Anzahl der Student-Objekte in der Datenbank: %d - Anzahl der Course-Objekte in der Datenbank: %d",
            db.countStudents(), db.countCourses()));

    Course[] courses =
        new Course[] {
          new Course("Programmierung", Term.WINTER_TERM),
          new Course("Design und Architektur von Software-Systemen", Term.WINTER_TERM),
          new Course("Distributed Objects and XML", Term.SUMMER_TERM),
          new Course("Formale Methoden", Term.SUMMER_TERM),
          new Course("Anwendung Formaler Methoden", Term.WINTER_TERM)
        };

    for (final Course course : courses) {
      db.insertCourse(course);
    }

    System.out.println(
        String.format(
            "Kurse hinzugefügt. Anzahl der Course-Objekte in der Datenbank: %d",
            db.countCourses()));

    Student[] students =
        new Student[] {
          new Student("Eduard", "Sunshine", 1995, 4, 12),
          new Student("Alina", "von Beetz", 1986, 9, 1),
          new Student("Bernd", "Bauer", 1993, 11, 5),
          new Student("Konstanze", "Fuchsberg", 1990, 8, 30),
          new Student("Daria", "Kern", 1989, 2, 14),
          new Student("Maciek", "Daborowski", 1992, 7, 11)
        };

    for (final Student student : students) {
      db.insertStudent(student);
      System.out.println(
          String.format(
              "%s %s eingefügt. Anzahl der Student-Objekte in der Datenbank: %d",
              student.getFirstName(), student.getLastName(), db.countStudents()));
    }

    // Noten
    students[0].setGrade(courses[2], 2.3);
    students[0].setGrade(courses[3], 1.3);
    students[1].setGrade(courses[1], 1.0);
    students[1].setGrade(courses[0], 2.7);
    students[1].setGrade(courses[2], 1.3);
    students[1].setGrade(courses[4], 2.0);
    students[2].setGrade(courses[0], 1.3);
    students[2].setGrade(courses[4], 1.7);
    students[2].setGrade(courses[1], 1.0);
    students[3].setGrade(courses[2], 2.3);
    students[3].setGrade(courses[3], 3.7);
    students[3].setGrade(courses[4], 5.0);
    students[3].setGrade(courses[0], 1.0);
    students[3].setGrade(courses[1], 2.7);
    students[4].setGrade(courses[2], 4.0);
    students[4].setGrade(courses[4], 1.0);

    System.out.println("\nAlle Studenten:");
    for (final Student student : db.getStudents()) {
      System.out.println(String.format("\t* %s", student));
    }

    System.out.println("\nJunge Studenten:");
    Calendar dateThreshold = GregorianCalendar.getInstance();
    dateThreshold.set(1990, 0, 1);
    for (final Student student : db.getStudentsBornAfter(dateThreshold)) {
      System.out.println(String.format("\t* %s", student));
    }

    System.out.println("\nDie besten Studenten (unsortiert):");
    double gradeThreshold = 2.3;
    for (final Student student : db.getGoodStudents(gradeThreshold)) {
      System.out.println(
          String.format(
              "\t* %s %s (%.2f)",
              student.getFirstName(), student.getLastName(), student.getAverageGrade()));
    }

    System.out.println("\nDie besten Studenten (sortiert):");
    for (final Student student : db.getGoodStudentsOrderedByGrade(gradeThreshold)) {
      System.out.println(
          String.format(
              "\t* %s %s (%.2f)",
              student.getFirstName(), student.getLastName(), student.getAverageGrade()));
    }

    System.out.println(String.format("\nStudenten, die '%s' gehört haben:", courses[2].getName()));
    for (final Student student : db.getStudentsAttendingCourse(courses[2])) {
      System.out.println(String.format("\t* %s %s", student.getFirstName(), student.getLastName()));
    }

    System.out.println("\nAlle Veranstaltungen:");
    for (final Course course : db.getCourses()) {
      System.out.println(String.format("\t* %s", course));
    }

    System.out.println("\nKurse, die im Veranstaltungen angeboten werden:");
    for (final Course course : db.getCoursesInTerm(Term.WINTER_TERM)) {
      System.out.println(String.format("\t* %s", course.getName()));
    }

    Database db2 = new InMemoryDatabase();
    System.out.println(
        String.format(
            "\nNeue Datenbank 'db2' erzeugt. Anzahl der Student-Objekte in der Datenbank: %d - Anzahl der Course-Objekte in der Datenbank: %d",
            db2.countStudents(), db2.countCourses()));

    db2.insertStudents(db.getStudents());
    System.out.println(
        String.format(
            "Alle Student-Objekte aus 'db' in 'db2' eingefügt. Anzahl der Student-Objekte in der Datenbank: %d",
            db2.countStudents()));
  }
}
