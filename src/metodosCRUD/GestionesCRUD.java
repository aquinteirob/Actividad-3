package metodosCRUD;

import conexionBD.Conexion;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;

import java.util.InputMismatchException;

public class GestionesCRUD {

    /**
     * Genera un menú de opciones para que el usuario pueda escoger la gestión a realizar, lo pide hasta que el usuario introduzca una opción valida
     * @return entero que representa la gestión seleccionada
     */
    public static int menu() {
        int gestion = 0;
        try {
            do {
                gestion = Basicos.numericos("1 Crea unidad o hechizo." + "\n"
                        + "2 Crear mazo" + "\n"
                        + "3 buscar unidad o hechizo" + "\n"
                        + "4 Modificar unidad o hechizo" + "\n"
                        + "5 Eliminar unidad o hechizo " + "\n"
                        + "6 Salir");
            } while (gestion < 1 || gestion > 6);
        } catch (InputMismatchException e) {
            System.out.println("Escoga un numero de las opciones");
            do {
                gestion = Basicos.numericos("1 Crea unidad o hechizo." + "\n"
                        + "2 Crear mazo" + "\n"
                        + "3 buscar unidad o hechizo" + "\n"
                        + "4 Modificar unidad o hechizo" + "\n"
                        + "5 Eliminar unidad o hechizo " + "\n"
                        + "6 Salir");
            } while (gestion < 1 || gestion > 6);
        }
        return gestion;
    }

    /**
     * Pregunta si la gestión que se quiere realizar es sobre el obj carta es un objeto de tipo unidad (criatura) o Spell (hechizo)
     * @return entero para representar sobre que tipo de carta se realizará la gestión
     */
    public static int elegirUnidadHechizo() {
        int eleccion = 0;
        try {
            do {
                eleccion = Basicos.numericos("¿ La gestión es sobre una unidad (1) o un hechizo (2) ?");
            } while ((eleccion != 1) && (eleccion != 2));
        } catch (InputMismatchException e) {
            System.out.println("Escoga sobre que tipo de carta quiere realizar la gestion");
            elegirUnidadHechizo();
        }
        return eleccion;
    }

    /**
     * Crea un objeto nuevo de Unidad pidiendo por consola los datos de la nueva carta antes de ser añadidos a la base de datos
     * @return un nuevo objeto de la clase Unidad
     */
    public static Unidad crearUnidad() {
        String nombre="";
        int coste = 0;
        int vida = 0;
        int poder = 0;
        nombre = Basicos.caracteres("Introduzca el nombre de la unidad");
        coste = Basicos.numericos("Introduzca el coste");
        vida = Basicos.numericos("Introduzca la vida de la unidad: ");
        poder = Basicos.numericos("Introduzca el poder de la unidad: ");
        String habilidad = Basicos.caracteres("Introduzca la habilidad de la unidad, si no tiene ninguna escriba null ");
        return new Unidad(nombre, coste, vida, poder, habilidad);
    }

    /**
     * Crea un objeto nuevo de Spell pidiendo por consola los datos de la nueva carta antes de añadirlo a la base de datos.
     * @return un objeto nuevo del método Spell
     */
    public static Spell crearHechizo() {
        String nombre="";
        int coste=0;
        String efecto="";
        nombre = Basicos.caracteres("Introduzca el nombre del nuevo hechizo: ");
        coste = Basicos.numericos("Introduzca el coste del nuevo hechizo: ");
        efecto = Basicos.caracteres("Introduzca el efecto: ");
        Spell nuevoHechizo = new Spell(nombre, coste, efecto);
        return new Spell(nombre, coste, efecto);
    }

    /**
     * Metodo para filtrar el parámetro por el que se va a buscar en los obj de tipo criatura almacenados en la base de datos, después del filtrado se busca dicha base
     * Aplica un control sobre las opciones que tiene el usuario para realizar la busqueda.
     */
    public static void buscarCriatura() {
        int parametro;
        String buscar = "";
        String encontrado;
        int costeBuscar;
        try {
            do {
                System.out.println("Parametros para buscar: ");
                parametro = Basicos.numericos("1. nombre" + "\n" + "2. coste" + "\n" + "3. habilidad");
            } while ((parametro != 1) && (parametro != 2) && (parametro != 3));
        }catch (InputMismatchException e){
            System.out.println("Introduzca el número de una de las opciones: ");
            do {
                System.out.println("Parametros para buscar: ");
                parametro = Basicos.numericos("1. nombre" + "\n" + "2. coste" + "\n" + "3. habilidad");
            } while ((parametro != 1) && (parametro != 2) && (parametro != 3));
        }
        switch (parametro) {
            case 1:
                buscar = Basicos.caracteres("Nombre a buscar: ");
                encontrado = Conexion.buscarUnidadHechizodDb(buscar, parametro);
                break;
            case 2:
                costeBuscar = Basicos.numericos("Introduzca el coste:");
                Conexion.buscarCosteDb(costeBuscar);
                break;
            case 3:
                buscar = Basicos.caracteres("Introduzca la habilidad");
                encontrado = Conexion.buscarUnidadHechizodDb(buscar, parametro);
                break;
        }
    }

    /**
     * Metodo para filtrar el parámetro por el que se va a buscar en los objetos de la clase Spell antes de realizar la búsqueda en la base de datos.
     */
    public static void buscarHechizo() {
        int parametro;
        String nombreBuscar;
        int costeBuscar;
        do {
            parametro = Basicos.numericos("Seleccione la opción para buscar:" + "\n" + "1. Nombre" + "\n" + "2. Coste");
        } while ((parametro != 1) && (parametro != 2));
        if (parametro == 1) {
            nombreBuscar = Basicos.caracteres("Introduzca el nombre del hechizo a buscar: ");
            Conexion.buscarUnidadHechizodDb(nombreBuscar, parametro);
        } else {
            costeBuscar = Basicos.numericos("Introduza el coste a buscar: ");
            Conexion.buscarCosteDb(costeBuscar);
        }
    }

    /**
     * Metodo que sirve para pasar una cadena de texto específica para la modificación de alguna criatura llamando al método modificarCarteDB.
     */
    public static void modificarCriatura() {
        String criaturaModificar;
        criaturaModificar = Basicos.caracteres("Introduzca el nombre de la criatura que quiere modificar");
        Conexion.modificarCartaDb(criaturaModificar);
    }

    /**
     * Metodo que sirve para pasar una cadena de texto específica para la modificación de algún hechizo llamando al método modificarCarteDB.
     */
    public static void modificarHechizo() {
        String hechizoModificar;
        hechizoModificar = Basicos.caracteres("Introduzca el nombre del hechizo que quiere modificar: ");
        Conexion.modificarCartaDb(hechizoModificar);
    }

    /**
     * Metodo que sirve para pasar una cadena de texto específica para la eliminación de alguna criatura llamando al método eliminadarCarteDB.
     */
    public static void eliminarCriatura() {
        String criaturaEliminar;
        criaturaEliminar = Basicos.caracteres("Introduzca el nombre de la criatura a eliminar: ");
        Conexion.eliminarCartaDb(criaturaEliminar);
    }

    /**
     * Metodo que sirve para pasar una cadena de texto específica para la eliminación de algún hechizo llamando al método eliminadarCarteDB.
     */
    public static void eliminarHechizo() {
        String hechizoEliminar;
        hechizoEliminar = Basicos.caracteres("Introduzca el nombre del hechizo a eliminar");
        Conexion.eliminarCartaDb(hechizoEliminar);
    }
}