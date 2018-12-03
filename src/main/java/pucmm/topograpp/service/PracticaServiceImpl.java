package pucmm.topograpp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.topograpp.model.Practica;
import pucmm.topograpp.repository.PracticaRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service("practicaService")
@Transactional
public class PracticaServiceImpl implements PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;

    public void Crear(Practica practica){
        practicaRepository.save(practica);
    }
    public void Actualizar(Practica practica){
        Crear(practica);
    }
    public void Borrar(Practica practica){
        practica.setDeleted(true);
        Actualizar(practica);
    }
    public void BorrarTodos(){
        practicaRepository.deleteAll();
    }
    public List<Practica> BuscarTodos(){
        return practicaRepository.findAll();
    }
    @Override
    public Practica Buscar(long id){
        return practicaRepository.findById(id).get();
    }
    @Override

    public List<BigInteger> BuscarTodasDeUser(long id){
        return practicaRepository.practicasDeusuario(id);
    }

    }
