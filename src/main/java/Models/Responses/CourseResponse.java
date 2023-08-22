package Models.Responses;

import Models.Entities.Course;
import Models.Entities.Subject;

public class CourseResponse{
  private String id;
  private String url = "course/detail-information?id=";
  private String code, name, credit, description;
  private Subject subject;
  private ShortProfessorInformation professor;

  public CourseResponse(Course course){
    this.id = course.getId();
    this.subject = course.getSubject();
    url = this.url + course.getId();
    code = course.getId();
    name = course.getName();
    credit = course.getCredit();
    description = course.getDescription();
    professor = new ShortProfessorInformation(course.getProfessor());
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getUrl(){
    return url;
  }

  public void setUrl(String url){
    this.url = url;
  }

  public String getCode(){
    return code;
  }

  public void setCode(String code){
    this.code = code;
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

  public Subject getSubject(){
    return subject;
  }

  public void setSubject(Subject subject){
    this.subject = subject;
  }

  public ShortProfessorInformation getProfessor(){
    return professor;
  }

  public void setProfessor(ShortProfessorInformation professor){
    this.professor = professor;
  }
}
