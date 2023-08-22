package API.Controllers.AdminControllers;

import Models.Entities.CourseSchedule;
import Models.Entities.Semester;
import Models.Entities.Slot;
import Models.Responses.SlotResponse;
import Services.CourseScheduleService;
import Services.SemesterService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Slot_Controller", value = "/api/admin/slots")
public class Slot_Controller extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      response.setContentType("application/json");
      String JsonString = "{}";
      PrintWriter out = response.getWriter();
      try{
          ArrayList<SlotResponse> slots = CourseScheduleService.getCourseSchedules(request.getParameter("group"),request.getParameter("course"), request.getParameter("semester"));
          JsonString = new Gson().toJson(slots);
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      out.print(JsonString);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
