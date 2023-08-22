package API.Controllers;

import Models.Entities.Professor;
import Services.ProfessorService;
import Services.RoomService;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "BuildingController", value = "/api/buildings")
public class BuildingController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      response.setContentType("application/json");
      String JsonString = "[]";
      PrintWriter out = response.getWriter();
      try{
          ArrayList<String> buildings = RoomService.getBuildings();
          JsonString = new Gson().toJson(buildings);
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      out.print(JsonString);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }
}
