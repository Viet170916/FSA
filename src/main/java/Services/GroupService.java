package Services;

import Data.DBEntity;
import Models.Entities.Course;
import Models.Entities.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GroupService{
  public static Group getGroup(String id) throws Exception{
    Group group = new Group();
    String query = "SELECT id, code, SemesterId FROM dbo.Classes WHERE Id = '" + id + "'";
    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      group.setId(resultSet.getString("id"));
      group.setCode(resultSet.getString("code"));
      group.setSemester(
              SemesterService
                      .getSemester(resultSet.getString("semesterId")
                      )
      );
    }
    return group;
  }
  public static ArrayList<Group> getGroups(String semesterId) throws Exception{
    ArrayList<Group> groups = new ArrayList<>();
    String query = "SELECT id, code, SemesterId " +
            "FROM dbo.Classes class " +
            "WHERE class.SemesterId = '" + semesterId + "' ";
    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      Group group = new Group();
      group.setId(resultSet.getString("id"));
      group.setCode(resultSet.getString("code"));
      group.setSemester(
              SemesterService
                      .getSemester(resultSet.getString("semesterId")
                      )
      );
      groups.add(group);
    }
    return groups;
  }
  public static void Add(String code, String semesterId)throws Exception{
    String query = "INSERT INTO dbo.Classes(Code, SemesterId) VALUES (?,?);";
    PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
    statement.setString(1,code);
    statement.setString(2, semesterId);
    statement.executeUpdate();
  }
}
