package API.Controllers.AdminControllers;

import Models.Entities.CourseSchedule;
import Models.Entities.Group;
import Services.CourseScheduleService;
import Services.GroupService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Admin_CourseScheduleController", value = "/api/admin/groups")
public class Admin_CourseScheduleController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      response.setContentType("application/json");
      String JsonString = "{}";
      PrintWriter out = response.getWriter();
      try{
          ArrayList<CourseSchedule> groups = CourseScheduleService.getCourseSchedules(request.getParameter("semester"));
          JsonString = new Gson().toJson(groups);
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      out.print(JsonString);
  }


}
