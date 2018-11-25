/*
 * Created by: Oppa Hansi
 *
 * <p>For learning purpose only.
 */
package com.oppahansi.ws1516.uebungen.zusatz.todo;

public class Todo implements Comparable<Todo> {

  private String topic;
  private String description;
  private int priority;

  // Cosntructor
  public Todo(String topic, String description, int priority) {
    this.topic = topic;
    this.description = description;
    this.priority = priority;
  }

  // overriden toString
  @Override
  public String toString() {
    String result = "";

    if (!topic.isEmpty()) {
      result += "Ueberscrift: " + topic;
    } else {
      result += "Ueberscrift: (nicht vorhanden)";
    }

    if (!description.isEmpty()) {
      result += "\nBeschreibung: " + description;
    } else {
      result += "\nBeschreibung: (nicht vorhanden)";
    }

    if (priority != 0) {
      result += "\nPrioritaet: " + priority;
    } else {
      result += "\nPrioritaet: (nicht vorhanden)";
    }

    return result;
  }

  // Ordnung
  @Override
  public int compareTo(final Todo o) {
    if (this.getPriority() > o.getPriority()) {
      return 1;
    } else if (this.getPriority() < o.getPriority()) {
      return -1;
    } else {
      if (!this.getTopic().isEmpty() && !o.getTopic().isEmpty()) {
        if ((int) this.getTopic().charAt(0) > (int) o.getTopic().charAt(0)) {
          return 1;
        } else {
          return -1;
        }
      } else {
        return 0;
      }
    }
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(final String topic) {
    this.topic = topic;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(final int priority) {
    this.priority = priority;
  }
}
