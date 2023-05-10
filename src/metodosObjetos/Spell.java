package metodosObjetos;

import metodosCRUD.Basicos;

import java.util.ArrayList;

public class Spell extends Carta {
    private String efecto;

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
