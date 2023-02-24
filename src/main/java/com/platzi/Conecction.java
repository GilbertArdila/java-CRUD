package com.platzi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecction {

    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app", "root", "0208");
            if (conection != null) {
                System.out.println("Conexión realizada");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conection;
    }
}
