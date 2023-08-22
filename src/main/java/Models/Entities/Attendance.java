package Models.Entities;

public class Attendance{
  private String id, description;
  private Student student;
  private Slot slot;
  private String isAbsent;
  private Semester semester;


  public Attendance(){
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public Student getStudent(){
    return student;
  }

  public void setStudent(Student student){
    this.student = student;
  }

  public Slot getCourseSchedule(){
    return slot;
  }

  public void setCourseSchedule(Slot slot){
    this.slot = slot;
  }

  public String isAbsent(){
    return isAbsent;
  }

  public void setAbsent(String absent){
    isAbsent = absent;
  }

  public Semester getSemester(){
    return semester;
  }

  public void setSemester(Semester semester){
    this.semester = semester;
  }

  public Attendance(String id, String description, Student student, Slot slot, String isAbsent, Semester semester){
    this.id = id;
    this.description = description;
    this.student = student;
    this.slot = slot;
    this.isAbsent = isAbsent;
    this.semester = semester;
  }
}
