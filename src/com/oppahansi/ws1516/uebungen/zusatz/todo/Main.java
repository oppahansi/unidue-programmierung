/*
 * Created by: Oppa Hansi
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1516.uebungen.zusatz.todo;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList<Todo> todoList = new ArrayList<>();

    Todo todo1 = new Todo("ToDo1", "Beschreibung ToDo1", 1);
    Todo todo2 = new Todo("BoDo2", "Beschreibung ToDo2", 3);
    Todo todo3 = new Todo("CoDo3", "Beschreibung ToDo3", 3);
    Todo todo4 = new Todo("ToDo4", "Beschreibung ToDo4", 2);
    Todo todo5 = new Todo("ToDo5", "", 5);

    todoList.add(todo1);
    todoList.add(todo2);
    todoList.add(todo3);
    todoList.add(todo4);
    todoList.add(todo5);

    todoList.forEach(todo -> System.out.println(todo.toString() + "\n"));

    todoList.sort(Todo::compareTo);

    todoList.forEach(todo -> System.out.println(todo.toString() + "\n"));
  }
}
