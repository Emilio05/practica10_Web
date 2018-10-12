package pucmm.inventarioequipos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.inventarioequipos.model.Equipo;
import pucmm.inventarioequipos.repository.EquipoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("equipoService")
@Transactional
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public void crearEquipo(Equipo equipo){
        equipoRepository.save(equipo);
    }
    public void actualizarEquipo(Equipo equipo){
        crearEquipo(equipo);
    }
    public void borrarEquipoPorId(long id){
        equipoRepository.deleteById(id);
    }
    public void borrarTodosLosEquipos(){
        equipoRepository.deleteAll();
    }
    public List<Equipo> buscarTodosEquipos(){
        return equipoRepository.findAll();
    }
    @Override
    public Equipo buscarPorId(long id){
        return equipoRepository.findById(id).get();
    }
    public Equipo findByNombreEquipo(String nombre){
        return equipoRepository.findByNombreEquipo(nombre);
    }
    public boolean equipoExiste(Equipo equipo){
        return findByNombreEquipo(equipo.getNombreEquipo()) != null;
    }
}
