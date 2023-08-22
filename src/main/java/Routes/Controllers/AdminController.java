package Routes.Controllers;

import Services.StudentService;
import Models.Entities.Student;
import Models.Entities.User;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminController", value = "/admin")
public class AdminController extends HttpServlet{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    User user = (User) request.getSession().getAttribute("user");
    try{
      Student student = StudentService.getStudentInformation(user.getId());
      String employeeJsonString = new Gson().toJson(student);
      PrintWriter out = response.getWriter();
      out.print(employeeJsonString);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }

  }
}
