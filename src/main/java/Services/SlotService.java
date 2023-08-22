package Services;

import Data.DBEntity;
import Models.Entities.Course;
import Models.Entities.Slot;
import Models.Responses.SlotResponse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SlotService{
  public static Slot getCourseSchedule(String teachingDate_id) throws Exception{
    Slot course = new Slot();
    String query = "SELECT teachingDate.Id, classid, courseid, roomid, slot, teachingdate FROM dbo.Slot slot JOIN dbo.CourseSchedules schedule ON schedule.Id = slot.CourseScheduleId  JOIN dbo.CourseSchedule_TeachingDate teachingDate ON slot.Id = teachingDate.CourseScheduleId WHERE teachingDate.Id = '" + teachingDate_id + "'";
    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      course.setId(resultSet.getString("Id"));
      course.setGroup(
              GroupService.getGroup(resultSet.getString("classId"))
      );
      course.setCourse(
              CourseService.getCourse(resultSet.getString("courseId"))
      );
      course.setRoom(
              RoomService.getRoom(resultSet.getString("roomId"))
      );
      course.setSlot(resultSet.getString("slot"));
      course.setTeachingDate(resultSet.getDate("teachingDate"));
    }
    System.out.println(course);
    return course;
  }

  public static Slot getCourseScheduleByDateAndGroup(String date, String groupCode, String subjectCode) throws Exception{
    Slot slot = new Slot();
    String query = "SELECT teachingDate.Id, classid, courseid, roomid, slot, teachingdate " +
            "FROM dbo.Slot slot JOIN dbo.CourseSchedules schedule ON schedule.Id = slot.CourseScheduleId  " +
            "JOIN dbo.CourseSchedule_TeachingDate teachingDate ON slot.Id = teachingDate.CourseScheduleId " +
            "JOIN dbo.Courses course on course.Id = schedule.CourseId " +
            "JOIN dbo.Subjects subject ON course.SubjectId = subject.Id " +
            "JOIN dbo.Classes class on class.Id = schedule.ClassId " +
            "WHERE teachingDate.TeachingDate = ? AND class.Code = ? AND subject.Code = ?";
    PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
    statement.setString(1, date);
    statement.setString(2, groupCode);
    statement.setString(3, subjectCode);
    ResultSet resultSet = statement.executeQuery();
    while(resultSet.next()){
      slot.setId(resultSet.getString("Id"));
      slot.setGroup(
              GroupService.getGroup(resultSet.getString("classId"))
      );
      slot.setCourse(
              CourseService.getCourse(resultSet.getString("courseId"))
      );
      slot.setRoom(
              RoomService.getRoom(resultSet.getString("roomId"))
      );
      slot.setSlot(resultSet.getString("slot"));
      slot.setTeachingDate(resultSet.getDate("teachingDate"));
    }
    return slot;
  }

  public static void UpdateSlot(SlotResponse slot) throws SQLException{ //teaching date
    System.out.println("Id: " + slot.getId());
    System.out.println("date: " + slot.getTeachingDate());
    System.out.println("room: " + slot.getRoom().getName());
    System.out.println("building: " + slot.getRoom().getBuildingName());
    System.out.println("slot: " + slot.getSlot());
    System.out.println("course: " + slot.getCourse().getSubject().getCode());
    System.out.println("courseId: " + slot.getCourse().getId());
    System.out.println("groupId: " + slot.getGroup().getId());
    PreparedStatement statement;
    //update or add and update slot to teachingDate
    ;
    String testQuery = "SELECT * FROM dbo.CourseSchedule_TeachingDate ctd " +
            "JOIN dbo.Slot S on S.Id = ctd.CourseScheduleId " +
            "JOIN dbo.CourseSchedules CS on CS.Id = S.CourseScheduleId " +
            "WHERE ctd.TeachingDate = ? AND S.Slot = ? AND (ctd.RoomId = ? OR CS.ClassId = ?)";
    statement = new DBEntity<>(Course.class).getConnection().prepareStatement(testQuery);
    statement.setString(1, slot.getTeachingDate());
    statement.setString(2, slot.getSlot());
    statement.setString(3, slot.getRoom().getId());
    statement.setString(4, slot.getGroup().getId());

    ResultSet resultSet = statement.executeQuery();
    if(resultSet.next()){
      SQLException exception = new SQLException("Cant be update because this date exists a slot is processing with this room or with this group");
      throw  exception;
    }

    String updateSlotQuery = "UPDATE dbo.CourseSchedule_TeachingDate SET CourseScheduleId = (SELECT id FROM dbo.Slot\n" +
            "                        WHERE Slot = ? AND CourseScheduleId = (SELECT CourseSchedules.Id\n" +
            "                                                                                                FROM dbo.CourseSchedules  join dbo.Courses C on C.Id = CourseSchedules.CourseId\n" +
            "                                                                                                join dbo.Subjects S on S.Id = C.SubjectId\n" +
            "                                                                                                WHERE S.Code =? ))  " +
            "WHERE CourseSchedule_TeachingDate.Id = ? ;";
    try{
      String addSlot = "INSERT INTO dbo.Slot (Slot, CourseScheduleId) " +
              "VALUES (?,(SELECT Id FROM dbo.CourseSchedules WHERE CourseSchedules.CourseId =? AND CourseSchedules.ClassId = ?))";
      statement = new DBEntity<>(Course.class).getConnection().prepareStatement(addSlot);
      statement.setString(1, slot.getSlot());
      statement.setString(2, slot.getCourse().getId());
      statement.setString(3, slot.getGroup().getId());
      statement.executeUpdate();
    }catch(SQLException e1){
      System.out.println("SlotService: e1: " + e1.getMessage() + "\n and " + e1.getSQLState());
      System.out.println("SlotService: e1: may be user update with the slot and courseSchedule(group and course) is existing");
//      throw e1;
    }
    String updateTeachingDateQuery;
    try{
      statement = new DBEntity<>(Course.class).getConnection().prepareStatement(updateSlotQuery);
      statement.setString(1, slot.getSlot());
      statement.setString(2, slot.getCourse().getSubject().getCode());
      statement.setString(3, slot.getId());
      statement.executeUpdate();
    }catch(SQLException e){
      System.out.println("SlotService: e: " + e.getMessage());
      throw e;
    }
    try{
      updateTeachingDateQuery = "UPDATE  dbo.CourseSchedule_TeachingDate SET TeachingDate = ?, RoomId = (SELECT Id FROM dbo.Rooms WHERE BuildingName = ? AND Name = ?) WHERE Id = ?";
      statement = new DBEntity<>(Course.class).getConnection().prepareStatement(updateTeachingDateQuery);
      statement.setString(1, slot.getTeachingDate());
      statement.setString(2, slot.getRoom().getBuildingName());
      statement.setString(3, slot.getRoom().getName());
      statement.setString(4, slot.getId());
      statement.executeUpdate();
    }catch(SQLException e){
      System.out.println("updateTeachingDate: e: " + e.getMessage());
      System.out.println("updateTeachingDate: e: may be teaching date and slot is existing");
      throw e;
    }
    System.out.println("successfully updating slot");

//    statement.setString(1, slot.getSlot());
//    statement.setString(2, slot.getId());
//    statement.executeUpdate();
//    statement = new DBEntity<>(Course.class).getConnection().prepareStatement(updateSlotQuery);
//    statement.setString(1, slot.getTeachingDate());
//    statement.setString(2, slot.getId());
//    statement.executeUpdate();
//    statement = new DBEntity<>(Course.class).getConnection().prepareStatement(updateRoomQuery);
//    statement.setString(1, slot.getRoom().getBuildingName());
//    statement.setString(2, slot.getRoom().getName());
//    statement.setString(3, slot.getRoom().getBuildingName());
//    ResultSet resultSet = statement.executeQuery();
  }
}
