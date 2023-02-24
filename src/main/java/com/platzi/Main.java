package com.platzi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("----------------------------");
            System.out.println("Bienvenido a la aplicación de mensajes");
            System.out.println("1. crear mensaje");
            System.out.println("2. listar mensaje");
            System.out.println("3. editar mensaje");
            System.out.println("4. borrar mensaje");
            System.out.println("5. salir");

            //acciones a realizar de acuerdo a la opción elegida
            switch (option){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensaje();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                default:
                    break;
            }

            //leemos la opción del usuario
            option = sc.nextInt();
        }while (option !=5);


    }

}
