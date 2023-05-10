package metodosCRUD;

import metodosObjetos.Spell;
import metodosObjetos.Unidad;

import java.util.ArrayList;

public class GestionesCRUD {

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

    public static int elegirUnidadHechizo() {
        int eleccion;
        do {
            eleccion = Basicos.numericos("¿ La gestión es sobre una unidad (1) o un hechizo (2) ?");
        } while ((eleccion != 1) && (eleccion != 2));
        return eleccion;
    }

    public static Unidad crearUnidad() {
        String nombre = Basicos.caracteres("Introduzca el nombre de la unidad");
        int coste = Basicos.numericos("Introduzca el coste");
        int vida = Basicos.numericos("Introduzca la vida de la unidad: ");
        int poder = Basicos.numericos("Introduzca el poder de la unidad: ");
        String habilidad = Basicos.caracteres("Introduzca la habilidad de la unidad, si no tiene ninguna escriba null ");
        return new Unidad(nombre, coste, vida, poder, habilidad);
    }

    public static Spell crearHechizo() {
        String nombre = Basicos.caracteres("Introduzca el nombre del nuevo hechizo: ");
        int coste = Basicos.numericos("Introduzca el coste del nuevo hechizo: ");
        String efecto = Basicos.caracteres("Introduzca el efecto: ");
        Spell nuevoHechizo = new Spell(nombre, coste, efecto);
        return new Spell(nombre, coste, efecto);
    }

    public static void buscarCriatura(ArrayList<Unidad> criaturas) {
        int parametro;
        ArrayList<Unidad> aux = new ArrayList<Unidad>();
        String nombreBuscar;
        int costeBuscar;
        String habilidadBuscar;
        System.out.println("Parametros para buscar: ");
        parametro = Basicos.numericos("1. nombre" + "\n" + "2. coste" + "\n" + "3. habilidad");
        switch (parametro) {
            case 1:
                nombreBuscar = Basicos.caracteres("Nombre a buscar: ");
                for (Unidad item : criaturas) {
                    if (item.getNombre().equals(nombreBuscar)) {
                        aux.add(item);
                    }
                }
                System.out.println(aux.toString());
                break;
            case 2:
                costeBuscar = Basicos.numericos("Introduzca el coste:");
                for (Unidad item : criaturas) {
                    if (item.getCoste() == costeBuscar) {
                        aux.add(item);
                    }
                }
                System.out.println(aux.toString());
                break;
            case 3:
                habilidadBuscar = Basicos.caracteres("Introduzca la habilidad");
                for (Unidad item : criaturas) {
                    if (item.getHabilidad().equals(habilidadBuscar)) {
                        aux.add(item);
                    }
                }
                System.out.println(aux.toString());
                break;
        }
    }

    public static void buscarHechizo(ArrayList<Spell> hechizos) {
        int parametro;
        String nombreBuscar;
        int costeBuscar;
        ArrayList<Spell> aux = new ArrayList<Spell>();
        parametro = Basicos.numericos("Seleccione la opción para buscar:" + "\n" + "1. Nombre" + "\n" + "2. Coste");
        if (parametro == 1) {
            nombreBuscar = Basicos.caracteres("Introduzca el nombre del hechizo a buscar: ");
            for (Spell item : hechizos) {
                if (item.getNombre().equals(nombreBuscar)) {
                    aux.add(item);
                }
            }
            System.out.println(aux.toString());
        } else {
            costeBuscar = Basicos.numericos("Introduza el coste a buscar: ");
            for (Spell item : hechizos) {
                if (item.getCoste() == costeBuscar) {
                    aux.add(item);
                }
            }
            System.out.println(aux.toString());
        }
    }

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

    public static void eliminarCriatura(ArrayList<Unidad> criatura) {
        String criaturaEliminar;
        criaturaEliminar = Basicos.caracteres("Introduzca el nombre de la criatura a eliminar: ");
        for (Unidad item : criatura) {
            if (item.getNombre().equals(criaturaEliminar)) {
                criatura.remove(item);
                System.out.println("Eliminado con exito");
            }
        }
    }

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