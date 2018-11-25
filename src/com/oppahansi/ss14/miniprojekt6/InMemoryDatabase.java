package com.oppahansi.ss14.miniprojekt6;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Implementierung des Database-Interfaces, die Objekte über Listen des Java Collection-Framework
 * direkt im Speicher verwaltet
 */
public class InMemoryDatabase implements Database {

  private List<Student> students = new LinkedList<>();
  private List<Course> courses = new LinkedList<>();

  @Override
  public void insertStudent(Student student) {
    // Aufgabe
    this.students.add(student);
  }

  @Override
  public void insertStudents(List<Student> students) {
    // Aufgabe
    this.students.addAll(students);
  }

  @Override
  public int countStudents() {
    // Aufgabe
    return this.students.size();
  }

  @Override
  public List<Student> getStudents() {
    // Aufgabe
    List<Student> copyStudentsList = new LinkedList<>();
    for (int i = 0; i < this.students.size(); i++) {
      copyStudentsList.add(this.students.get(i));
    }
    return copyStudentsList;
  }

  @Override
  public List<Student> getStudentsBornAfter(Calendar date) {
    // Aufgabe
    List<Student> bornAfter = new LinkedList<>();
    for (int i = 0; i < this.students.size(); i++) {
      if (this.students.get(i).getDateOfBirth().compareTo(date) > 0) {
        bornAfter.add(this.students.get(i));
      }
    }
    return bornAfter;
  }

  @Override
  public List<Student> getGoodStudents(double gradeThreshold) {
    // Aufgabe
    List<Student> goodStudents = new LinkedList<>();
    for (int i = 0; i < students.size(); i++) {
      if (this.students.get(i).getAverageGrade() != 0
          && this.students.get(i).getAverageGrade() < gradeThreshold) {
        goodStudents.add(students.get(i));
      }
    }
    return goodStudents;
  }

  @Override
  public List<Student> getGoodStudentsOrderedByGrade(double gradeThreshold) {
    // Aufgabe
    List<Student> goodStudentsOrdered = getGoodStudents(gradeThreshold);
    GradeComparator comparator = new GradeComparator();
    Collections.sort(goodStudentsOrdered, comparator);
    return goodStudentsOrdered;
  }

  @Override
  public List<Student> getStudentsAttendingCourse(Course course) {
    // Aufgabe
    List<Student> studentsByCourse = new LinkedList<>();
    for (int i = 0; i < this.students.size(); i++) {
      if (this.students.get(i).getAttendedCourses().contains(course)) {
        studentsByCourse.add(this.students.get(i));
      }
    }
    return studentsByCourse;
  }

  @Override
  public void insertCourse(Course course) {
    // Aufgabe
    this.courses.add(course);
  }

  @Override
  public List<Course> getCourses() {
    // Aufgabe
    List<Course> coursesCopy = new LinkedList<>();
    for (int i = 0; i < this.courses.size(); i++) {
      coursesCopy.add(this.courses.get(i));
    }
    return coursesCopy;
  }

  @Override
  public List<Course> getCoursesInTerm(Term term) {
    // Aufgabe
    List<Course> termCourses = new LinkedList<>();
    for (int i = 0; i < this.courses.size(); i++) {
      if (this.courses.get(i).getTerm() == term) {
        termCourses.add(this.courses.get(i));
      }
    }
    return termCourses;
  }

  @Override
  public int countCourses() {
    // Aufgabe
    return this.courses.size();
  }
}
