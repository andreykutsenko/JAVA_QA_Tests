package com.aka.nyc.dotdash.tests;

import com.aka.nyc.dotdash.model.Categories;
import com.aka.nyc.dotdash.model.CategoryData;
import com.aka.nyc.dotdash.model.TaskData;
import com.aka.nyc.dotdash.model.Tasks;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationTaskTests extends TestBase {

  @Test
  public void testCreationTask() throws IOException {
    app.goTo().login();
    Tasks before = app.Rest().getTasks();
    Categories uiCategories = app.task().allCategories();
    long now = System.currentTimeMillis();
    CategoryData selectedCategory = uiCategories.iterator().next();
    TaskData newTask = new TaskData().withTaskName(String.format("New Task Name %s", now)).
            withCategoryName(selectedCategory.getCategoryName()).
            withStatus("").withDueData("").
            withCategoryId(String.valueOf(selectedCategory.getId()));
    app.task().create(newTask);
    Tasks after = app.Rest().getTasks();

    assertThat((after.size()), equalTo(before.size() + 1));

    for (TaskData task : after) {
      if (task.getCategoryId().trim().length() == 0) {  //Tasks without categories
        System.out.println("ID: " + task.getId() + "; Task name: " + task.getTaskName());
      }
    }


  }
}
