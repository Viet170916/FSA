package API.Controllers;

import Models.Entities.Subject;
import Services.SubjectService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SubjectController", value = "/api/subjects")
public class SubjectController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      response.setContentType("application/json");
      String JsonString = "[]";
      PrintWriter out = response.getWriter();
      try{
          ArrayList<Subject> subjects = SubjectService.getSubjects(request.getParameter("code"));
          JsonString = new Gson().toJson(subjects);
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      out.print(JsonString);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
