package pucmm.inventarioequipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.inventarioequipos.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombreRol(String rol);

}
