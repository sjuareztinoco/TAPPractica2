package dao;

import conexion.Conexion;
import modelo.Especialidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOEspecialidad implements DAOGeneral<Integer, Especialidad>{
    private final Conexion conexion;

    public DAOEspecialidad() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean agregar(Especialidad elemento) {
        boolean estatus = false;
        String sql = "INSERT INTO especialidad(nombre) VALUES(?)";
        if(conexion.abrirConexion()) {
            Connection con = conexion.obtenerConexion();
            try {
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,elemento.getNombre());
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    estatus = true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        conexion.cerrarConexion();
        return estatus;
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }

    @Override
    public boolean actualizar(Integer id, Especialidad nuevoElemento) {
        return false;
    }

    @Override
    public Especialidad obtener(Integer id) {
        return null;
    }
}
