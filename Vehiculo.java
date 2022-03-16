package compartircoche;

/**
 *
 * @author Alberto Paz Pérez
 */
public class Vehiculo {

    String matricula;

    public Vehiculo() {
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    //Función matricula valida
    public static boolean esMatriculaValida(String matricula) {
        matricula = matricula.toUpperCase();
        boolean esValida = true;
        int i = 0;

        //Si la longitud del String no es 7 ya es incorrecta la matricula
        if (matricula.length() != 7) {
            esValida = false;
        } else {
            //Bucle do while para comprobar matricula
            do {
                if (i < 4) {
                    if (!Character.isDigit(matricula.charAt(i))) {
                        esValida = false;
                    }
                } else {
                    esValida = esLetraValida(matricula.charAt(i));
                }
                i++;
            } while (esValida && i < 7);

        }
        return esValida;
    }

    //Función es letra válida
    public static boolean esLetraValida(char ch) {
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        boolean esLetraValida = true;

        //Si no es una letra o si contiene una letra prohibida, el booleano será falso
        if (!letras.contains(String.valueOf(ch))) {
            esLetraValida = false;
        }
        return esLetraValida;
    }
}
