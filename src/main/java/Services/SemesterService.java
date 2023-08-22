package Services;

import Data.DBEntity;
import Models.Entities.Semester;
import Models.Entities.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SemesterService{
  public static Semester getSemester(String semesterId) throws Exception{
    Semester semester = new Semester();
    String query =
            "SELECT id, name, startdate, enddate " +
                    "FROM dbo.Semesters WHERE Id  = '" + semesterId + "'";
    ResultSet resultSet = new DBEntity<>(Student.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    while(resultSet.next()){
      semester.setId(resultSet.getString("id"));
      semester.setStartDate(resultSet.getDate("startDate"));
      semester.setEndDate(resultSet.getDate("endDate"));
      semester.setName(resultSet.getString("name"));
    }
    return semester;
  }
  public static ArrayList<Semester> getSemesters() throws Exception{
    ArrayList<Semester> semesters = new ArrayList<>();

    String query =
            "SELECT id, name, startdate, enddate " +
                    "FROM dbo.Semesters ;";
    ResultSet resultSet = new DBEntity<>(Student.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    while(resultSet.next()){
      Semester semester = new Semester();
      semester.setId(resultSet.getString("id"));
      semester.setStartDate(resultSet.getDate("startDate"));
      semester.setEndDate(resultSet.getDate("endDate"));
      semester.setName(resultSet.getString("name"));
      semesters.add(semester);
    }
    return semesters;
  }

}
