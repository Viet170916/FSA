package API.Controllers.AdminControllers;

import Models.Entities.Group;
import Services.GroupService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Admin_GroupController", value = "/api/admin/group")
public class Admin_GroupController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String JsonString = "{}";
    PrintWriter out = response.getWriter();
    try{
      ArrayList<Group> groups = GroupService.getGroups(request.getParameter("semester-id"));
      JsonString = new Gson().toJson(groups);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    out.print(JsonString);
  }
}
