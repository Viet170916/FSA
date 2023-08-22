package Routes;

import Models.Entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Home", value = "/")
public class Home extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    try{
      User user = (User)request.getSession().getAttribute("user");
      if(user.getStudentId()!=null){
        request.getRequestDispatcher("Home.jsp").forward(request, response);
      }else if(user.getProfessorId()!=null){
        request.getRequestDispatcher("ProfessorHome.jsp").forward(request,response);
      }else if(user.getIsAdmin()) {
        request.getRequestDispatcher("AdminHome.jsp").forward(request,response);
      }else {

      }
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
