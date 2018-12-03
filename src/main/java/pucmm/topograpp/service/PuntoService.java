package pucmm.topograpp.service;

import pucmm.topograpp.model.Medida;
import pucmm.topograpp.model.Punto;

import java.util.List;

public interface PuntoService {

    void Crear(Punto medida);
    void Actualizar(Punto medida);
    void Borrar(Punto medida);
    void BorrarTodos();
    List<Punto> BuscarTodos();
    Punto Buscar(long id);

}
