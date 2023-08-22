package Models.Responses;

import Models.Entities.Group;
import Models.Entities.Semester;

public class GroupResponse{
  String id, code;
  SemesterResponse semester;

  public GroupResponse(Group group){
    this.id = group.getId();
    this.code = group.getCode();
    this.semester = new SemesterResponse(group.getSemester());
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

  public SemesterResponse getSemester(){
    return semester;
  }

  public void setSemester(SemesterResponse semester){
    this.semester = semester;
  }
}
