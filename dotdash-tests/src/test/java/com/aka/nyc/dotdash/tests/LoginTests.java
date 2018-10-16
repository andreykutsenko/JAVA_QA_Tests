package com.aka.nyc.dotdash.tests;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

  @Test
  public void testLogin() {
    app.goTo().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
//    app.goTo().managerUsers();
//    assertTrue(session.login("Kutsenko", "Rewtyrj76"));
//    assertTrue(session.isLoggedInAs("Kutsenko"));

  }

}
