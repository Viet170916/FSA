package Models.Responses;

import Models.Entities.Student;

public class StudentResponse{
  private String url = "student/profile?id=";
  private String id, image, firstName, lastName, gender, email, phone, address;
  private String birthdate, code;
  private String major;

  public StudentResponse(Student student){
    birthdate = student.getBirthdate();
    major = (student.getMajor()!=null)?student.getMajor().getName():null;
    id = student.getId();
    image = student.getImage();
    lastName = student.getLastName();
    firstName = student.getFirstName();
    gender = student.getGender();
    email = student.getEmail();
    address = student.getAddress();
    code = student.getCode();
    url = this.url + student.getId();
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

  public String getPhone(){
    return phone;
  }

  public void setPhone(String phone){
    this.phone = phone;
  }

  public String getAddress(){
    return address;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public String getBirthdate(){
    return birthdate;
  }

  public void setBirthdate(String birthdate){
    this.birthdate = birthdate;
  }

  public String getMajor(){
    return major;
  }

  public void setMajor(String major){
    this.major = major;
  }
}
