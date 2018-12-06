package pucmm.inventarioequipos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pucmm.inventarioequipos.model.Categoria;
import pucmm.inventarioequipos.model.SubFamilia;
import pucmm.inventarioequipos.service.CategoriaServiceImpl;
import pucmm.inventarioequipos.service.SubFamiliaServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/subfamilias")
public class SubFamiliaController {



    @Autowired
    private SubFamiliaServiceImpl subFamiliaService;
    @Autowired
    private CategoriaServiceImpl categoriaService;

    @RequestMapping(value = "/")
    public String subfamilias(Model model)
    {
        List<SubFamilia> subFamilias = new ArrayList<>();
        subFamilias = subFamiliaService.buscarTodasSubFamilias();
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        model.addAttribute("subFamilias",subFamilias);
        model.addAttribute("categorias",categorias);
        return "subfamilias";
    }

    @PostMapping(value = "/")
    public String crearSubFamilia(@RequestParam("nombre") String nombre, @RequestParam("categoria") String categoria,
                                 RedirectAttributes redirectAttributes) {

        SubFamilia subFamilia= new SubFamilia();
        subFamilia.setNombreSubFamilia(nombre);
        subFamilia.setCategoria(categoriaService.findByNombreCategoria(categoria));
        subFamiliaService.crearSubFamilia(subFamilia);

        return "redirect:/subfamilias/";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String borrarSubFamilia(@PathVariable String id) {
        SubFamilia subFamilia = subFamiliaService.buscarPorId(Long.parseLong(id));
        subFamiliaService.borrarSubFamiliaPorId(subFamilia);
        return "redirect:/subfamilias/";

    }


}
