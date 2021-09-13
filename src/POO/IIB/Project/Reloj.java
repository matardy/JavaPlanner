/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.IIB.Project;

import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;//para el formato de 24HH en el reloj
import javax.swing.JLabel;

/**
 *
 * @author madelyn.fernandez
 */
public class Reloj extends Thread{//extiendo de la clase hilo y puedo utilizar Thread = Hilo
    //todas las caracteristicas de tipo hilo
    private JLabel lbl;//Variable de tipo JLabel es cabiante
    private int horaingresada;
    private int minutoingresado;
    private int segundoingresado;
    private String horaComparada;
    public GUICalendar guiR;

    public Reloj(JLabel lbl) {
        this.lbl = lbl;
    }

    public Reloj(int horaingresada, int minutoingresado, int segundoingresado) {
        this.horaingresada = horaingresada;
        this.minutoingresado = minutoingresado;
        this.segundoingresado = segundoingresado;
    }

    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }

    public int getHoraingresada() {
        return horaingresada;
    }

    public void setHoraingresada(int horaingresada) {
        this.horaingresada = horaingresada;
    }

    public int getMinutoingresado() {
        return minutoingresado;
    }

    public void setMinutoingresado(int minutoingresado) {
        this.minutoingresado = minutoingresado;
    }

    public int getSegundoingresado() {
        return segundoingresado;
    }

    public void setSegundoingresado(int segundoingresado) {
        this.segundoingresado = segundoingresado;
    }
    
    //metodo para que cargue el reloj 
    @Override
    public void run(){
        while(true){
            Date hoy = new Date ();//atributo de la clase Date, encapsula la hora
            //y fecha actual, permite tener dos construnctores:  
            //1)inicializa la fecha y hora actual

            //Formato de la fecha
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss", Locale.UK);
            
            //al atributo de tipo JLabel le pasamos el formatoHora
            lbl.setText(formatoHora.format(hoy));
            
            try{
                sleep(1000);//el reloj se va actualizar cada segundo 
            } catch (Exception ex) {  
                
            }
        }
    }
    
}
