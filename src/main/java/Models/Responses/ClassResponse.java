package Models.Responses;

import Models.Entities.Group;
import Models.Entities.Student;

import java.util.ArrayList;

public class ClassResponse{
  private String id;
  private String url = "class/information/?id=";
  private ArrayList<StudentResponse> students;

  public ClassResponse(Group group){
    url = this.url + group.getId();
    id = group.getId();
    for(Student student : group.getStudents()){
      assert false;
      students.add(new StudentResponse(student));
    }
  }

  public String getClassUrl(){
    return url;
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public ArrayList<StudentResponse> getStudents(){
    return students;
  }

  public void setStudents(ArrayList<StudentResponse> students){
    this.students = students;
  }

}
