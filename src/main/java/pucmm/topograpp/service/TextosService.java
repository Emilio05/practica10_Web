package pucmm.topograpp.service;


import pucmm.topograpp.model.Textos;

import java.util.List;

public interface TextosService {

    void Crear(Textos l);
    void Actualizar(Textos l);
    void Borrar(Textos l);
    void BorrarTodos();
    List<Textos> BuscarTodos();
    Textos Buscar(long id);
    Textos findByUid(String uid);



}
