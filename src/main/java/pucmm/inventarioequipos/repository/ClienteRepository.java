package pucmm.inventarioequipos.repository;

import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.inventarioequipos.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNombre(String nombre);

}
