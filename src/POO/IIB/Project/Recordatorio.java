/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.IIB.Project;

/**
 *
 * @author StevG
 */
public class Recordatorio extends Evento{
    private int hora;
    private int minutos;
    private int segundos; 
    public Recordatorio(String nombre, String descripcion, String detalles, int hora, int minutos, int segundos){
        super(nombre, descripcion, detalles);
        this.hora = hora; 
        this.minutos = minutos; 
        this.segundos = segundos; 
    }
    
}
