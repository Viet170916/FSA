package Services;

import Data.DBEntity;
import Models.Entities.Subject;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectService{
  public static Subject getSubject(String id) throws Exception{
    Subject subject = new Subject();
    String query = "SELECT Code, Name, DepartmentId, Id FROM dbo.Subjects WHERE Id = '" + id + "'";
    ResultSet resultSet = new DBEntity<>(Subject.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      subject.setId(resultSet.getString("id"));
      subject.setCode(resultSet.getString("code"));
      subject.setName(resultSet.getString("name"));
      subject.setDepartment(
              DepartmentService.getDepartment(
                      resultSet.getString("departmentId")
              )
      );
    }
    return subject;
  }

  public static ArrayList<Subject> getSubjects(String code) throws Exception{
    ArrayList<Subject> subjects = new ArrayList<>();
    String query = "SELECT Code FROM dbo.Subjects WHERE Code LIKE '%"+code+"%'";
    ResultSet resultSet = new DBEntity<>(Subject.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      Subject subject = new Subject();
      subject.setCode(resultSet.getString("code"));
      subjects.add(subject);
    }
    return subjects;
  }
}
