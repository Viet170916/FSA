package Routes;

import Models.Entities.User;
import Services.AuthenticationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.getRequestDispatcher("layouts/LoginLayout/Login2.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    try{
      User user = AuthenticationService.getAuthentication(
//              request.getParameter("user-name"),
//              "TamPTHE161012@fpt.edu.vn",
//              "vwx890"
//              "AnhHT27@fu.edu.vn",
//              "987abc"
              "admin",
              "admin"
//              request.getParameter("password")
      );
      user.setPassword("");
      request
              .getSession()
              .setAttribute(
                      "user",
                      user
              );
      response.sendRedirect("../../../../../");
    }catch(Exception e){
      request.setAttribute("err", "User name or Password is incorrect");
      request.getRequestDispatcher("layouts/LoginLayout/Login2.jsp").forward(request, response);
    }
  }
}
