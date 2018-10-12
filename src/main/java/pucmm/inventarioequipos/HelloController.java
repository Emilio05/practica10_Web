package pucmm.inventarioequipos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model)
    {
        List<String> usuarios = new ArrayList<>();

        model.addAttribute("usuarios",usuarios);
        return "usuarios";
    }

    @GetMapping("/equipos")
    public String equipos(Model model)
    {
        List<String> equipos = new ArrayList<>();

        model.addAttribute("equipos",equipos);
        return "equipos";
    }

    @GetMapping("/clientes")
    public String clientes(Model model)
    {
        List<String> clientes = new ArrayList<>();

        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/facturacion")
    public String facturacion(Model model)
    {
        List<String> facturacion = new ArrayList<>();

        model.addAttribute("facturacion",facturacion);
        return "facturacion";
    }
}