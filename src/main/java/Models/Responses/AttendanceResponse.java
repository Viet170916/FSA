package Models.Responses;

import Models.Entities.Attendance;


public class AttendanceResponse{
  private String id, description;
  private String  studentURL = "/student/profile";
  private SlotResponse courseSchedule;
  private String isAbsent;
  private SemesterResponse semester;

  public AttendanceResponse(Attendance attendance){
    this.id = attendance.getId();
    this.description = attendance.getDescription();
    this.courseSchedule = new SlotResponse(attendance.getCourseSchedule());
    this.isAbsent = attendance.isAbsent();
    this.semester = new SemesterResponse(attendance.getSemester());
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

  public String getStudentURL(){
    return studentURL;
  }

  public void setStudentURL(String studentURL){
    this.studentURL = studentURL;
  }

  public SlotResponse getCourseSchedule(){
    return courseSchedule;
  }

  public void setCourseSchedule(SlotResponse courseSchedule){
    this.courseSchedule = courseSchedule;
  }

  public String getIsAbsent(){
    return isAbsent;
  }

  public void setIsAbsent(String isAbsent){
    this.isAbsent = isAbsent;
  }

  public SemesterResponse getSemester(){
    return semester;
  }

  public void setSemester(SemesterResponse semester){
    this.semester = semester;
  }
}
