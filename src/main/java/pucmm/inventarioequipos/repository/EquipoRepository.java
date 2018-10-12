package pucmm.inventarioequipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.inventarioequipos.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    Equipo findByNombreEquipo(String nombre);
}
