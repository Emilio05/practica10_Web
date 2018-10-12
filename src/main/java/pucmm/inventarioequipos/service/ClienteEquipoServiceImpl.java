package pucmm.inventarioequipos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.inventarioequipos.model.ClienteEquipo;
import pucmm.inventarioequipos.repository.ClienteEquipoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("clienteEquipoService")
@Transactional
public class ClienteEquipoServiceImpl implements ClienteEquipoService {

    @Autowired
    private ClienteEquipoRepository clienteEquipoRepository;

    public void crearClienteEquipo(ClienteEquipo clienteEquipo){

    }
    public void actualizarClienteEquipo(ClienteEquipo clienteEquipo){
        crearClienteEquipo(clienteEquipo);
    }
    public void borrarClienteEquipoPorId(long id){
        clienteEquipoRepository.deleteById(id);
    }
    public void borrarTodosLosClientesEquipos(){
        clienteEquipoRepository.deleteAll();
    }
    public List<ClienteEquipo> buscarTodosClientesEquipos(){
        return clienteEquipoRepository.findAll();
    }
    @Override
    public ClienteEquipo buscarPorId(long id){
        return clienteEquipoRepository.findById(id).get();
    }

    public boolean clienteEquipoExiste(ClienteEquipo clienteEquipo){
        return buscarPorId(clienteEquipo.getId()) != null;
    }
}
