package pucmm.topograpp.service;

public interface SecurityService {

    String usuarioLogueado();

    void autoLogin(String username, String password);
}
