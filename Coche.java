package compartircoche;

/**
 *
 * @author Alberto Paz Pérez
 */
public class Coche {

    protected String nombre;
    protected String color;
    protected int numPlazas;
    protected String matricula;
    
    protected enum Combustible {DIESEL, GASOLINA, ELECTRICO, HIBRIDO}
    protected Combustible combustible;
    
    String distintivoAmb;
    
    public Coche() {

    }

    public Coche(String nombre, String color, int numPlazas, String matricula, Combustible combustible, String distintivoAmb) {
        //Primero comprobamos si la amtrícula es válida, de ser así creamos los valores
        if (Vehiculo.esMatriculaValida(matricula)) {
            this.matricula = matricula;
            this.nombre = nombre;
            this.color = color;
            //Un coche ha de tener un mínimo de 2 plazas totales
            if (numPlazas < 2) {
                this.numPlazas = 2;
            } else {
                this.numPlazas = numPlazas;
            }
            //Si la matrícula no es válida, da mensaje de error
        } else {
            System.out.println("Matrícula inválida, no se guardarán los datos del coche");
            //Este this se tendrá que quitar, sin el ahora da error al verificar las plazas libres
            this.numPlazas = 2;
        }
        this.combustible = combustible;
        this.distintivoAmb = distintivoAmb;
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
