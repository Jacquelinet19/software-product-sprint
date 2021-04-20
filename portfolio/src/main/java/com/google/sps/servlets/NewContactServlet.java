package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/new-contact")
public class NewContactServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String nameValue = Jsoup.clean(request.getParameter("name"), Whitelist.none());
    String emailValue = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    String reasonValue = Jsoup.clean(request.getParameter("reason"), Whitelist.none());
 
     Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    Key contactKey = datastore.newKeyFactory()
                    .setKind("Contact")
                    .newKey(nameValue);
    Entity contact = Entity.newBuilder(contactKey)
                    .set("name", nameValue)
                    .set("email", emailValue)
                    .set("reason", reasonValue)
                    .build();
    datastore.put(contact);

    response.sendRedirect("/index.html");

    }
}