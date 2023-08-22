package Models.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Professor{
  private String id, image, firstName, lastName,gender, email, phone, address, code;
  private Date birthdate;
  private User user;

  public Professor(){
  }

  public Professor(String id,String code, String image, String firstName, String lastName, String gender, String email, String phone, String address, Date birthdate, User user){
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
    String date=null;
    try{
      DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
      date = dateFormat.format(birthdate);
    }catch(Exception e){

    }
    return date;
  }

  public void setBirthdate(Date birthdate){
    this.birthdate = birthdate;
  }

  public User getUser(){
    return user;
  }

  public void setUser(User user){
    this.user = user;
  }
}
