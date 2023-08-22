package Models.Entities;

import java.util.Date;

public class Slot{
  private String id, slot;
  private Date teachingDate;
  private Group group;
  private Course course;
  private Room room;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getSlot(){
    return slot;
  }

  public void setSlot(String slot){
    this.slot = slot;
  }

  public Date getTeachingDate(){
    return teachingDate;
  }

  public void setTeachingDate(Date teachingDate){
    this.teachingDate = teachingDate;
  }

  public Group getGroup(){
    return group;
  }

  public void setGroup(Group group){
    this.group = group;
  }

  public Course getCourse(){
    return course;
  }

  public void setCourse(Course course){
    this.course = course;
  }

  public Room getRoom(){
    return room;
  }

  public void setRoom(Room room){
    this.room = room;
  }
}
