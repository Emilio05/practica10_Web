package pucmm.topograpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pucmm.topograpp.model.Practica;

import java.math.BigInteger;
import java.util.List;

public interface PracticaRepository extends JpaRepository<Practica, Long> {


@Query(value= "SELECT PRACTICE_ID FROM PRACTICE_USER WHERE USER_ID = :id", nativeQuery = true)
List<BigInteger> practicasDeusuario(@Param("id") long id);


}
