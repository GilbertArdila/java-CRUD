package com.platzi;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Conecction conexion = new Conecction();
        try(Connection cnx = conexion.get_connection()){

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
