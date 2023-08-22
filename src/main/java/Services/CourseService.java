package Services;

import Data.DBEntity;
import Models.Entities.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseService{
  public static Course getCourse(String id) throws Exception{
    Course course = new Course();
    String query = "SELECT id, description, subjectid, professorid FROM dbo.Courses WHERE Id = '" + id + "'";
    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      course.setId(resultSet.getString("id"));
      course.setDescription(resultSet.getString("description"));
      course.setProfessor(
              ProfessorService.getProfessor(
                      resultSet.getString("professorId")
              )
      );
      course.setSubject(
              SubjectService.getSubject(
                      resultSet.getString("subjectId")
              )
      );
    }
    return course;
  }

  public static void Add(String SubjectCode, String ProfessorCode) throws SQLException{
    Course course = new Course();
    String query = "INSERT INTO dbo.Courses( Description, SubjectId, ProfessorId) VALUES (?,(SELECT Id FROM dbo.Subjects WHERE Code =?),(SELECT Id FROM dbo.Professors WHERE Code = ?))";
    PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
    statement.setString(1, "");
    statement.setString(2, SubjectCode);
    statement.setString(3, ProfessorCode);
    statement.executeUpdate();
  }
}
