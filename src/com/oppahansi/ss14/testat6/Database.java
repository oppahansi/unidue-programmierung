package com.oppahansi.ss14.testat6;

import java.util.Calendar;
import java.util.List;

/* Datenbank zur Verwaltung von Studenten (Student) und Veranstaltungen (Course) */
public interface Database {

  void insertStudent(Student student, int matriculationNumber);

  Student getStudentByMatriculationNumber(int matriculationNumber);

  int countStudentsWithFirstName(String firstName);

  List<Student> getStudentsBornAfter(Calendar date);
}
