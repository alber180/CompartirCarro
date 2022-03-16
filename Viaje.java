package compartircoche;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *
 * @author Alberto Paz Pérez
 */
public class Viaje {

    protected Conductor conductor;
    protected LocalDateTime fechaHoraSalida;
    protected PuntoEncuentro puntoSalida;
    protected PuntoEncuentro puntoLlegada;
    protected int numPlazasLibres;
    protected String[] pasajeros;
    protected Coche coche;
    
    public Viaje() {
    }

    public Viaje(Conductor conductor, LocalDateTime fechaHoraSalida, PuntoEncuentro puntoSalida, PuntoEncuentro puntoLlegada, int numPlazasLibres) {
        this.conductor = conductor;
        this.fechaHoraSalida = fechaHoraSalida;
        this.puntoSalida = puntoSalida;
        this.puntoLlegada = puntoLlegada;
        if (numPlazasLibres >= conductor.coche.numPlazas || numPlazasLibres < 0) {
            //Si hay demasiadas plazas libres o menores que 0, se asignarán las totales menos la del conductor
            numPlazasLibres = conductor.coche.numPlazas - 1;
            this.numPlazasLibres = numPlazasLibres; 
        } else {
            //Si está dentro del rango permitido, se asigna el valor pasado
            this.numPlazasLibres = numPlazasLibres;
            
        }
        pasajeros = new String[numPlazasLibres];

        
    }

    public boolean addPasajero(Pasajero pasajero) {
        boolean haySitio = false;
        int i = 0;

        if (pasajeros.length != 0) {
            do {
                if (pasajeros[i] == null) {
                    pasajeros[i] = pasajero.nombre;
                    haySitio = true;
                }
                i++;
            } while (!haySitio && i < pasajeros.length);
        }
        return haySitio;
    }
    
    public int plazasOcupadas() {
        int plazasOcupadas = 0;
        if (pasajeros.length != 0) {
            for (String pasajero : pasajeros) {
                if (pasajero != null) {
                    plazasOcupadas++;
                }
            }
        }
        return plazasOcupadas;
    }
    public int plazasLibres() {
        int plazasLibres = 0;
        if (pasajeros.length != 0) {
            for (String pasajero : pasajeros) {
                if (pasajero == null) {
                    plazasLibres++;
                }
            }
        }

        return plazasLibres;
    }

    @Override
    public String toString() {
        String cad = "";
        cad += "-*-*-*-*Viaje resumido*-*-*-*- \n";
        cad += "Conductor: " + conductor.nombre + "\n";
        cad += "Fecha de salida: " + fechaHoraSalida + "\n";
        cad += "Punto de salida: " + puntoSalida.toString() + "\n";
        cad += "Punto de llegada: " + puntoLlegada + "\n";
        cad += "Número de plazas ofertadas a pasajeros: " + numPlazasLibres + "\n";
        cad += "Pasajeros: " + Arrays.toString(pasajeros) + "\n";
        return cad;

    }

}
