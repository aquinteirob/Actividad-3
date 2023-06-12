import conexionBD.Conexion;
import metodosObjetos.Deck;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;
import metodosCRUD.GestionesCRUD;

import java.util.ArrayList;


public class Controlador {
    public static void main(String[] args) {
        Gestor();
    }

    /**
     * Clase de interacción por consola para las gestiones de un CRUD de cartas
     *
     * @author Quinteiro_Adhemar
     */
    public static void Gestor() {
        int gestion;
        int parametroBuscador;
        ArrayList<Unidad> criaturas = new ArrayList<Unidad>();
        ArrayList<Spell> hechizos = new ArrayList<Spell>();
        Deck mazoNuevo = new Deck(" ");
        int longitudUnidades = criaturas.size();
        int longitudSpell= hechizos.size();

        do {
            gestion = GestionesCRUD.menu();
            switch (gestion) {
                case 1:
                    if (GestionesCRUD.elegirUnidadHechizo() == 1) {
                        criaturas.add(GestionesCRUD.crearUnidad());
                        Conexion.crear(criaturas.get(longitudUnidades));
                    } else {
                        hechizos.add(GestionesCRUD.crearHechizo());
                            Conexion.crear(hechizos.get(longitudSpell));
                    }
                    break;
                case 2:
                    mazoNuevo.addCard(GestionesCRUD.crearUnidad());
                    System.out.println(mazoNuevo);
                    break;
                case 3:
                    if (GestionesCRUD.elegirUnidadHechizo() == 1) {
                        GestionesCRUD.buscarCriatura(criaturas);

                    } else {
                        GestionesCRUD.buscarHechizo(hechizos);
                    }
                    break;
                case 4:
                    if (GestionesCRUD.elegirUnidadHechizo() == 1) {
                        GestionesCRUD.modificarCriatura(criaturas);
                    } else {
                        GestionesCRUD.modificarHechizo(hechizos);
                    }
                    break;
                case 5:
                    if (GestionesCRUD.elegirUnidadHechizo() == 1) {
                        GestionesCRUD.eliminarCriatura(criaturas);
                    } else {
                        GestionesCRUD.eliminarHechizo(hechizos);
                    }
                    break;
            }
        } while (gestion != 6);

    }
}