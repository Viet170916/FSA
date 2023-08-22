package Data;

import Data.FSADatabaseContext.DBContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBEntity<T> extends DBContext{
  private final Class<T> t;

  public DBEntity(Class<T> t){
    this.t = t;
    try{
      this.entityName = t.getDeclaredConstructor().newInstance()
              .getClass()
              .getSimpleName() + "s";
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  private String entityName;

  private T getT(ResultSet result) throws Exception{
    T instance = t.getDeclaredConstructor().newInstance();
    for(Method method : instance.getClass().getDeclaredMethods()){
      String methodName = method.getName();
      if(methodName.contains("set")){
        try{
          method.invoke(instance, result.getString(methodName
                  .replaceAll("set", "")));
        }catch(Exception e){
          System.out.println("get " + entityName + ": " + e.getMessage());
        }
      }
    }
    return instance;
  }

  private String getConditionParamsString(T instance) throws InvocationTargetException, IllegalAccessException{
    StringBuilder conditionParamString = new StringBuilder();
    for(Method method : instance.getClass().getDeclaredMethods()){
      String methodName = method.getName();
      if(methodName.contains("get") && method.invoke(instance) != null){
        conditionParamString.append(method.getName().replaceAll("get", "")).append(" = ? , ");
      }
    }
    conditionParamString.deleteCharAt(conditionParamString.length() - 2);
    return conditionParamString.toString();
  }

  private void setStringForPrepareStatement(PreparedStatement preparedStatement, T instance) throws InvocationTargetException, IllegalAccessException, SQLException{
    int i = 0;
    for(Method method : instance.getClass().getDeclaredMethods()){
      String methodName = method.getName();
      if(methodName.contains("get") && method.invoke(instance) != null){
        try{
          preparedStatement.setString(++i, method.invoke(instance).toString());
        }catch(Exception e){
          System.out.println("add " + methodName + " err: " + e.getMessage());
        }
      }
    }
  }

  //ServiceRepositories
  public ArrayList<T> getAll() throws Exception{
    ResultSet result;
    ArrayList<T> objectsList = new ArrayList<>();
    String query = "SELECT * FROM " + entityName + ";";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(query);
    result = preparedStatement.executeQuery();
    while(result.next()){
      objectsList.add(getT(result));
    }
    return objectsList;
  }

  public ArrayList<T> getObjectsWithConditions(T instance) throws Exception{
    String query = "SELECT * FROM " + entityName + " WHERE " + getConditionParamsString(instance).replaceAll(",","and") + ";";
    ResultSet resultSet;
    ArrayList<T> instances = new ArrayList<>();
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(query);
    setStringForPrepareStatement(preparedStatement,instance);
    resultSet = preparedStatement.executeQuery();
    while(resultSet.next()){
      instances.add(getT(resultSet));
    }
    return instances;
  }

  public void add(T instance) throws InvocationTargetException, IllegalAccessException, SQLException{
    StringBuilder param = new StringBuilder();
    StringBuilder paramValue = new StringBuilder();
    for(Method method : instance.getClass().getDeclaredMethods()){
      String methodName = method.getName();
      if(methodName.contains("get") && method.invoke(instance) != null){
        param.append(method.getName().replaceAll("get", "")).append(",");
        paramValue.append("?,");
      }
    }
    param.deleteCharAt(param.length() - 1);
    paramValue.deleteCharAt(paramValue.length() - 1);
    String query = "INSERT INTO " + entityName + "(" + param + ") VALUES (" + paramValue + ")";
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    setStringForPrepareStatement(preparedStatement, instance);
    preparedStatement.executeUpdate();
  }

  public void delete(T instance){
    PreparedStatement preparedStatement;
    try{
      String query = "DELETE FROM " + entityName + " WHERE " + getConditionParamsString(instance) + ";";
      preparedStatement = connection.prepareStatement(query);
      setStringForPrepareStatement(preparedStatement, instance);
      preparedStatement.executeUpdate();
    }catch(Exception e){
      System.out.println("check: " + e.getMessage());
    }
  }

  public ResultSet getResulSet(String query, PreparedStatement preparedStatement) throws SQLException{
    preparedStatement = connection.prepareStatement(query);
    return preparedStatement.executeQuery();
  }

  public void updateExecute(String query, PreparedStatement preparedStatement) throws SQLException{
    preparedStatement = connection.prepareStatement(query);
    preparedStatement.executeUpdate();
  }
public Connection getConnection(){
    return this.connection;
}
}
