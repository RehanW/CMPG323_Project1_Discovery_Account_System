import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Accounts {
  
  public static void main(String[] args) {
  
    System.out.println("First line of code for my project!!");
    
    try {
      
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts",
              "Eclipse", "Rehan@405170");
  
      Statement statement = connection.createStatement();
  
      ResultSet resultSet = statement.executeQuery("select * from users");
  
      while (resultSet.next()) {
        System.out.println(resultSet.getString("user_name"));
        System.out.println(resultSet.getString("user_password"));
      }
    } catch (Exception e){
      e.printStackTrace();
    }
    
  }
}
