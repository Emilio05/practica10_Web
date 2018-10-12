package pucmm.inventarioequipos.service;

import pucmm.inventarioequipos.model.ClienteEquipo;

import java.util.List;

public interface ClienteEquipoService {

    void crearClienteEquipo(ClienteEquipo clienteEquipo);
    void actualizarClienteEquipo(ClienteEquipo clienteEquipo);
    void borrarClienteEquipoPorId(long id);
    void borrarTodosLosClientesEquipos();
    List<ClienteEquipo> buscarTodosClientesEquipos();
    ClienteEquipo buscarPorId(long id);
    boolean clienteEquipoExiste(ClienteEquipo clienteEquipo);
}
