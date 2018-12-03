package pucmm.topograpp.service;

import pucmm.topograpp.model.Peticion;


import java.util.List;

public interface PeticionService {

    void Crear(Peticion practica);
    void Actualizar(Peticion practica);
    void Borrar(Peticion practica);
    void BorrarTodos();
    List<Peticion> BuscarTodos();
    Peticion Buscar(long id);

}
