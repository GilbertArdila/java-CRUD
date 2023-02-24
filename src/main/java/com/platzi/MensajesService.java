package com.platzi;

import java.util.Scanner;

public class MensajesService {

    /**
     * esta clase servicio nos provee los servicios para el CRUD
     * */
    public static void crearMensaje(){
        //pedimos los datos por consola y los guardamos en variables
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el mensaje");
        String body_message = sc.nextLine();
        System.out.println("Ingresa tu nombre");
        String message_autor = sc.nextLine();
         //creamos objeto de tipo Mensajes y guardamos los datos en el
        Mensajes mensaje= new Mensajes();
        mensaje.setMensaje(body_message);
        mensaje.setAutor_mensaje(message_autor);

        //enviamos a la capa DAO el objeto
        MensajesDAO.crearMensajeDB(mensaje);

    }

    public static void listarMensaje(){
         MensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el id del mensaje a borrar");
        int id = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id);
    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nuevo mensaje");
        String new_body = sc.nextLine();
        System.out.println("Ingresa el id del  mensaje");
        int id = sc.nextInt();
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id);
        actualizacion.setMensaje(new_body);
        MensajesDAO.actualizarMensajeDB(actualizacion);

    }
}
