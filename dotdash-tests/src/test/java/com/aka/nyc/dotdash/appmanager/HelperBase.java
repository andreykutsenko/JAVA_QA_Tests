package com.aka.nyc.dotdash.appmanager;

import org.openqa.selenium.*;

public class HelperBase {

  protected ApplicationManager app;
  protected WebDriver wd;

  public HelperBase(ApplicationManager app) {
    this.app = app;
    this.wd = app.getDriver();
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  public void submitCreation() {
    click(By.xpath("//input[@value='Add']"));
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public void selectTaskById(int id) {
    wd.findElement(By.cssSelector("input[name='todo[" + id + "]']")).click();
  }

  public void initTaskModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void submitModification() {
    click(By.name("submit"));
  }

}