package compartircoche;

/**
 *
 * @author Alberto Paz Pérez
 */
public class Pasajero extends Persona {
    
    
    public Pasajero() {
    }

    public Pasajero(String nombre) {
        this.nombre = nombre;
    }

    
    public Pasajero(String nombre, String telefono, String dni) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;
    }
    
    
    
}
