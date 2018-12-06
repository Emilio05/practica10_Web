package pucmm.topograpp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.topograpp.model.Medida;
import pucmm.topograpp.repository.MedidaRepository;
import pucmm.topograpp.repository.PracticaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("medidaService")
@Transactional
public class MedidaServiceImpl implements MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    public void Crear(Medida medida){
        medidaRepository.save(medida);
    }
    public void Actualizar(Medida medida){
        Crear(medida);
    }
    public void Borrar(Medida medida){
        medida.setDeleted(true);
        Actualizar(medida);
    }
    public void BorrarTodos(){
        medidaRepository.deleteAll();
    }
    public List<Medida> BuscarTodos(){
        return medidaRepository.findAll();
    }
    @Override
    public Medida Buscar(long id){
        return medidaRepository.findById(id).get();
    }

    }
