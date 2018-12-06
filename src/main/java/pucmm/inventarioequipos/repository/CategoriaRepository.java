package pucmm.inventarioequipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.inventarioequipos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNombreCategoria(String nombre);

}
