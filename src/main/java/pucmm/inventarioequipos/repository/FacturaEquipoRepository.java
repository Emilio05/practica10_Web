package pucmm.inventarioequipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pucmm.inventarioequipos.model.FacturaEquipo;

import java.util.List;

public interface FacturaEquipoRepository extends JpaRepository<FacturaEquipo, Long> {




}
