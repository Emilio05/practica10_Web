package pucmm.topograpp.service;

import pucmm.topograpp.model.Medida;

import java.util.List;

public interface MedidaService {

    void Crear(Medida medida);
    void Actualizar(Medida medida);
    void Borrar(Medida medida);
    void BorrarTodos();
    List<Medida> BuscarTodos();
    Medida Buscar(long id);

}
