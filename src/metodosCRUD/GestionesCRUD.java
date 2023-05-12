package metodosCRUD;

import conexionBD.Conexion;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;

import java.util.ArrayList;

public class GestionesCRUD {

    /**
     * Genera un menú de opciones para que el usuario pueda escoger la gestión a realizar
     * @return entero que representa la gestión seleccionada
     * @author Quinteiro_Adhemar
     */
    public static int menu() {
        int gestion;
        do {
            gestion = Basicos.numericos("1 Crea unidad o hechizo." + "\n"
                    + "2 Crear mazo" + "\n"
                    + "3 buscar unidad o hechizo" + "\n"
                    + "4 Modificar unidad o hechizo" + "\n"
                    + "5 Eliminar unidad o hechizo " + "\n"
                    + "6 Salir");
        } while (gestion < 1 || gestion > 6);
        return gestion;
    }

    /**
     * Pregunta si la gestión que se quiere realizar es sobre una carta de tipo unidad (criatur) o un hechizo
     * @return entero para representar sobre que tipo de carta se realizará la gestión
     * @author Quinteiro_Adhemar
     */
    public static int elegirUnidadHechizo() {
        int eleccion;
        do {
            eleccion = Basicos.numericos("¿ La gestión es sobre una unidad (1) o un hechizo (2) ?");
        } while ((eleccion != 1) && (eleccion != 2));
        return eleccion;
    }

    /**
     * Crea un objeto nuevo de Unidad pidiendo por consola los datos de la nueva carta
     * @return un objeto del método Unidad
     * @author Quinteiro_Adhemar
     */
    public static Unidad crearUnidad() {
        String nombre = Basicos.caracteres("Introduzca el nombre de la unidad");
        int coste = Basicos.numericos("Introduzca el coste");
        int vida = Basicos.numericos("Introduzca la vida de la unidad: ");
        int poder = Basicos.numericos("Introduzca el poder de la unidad: ");
        String habilidad = Basicos.caracteres("Introduzca la habilidad de la unidad, si no tiene ninguna escriba null ");
        return new Unidad(nombre, coste, vida, poder, habilidad);
    }

    /**
     * Crea un objeto nuevo de Spell pidiendo por consola los datos de la nueva carta
     * @return un objeto nuevo del método Spell
     * @author Quinteiro_Adhemar
     */
    public static Spell crearHechizo() {
        String nombre = Basicos.caracteres("Introduzca el nombre del nuevo hechizo: ");
        int coste = Basicos.numericos("Introduzca el coste del nuevo hechizo: ");
        String efecto = Basicos.caracteres("Introduzca el efecto: ");
        Spell nuevoHechizo = new Spell(nombre, coste, efecto);
        return new Spell(nombre, coste, efecto);
    }

    /**
     * Busca si existe una unidad en el arreglo donde se almacenan los objetos de Unidad, se puede buscar por nombre, coste o habilidad
     * @param criaturas Lista donde se almacenan los objetos de tipo Unidad
     * @author Quinteiro_Adhemar
     */
    public static void buscarCriatura(ArrayList<Unidad> criaturas) {
        int parametro;
        ArrayList<Unidad> aux = new ArrayList<Unidad>();
        String buscar="";
        int costeBuscar;
        do {
            System.out.println("Parametros para buscar: ");
            parametro = Basicos.numericos("1. nombre" + "\n" + "2. coste" + "\n" + "3. habilidad");
        }while((parametro!=1)&&(parametro!=2)&&(parametro!=3));
        switch (parametro) {
            case 1:
                buscar = Basicos.caracteres("Nombre a buscar: ");
                Conexion.buscarUnidaHechizodDb(buscar,parametro);
                break;
            case 2:
                costeBuscar = Basicos.numericos("Introduzca el coste:");
                Conexion.buscarCosteDb(costeBuscar);
                break;
            case 3:
                buscar = Basicos.caracteres("Introduzca la habilidad");
                Conexion.buscarUnidaHechizodDb(buscar,parametro);
                break;
        }
    }

    /**
     * Busca si existe un hechizo en el arreglo donde se almacenan los objetos de Spell, dando la opción a filtrar por nombre o coste
     * @param hechizos Lista donde se almacenan los objetos de tipo Spell
     * @author Quinteiro_Adhemar
     */
    public static void buscarHechizo(ArrayList<Spell> hechizos) {
        int parametro;
        String nombreBuscar;
        int costeBuscar;
        ArrayList<Spell> aux = new ArrayList<Spell>();
        do {
            parametro = Basicos.numericos("Seleccione la opción para buscar:" + "\n" + "1. Nombre" + "\n" + "2. Coste");
        }while((parametro!=1)&&(parametro!=2));
        if (parametro == 1) {
            nombreBuscar = Basicos.caracteres("Introduzca el nombre del hechizo a buscar: ");
            Conexion.buscarUnidaHechizodDb(nombreBuscar,parametro);
        } else {
            costeBuscar = Basicos.numericos("Introduza el coste a buscar: ");
            Conexion.buscarCosteDb(costeBuscar);
        }
    }

    /**
     * Modifica un objeto de tipo Unidad, buscando primero si existe en la lista donde se almacenan, solo se permite la búsqueda por nombre de la unidad y posteriormente se piden los datos nuevos al usuario. La busqueda se hace solo por nombre
     * @param criaturas Lista donde se almacenan los objetos de tipo Unidad
     * @author Quinteiro_Adhemar
     */
    public static void modificarCriatura(ArrayList<Unidad> criaturas) {
        String criaturaModificar;
        int modificar;
        String nuevoNombre;
        int nuevoCosto;
        String nuevaHabilidad;
        int nuevoPoder;
        int nuevaVida;
        System.out.println(criaturas);
        criaturaModificar = Basicos.caracteres("Introduzca el nombre de la criatura que quiere modificar");
        for (Unidad item : criaturas) {
            if (item.getNombre().equals(criaturaModificar)) {
                modificar = Basicos.numericos("Parámetro a modificar: " + "\n" + "1. nombre" + "\n" + "2. costo" + "\n" + "3. habilidad" + "\n" + "4. poder" + "\n" + "5. vida");
                switch (modificar) {
                    case 1:
                        nuevoNombre = Basicos.caracteres("Introduzca el nuevo nombre");
                        item.setNombre(nuevoNombre);
                        System.out.println("modificado con exito");
                        break;
                    case 2:
                        nuevoCosto = Basicos.numericos("Introduzca el nuevo costo");
                        item.setCoste(nuevoCosto);
                        System.out.println("modificado con exito");
                        break;
                    case 3:
                        nuevaHabilidad = Basicos.caracteres("Nueva habilidad");
                        item.setHabilidad(nuevaHabilidad);
                        System.out.println("modificado con exito");
                        break;
                    case 4:
                        nuevoPoder = Basicos.numericos("Nuevo poder");
                        item.setPoder(nuevoPoder);
                        System.out.println("modificado con exito");
                        break;
                    case 5:
                        nuevaVida = Basicos.numericos("Nueva vida");
                        item.setVida(nuevaVida);
                        System.out.println("modificado con exito");
                        break;
                }
            }
        }
    }

    /**
     * Modifica un objeto de tipo Spell, buscando primero si existe en la lista donde se almacenan, solo se permite la búsqueda por nombre del hechizo y posteriormente se piden los datos nuevos al usuario. La busqueda se hace solo por nombre
     * @param hechizos Lista donde se almacenan los objetos de tipo Spell
     * @author Quinteiro_Adhemar
     */
    public static void modificarHechizo(ArrayList<Spell> hechizos) {
        String hechizoModificar;
        int modificar;
        String nuevoNombre;
        int nuevoCosto;
        String nuevoEfecto;
        System.out.println(hechizos);
        hechizoModificar = Basicos.caracteres("Introduzca el nombre del hechizo que quiere modificar: ");
        for (Spell item : hechizos) {
            if (item.getNombre().equals(hechizoModificar)) {
                modificar = Basicos.numericos("Parámetro a modificar: " + "\n" + "1. nombre" + "\n" + "2. costo" + "\n" + "3. efecto");
                switch (modificar) {
                    case 1:
                        nuevoNombre = Basicos.caracteres("nuevo nombre: ");
                        item.setNombre(nuevoNombre);
                        System.out.println("modificado con exito");
                        break;
                    case 2:
                        nuevoCosto = Basicos.numericos("nuevo costo: ");
                        item.setCoste(nuevoCosto);
                        System.out.println("modificado con exito");
                        break;
                    case 3:
                        nuevoEfecto = Basicos.caracteres("Nuevo efecto");
                        item.setEfecto(nuevoEfecto);
                        System.out.println("modificado con exito");
                }
            }
        }
    }

    /**
     * Modifica un objeto de tipo Unidad, buscando primero si existe en la lista donde se almacenan los objetos de este tipo y en caso de existir borra dicho objeto. La busqueda del objeto a borrar se hace mediante el nombre que se le pide al usuario
     * @param criaturas Lista donde se almacenan los objetos de tipo Unidad
     * @author Quinteiro_Adhemar
     * @see " https://www.geeksforgeeks.org/list-removeobject-obj-method-in-java-with-examples/ "
     */
    public static void eliminarCriatura(ArrayList<Unidad> criaturas) {
        String criaturaEliminar;
        criaturaEliminar = Basicos.caracteres("Introduzca el nombre de la criatura a eliminar: ");
        for (Unidad item : criaturas) {
            if (item.getNombre().equals(criaturaEliminar)) {
                criaturas.remove(item);
                System.out.println("Eliminado con exito");
            }
        }
    }

    /**
     * Modifica un objeto de tipo Spell, buscando primero si existe en la lista donde se almacenan los objetos de este tipo y en caso de existir borra dicho objeto. La busqueda del objeto a borrar se hace mediante el nombre que se le pide al usuario
     * @param hechizos Lista donde se almacenan los objetos de tipo Spell
     * @author Quinteiro_Adhemar
     * @see "https://www.geeksforgeeks.org/list-removeobject-obj-method-in-java-with-examples/"
     */
    public static void eliminarHechizo(ArrayList<Spell> hechizos) {
        String hechizoEliminar;
        hechizoEliminar = Basicos.caracteres("Introduzca el nombre de la criatura a eliminar");
        for (Spell item : hechizos) {
            if (item.getNombre().equals(hechizoEliminar)) {
                hechizos.remove(item);
            }
        }
    }
}