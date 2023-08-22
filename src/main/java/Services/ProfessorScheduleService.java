package Services;

import Data.DBEntity;
import Models.Entities.Slot;
import Models.Entities.Professor;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfessorScheduleService{
  public static ArrayList<Slot> getScheduleOfADay(String professorId, String teachingDate) throws Exception{
    ArrayList<Slot> schedule = new ArrayList<>();
    String query =
            "SELECT courseSchedule.Id, date.TeachingDate, CourseId, Description, SubjectId, ProfessorId, ClassId, RoomId,Slot " +
                    " FROM dbo.CourseSchedule_TeachingDate date" +
                    " JOIN dbo.Slot S on date.CourseScheduleId = S.Id" +
                    "         JOIN dbo.CourseSchedules courseSchedule ON courseSchedule.Id = S.CourseScheduleId" +
                    "         JOIN dbo.Courses course ON course.Id = courseSchedule.CourseId " +
                    "WHERE ProfessorId = '" + professorId + "'AND date.TeachingDate = '" + teachingDate + "' ;";
    System.out.println(query);
    ResultSet resultSet = new DBEntity<>(Professor.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    while(resultSet.next()){
      Slot slot = new Slot();
      slot.setId(resultSet.getString("id"));
      slot.setSlot(resultSet.getString("slot"));
      slot.setTeachingDate(resultSet.getDate("TeachingDate"));
      slot.setGroup(GroupService.getGroup(resultSet.getString("ClassId")));
      slot.setRoom(RoomService.getRoom(resultSet.getString("RoomId")));
      slot.setCourse(CourseService.getCourse(resultSet.getString("CourseId")));
      schedule.add(slot);
      System.out.println(slot);
    }
    return schedule;
  }
}
