package pucmm.inventarioequipos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.inventarioequipos.model.Usuario;
import pucmm.inventarioequipos.repository.UsuarioRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public void actualizarUsuario(Usuario usuario){
        crearUsuario(usuario);
    }
    public void borrarUsuarioPorId(long id){
        usuarioRepository.deleteById(id);
    }
    public void borrarTodosLosUsuarios(){
        usuarioRepository.deleteAll();
    }
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario buscarPorId(long id){
        return usuarioRepository.findById(id).get();
    }
    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
    public boolean usuarioExiste(Usuario usuario){
        return findByUsername(usuario.getUsername()) != null;
    }
}

