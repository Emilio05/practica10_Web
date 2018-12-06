package pucmm.inventarioequipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.inventarioequipos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
