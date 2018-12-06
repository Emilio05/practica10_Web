package pucmm.inventarioequipos.service;

import pucmm.inventarioequipos.model.FacturaEquipo;

import java.util.List;

public interface FacturaEquipoService {

    void crearFacturaEquipo(FacturaEquipo facturaEquipo);
    void actualizarFacturaEquipo(FacturaEquipo facturaEquipo);
    void borrarFacturaEquipoPorId(long id);
    void borrarTodasLasFacturaEquipos();
    List<FacturaEquipo> buscarTodasFacturaEquipos();
    FacturaEquipo buscarPorId(long id);
    boolean facturaEquipoExiste(FacturaEquipo facturaEquipo);
}
