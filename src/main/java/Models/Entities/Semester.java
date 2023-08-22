package Models.Entities;

import java.util.Date;

public class Semester{
  private String id, name;
  private Date startDate, endDate;

  public Semester(){
  }

  public Semester(String id, String name, Date startDate, Date endDate){
    this.id = id;
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
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

  public Date getStartDate(){
    return startDate;
  }

  public void setStartDate(Date startDate){
    this.startDate = startDate;
  }

  public Date getEndDate(){
    return endDate;
  }

  public void setEndDate(Date endDate){
    this.endDate = endDate;
  }
}
