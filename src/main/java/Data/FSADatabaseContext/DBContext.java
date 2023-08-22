package Data.FSADatabaseContext;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext{
  protected Connection connection;

  public DBContext(){
    //connection
    try{
      String user = "sa";
      String pass = "vietvqhe170916";
      String url = "jdbc:sqlserver://localhost:1433;database=FSA;trustServerCertificate=true;";
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      connection = DriverManager.getConnection(url, user, pass);
    }catch(Exception ex){
      System.out.println("unsuccessful: "+ex.getMessage());
    }
  }
}
