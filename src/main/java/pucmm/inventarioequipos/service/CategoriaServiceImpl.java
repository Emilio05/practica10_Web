package pucmm.inventarioequipos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.inventarioequipos.model.Categoria;
import pucmm.inventarioequipos.repository.CategoriaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void crearCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }
    public void actualizarCategoria(Categoria categoria){
        crearCategoria(categoria);
    }
    public void borrarCategoriaPorId(long id){
        categoriaRepository.deleteById(id);
    }
    public void borrarTodasLasCategorias(){
        categoriaRepository.deleteAll();
    }
    public List<Categoria> buscarTodasCategorias(){
        return categoriaRepository.findAll();
    }
    @Override
    public Categoria buscarPorId(long id){
        return categoriaRepository.findById(id).get();
    }
    public Categoria findByNombreCategoria(String nombre){
        return categoriaRepository.findByNombreCategoria(nombre);
    }
    public boolean categoriaExiste(Categoria categoria){
        return findByNombreCategoria(categoria.getNombreCategoria()) != null;
    }
}
