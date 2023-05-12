package metodosObjetos;

import metodosCRUD.Basicos;

import java.util.ArrayList;

public class Unidad extends Carta {
    private int vida;
    private int poder;
    private String habilidad;

    /**
     * Constructor de la clase Unidad que sirve para la creación de criaturas, hereda del método Carta
     * @param nombre    atributo heredado
     * @param coste     atributo heredad
     * @param vida      representa los puntos de daño que puede soportar la unidad
     * @param poder     representa los puntos de daño que hace la unidad
     * @param habilidad palabra clave que otorga efecto especial a la unidad, puede ser nulo.
     */
    public Unidad(String nombre, int coste, int vida, int poder, String habilidad) {
        super(nombre, coste);
        this.vida = vida;
        this.poder = poder;
        this.habilidad = habilidad;
    }

    /**
     * Obtiene el valor del atributo vida de la clase Unidad
     * @return entero que representa el atributo vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * Permite la modificación del atributo vida de la clase Unidad
     * @param vida Entero que representa el nuevo valor que tendrá el atributo vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Obtiene el valor del atributo poder que ha sido definido
     * @return entero que representa el valor del atributo poder
     */
    public int getPoder() {
        return poder;
    }

    /**
     * Método que permite la modificación del atributo poder
     * @param poder entero que será en nuevo valor del atributo poder
     */
    public void setPoder(int poder) {
        this.poder = poder;
    }

    /**
     * Método para otorgar una palabra específica a un obj de la clase Unidad
     * @return Cadena con el valor de la palabra asignada
     */
    public String getHabilidad() {
        return habilidad;
    }

    /**
     * Método para la modificación del atributo habilidad
     * @param habilidad Cadena que representa el nuevo valor que tendrá este atributo
     */
    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "nombre='" + nombre + '\'' +
                ", coste=" + coste +
                "vida=" + vida +
                ", poder=" + poder +
                ", habilidad='" + habilidad +
                '}';
    }
}
