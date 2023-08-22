package API.Controllers.AdminControllers;

import Models.Entities.Group;
import Models.Entities.Semester;
import Services.GroupService;
import Services.SemesterService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Admin_SemesterController", value = "/api/admin/semesters")
public class Admin_SemesterController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String JsonString = "{}";
    PrintWriter out = response.getWriter();
    try{
      ArrayList<Semester> semesters = SemesterService.getSemesters();
      JsonString = new Gson().toJson(semesters);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    out.print(JsonString);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
