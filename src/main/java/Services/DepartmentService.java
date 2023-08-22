package Services;

import Data.DBEntity;
import Models.Entities.Department;

import java.util.ArrayList;

public class DepartmentService{
  public static Department getDepartment(String id) throws Exception{
    Department department = new Department();
    department.setId(id);
    return new DBEntity<>(Department.class).getObjectsWithConditions(department).get(0);
  }
public static ArrayList<Department> getDepartments() throws Exception{
    return new DBEntity<>(Department.class).getAll();
}
}
