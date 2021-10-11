import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Accounts {
  
  public static void main(String[] args) {
  
    System.out.println("First line of code for my project!!");
    Scanner action = new Scanner(System.in);
    Scanner username = new Scanner(System.in);
    String action_choice;
    
    try {
      
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts",
              "Eclipse", "Rehan@405170");
  
      Statement statement = connection.createStatement();
  
      ResultSet resultSet = statement.executeQuery("select * from users");
  
      while (resultSet.next()) {
        System.out.println(resultSet.getString("user_name"));
        System.out.println(resultSet.getString("user_password"));
      }
  
      System.out.println("Please select which action you would like to do. 'view' to view your " +
                                 "current miles, 'add' to add newly gained miles to your account " +
                                 "or 'withdraw' to withdraw miles for rewards");
      System.out.println(action.nextLine());
      action_choice = action.toString();
      
      if(action_choice.toLowerCase() == "view"){
        System.out.println("Please enter username:");
        System.out.println(username.nextLine());
        String user_check = String.valueOf(username);
        
        ResultSet view = statement.executeQuery("select * from miles");
        while(view.next()){
          if(user_check == view.toString()){
            System.out.println(view.getString("user_name"));
            System.out.println(view.getString("Total_Miles"));
          }
        }
      }
  
      if(action_choice.toLowerCase() == "add"){
        System.out.println("Please enter username:");
        System.out.println(username.nextLine());
        String user_check = String.valueOf(username);
        
        ResultSet add = statement.executeQuery("select * from miles");
        while(add.next()){
          if(user_check == add.toString()){
            System.out.println(add.getString("user_name"));
            System.out.println(add.getString("Total_Miles"));
          }
        }
      }
  
      if(action_choice.toLowerCase() == "withdraw"){
        System.out.println("Please enter username:");
        System.out.println(username.nextLine());
        String user_check = String.valueOf(username);
        
        ResultSet withdraw = statement.executeQuery("select * from miles");
        while(withdraw.next()){
          if(user_check == withdraw.toString()){
            System.out.println(withdraw.getString("user_name"));
            System.out.println(withdraw.getString("Total_Miles"));
          }
        }
      }
      
    } catch (Exception e){
      e.printStackTrace();
    }
    
  }
}
