package pucmm.topograpp.service;

import pucmm.topograpp.model.Levantamiento;


import java.util.List;

public interface LevantamientoService {

    void Crear(Levantamiento l);
    void Actualizar(Levantamiento l);
    void Borrar(Levantamiento l);
    void BorrarTodos();
    List<Levantamiento> BuscarTodos();
    Levantamiento Buscar(long id);

}
