
package POO.IIB.Project;

/**
 *
 * @author StevG
 */
public abstract class Evento {
    //Falta gestionar ingresar las horas
    protected String nombre; 
    protected String descripcion;
    protected String detalles; 
    
    public Evento(String nombre, String descripcion, String detalles){
        this.nombre= nombre; 
        this.descripcion = descripcion; 
        this.detalles = detalles; 
    }
    
    public abstract void mostrarEvento();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    //Aqui toca añadir los diferentes tipos de datos. 

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDetalles() {
        return detalles;
    }
}
