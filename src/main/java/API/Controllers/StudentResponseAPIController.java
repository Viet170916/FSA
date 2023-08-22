package API.Controllers;

import Models.Entities.Student;
import Models.Entities.User;
import Models.Responses.StudentResponse;
import Services.StudentService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentResponseAPIController", value = "/api/student-profile")
public class StudentResponseAPIController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String employeeJsonString = "{}";
    PrintWriter out = response.getWriter();
    try{
      if(request.getParameter("id") != null){
        Student student = StudentService
                .getStudentInformation(request.getParameter("id"));
        employeeJsonString = new Gson()
                .toJson(new StudentResponse(student));
      }else{
        User user = (User) request.getSession().getAttribute("user");
        Student student =  StudentService.getStudentInformation(user.getId());
        employeeJsonString = new Gson().toJson(new StudentResponse(student));
      }
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    out.print(employeeJsonString);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
