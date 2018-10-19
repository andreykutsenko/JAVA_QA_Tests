package com.aka.nyc.dotdash.Model;

import java.util.Objects;

public class CategoryData {

  private int id;
  private byte hexCode;
  private String categoryName;

  public int getId() {
    return id;
  }

  public CategoryData withId(int id) {
    this.id = id;
    return this;
  }

  public byte getHexCode() {
    return hexCode;
  }

  public CategoryData withHexCode(byte hexCode) {
    this.hexCode = hexCode;
    return this;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public CategoryData withCategoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CategoryData that = (CategoryData) o;
    return id == that.id &&
            hexCode == that.hexCode &&
            Objects.equals(categoryName, that.categoryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hexCode, categoryName);
  }

  @Override
  public String toString() {
    return "CategoryData{" +
            "id=" + id +
            ", hexCode=" + hexCode +
            ", categoryName='" + categoryName + '\'' +
            '}';
  }
}
