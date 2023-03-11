package dao;

import java.util.List;

public interface DAOGeneral<T, E> {
    boolean agregar(E elemento);
    boolean eliminar(T id);
    boolean actualizar(T id, E nuevoElemento);
    List<E> consultar();
}
