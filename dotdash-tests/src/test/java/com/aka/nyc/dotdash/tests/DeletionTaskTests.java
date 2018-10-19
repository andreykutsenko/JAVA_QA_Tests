package com.aka.nyc.dotdash.tests;

import com.aka.nyc.dotdash.Model.TaskData;
import com.aka.nyc.dotdash.Model.Tasks;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletionTaskTests extends TestBase {

  @Test
  public void testDeletionTask() throws IOException {
    app.goTo().login();
    Tasks before = app.Rest().getTasks();
    TaskData deletedTask = before.iterator().next();
    app.task().delete(deletedTask);
    assertThat(app.task().count(), equalTo(before.size() - 1));
  }
}
