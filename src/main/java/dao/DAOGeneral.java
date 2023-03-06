package dao;

public interface DAOGeneral<T, E> {
    boolean agregar(E elemento);
    boolean eliminar(T id);
    boolean actualizar(T id, E nuevoElemento);
    E obtener(T id);
}
