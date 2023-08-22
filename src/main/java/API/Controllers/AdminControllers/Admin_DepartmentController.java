package API.Controllers.AdminControllers;

import Models.Entities.CourseSchedule;
import Models.Entities.Department;
import Services.CourseScheduleService;
import Services.DepartmentService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Admin_DepartmentController", value = "/api/admin/departments")
public class Admin_DepartmentController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String JsonString = "{}";
    PrintWriter out = response.getWriter();
    try{
      ArrayList<Department> departments = DepartmentService.getDepartments();
      JsonString = new Gson().toJson(departments);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    out.print(JsonString);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
