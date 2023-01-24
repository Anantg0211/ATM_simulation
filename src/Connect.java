import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
// Steps to connect database or do jdbc
// 1. Register the driver
// 2. Create connection
// 3. Create statement
// 4. Execute Query
// 5/ close connection
public class Connect {
    Connection c; // here we are making a connection object which connects our database to java application by jdbc
    Statement s; // here we are creating statement which helps to execute query
    Statement e;
    public Connect(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Minnu@123");
            s = c.createStatement();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
