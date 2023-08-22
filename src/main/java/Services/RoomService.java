package Services;

import Data.DBEntity;
import Models.Entities.Course;
import Models.Entities.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomService{
  public static Room getRoom(String id) throws Exception{
    Room room = new Room();
    String query = "SELECT id, name, buildingname, description FROM dbo.Rooms WHERE Id = '" + id + "'";
    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      room.setId(resultSet.getString("id"));
      room.setName(resultSet.getString("name"));
      room.setDescription(resultSet.getString("description"));
      room.setBuildingName(resultSet.getString("buildingName"));
    }
    return room;
  }

  public static ArrayList<Room> getRooms(String buildingName, String code) throws Exception{
    ArrayList<Room> rooms = new ArrayList<>();
    String query = "SELECT id, name FROM dbo.Rooms WHERE BuildingName = '" + buildingName + "' AND Name LIKE '%" + code + "%'";
    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      Room room = new Room();
      room.setName(resultSet.getString("buildingName") + resultSet.getString("name"));
      rooms.add(room);
    }
    return rooms;
  }

  public static ArrayList<String> getBuildings() throws Exception{
    ArrayList<String> rooms = new ArrayList<>();
    String query = "SELECT BuildingName FROM dbo.Rooms GROUP BY BuildingName";
    ResultSet resultSet = new DBEntity<>(Course.class).getConnection().prepareStatement(query).executeQuery();
    while(resultSet.next()){
      rooms.add(resultSet.getString("buildingName"));
    }
    return rooms;
  }

  public static ArrayList<String> getRoomsInABuilding(String dependence) throws SQLException{
    ArrayList<String> rooms = new ArrayList<>();
    String query = "SELECT Name FROM dbo.Rooms WHERE BuildingName =?";
    PreparedStatement statement = new DBEntity<>(Course.class).getConnection().prepareStatement(query);
    statement.setString(1,dependence);
    ResultSet resultSet = statement.executeQuery();
    while(resultSet.next()){
      rooms.add(resultSet.getString("name"));
    }
    return rooms;
  }
}
