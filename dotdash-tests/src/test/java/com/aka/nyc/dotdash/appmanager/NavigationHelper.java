package com.aka.nyc.dotdash.appmanager;

import org.openqa.selenium.By;


public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void login() {
    wd.get(app.getProperty("web.baseUrl"));
  }

}

