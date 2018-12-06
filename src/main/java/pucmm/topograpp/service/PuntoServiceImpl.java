package pucmm.topograpp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.topograpp.model.Medida;
import pucmm.topograpp.model.Punto;
import pucmm.topograpp.repository.MedidaRepository;
import pucmm.topograpp.repository.PuntoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("puntoService")
@Transactional
public class PuntoServiceImpl implements PuntoService {

    @Autowired
    private PuntoRepository puntoRepository;

    public void Crear(Punto medida){
        puntoRepository.save(medida);
    }
    public void Actualizar(Punto medida){
        Crear(medida);
    }
    public void Borrar(Punto medida){
        medida.setDeleted(true);
        Actualizar(medida);
    }
    public void BorrarTodos(){
        puntoRepository.deleteAll();
    }
    public List<Punto> BuscarTodos(){
        return puntoRepository.findAll();
    }
    @Override
    public Punto Buscar(long id){
        return puntoRepository.findById(id).get();
    }

    }
