package pucmm.inventarioequipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.inventarioequipos.model.Categoria;
import pucmm.inventarioequipos.model.Rol;
import pucmm.inventarioequipos.model.Usuario;
import pucmm.inventarioequipos.service.CategoriaServiceImpl;
import pucmm.inventarioequipos.service.RolServiceImpl;
import pucmm.inventarioequipos.service.UsuarioServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/familias")
public class CategoriasController {

    @Autowired
    private CategoriaServiceImpl categoriasService;

    @GetMapping(value="/")
    public String familias(Model model)
    {
        List<Categoria> categorias = new ArrayList<>();
        categorias = categoriasService.buscarTodasCategorias();
        model.addAttribute("familias", categorias);
        return "familias";
    }



    @PostMapping("/")
    public String crearFamilia(@RequestParam("categoria") String categoria){
    Categoria f = new Categoria();
    f.setNombreCategoria(categoria);
    categoriasService.crearCategoria(f);
        return "redirect:/familias/";
    }


    @PostMapping(value = "/eliminar/{id}")
    public String borrarFamilia(@PathVariable String id) {
        categoriasService.borrarCategoriaPorId(Long.parseLong(id));
        return "redirect:/familias/";

    }
}
