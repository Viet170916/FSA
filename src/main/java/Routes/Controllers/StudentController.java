package Routes.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "StudentController", value = "/student/profile")
public class StudentController extends HttpServlet{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    try{
      if(request.getParameter("id") != null){
        request.setAttribute("id", request.getParameter("id"));
      }
      request.getRequestDispatcher("../StudentProfileLayout.jsp").forward(request, response);

    }catch(Exception e){
      System.out.println("../student/profile: " + e.getMessage());
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
