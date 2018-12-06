package pucmm.inventarioequipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.inventarioequipos.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {


}
