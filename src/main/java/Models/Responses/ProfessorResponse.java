package Models.Responses;

import Models.Entities.Professor;

public class ProfessorResponse{
  private String url = "professor/detail-information?id=";
  private String id, image, firstName, lastName, gender, email, code;
  private String birthdate;

  public ProfessorResponse(Professor professor){
    this.url = this.url + professor.getId();
    this.id = professor.getId();
    this.birthdate = professor.getBirthdate();
    this.email = professor.getEmail();
    this.image = professor.getImage();
    this.firstName = professor.getFirstName();
    this.gender = professor.getGender();
    this.lastName = professor.getLastName();
    this.code = professor.getCode();
  }

  public String getCode(){
    return code;
  }

  public void setCode(String code){
    this.code = code;
  }

  public String getUrl(){
    return url;
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getImage(){
    return image;
  }

  public void setImage(String image){
    this.image = image;
  }

  public String getFirstName(){
    return firstName;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public String getGender(){
    return gender;
  }

  public void setGender(String gender){
    this.gender = gender;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getBirthdate(){
    return birthdate;
  }

  public void setBirthdate(String birthdate){
    this.birthdate = birthdate;
  }
}
