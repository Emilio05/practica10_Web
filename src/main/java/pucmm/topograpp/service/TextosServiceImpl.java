package pucmm.topograpp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pucmm.topograpp.model.Textos;
import pucmm.topograpp.repository.TextosRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("TextosService")
@Transactional
public class TextosServiceImpl implements TextosService {

    @Autowired
    private TextosRepository textosRepository;

    public void Crear(Textos l){
        textosRepository.save(l);
    }
    public void Actualizar(Textos l){
        Crear(l);
    }
    public void Borrar(Textos l){
        textosRepository.delete(l);
    }
    public void BorrarTodos(){
        textosRepository.deleteAll();
    }
    public List<Textos> BuscarTodos(){
        return textosRepository.findAll();
    }
    @Override
    public Textos Buscar(long id){
        return textosRepository.findById(id).get();
    }


    public Textos findByUid(String uid){return textosRepository.findByUid(uid);};
    }
