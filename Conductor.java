package compartircoche;

import java.time.LocalDateTime;

/**
 *
 * @author Alberto Paz Pérez
 */
public class Conductor extends Persona {

    protected Coche coche;
    protected LocalDateTime fechaExpedicion;

    public Conductor() {
    }

    public Conductor(String nombre, Coche coche) {
        this.nombre = nombre;
        this.coche = coche;
    }

    public Conductor(String nombre, Coche coche, LocalDateTime fechaExpedicion) {
        this.nombre = nombre;
        this.coche = coche;
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getAntiguedadPermiso(LocalDateTime fechaExpedicion) {
        int anhosDif;
        int mesesDif;
        String antiguedad;
        anhosDif = LocalDateTime.now().getYear() - fechaExpedicion.getYear();
        mesesDif = (LocalDateTime.now().getDayOfYear() - fechaExpedicion.getDayOfYear()) / 12;

        if (mesesDif < 0) {
            anhosDif -= 1;
        }
        antiguedad = "Años: " + anhosDif;

        return antiguedad;
    }

}
