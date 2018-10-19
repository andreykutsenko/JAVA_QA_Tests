package com.aka.nyc.dotdash.Model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tasks extends ForwardingSet<TaskData> {

  private Set<TaskData> delegate;

  public Tasks(Tasks tasks) {
    this.delegate = new HashSet<TaskData>(tasks.delegate);
  }

  public Tasks() {
    this.delegate = new HashSet<TaskData>();
  }

  public Tasks(Collection<TaskData> tasks) {
    this.delegate = new HashSet<TaskData>(tasks);
  }

  @Override
  protected Set<TaskData> delegate() {
    return delegate;
  }

  public Tasks withAdded(TaskData task) {
    Tasks tasks = new Tasks(this);
    tasks.add(task);
    return tasks;
  }

  public Tasks without(TaskData task) {
    Tasks tasks = new Tasks(this);
    tasks.remove(task);
    return tasks;
  }


}
