package Models.Entities;

public class Course{
  private String id, name, credit, description, code;
  private Subject subject;
  private Professor professor;

  public Course(){
  }

  public Course(String id, String name, String credit, String description, String code, Subject subject, Professor professor){
    this.id = id;
    this.name = name;
    this.credit = credit;
    this.description = description;
    this.code = code;
    this.subject = subject;
    this.professor = professor;
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

  public String getCredit(){
    return credit;
  }

  public void setCredit(String credit){
    this.credit = credit;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public String getCode(){
    return code;
  }

  public void setCode(String code){
    this.code = code;
  }

  public Subject getSubject(){
    return subject;
  }

  public void setSubject(Subject subject){
    this.subject = subject;
  }

  public Professor getProfessor(){
    return professor;
  }

  public void setProfessor(Professor professor){
    this.professor = professor;
  }
}
