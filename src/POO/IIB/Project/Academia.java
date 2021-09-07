/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.IIB.Project;

import javax.swing.JOptionPane;

/**
 *
 * @author StevG
 */
public class Academia extends Evento{
    String nombreMateria;
    String linkReunion; 
    
    public Academia(String nombre, String descripcion, String detalles,
            String nombreMateria, String linkReunion){
        super(nombre,descripcion,detalles);
        this.nombreMateria = nombreMateria; 
        this.linkReunion = linkReunion; 
    }
    @Override
    public void mostrarEvento(){
        JOptionPane.showMessageDialog(null, "Valor");
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public String getLinkReunion() {
        return linkReunion;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public void setLinkReunion(String linkReunion) {
        this.linkReunion = linkReunion;
    }
    
}
