package com.aka.nyc.dotdash.Model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Categories extends ForwardingSet<CategoryData> {

  private Set<CategoryData> delegate;

  public Categories(Categories categories) {
    this.delegate = new HashSet<CategoryData>(categories.delegate);
  }

  public Categories() {
    this.delegate = new HashSet<CategoryData>();
  }

  public Categories(Collection<CategoryData> categories) {
    this.delegate = new HashSet<CategoryData>(categories);
  }

  @Override
  protected Set<CategoryData> delegate() {
    return delegate;
  }

  public Categories withAdded(CategoryData category) {
    Categories categories = new Categories(this);
    categories.add(category);
    return categories;
  }

  public Categories withOut(CategoryData category) {
    Categories categories = new Categories(this);
    categories.remove(category);
    return categories;
  }
}
