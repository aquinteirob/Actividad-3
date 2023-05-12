package conexionBD;

import metodosObjetos.Spell;
import metodosObjetos.Unidad;

import java.sql.*;

public class Conexion {
    public static void main(String[] args) throws SQLException {
        conectarDb();

    }

    /**
     * Metodo para conectar con una base de datos en mySql
     *
     * @see "sesion 42 de programacion"
     */
    public static void conectarDb() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Conectado/desconectado");

    }

    /**
     * Metodo para insertar el objeto criatura en la tabla unidad, se hace mediante consulta de tipo insert, mostrando por pantalla que la creación fue exitosa
     * @param unidad Objeto de la clase Unidad, permite obtener los atributos de dicho objeto
     * @author Quinteiro_Adhemar
     */
    public static void crear(Unidad unidad) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        int exito = 0;
        String nombre = unidad.getNombre();
        int coste = unidad.getCoste();
        int vida = unidad.getVida();
        int poder = unidad.getPoder();
        String habilidad = unidad.getHabilidad();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            sql = "INSERT INTO carta (id, nombre, coste) VALUES (NULL," + nombre + "', '" + coste;
            System.out.println(sql);
            if (exito >= 1) {
                System.out.println("Carta creada con exito");
            }
            sql = "INSERT INTO unidad (id, vida, poder, habilidad, idCarta, idDeckUnidad) VALUES (NULL, '" + vida + "', '" + poder + "', '" + habilidad + "', '', ''";
            System.out.println(sql);
            exito = sentenciaSQL.executeUpdate(sql);
            if (exito >= 1) {
                System.out.println("Se ha creado con exito la unidad");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo para insertar el objeto hechizo en la tabla spell, se hace mediante consulta de tipo insert, mostrando por pantalla que la creación fue exitosa
     * @param hechizo Objeto de la clase Spell, permite obtener los atributos de dicho objeto
     * @author Quinteiro_Adhemar
     */
    public static void crear(Spell hechizo) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        int exito = 0;
        String nombre = hechizo.getNombre();
        int coste = hechizo.getCoste();
        String efecto = hechizo.getEfecto();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            sql = "INSERT INTO carta (id, nombre, coste) VALUES (NULL," + nombre + "', '" + coste;
            System.out.println(sql);
            if (exito >= 1) {
                System.out.println("Carta creada con exito");
            }
            sql = "INSERT INTO spell (id, efecto, idCarta, idDeckSpell) VALUES (NULL, '" + efecto + "', '', '";
            System.out.println(sql);
            exito = sentenciaSQL.executeUpdate(sql);
            if (exito >= 1) {
                System.out.println("Se ha creado con exito el hechizo");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Método que permite buscar en la tabla carta el nombre o la habilidad de la unidad o hechizo, la busqueda se hace mediante un select, posteriormente se muestran todos los resultados obtenidos
     * @param texto Cadena que se le pide al usuario para saber el nombre o habilidad que se van a buscar
     * @param parametroBuscador Entero que representa si es la busqueda es por nombre o hechizo
     * @author Quinteiro_Adhemar
     */
    public static void buscarUnidaHechizodDb(String texto, int parametroBuscador) { //Hacer vista de un inner join entre la tabla de cartas, unidad y hechizo para poder hacer la consulta sobre esa vista
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet resultado = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            if (parametroBuscador == 1) {
                resultado = sentenciaSQL.executeQuery("Select * from carta where nombre =" + texto);
                while (resultado.next()) {
                    System.out.println("nombre" + resultado.getString("nombre") + "coste" + resultado.getInt("coste"));
                }
            } else {
                resultado = sentenciaSQL.executeQuery("Select * from unidad where habilidad =" + texto);
                while (resultado.next()) {
                    System.out.println("nombre" + resultado.getString("nombre") + "coste" + resultado.getInt("coste") + "habilidad" + resultado.getString("habilidad"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para buscar en la tabla carta por el coste de una unidad o hechizo, la busqueda se hace con un select, posteriormente se muestran todos los resultados obtenidos
     * @param coste Entero que representa el precio que tiene la utilización de una carta y parámetro por el que se va a buscar
     * @author Quinteiro_Adhemar
     */
    public static void buscarCosteDb(int coste) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet resultado = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            resultado = sentenciaSQL.executeQuery("Select * from carta where coste =" + coste);
            while (resultado.next()) {
                System.out.println("nombre" + resultado.getString("nombre") + "coste" + resultado.getInt("coste"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
