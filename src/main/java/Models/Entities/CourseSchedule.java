package Models.Entities;

public class CourseSchedule{
  private String id;
  private Group group;
  private Course course;
  private Room room;

  public CourseSchedule(String id, Group group, Course course, Room room){
    this.id = id;
    this.group = group;
    this.course = course;
    this.room = room;
  }

  public CourseSchedule(){
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
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
