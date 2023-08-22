package Models.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student{
  private String id, image,code, firstName, lastName, gender, email, phone, address;
  private Date birthdate;
  private Major major;
  private User user;

  public Student(){
  }

  public Student(String id,String code, String image, String firstName, String lastName, String gender, String email, String phone, String address, Date birthdate, Major major, User user){
    this.id = id;
    this.code = code;
    this.image = image;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.birthdate = birthdate;
    this.major = major;
    this.user = user;
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
    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
    return dateFormat.format(birthdate);
  }

  public void setBirthdate(Date birthdate){
    this.birthdate = birthdate;
  }

  public Major getMajor(){
    return major;
  }

  public void setMajor(Major major){
    this.major = major;
  }

  public User getUser(){
    return user;
  }

  public void setUser(User user){
    this.user = user;
  }

  @Override
  public String toString(){
    return "Student{" +
            "id='" + id + '\'' +
            ", image='" + image + '\'' +
            ", code='" + code + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", gender='" + gender + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", birthdate=" + birthdate +
            ", major=" + major +
            ", user=" + user +
            '}';
  }
}
