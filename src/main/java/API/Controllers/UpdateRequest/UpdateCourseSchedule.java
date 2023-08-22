package API.Controllers.UpdateRequest;

import Models.Responses.SlotResponse;
import Services.SlotService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet(name = "UpdateCourseSchedule", value = "/update/schedule")
public class UpdateCourseSchedule extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
    StringBuilder jsonString = new StringBuilder();
    String line;
    while((line = reader.readLine()) != null){
      jsonString.append(line);
    }
    reader.close();
    Gson gson = new Gson();
    response.setContentType("application/json");
    String JsonString = "{}";
    PrintWriter out = response.getWriter();
    try{
      SlotResponse slot = gson.fromJson(jsonString.toString(), SlotResponse.class);
      SlotService.UpdateSlot(slot);
      JsonString = "{\"mess\":\"The schedule was updated successfully\"}";
    }catch(Exception e){
      System.out.println("/update/schedule/POST: " + e.getMessage());
      if(e.getMessage().equals("Cant be update because this date exists a slot is processing with this room or with this group")){
        JsonString = "data: { error: \"" + e.getMessage() + "\" }";
        JsonString = "{\"error\":\""+e.getMessage()+"\"}";
//        response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
      }
    }
    out.print(JsonString);
  }
}
