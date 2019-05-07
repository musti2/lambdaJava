package jdbcsample;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.sql.*;

public class JDBCSample {
  private static final String CREATE_TABLE_SQL = "CREATE TABLE REGISTRATION " +
                        "(id INTEGER not NULL, " +
                        " first VARCHAR(255), " + 
                        " last VARCHAR(255), " + 
                        " age INTEGER, " + 
                        " PRIMARY KEY ( id ))"; 
  
  public static void main(String[] args) throws SQLException {
    String URI = "jdbc:mysql://mycloudsql.cqn3yevtqiix.ap-northeast-1.rds.amazonaws.com:3306/BORAJI";
    String username = "adminuser";
    String password = "adminuser";

    Connection conn = null;
    Statement stmt = null;

    try {
      conn = DriverManager.getConnection(URI, username, password);
      stmt = conn.createStatement();
      stmt.executeUpdate(CREATE_TABLE_SQL);
      System.out.println("Table created");

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Caught Exception: " + e.getMessage());
    } finally {
      try {
        // Close connection
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Caught Exception: " + e.getMessage());
      }
    }
  }
}
