package com.aka.nyc.dotdash.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class TaskData {

  private int id;
  private String status;

  @SerializedName("task name")
  private String taskName;

  private String categoryName;

  @SerializedName("category")
  private String categoryId;

  @SerializedName("due date")
  private String dueDate;


  public int getId() {
    return id;
  }

  public TaskData withId(int id) {
    this.id = id;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public TaskData withStatus(String status) {
    this.status = status;
    return this;
  }

  public String getTaskName() {
    return taskName;
  }

  public TaskData withTaskName(String taskName) {
    this.taskName = taskName;
    return this;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public TaskData withCategoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  public TaskData withCategoryId(String categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public String getDueDate() {
    return dueDate;
  }

  public TaskData withDueData(String dueData) {
    this.dueDate = dueData;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TaskData taskData = (TaskData) o;
    return id == taskData.id &&
            categoryId == taskData.categoryId &&
            Objects.equals(status, taskData.status) &&
            Objects.equals(taskName, taskData.taskName) &&
            Objects.equals(categoryName, taskData.categoryName) &&
            Objects.equals(dueDate, taskData.dueDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, taskName, categoryName, categoryId, dueDate);
  }

  @Override
  public String toString() {
    return "TaskData{" +
            "id=" + id +
            ", status='" + status + '\'' +
            ", taskName='" + taskName + '\'' +
            ", categoryName='" + categoryName + '\'' +
            ", categoryId='" + categoryId + '\'' +
            ", dueDate='" + dueDate + '\'' +
            '}';
  }
}
