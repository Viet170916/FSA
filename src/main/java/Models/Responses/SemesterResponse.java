package Models.Responses;

import Models.Entities.Semester;

public class SemesterResponse{
  private String id, name;
  private String startDate, endDate;

  public SemesterResponse(Semester semester){
    this.id = null;
    this.name = semester.getName();
    this.startDate = semester.getStartDate().toString();
    this.endDate = semester.getEndDate().toString();
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getStartDate(){
    return startDate;
  }

  public void setStartDate(String startDate){
    this.startDate = startDate;
  }

  public String getEndDate(){
    return endDate;
  }

  public void setEndDate(String endDate){
    this.endDate = endDate;
  }
}
