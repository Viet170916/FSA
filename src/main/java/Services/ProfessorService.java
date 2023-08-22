package Services;

import Data.DBEntity;
import Models.Entities.Professor;
import Models.Entities.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfessorService{
  public static Professor getProfessor(String userOrProfessorId) throws Exception{
    Professor professor = new Professor();
    String query =
            "SELECT professor.id, professor.Code, lastname, firstname, midname, image, gender, email, phone, address, birthdate " +
                    "FROM dbo.Professors professor JOIN dbo.Users dbUser on professor.Id = dbUser.ProfessorId " +
                    "WHERE dbUser.id = '" + userOrProfessorId + "' OR professor.Id = '" + userOrProfessorId + "';";
    ResultSet resultSet = new DBEntity<>(Student.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    while(resultSet.next()){
      professor.setId(resultSet.getString("id"));
      professor.setCode(resultSet.getString("code"));
      professor.setImage(resultSet.getString("image"));
      professor.setFirstName(resultSet.getString("firstname"));
      professor.setLastName(resultSet.getString("lastname"));
      professor.setGender(resultSet.getString("gender"));
      professor.setEmail(resultSet.getString("email"));
      professor.setPhone(resultSet.getString("phone"));
      professor.setAddress(resultSet.getString("address"));
      professor.setBirthdate(resultSet.getDate("birthdate"));
      professor.setUser(null);
    }
    return professor;
  }

  public static ArrayList<Professor> getProfessors(String Subject, String search) throws Exception{
    String query =
            "SELECT professor.id, professor.Code, lastname, firstname, midname, image, gender, email, phone, address, birthdate " +
                    "FROM dbo.Professors professor JOIN dbo.Users dbUser on professor.Id = dbUser.ProfessorId " +
//                    " JOIN dbo.Departments D on D.Id = professor.DepartmentId " +
//                    "JOIN dbo.Subjects subject ON subject.DepartmentId = D.Id " +
                    "WHERE (dbUser.Email LIKE '%" + search + "%' OR " +
                    "dbUser.LastName LIKE '%" + search + "%'   OR " +
                    "dbUser.Code LIKE '%" + search + "%'   " +
                    ")" +";";
//                    "AND subject.Code = '" + Subject + "';";
    ResultSet resultSet = new DBEntity<>(Student.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    ArrayList<Professor> professors = new ArrayList<>();
    while(resultSet.next()){
      Professor professor = new Professor();
      professor.setCode(resultSet.getString("code"));
      professors.add(professor);
    }
    return professors;
  }
}
