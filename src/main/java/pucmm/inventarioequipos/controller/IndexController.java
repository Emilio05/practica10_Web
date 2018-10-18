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
import pucmm.inventarioequipos.service.CategoriaServiceImpl;
import pucmm.inventarioequipos.service.ClienteEquipoServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;
    @Autowired
    private CategoriaServiceImpl categoriaService;

//    @Autowired
//    private MessageSource messageSource;

    @RequestMapping(value = "/")
    public String index(Model model, Locale locale)
    {
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        model.addAttribute("categorias",categorias);
       // model.addAttribute("derecho_autor", messageSource.getMessage("derecho_autor", null, locale));
        return "index";
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
