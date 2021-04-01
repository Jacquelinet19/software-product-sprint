package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/randomquote")
public class RandomQuoteServlet extends HttpServlet {
  String [] randomQuotes = {"You can sacirfice now for your future, or your future for now","You miss 100% of the shots you don't take","Failure is not the opposite of success, it's part of success"};
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Gson gson = new Gson();
    String json = gson.toJson(randomQuotes);
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
}