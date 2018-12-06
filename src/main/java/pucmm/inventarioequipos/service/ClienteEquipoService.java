package pucmm.inventarioequipos.service;

import org.springframework.data.repository.query.Param;
import pucmm.inventarioequipos.model.ClienteEquipo;

import java.util.List;

public interface ClienteEquipoService {

    void crearClienteEquipo(ClienteEquipo clienteEquipo);
    void actualizarClienteEquipo(ClienteEquipo clienteEquipo);
    void borrarClienteEquipoPorId(ClienteEquipo clienteEquipo);
    void borrarTodosLosClientesEquipos();
    List<ClienteEquipo> buscarTodosClientesEquipos();
    ClienteEquipo buscarPorId(long id);
    boolean clienteEquipoExiste(ClienteEquipo clienteEquipo);
    List<Object[]> equiposAlquiladosNoDevueltos();
    List<Object[]> historialCliente(long id);
    List<Object[]> promedioAlquilerPorFamilia(long id);


}
