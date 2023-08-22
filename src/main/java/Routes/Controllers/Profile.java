package Routes.Controllers;

import Models.Entities.Student;
import Models.Entities.User;
import Services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Profile", value = "/profile")
public class Profile extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    try{
      User user = (User) request.getSession().getAttribute("user");
      Student student = StudentService.getStudentInformation(user.getId());
      if(request.getParameter("id") == null || request.getParameter("id").equals(student.getId())){
        request.getRequestDispatcher("../StudentProfileLayout.jsp").forward(request, response);
      }
    }catch(Exception e){
      System.out.println("../student/profile: " + e.getMessage());
      response.sendRedirect("../login");
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
