package pucmm.topograpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pucmm.topograpp.model.Textos;


public interface TextosRepository extends JpaRepository<Textos, Long> {


    Textos findByUid(String uid);
}
