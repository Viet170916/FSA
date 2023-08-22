package API.Controllers;

import Models.Entities.User;
import Models.Responses.ProfessorScheduleResponse;
import Services.ProfessorScheduleService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "ProfessorScheduleController", value = "/api/professor/schedule")
public class ProfessorScheduleController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("application/json");
    String result = "{}";
    PrintWriter out = response.getWriter();
    try{
      User user = (User) request.getSession().getAttribute("user");
      System.out.println(user);
      if(user.getProfessorId() != null){
        result = new Gson()
                .toJson(new ProfessorScheduleResponse(
                        ProfessorScheduleService.getScheduleOfADay(user.getProfessorId(),
                                request.getParameter("date") != null ? request.getParameter("date") : String.valueOf(LocalDate.now()
                                )
                        )
                ));
      }
    }catch(Exception e){
      System.out.println("/api/professor/schedule: " + e.getMessage());
    }
    out.print(result);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
