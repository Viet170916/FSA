package Models.Responses;

import Models.Entities.Slot;

import java.util.ArrayList;

public class ProfessorScheduleResponse{
  private ArrayList<SlotResponse> schedule = new ArrayList<>();

  public ProfessorScheduleResponse(ArrayList<Slot> schedule){
    for(Slot course : schedule){
      this.schedule.add(new SlotResponse(course));
    }
  }

  public ArrayList<SlotResponse> getSchedule(){
    return schedule;
  }

  public void setSchedule(ArrayList<SlotResponse> schedule){
    this.schedule = schedule;
  }
}
