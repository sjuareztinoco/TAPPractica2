package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String usuario;
    private final String password;
    private final String host;
    private final String puerto;

    private final String nombreBD;

    private Connection conexion;

    public Conexion() {
        this.usuario = "tap";
        this.password = "tap";
        this.host = "localhost";
        this.puerto = "3306";
        this.nombreBD = "escolar";
    }

    public Connection obtenerConexion() {
        return this.conexion;
    }

    public boolean abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(
                    "jdbc:mysql://"+host+":"+puerto+"/"+nombreBD,
                    usuario,
                    password
            );
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean cerrarConexion() {
        try {
            this.conexion.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
