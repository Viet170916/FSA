package Models.Entities;

import java.util.ArrayList;

public class Group{
  private String id;
  private String code;
  private ArrayList<Student> students;
  private Semester semester;

  public Group(){
  }

  public Group(String id, String code, ArrayList<Student> students, Semester semester){
    this.id = id;
    this.code = code;
    this.students = students;
    this.semester = semester;
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getCode(){
    return code;
  }

  public void setCode(String code){
    this.code = code;
  }

  public ArrayList<Student> getStudents(){
    return students;
  }

  public void setStudents(ArrayList<Student> students){
    this.students = students;
  }

  public Semester getSemester(){
    return semester;
  }

  public void setSemester(Semester semester){
    this.semester = semester;
  }
}
