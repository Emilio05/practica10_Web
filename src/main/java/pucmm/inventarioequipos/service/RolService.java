package pucmm.inventarioequipos.service;

import pucmm.inventarioequipos.model.Rol;

import java.util.List;

public interface RolService {

    void crearRol(Rol rol);
    void actualizarRol(Rol rol);
    void borrarRolPorId(long id);
    void borrarTodosLosRoles();
    List<Rol> buscarTodosRoles();
    Rol buscarPorId(long id);
    Rol findByNombreRol(String nombreRol);
    boolean rolExiste(Rol cliente);
}
