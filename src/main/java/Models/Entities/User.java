package Models.Entities;

public class User{
  private String id, email, password, studentId, professorId;
  private Boolean isAdmin;

  public User(){
  }

  public User(String id, String userName, String password){
    this.id = id;
    this.email = userName;
    this.password = password;
  }

  public Boolean getIsAdmin(){
    return isAdmin;
  }

  public void setIsAdmin(String admin){
    try{
      System.out.println(admin);
      isAdmin = admin.equals("1");
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  public String getStudentId(){
    return studentId;
  }

  public void setStudentId(String studentId){
    this.studentId = studentId;
  }

  public String getProfessorId(){
    return professorId;
  }

  public void setProfessorId(String professorId){
    this.professorId = professorId;
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String userName){
    this.email = userName;
  }

  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  @Override
  public String toString(){
    return "User{" +
            "id='" + id + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", studentId='" + studentId + '\'' +
            ", professorId='" + professorId + '\'' +
            ", isAdmin=" + isAdmin +
            '}';
  }
}
