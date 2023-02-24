package com.platzi;

import com.platzi.Mensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
/**
 * capa DAO data access object
 * */
    public static void crearMensajeDB(Mensajes mensaje){
       Conexion db_connect = new Conexion();
       try(Connection conexion = db_connect.get_connection();){
           PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes(mensaje,autor_mensaje) VALUES(?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2,mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            }catch (SQLException ex){
                System.out.println(ex);
            }
       } catch (SQLException e) {
           System.out.println(e);
       }
    }

    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection();){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
              String query = "SELECT * FROM mensajes";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()){
                    //estos son los nombres de las columnas en la db
                    System.out.println("ID: "+rs.getInt("id_mensaje")+"\nMensaje: "+rs.getString("mensaje")+
                            "\nAutor: "+rs.getString("autor_mensaje")+"\nFecha: "+rs.getString("fecha_mensaje"));
                    System.out.println("---------------------------------");
                }
            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("Mensajes no recuperados :(");

            }
        }
         catch (SQLException e) {
             System.out.println(e);;
        }
    }

    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection();){
            PreparedStatement ps = null;
            try{
               String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
               ps = conexion.prepareStatement(query);
               ps.setInt(1 ,id_mensaje);
               ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("Imposible borrar el mensaje");
            }

        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection();){
            PreparedStatement ps = null;
            try{
                String query = "UPDATE  mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado con exito");
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("El mensaje no se ha actualizado");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Conección no realizada");
        }
    }
}
