package com.aka.nyc.dotdash.tests;

import com.aka.nyc.dotdash.Model.Categories;
import com.aka.nyc.dotdash.Model.CategoryData;
import com.aka.nyc.dotdash.Model.TaskData;
import com.aka.nyc.dotdash.Model.Tasks;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ModificationTaskTests extends TestBase {

  @Test
  public void testModificationTask() throws IOException {
    app.goTo().login();
    Tasks before = app.Rest().getTasks();
    TaskData modifiedTask = before.iterator().next();

    Categories uiCategories = app.task().allCategories();
    long now = System.currentTimeMillis();
    CategoryData selectedCategory = uiCategories.iterator().next();

    TaskData newTask = new TaskData().withTaskName(String.format("New Task Name %s", now)).
            withCategoryName(selectedCategory.getCategoryName()).
            withStatus("").withDueData("").withId(modifiedTask.getId()).
            withCategoryId(String.valueOf(selectedCategory.getId()));


    app.task().modify(newTask);
    Tasks after = app.Rest().getTasks();

    assertEquals(after.size(), before.size());
  }
}