package pucmm.topograpp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.topograpp.model.Medida;
import pucmm.topograpp.model.Peticion;
import pucmm.topograpp.repository.MedidaRepository;
import pucmm.topograpp.repository.PeticionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("peticionService")
@Transactional
public class PeticionServiceImpl implements PeticionService {

    @Autowired
    private PeticionRepository peticionRepository;

    public void Crear(Peticion peticion){
        peticionRepository.save(peticion);
    }
    public void Actualizar(Peticion peticion){
        Crear(peticion);
    }
    public void Borrar(Peticion peticion){
        peticion.setDeleted(true);
        Actualizar(peticion);
    }
    public void BorrarTodos(){
        peticionRepository.deleteAll();
    }
    public List<Peticion> BuscarTodos(){
        return peticionRepository.findAll();
    }
    @Override
    public Peticion Buscar(long id){
        return peticionRepository.findById(id).get();
    }

    }
