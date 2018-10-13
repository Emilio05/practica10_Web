package pucmm.inventarioequipos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.inventarioequipos.model.Cliente;
import pucmm.inventarioequipos.repository.ClienteRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void crearCliente(String nombre, String cedula, Date fechaNacimiento){
        clienteRepository.save(new Cliente(nombre, cedula, fechaNacimiento));
    }
    public void actualizarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }
    public void borrarClientePorId(long id){
        clienteRepository.deleteById(id);
    }
    public void borrarTodosLosClientes(){
        clienteRepository.deleteAll();
    }
    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }
    @Override
    public Cliente buscarPorId(long id){
        return clienteRepository.findById(id).get();
    }
    public Cliente findByNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }
    public boolean clienteExiste(Cliente cliente){
        return findByNombre(cliente.getNombre()) != null;
    }
}
