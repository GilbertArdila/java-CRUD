package com.platzi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecction {
    /**
     * creamos la conección a la base de datos
     * */

    public Connection get_connection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "0208");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conection;
    }
}
