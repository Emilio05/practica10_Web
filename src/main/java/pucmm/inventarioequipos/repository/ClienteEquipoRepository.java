package pucmm.inventarioequipos.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import pucmm.inventarioequipos.model.ClienteEquipo;
        import pucmm.inventarioequipos.model.Historial;

        import java.util.List;

public interface ClienteEquipoRepository extends JpaRepository<ClienteEquipo, Long> {

    @Query(value = "SELECT CLI.NOMBRE, EQ.NOMBRE_EQUIPO, DATEDIFF('DAY',ALQ.FECHA_INICIO_ALQUILER, FECHA_FIN_ALQUILER ) AS DIAS " +
            "FROM ALQUILER ALQ INNER JOIN CLIENTE CLI ON CLI.ID = ALQ.CLIENTE_ID INNER JOIN EQUIPO EQ ON EQ.ID = ALQ.EQUIPO_ID " +
            "WHERE ALQ.ESTADO = 'Pendiente' ORDER BY ALQ.FECHA_INICIO_ALQUILER", nativeQuery = true)
    List<Object[]> equiposAlquiladosNoDevueltos();

    @Query(value = "SELECT  CLI.NOMBRE, EQ.NOMBRE_EQUIPO, ALQ.FECHA_INICIO_ALQUILER, ALQ.FECHA_FIN_ALQUILER, ALQ.ESTADO FROM ALQUILER ALQ " +
            "INNER JOIN CLIENTE CLI ON CLI.id = ALQ.CLIENTE_ID INNER JOIN EQUIPO EQ ON EQ.ID = ALQ.EQUIPO_ID WHERE CLI.ID = :id", nativeQuery = true)
    List<Object[]> historialCliente(@Param("id") long id);

//
//    @Query(nativeQuery = true, value = "SELECT new Historial(cli.nombre, eq.nombre_equipo, alq.fecha_inicio_alquiler, alq.fecha_fin_alquiler, alq.estado) FROM ClienteEquipo alq " +
//            "INNER join Cliente cli on cli.id = alq.cliente inner join Equipo eq on eq.id = alq.equipo where cli.id = :id")
//    List<Historial> historialDeCliente(@Param("id") long id);
}

