package Models.Entities;

import java.util.ArrayList;

public class Major{
  private String id, name, description, code;
  private ArrayList<Semester> semesters;

  public Major(){
  }

  public Major(String id, String name, String code, String description, ArrayList<Semester> semesters){
    this.id = id;
    this.code = code;
    this.name = name;
    this.description = description;
    this.semesters = semesters;
  }

  public String getCode(){
    return code;
  }

  public void setCode(String code){
    this.code = code;
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

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public ArrayList<Semester> getSemesters(){
    return semesters;
  }

  public void setSemesters(ArrayList<Semester> semesters){
    this.semesters = semesters;
  }
  //...
}
