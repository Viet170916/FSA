package Services;

import Data.DBEntity;
import Models.Entities.Attendance;
import Models.Entities.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AttendanceService{
  public static ArrayList<Attendance> getSchedule(String studentId) throws Exception{
    ArrayList<Attendance> scheduleOfAWeek = new ArrayList<>();
    String query =
            "SELECT id, description, courseschedule_teachingdateid, isabsent, semesterid " +
                    "FROM dbo.Attendances WHERE StudentId = '" + studentId + "'";
    ResultSet resultSet = new DBEntity<>(Student.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    while(resultSet.next()){
      Attendance attendance = new Attendance();
      attendance.setId(resultSet.getString("id"));
      attendance.setDescription(resultSet.getNString("description"));
      attendance.setAbsent(resultSet.getString("isAbsent"));
      attendance.setStudent(
              StudentService.getStudentInformation(studentId)
      );
      attendance.setSemester(
              SemesterService.getSemester(
                      resultSet.getString("semesterId")
              )
      );
      attendance.setCourseSchedule(
              SlotService.getCourseSchedule(
                      resultSet.getString("courseSchedule_teachingDateId")
              )
      );
      scheduleOfAWeek.add(attendance);
    }
    return scheduleOfAWeek;
  }

  public static ArrayList<Attendance> getScheduleOfAWeek(String studentId,String teachingDate) throws Exception{
    ArrayList<Attendance> scheduleOfAWeek = new ArrayList<>();
    String query =
            "SELECT attendance.id, description, courseschedule_teachingdateid, isabsent, semesterid, date.TeachingDate " +
                    "FROM dbo.Attendances attendance JOIN dbo.CourseSchedule_TeachingDate date ON attendance.CourseSchedule_TeachingDateId = date.Id " +
                    "WHERE StudentId = '" + studentId + "' AND date.TeachingDate = '"+teachingDate+"' ";
    ResultSet resultSet = new DBEntity<>(Student.class)
            .getConnection()
            .prepareStatement(query)
            .executeQuery();
    while(resultSet.next()){
      Attendance attendance = new Attendance();
      attendance.setId(resultSet.getString("id"));
      attendance.setDescription(resultSet.getNString("description"));
      attendance.setAbsent(resultSet.getString("isAbsent"));
      attendance.setStudent(
              StudentService.getStudentInformation(studentId)
      );
      attendance.setSemester(
              SemesterService.getSemester(
                      resultSet.getString("semesterId")
              )
      );
      attendance.setCourseSchedule(
              SlotService.getCourseSchedule(
                      resultSet.getString("courseSchedule_teachingDateId")
              )
      );
      scheduleOfAWeek.add(attendance);
    }
    return scheduleOfAWeek;
  }

}
