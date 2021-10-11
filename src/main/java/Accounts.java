import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Accounts {
  
  public static void main(String[] args) {
  
    System.out.println("First line of code for my project!!");
    Scanner sc = new Scanner(System.in);
    String login_name = "";
    String login_pass = "";
    String username = "";
    String action_choice;
    boolean name_logged = false;
    boolean password_logged = false;
    
    try {
      
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts",
              "Eclipse", "Rehan@405170");
  
      Statement stmt = connection.createStatement();
  
      System.out.println("Welcome to Discovery rewards Accounts, please login to your account");
      System.out.println("Please enter your username, or '0' if you would like to exit:\n");
      login_name = sc.nextLine();
      
      while (!name_logged && !password_logged ) {
        while (!name_logged) {
          String sql_name = "SELECT * FROM users WHERE user_name = '" + login_name + "'";
          try {
            ResultSet rs_name = stmt.executeQuery(sql_name);
            //rs_name.next();
            
            if (rs_name.next()) {
              System.out.println("Welcome!!");
              System.out.println(rs_name.getString("user_name"));
              name_logged = true;
            } else {
              System.out.println("Invalid username, please try again\n");
              login_name = sc.nextLine();
              continue;
            }
          }catch (Exception e){
            e.printStackTrace();
        }
      }
        
        System.out.println("Please enter the password for user " + login_name + "\n");
        login_pass = sc.nextLine();
        while (!password_logged){
          String sql_pass = "SELECT * FROM users WHERE user_name = '" + login_pass + "'";
          ResultSet rs_pass = stmt.executeQuery(sql_pass);
          if(rs_pass.next()){
            System.out.println("Success");
            password_logged = true;
          } else {
            System.out.println("Invalid password, please try again\n");
            login_pass = sc.nextLine();
            continue;
          }
        }
        
      }
  
      System.out.println(login_name + "Please select which action you would like to do. 'view' to view " +
                                 "your " +
                                 "current miles, 'add' to add newly gained miles to your account " +
                                 "or 'withdraw' to withdraw miles for rewards\n");
      action_choice = sc.nextLine();
      
      if(action_choice.toLowerCase().equals("view")){
        System.out.println("Please enter username:\n");
        username = sc.nextLine();
        String sql_view_miles = "SELECT * FROM miles WHERE user_name = '" + username + "'";
        ResultSet view = stmt.executeQuery(sql_view_miles);
          if(view.next()){
            System.out.println(view.getString("user_name"));
            System.out.println(view.getString("Total_Miles"));
          }
        }
  
      if(action_choice.toLowerCase().equals("add")){
        System.out.println("Please enter username:\n");
        username = sc.nextLine();
        String sql_view_miles = "SELECT * FROM miles WHERE user_name = '" + username + "'";
        ResultSet view = stmt.executeQuery(sql_view_miles);
        if(view.next()){
          System.out.println(view.getString("user_name"));
          System.out.println(view.getString("Total_Miles"));
          System.out.println("Amount of miles to be added:\n");
        }
      }
  
      if(action_choice.toLowerCase().equals("view")){
        System.out.println("Please enter username:\n");
        username = sc.nextLine();
        String sql_view_miles = "SELECT * FROM miles WHERE user_name = '" + username + "'";
        ResultSet view = stmt.executeQuery(sql_view_miles);
        if(view.next()){
          System.out.println(view.getString("user_name"));
          System.out.println(view.getString("Total_Miles"));
        }
      }
      
    } catch (Exception e){
      e.printStackTrace();
    }
    
  }
}
