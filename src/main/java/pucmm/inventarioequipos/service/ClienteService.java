package pucmm.inventarioequipos.service;

import org.springframework.beans.factory.annotation.Autowired;
import pucmm.inventarioequipos.model.Cliente;
import pucmm.inventarioequipos.repository.ClienteRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ClienteService {

     void crearCliente(Cliente cliente);
     void actualizarCliente(Cliente cliente);
     void borrarClientePorId(long id);
     void borrarTodosLosClientes();
     List<Cliente> buscarTodosClientes();
     Cliente buscarPorId(long id);
     Cliente findByNombre(String nombre);
     boolean clienteExiste(Cliente cliente);

}
