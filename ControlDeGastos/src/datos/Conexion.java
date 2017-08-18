package datos;

import java.sql.*;

/**
 * Clase que permite hacer la conexión entre el programa y la base de datos del Control de Gastos.
 * La base de datos está almacenada en la herramienta mySQL.
 */
public class Conexion {

    private Connection conexion;
    private String username;
    private String password;
    private static Conexion connect;

    /**
     * Constructor vacío de la clase que permite la conexión con la base de datos registrada y
     * predetermina una usuario y una contraseña ya registrados en las bases de datos de los
     * ordenadores personales de las personas que utilizarán el Sistema.
     */
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            username = "gastador";
            password = "pepeProblemas";
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ControlDeGastos", username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            //Error
        }
    }

    /**
     * Bloque de Getters y Setters de la clase. Su documentación no es necesaria.
     */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Función que abre la conexión con la base de datos del Sistema.
     *
     * @return
     */
    public Connection connection() {
        try {
            return conexion;
        } finally {
        }
    }

    /**
     * Función que permite cerrar la conexión con la base de datos del Sistema.
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            //Error
        }
    }

    public static Conexion getConnect() {
        return connect;
    }

    public static void setConnect(Conexion conexion) {
        Conexion.connect = conexion;
    }
}
