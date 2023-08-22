package Models.Entities;

public class Subject{
  private String id, Code, Name;
  private Department department;

  public Subject(String id, String code, String name, Department department){
    this.id = id;
    Code = code;
    Name = name;
    this.department = department;
  }

  public Subject(){
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getCode(){
    return Code;
  }

  public void setCode(String code){
    Code = code;
  }

  public String getName(){
    return Name;
  }

  public void setName(String name){
    Name = name;
  }

  public Department getDepartment(){
    return department;
  }

  public void setDepartment(Department department){
    this.department = department;
  }
}
