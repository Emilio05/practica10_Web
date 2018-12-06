package pucmm.inventarioequipos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pucmm.inventarioequipos.model.Categoria;
import pucmm.inventarioequipos.service.CategoriaServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {



    @Autowired
    private CategoriaServiceImpl categoriaService;

    @RequestMapping(value = "/")
    public String categorias(Model model)
    {
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList = categoriaService.buscarTodasCategorias();
        model.addAttribute("categorias",categoriaList);
        return "categoria";
    }

    @PostMapping(value = "/")
    public String crearCategoria(@RequestParam("nombre") String nombre,
                               RedirectAttributes redirectAttributes) {

        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(nombre);
        categoriaService.crearCategoria(categoria);

        return "redirect:/categorias/";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String borrarCategoria(@PathVariable String id) {
        Categoria categoria = categoriaService.buscarPorId(Long.parseLong(id));
        categoriaService.borrarCategoriaPorId(categoria);
        return "redirect:/categorias/";

    }


}
