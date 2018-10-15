package pucmm.inventarioequipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.inventarioequipos.model.Equipo;
import pucmm.inventarioequipos.service.EquipoServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    private EquipoServiceImpl equipoService;

//    @GetMapping("/equipos")
//    public String equipos(Model model)
//    {
//        List<Equipo> equipos = new ArrayList<>();
//        equipos = equipoService.buscarTodosEquipos();
//        model.addAttribute("equipos", equipos);
//        return "equipos";
//    }
//
//    @PostMapping("/equipos")
//    public String agregarEquipo(Equipo equipo, Model model) {
//        model.addAttribute("equipos", equipo);
//        return "equipos";
////    }
//    @RequestMapping("/equipo/{id}")
//    public Equipo obtenerEquipo(@PathVariable int id){
//        return equipoService.buscarPorId(id);
//    }



//    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
//    public String agregarCliente(@RequestParam int id, @RequestParam String nombre){
//        Estudiante estudiante = new Estudiante(matricula);
//        estudiante.setNombre(nombre);
//        return ""+estudiante.getMatricula();
//    }

}
