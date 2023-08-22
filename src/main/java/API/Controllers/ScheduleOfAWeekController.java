package API.Controllers;

import Models.Entities.User;
import Models.Responses.ScheduleOfAWeekResponse;
import Services.AttendanceService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "ScheduleOfAWeekController", value = "/api/student/schedule-of-a-week")
public class ScheduleOfAWeekController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String result = "{}";
    PrintWriter out = response.getWriter();
    try{
      User user = (User)request.getSession().getAttribute("user");
      if(user.getStudentId() != null){
        System.out.println(String.valueOf(LocalDate.now()));
        result = new Gson()
                .toJson(new ScheduleOfAWeekResponse( AttendanceService.getScheduleOfAWeek(user.getStudentId(), request.getParameter("date")!=null?request.getParameter("date"):String.valueOf(LocalDate.now()))));
      }
    }catch(Exception e){
      System.out.println("/api/student/schedule-of-a-week: "+e.getMessage());
    }
    out.print(result);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
