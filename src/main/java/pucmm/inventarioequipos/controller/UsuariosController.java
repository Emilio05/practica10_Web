package pucmm.inventarioequipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.inventarioequipos.model.Equipo;
import pucmm.inventarioequipos.model.Usuario;
import pucmm.inventarioequipos.service.EquipoServiceImpl;
import pucmm.inventarioequipos.service.UsuarioServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("/usuarios")
    public String usuarios(Model model)
    {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioService.buscarTodosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
}
