package pucmm.topograpp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.topograpp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
    Usuario findByEmail(String email);

}
