package pucmm.topograpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.topograpp.model.Peticion;


public interface PeticionRepository extends JpaRepository<Peticion, Long> {


}
