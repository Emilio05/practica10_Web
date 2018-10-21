package pucmm.inventarioequipos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.inventarioequipos.model.Categoria;
import pucmm.inventarioequipos.model.SubFamilia;
import pucmm.inventarioequipos.repository.CategoriaRepository;
import pucmm.inventarioequipos.repository.SubFamiliaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("subFamiliaService")
@Transactional
public class SubFamiliaServiceImpl implements SubFamiliaService {

    @Autowired
    private SubFamiliaRepository subFamiliaRepository;

    public void crearSubFamilia(SubFamilia subFamilia){
        subFamiliaRepository.save(subFamilia);
    }
    public void actualizarSubFamilia(SubFamilia subFamilia){
        crearSubFamilia(subFamilia);
    }
    public void borrarSubFamiliaPorId(SubFamilia subFamilia){
        subFamilia.setDeleted(true);
        actualizarSubFamilia(subFamilia);
    }
    public void borrarTodasLasSubFamilias(){
        subFamiliaRepository.deleteAll();
    }
    public List<SubFamilia> buscarTodasSubFamilias(){
        return subFamiliaRepository.findAll();
    }
    @Override
    public SubFamilia buscarPorId(long id){
        return subFamiliaRepository.findById(id).get();
    }
    public SubFamilia findByNombreSubFamilia(String nombre){
        return subFamiliaRepository.findByNombreSubFamilia(nombre);
    }
    public boolean subFamiliaExiste(SubFamilia subFamilia){
        return findByNombreSubFamilia(subFamilia.getNombreSubFamilia()) != null;
    }
}
