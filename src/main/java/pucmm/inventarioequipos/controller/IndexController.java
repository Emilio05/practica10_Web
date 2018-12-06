package pucmm.inventarioequipos.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pucmm.inventarioequipos.model.Categoria;
import pucmm.inventarioequipos.model.Rol;
import pucmm.inventarioequipos.model.Usuario;
import pucmm.inventarioequipos.service.CategoriaServiceImpl;
import pucmm.inventarioequipos.service.ClienteEquipoServiceImpl;
import pucmm.inventarioequipos.service.RolServiceImpl;
import pucmm.inventarioequipos.service.UsuarioServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;
    @Autowired
    private CategoriaServiceImpl categoriaService;
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private RolServiceImpl rolService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/")
    public String index(Model model, Locale locale, HttpServletRequest request)
    {
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        model.addAttribute("categorias",categorias);
        model.addAttribute("puerto", ""+request.getLocalPort());
//        model.addAttribute("saludo", messageSource.getMessage("saludo", null, locale));

        // model.addAttribute("derecho_autor", messageSource.getMessage("derecho_autor", null, locale));
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Model model) {

        if(usuarioService.buscarTodosUsuarios().size() == 0) {
            Set<Rol> roles = new HashSet<>();
            Rol rol = new Rol();
            rol.setNombreRol("ADMIN");
            rolService.crearRol(rol);
            Rol rol2 = new Rol();
            rol2.setNombreRol("Vendedor");
            rolService.crearRol(rol2);
            usuarioService.crearUsuario(new Usuario(1, "admin", "admin", "admin@gmail.com", rol));
        }
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password
    ) {
        usuarioService.autoLogin(username, password);

        return "redirect:/";
    }


    @ResponseBody
    @PostMapping(value = "/graficar")
    public List<Object[]> graficar(@RequestParam("categoria") String categoria, Model model)
    {
        Categoria categoria1 = categoriaService.findByNombreCategoria(categoria);
        List<Object[]> result = clienteEquipoService.promedioAlquilerPorFamilia(categoriaService.findByNombreCategoria(categoria).getId());
        model.addAttribute("categoria", categoria1);
        model.addAttribute("result", result);
        return result;

    }
}
