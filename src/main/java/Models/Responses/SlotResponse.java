package Models.Responses;

import Models.Entities.*;

public class SlotResponse{
  private String id;
  private CourseResponse course;
  private GroupResponse group;
  private Room room;
  private String slot;
  private String teachingDate;

  public SlotResponse(){
  }
  public SlotResponse(Slot slot){
    this.id = slot.getId();
    this.course = new CourseResponse(slot.getCourse());
    this.room = slot.getRoom();
    this.group = new GroupResponse(slot.getGroup());
    this.slot = slot.getSlot();
    this.teachingDate = slot.getTeachingDate().toString();
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public CourseResponse getCourse(){
    return course;
  }

  public void setCourse(CourseResponse course){
    this.course = course;
  }

  public GroupResponse getGroup(){
    return group;
  }

  public void setGroup(GroupResponse group){
    this.group = group;
  }

  public Room getRoom(){
    return room;
  }

  public void setRoom(Room room){
    this.room = room;
  }

  public String getSlot(){
    return slot;
  }

  public void setSlot(String slot){
    this.slot = slot;
  }

  public String getTeachingDate(){
    return teachingDate;
  }

  public void setTeachingDate(String teachingDate){
    this.teachingDate = teachingDate;
  }
}
