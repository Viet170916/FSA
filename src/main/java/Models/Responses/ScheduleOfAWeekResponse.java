package Models.Responses;

import Models.Entities.Attendance;

import java.util.ArrayList;

public class ScheduleOfAWeekResponse{
  ArrayList<AttendanceResponse> schedule = new ArrayList<>();

  public ScheduleOfAWeekResponse(ArrayList<Attendance> schedule){
    for(Attendance attendance : schedule){
      this.schedule.add(new AttendanceResponse(attendance));
    }
  }
}
