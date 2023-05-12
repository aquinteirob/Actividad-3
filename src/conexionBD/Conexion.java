package conexionBD;

import metodosCRUD.Basicos;
import metodosObjetos.Spell;
import metodosObjetos.Unidad;

import java.sql.*;

public class Conexion {
    public static void main(String[] args) throws SQLException {
        conectarDb();

    }

    /**
     * Metodo para conectar con una base de datos en mySql
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
     */
    public static void crear(Unidad unidad) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        String sql2 = "";
        ResultSet resultado = null;
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
            sql = "INSERT INTO carta (id, nombre, coste) VALUES (NULL," + "'" + nombre + "'" + "," + coste + ")";
            System.out.println(sql);
            exito = sentenciaSQL.executeUpdate(sql);
            if (exito >= 1) {
                System.out.println("Carta creada con exito");
            }

            sql2 = "INSERT INTO unidad (idUnidad, vida, poder, habilidad) VALUES (NULL," + vida + ", " + poder + ", " + "'" + habilidad + "'" + ")";
            System.out.println(sql2);
            exito = sentenciaSQL.executeUpdate(sql2);
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
            sql = "INSERT INTO carta (id, nombre, coste) VALUES (NULL," + "'" + nombre + "'" + "," + coste + ")";

            System.out.println(sql);
            exito = sentenciaSQL.executeUpdate(sql);
            if (exito >= 1) {
                System.out.println("Carta creada con exito");
            }
            sql = "INSERT INTO spell (idSpell, efecto) VALUES (NULL," + "'" + efecto + "'" + ")";
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
     * Método que busca un objeto existente en la base de datos de tipo carta en la base de datos, al conseguirlo lo imprime por consola y posteriormente, si es un obj Unidad imprime el resto de los atributos.
     * @param texto Cadena que se le pide al usuario para saber el nombre o habilidad que busca del obj Carta, obj Unidad u obj Spell (Los Spell se buscan solo por nombre o coste)
     * @param parametroBuscador entero que representa la elección de parámetro por el que se va a buscar, en este caso 1 representa el nombre y cualquier otra opción representa la habilidad.
     * @return Cadena de texto que puede ser el nombre o la habilidad del obj carta buscada.
     */
    public static String buscarUnidadHechizodDb(String texto, int parametroBuscador) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet resultado = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            if (parametroBuscador == 1) {
                resultado = sentenciaSQL.executeQuery("Select * from carta where nombre ='" + texto + "'");
                while (resultado.next()) {
                    System.out.println("nombre " + resultado.getString("nombre") + " coste " + resultado.getInt("coste"));
                }
            } else {
                resultado = sentenciaSQL.executeQuery("Select * from unidad where habilidad ='" + texto + "'");
                while (resultado.next()) {
                    System.out.println("nombre " + resultado.getString("nombre") + " coste " + resultado.getInt("coste") + " habilidad" + resultado.getString("habilidad"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return texto;
    }

    /**
     * Método para buscar un obj existente de tipo Carta con el atributo coste almacenado en la base de datos, posteriormente se muestran todos los resultados obtenidos
     * @param coste Entero que representa el precio que tiene la utilización de una carta y parámetro por el que se va a buscar
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
                System.out.println("nombre " + resultado.getString("nombre") + " coste " + resultado.getInt("coste"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para modificar un objeto existente de tipo Carta, se busca por el atributo nombre antes de realizar la modificación, el valor buscado y el valor por el cual se va a modificar se piden al usuario
     * en caso de modificación correcta se notifica por consola.
     * @param texto cadena de texto que representa el atributo nombre del obj carta que se quiere modificar
     */
    public static void modificarCartaDb(String texto) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        int actualiza = 0;
        String nombre;
        String nuevoNombre;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            nombre = buscarUnidadHechizodDb(texto, 1);
            nuevoNombre = Basicos.caracteres("Introduzca el nuevo nombre");
            sql = "UPDATE carta SET nombre = '" + nuevoNombre + "'" + " WHERE carta.nombre ='" + nombre + "'";
            System.out.println(sql);
            actualiza = sentenciaSQL.executeUpdate(sql);
            if(actualiza>=1){
                System.out.println("Nombre modificado con exito");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método para eliminar un obj Carta ya existente y almacenado en la base de datos, el nombre del objeto a eliminar se pide por consola y si se logra eliminar se notifica de igual manera.
     * @param texto Cadena de texto que representa el atributo nombre del obj carta que se quiere eliminar
     */
    public static void eliminarCartaDb(String texto) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        int actualiza = 0;
        String borrar;
        String cartaBorrar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/actividad3",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            borrar = buscarUnidadHechizodDb(texto, 1);
            sql = "DELETE FROM carta WHERE carta.nombre = '" + borrar + "'";
            System.out.println(sql);
            actualiza = sentenciaSQL.executeUpdate(sql);
            if(actualiza>=1){
                System.out.println("Carta borrada de manera exitosa");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
