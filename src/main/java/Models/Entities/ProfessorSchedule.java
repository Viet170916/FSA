package Models.Entities;

public class ProfessorSchedule{
  private String Id;
  private Slot slot;

  public String getId(){
    return Id;
  }

  public void setId(String id){
    Id = id;
  }

  public Slot getCourseSchedule(){
    return slot;
  }

  public void setCourseSchedule(Slot slot){
    this.slot = slot;
  }

  public ProfessorSchedule(String id, Slot slot){
    Id = id;
    this.slot = slot;
  }

  public ProfessorSchedule(){
  }
}
