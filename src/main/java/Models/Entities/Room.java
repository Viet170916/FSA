package Models.Entities;

public class Room{
  private String id, name, buildingName, Description;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getBuildingName(){
    return buildingName;
  }

  public void setBuildingName(String buildingName){
    this.buildingName = buildingName;
  }

  public String getDescription(){
    return Description;
  }

  public void setDescription(String description){
    Description = description;
  }

  public Room(String id, String name, String buildingName, String description){
    this.id = id;
    this.name = name;
    this.buildingName = buildingName;
    Description = description;
  }

  public Room(){
  }
}
