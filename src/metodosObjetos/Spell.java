package metodosObjetos;

import metodosCRUD.Basicos;

import java.util.ArrayList;

public class Spell extends Carta {
    private String efecto;

    /**
     * Constructor de la clase Spell que sirve para la creación de hechizos, hereda de Carta
     * @param nombre atributo heredado de Carta
     * @param coste atributo heredado de Carta
     * @param efecto Acción que realiza el hechizo al ser jugado
     * @author Quinteiro_Adhemar
     */
    public Spell(String nombre, int coste, String efecto) {
        super(nombre, coste);
        this.efecto = efecto;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "nombre='" + nombre + '\'' +
                ", coste=" + coste +
                "efecto='" + efecto + '\'' +
                '}';
    }
}
