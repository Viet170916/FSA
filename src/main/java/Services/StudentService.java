package Services;

import Data.DBEntity;
import Models.Entities.Attendance;
import Models.Entities.Major;
import Models.Entities.Student;
import Models.Entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService{


  public static Student getStudentInformation(String userOrStudentId) throws Exception{
    Student student = new Student();
    String query =
            "SELECT student.id, student.Code, lastname, firstname, midname, image, gender, email, phone, address, birthdate,majorid " +
            "FROM dbo.Students student JOIN dbo.Users dbUser on student.Id = dbUser.StudentId " +
            "WHERE dbUser.id = '" + userOrStudentId + "' OR student.Id = '"+userOrStudentId+"';";
    ResultSet resultSet = new DBEntity<>(Student.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    while(resultSet.next()){
      student.setId(resultSet.getString("id"));
      student.setCode(resultSet.getString("code"));
      student.setImage(resultSet.getString("image"));
      student.setFirstName(resultSet.getString("firstname"));
      student.setLastName(resultSet.getString("lastname"));
      student.setGender(resultSet.getString("gender"));
      student.setEmail(resultSet.getString("email"));
      student.setPhone(resultSet.getString("phone"));
      student.setAddress(resultSet.getString("address"));
      student.setBirthdate(resultSet.getDate("birthdate"));
      student.setMajor(null);
      student.setUser(null);
    }
    return student;
  }


}
