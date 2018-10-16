package com.aka.nyc.dotdash.appmanager;

import org.openqa.selenium.By;


public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl"));
//    type(By.name("Login"), username);
//    type(By.name("Password"), password);
//    click(By.cssSelector("input[value='Sign In']"));
  }

  public void managerUsers() {
    wd.get(app.getProperty("web.baseUrl") + "/manage_overview_page.php");
    click(By.linkText("Manage Users"));
  }

}

