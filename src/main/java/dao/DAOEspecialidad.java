package dao;

import modelo.Especialidad;

public class DAOEspecialidad implements DAOGeneral<Integer, Especialidad>{
    @Override
    public boolean agregar(Especialidad elemento) {
        return false;
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
