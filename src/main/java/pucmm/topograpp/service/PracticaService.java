package pucmm.topograpp.service;

import pucmm.topograpp.model.Practica;

import java.math.BigInteger;
import java.util.List;

public interface PracticaService {

    void Crear(Practica practica);
    void Actualizar(Practica practica);
    void Borrar(Practica practica);
    void BorrarTodos();
    List<Practica> BuscarTodos();
    Practica Buscar(long id);
    List<BigInteger> BuscarTodasDeUser(long id);

}
