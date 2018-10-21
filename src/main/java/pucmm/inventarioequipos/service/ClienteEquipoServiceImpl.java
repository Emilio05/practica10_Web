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
        clienteEquipoRepository.save(clienteEquipo);
    }
    public void actualizarClienteEquipo(ClienteEquipo clienteEquipo){
        crearClienteEquipo(clienteEquipo);
    }
    public void borrarClienteEquipoPorId(ClienteEquipo clienteEquipo){
        clienteEquipo.setDeleted(true);
        actualizarClienteEquipo(clienteEquipo);
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

    public List<Object[]> equiposAlquiladosNoDevueltos(){
        return clienteEquipoRepository.equiposAlquiladosNoDevueltos();
    }

    public List<Object[]> historialCliente(long id){
        return clienteEquipoRepository.historialCliente(id);
    }
    public List<Object[]> promedioAlquilerPorFamilia(long id){
        return clienteEquipoRepository.promediosAlquiler(id);
    }


}
