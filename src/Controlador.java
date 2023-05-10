import metodosObjetos.Deck;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;
import metodosCRUD.GestionesCRUD;

import java.util.ArrayList;


public class Controlador {
    public static void main(String[] args) {
        int gestion;

        ArrayList<Unidad> criaturas = new ArrayList<Unidad>();
        ArrayList<Spell> hechizos = new ArrayList<Spell>();

        Deck mazoNuevo = new Deck(" ");
        do {
            gestion = GestionesCRUD.menu();
            switch (gestion) {
                case 1:
                    if (GestionesCRUD.elegirUnidadHechizo() == 1) {
                        criaturas.add(GestionesCRUD.crearUnidad());
                    } else {
                        hechizos.add(GestionesCRUD.crearHechizo());
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