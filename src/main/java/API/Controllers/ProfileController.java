package API.Controllers;

import Models.Entities.Professor;
import Models.Entities.Student;
import Models.Entities.User;
import Models.Responses.ProfessorResponse;
import Models.Responses.StudentResponse;
import Services.ProfessorService;
import Services.StudentService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileController", value = "/api/user/profile")
public class ProfileController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String employeeJsonString = "{}";
    PrintWriter out = response.getWriter();
    User user = (User) request.getSession().getAttribute("user");
    try{
      if(user.getProfessorId()!=null){
        Professor professor = ProfessorService.getProfessor(user.getId());
        System.out.println(professor);
        employeeJsonString = new Gson().toJson(new ProfessorResponse(professor));

      }else if(user.getStudentId()!=null){
        Student student =  StudentService.getStudentInformation(user.getId());
        employeeJsonString = new Gson().toJson(new StudentResponse(student));
      }else{

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
