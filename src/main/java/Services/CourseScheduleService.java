package Services;

import Data.DBEntity;
import Models.Entities.Course;
import Models.Entities.CourseSchedule;
import Models.Entities.Semester;
import Models.Entities.Slot;
import Models.Responses.SlotResponse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseScheduleService{
//  public static void Add(String Building_NameRoom){
//    try{
//      String query = "INSERT INTO dbo.CourseSchedules(ClassId, CourseId, RoomId) " +
//              "VALUES ((SELECT Id " +
//              "FROM dbo.Classes " +
//              "WHERE Id = (SELECT MAX(Id) FROM dbo.Classes)), " +
//              "(SELECT Id " +
//              "FROM dbo.Courses " +
//              "WHERE Id = (SELECT MAX(Id) FROM dbo.Courses)" +
//              ")," +
//              "(SELECT Id " +
//              "FROM dbo.Rooms " +
//              "WHERE (BuildingName+Name) = ?))" +
//              "";
//      PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
//      statement.setString(1, Building_NameRoom);
//      statement.executeUpdate();
//    }catch(Exception e){
//      System.out.println(e.getMessage());
//    }
//  }

//  public static void AddDate(String date) throws SQLException{
//    String query = "INSERT INTO dbo.CourseSchedule_TeachingDate(CourseScheduleId, TeachingDate) VALUES ((SELECT Id FROM dbo.Slot WHERE Slot.Id = (SELECT MAX(Id) FROM Slot)), ?)";
//    PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
//    statement.setString(1, date);
//    statement.executeUpdate();
//  }
//
//  public static void AddSlot(String slot) throws SQLException{
//    String query = "INSERT INTO dbo.Slot(Slot, CourseScheduleId) VALUES (?,(SELECT Id FROM dbo.CourseSchedules WHERE CourseSchedules.Id = (SELECT MAX(Id) FROM CourseSchedules)))";
//    PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
//    statement.setString(1, slot);
//    statement.executeUpdate();
//  }

//  public static CourseSchedule getCourseSchedule(String id) throws Exception{
//    CourseSchedule courseSchedule = new CourseSchedule();
//    String query = "SELECT ClassId, CourseId, RoomId, Id FROM dbo.CourseSchedules WHERE Id = '" + id + "'";
//    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
//    while(resultSet.next()){
//      courseSchedule.setId(resultSet.getString("id"));
//      courseSchedule.setCourse(CourseService.getCourse(resultSet.getString("CourseId")));
//      courseSchedule.setGroup(GroupService.getGroup(resultSet.getString("groupId")));
//      courseSchedule.setRoom(RoomService.getRoom(resultSet.getString("roomId")));
//    }
//    return courseSchedule;
//  }

  public static ArrayList<CourseSchedule> getCourseSchedules(String currentSemester) throws Exception{
    ArrayList<CourseSchedule> courseSchedules = new ArrayList<>();
    String query = "SELECT ClassId, CourseId " +
            "FROM dbo.CourseSchedules cs" +
            "         JOIN dbo.Courses Co on Co.Id = cs.CourseId" +
            "         JOIN dbo.Subjects Su on Su.Id = Co.SubjectId" +
            "         JOIN dbo.Classes C on C.Id = cs.ClassId" +
            "         JOIN dbo.Semesters S on S.Id = C.SemesterId " +
            "JOIN dbo.Slot S2 on cs.Id = S2.CourseScheduleId" +
            " JOIN dbo.CourseSchedule_TeachingDate tchD ON tchD.CourseScheduleId = S2.Id " +
            "WHERE S.Id<= '" + currentSemester + "' " +
            "GROUP BY ClassId, CourseId;";

    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      CourseSchedule courseSchedule = new CourseSchedule();
//      courseSchedule.setId(resultSet.getString("id"));
      courseSchedule.setCourse(CourseService.getCourse(resultSet.getString("CourseId")));
      courseSchedule.setGroup(GroupService.getGroup(resultSet.getString("classId")));
      courseSchedules.add(courseSchedule);
    }
    return courseSchedules;
  }

  public static ArrayList<SlotResponse> getCourseSchedules(String groupCode, String courseCode, String semesterId) throws Exception{
    ArrayList<SlotResponse> courseSchedules = new ArrayList<>();
    String query = "SELECT ClassId, CourseId, RoomId, CSTD.Id, TeachingDate,Slot  " +
            "FROM dbo.CourseSchedules cs " +
            "JOIN dbo.Slot Sl on cs.Id = Sl.CourseScheduleId " +
            "JOIN dbo.CourseSchedule_TeachingDate CSTD on Sl.Id = CSTD.CourseScheduleId " +
            "         JOIN dbo.Courses Co on Co.Id = cs.CourseId" +
            "         JOIN dbo.Subjects Su on Su.Id = Co.SubjectId" +
            "         JOIN dbo.Classes C on C.Id = cs.ClassId" +
            "         JOIN dbo.Semesters S on S.Id = C.SemesterId " +
            "WHERE C.Code = ? AND Su.Code = ? AND S.Id = ? " +
            "ORDER BY TeachingDate DESC ;";

    PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
    statement.setString(1, groupCode);
    statement.setString(2,courseCode);
    statement.setString(3,semesterId);
    ResultSet resultSet = statement.executeQuery();
    while(resultSet.next()){
      Slot slot = new Slot();
      slot.setSlot(resultSet.getString("slot"));
      slot.setTeachingDate(resultSet.getDate("teachingDate"));
      slot.setId(resultSet.getString("id"));
      slot.setCourse(CourseService.getCourse(resultSet.getString("CourseId")));
      slot.setGroup(GroupService.getGroup(resultSet.getString("classId")));
      slot.setRoom(RoomService.getRoom(resultSet.getString("roomId")));
      courseSchedules.add(new SlotResponse(slot));
    }
    return courseSchedules;
  }
}
