/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 *
 * <p>Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */
package com.oppahansi.ws1516.mp.mp6;

import java.util.Calendar;
import java.util.List;

/* Datenbank zur Verwaltung von Studenten (Student) und Veranstaltungen (Course) */
public interface Database {

  void insertStudent(Student student);

  void insertStudents(List<Student> students);

  int countStudents();

  List<Student> getStudents();

  List<Student> getStudentsBornAfter(Calendar date);

  List<Student> getGoodStudents(double gradeThreshold);

  List<Student> getGoodStudentsOrderedByGrade(double gradeThreshold);

  List<Student> getStudentsAttendingCourse(Course course);

  void insertCourse(Course course);

  List<Course> getCourses();

  List<Course> getCoursesInTerm(Term term);

  int countCourses();
}
