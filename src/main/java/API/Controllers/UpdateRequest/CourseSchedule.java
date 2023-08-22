package API.Controllers.UpdateRequest;

import Models.Entities.Slot;
import Services.CourseScheduleService;
import Services.CourseService;
import Services.GroupService;
import Services.SlotService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CourseSchedule", value = "/update/course-schedule")
public class CourseSchedule extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String JsonString = "{}";
    PrintWriter out = response.getWriter();
    try{
      if(request.getParameter("id") != null){
        Slot slot = SlotService.getCourseSchedule(request.getParameter("id"));
        JsonString = new Gson().toJson(slot);
      }else if(request.getParameter("date")!=null && request.getParameter("group")!=null&& request.getParameter("subject")!=null){
        Slot slot = SlotService.getCourseScheduleByDateAndGroup(
                request.getParameter("date"),
                request.getParameter("group"),
                request.getParameter("subject")
        );
        JsonString = new Gson().toJson(slot);

      }
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
    out.print(JsonString);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//    response.setContentType("application/json");
//    String JsonString = "{}";
//    PrintWriter out = response.getWriter();
//    try{
//      System.out.println(request.getParameter("group") + request.getParameter("subject") + request.getParameter("professor") + request.getParameter("room") + request.getParameter("slot") + request.getParameter("date"));
//      GroupService.Add(request.getParameter("group"), "2");
//      CourseService.Add(request.getParameter("subject"),
//              request.getParameter("professor"));
//      CourseScheduleService.Add(request.getParameter("room"));
//      CourseScheduleService.AddSlot(request.getParameter("slot"));
//      CourseScheduleService.AddDate(request.getParameter("date"));
//    }catch(Exception e){
//      System.out.println(e.getMessage());
//    }
//    out.print(JsonString);
  }
}
