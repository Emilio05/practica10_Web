package pucmm.inventarioequipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.inventarioequipos.model.SubFamilia;

public interface SubFamiliaRepository  extends JpaRepository<SubFamilia, Long> {

    SubFamilia findByNombreSubFamilia(String nombre);

}
