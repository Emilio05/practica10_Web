package pucmm.topograpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.topograpp.model.Medida;
import pucmm.topograpp.model.Punto;

public interface PuntoRepository extends JpaRepository<Punto, Long> {


}
