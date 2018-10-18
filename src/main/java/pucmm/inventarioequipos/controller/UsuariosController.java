package pucmm.inventarioequipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.inventarioequipos.model.Equipo;
import pucmm.inventarioequipos.model.Rol;
import pucmm.inventarioequipos.model.Usuario;
import pucmm.inventarioequipos.service.EquipoServiceImpl;
import pucmm.inventarioequipos.service.RolServiceImpl;
import pucmm.inventarioequipos.service.UsuarioServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private RolServiceImpl rolService;

    @GetMapping(value="/")
    public String usuarios(Model model)
    {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioService.buscarTodosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }



    @PostMapping("/")
    public String crearEquipo(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("rol") String rol){
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        Rol r = new Rol();
        r = rolService.findByNombreRol(rol);
        u.setRol(r);
        usuarioService.crearUsuario(u);
        return "redirect:/usuarios/";
    }
}
