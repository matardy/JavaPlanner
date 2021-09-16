/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.IIB.Project;

/**
 *
 * @author Isaac
 */
//CREAMOS VALIDADOR CON EXPRESIONES REGULARES DE LAS 3 PARTES DE LA GUI PARA USUARIO
public class Validador {

   public static boolean verificarNombre(String nombre){
        return nombre.matches("^[a-zA-ZñÑ]+$");
    }
   public static boolean verificarDescripcion(String descripcion){
       return descripcion.matches("^[a-zA-ZñÑ0-9_ ]+$");
   }
    public static boolean verificarDetalles(String detalles){
        return detalles.matches("^[a-zA-ZñÑ]+$");
    }
}
