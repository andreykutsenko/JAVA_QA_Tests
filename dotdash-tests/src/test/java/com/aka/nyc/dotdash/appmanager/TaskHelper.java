package com.aka.nyc.dotdash.appmanager;

import com.aka.nyc.dotdash.Model.Categories;
import com.aka.nyc.dotdash.Model.CategoryData;
import com.aka.nyc.dotdash.Model.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TaskHelper extends HelperBase {

  public TaskHelper(ApplicationManager app) {
    super(app);
  }

  public void fillTaskForm(TaskData taskData) {
    type(By.name("data"), taskData.getTaskName());
    new Select(wd.findElement(By.name("category"))).selectByVisibleText(taskData.getCategoryName());
  }

  private Categories categoryCache = null;

  public Categories allCategories() {
    if (categoryCache != null) {
      return new Categories(categoryCache);
    }

    categoryCache = new Categories();
    List<WebElement> elements = wd.findElements(By.xpath("//a[@title='Remove this category']"));
    for (WebElement element : elements) {
      String name = element.findElement(By.tagName("span")).getText();
      int id = Integer.parseInt(element.getAttribute("href").substring(48));
      categoryCache.add(new CategoryData().withId(id).withCategoryName(name));
    }
    return new Categories(categoryCache);
  }

  public void deleteSelectedTask() {
    click(By.xpath("//input[@value='Remove']"));
  }

  public void create(TaskData task) {
    fillTaskForm(task);
    submitCreation();
  }

  public void delete(TaskData task) {
    selectTaskById(task.getId());
    deleteSelectedTask();
  }

  public int count() {
    return wd.findElements(By.tagName("li")).size();
  }

  public void modify(TaskData task) {
    initTaskModificationById(task.getId());
    fillTaskForm(task);
    submitModification();
  }

}
