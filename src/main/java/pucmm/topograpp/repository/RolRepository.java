package pucmm.topograpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.topograpp.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombreRol(String rol);

}
