package LLD.ObjectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    Connection connection;

    DbConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
        } catch (Exception e) {
            System.out.println("Error: ");
        }
    }
}
