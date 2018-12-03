package pucmm.topograpp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.topograpp.model.Levantamiento;
import pucmm.topograpp.model.Medida;
import pucmm.topograpp.repository.LevantamientoRepository;
import pucmm.topograpp.repository.MedidaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("levantamientoService")
@Transactional
public class LevantamientoServiceImpl implements LevantamientoService {

    @Autowired
    private LevantamientoRepository levantamientoRepository;

    public void Crear(Levantamiento l){
        levantamientoRepository.save(l);
    }
    public void Actualizar(Levantamiento l){
        Crear(l);
    }
    public void Borrar(Levantamiento l){
        l.setDeleted(true);
        Actualizar(l);
    }
    public void BorrarTodos(){
        levantamientoRepository.deleteAll();
    }
    public List<Levantamiento> BuscarTodos(){
        return levantamientoRepository.findAll();
    }
    @Override
    public Levantamiento Buscar(long id){
        return levantamientoRepository.findById(id).get();
    }

    }
