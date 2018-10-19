package com.aka.nyc.dotdash.appmanager;

import com.aka.nyc.dotdash.model.Tasks;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class RestHelper extends HelperBase {

  public RestHelper(ApplicationManager app) {
    super(app);
  }

  public Tasks getTasks() throws IOException {
    String json = Request.Get("http://localhost/dotdash-project/fake-api-call.php").execute()
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return new Gson().fromJson(parsed, new TypeToken<Tasks>() {}.getType());
  }

}

