package com.oppahansi.ss14.testat6;

import java.util.*;

public class InMemoryDatabase implements Database {

  private List<Student> students = new LinkedList<>();
  private Map<Integer, Student> index = new HashMap<>();

  @Override
  public void insertStudent(Student student, int matriculationNumber) {
    students.add(student);
    index.put(matriculationNumber, student);
  }

  @Override
  public Student getStudentByMatriculationNumber(int matriculationNumber) {

    return index.get(matriculationNumber);
  }

  @Override
  public int countStudentsWithFirstName(String firstName) {
    int sum = 0;

    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getFirstName().compareTo(firstName) == 0) {
        sum++;
      }
    }

    return sum;
  }

  @Override
  public List<Student> getStudentsBornAfter(Calendar date) {
    List<Student> bornAfter = new LinkedList<>();

    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getDateOfBirth().compareTo(date) > 0) {
        bornAfter.add(students.get(i));
      }
    }

    return bornAfter;
  }
}
