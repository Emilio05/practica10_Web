package pucmm.inventarioequipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.inventarioequipos.model.ClienteEquipo;
import pucmm.inventarioequipos.model.Equipo;
import pucmm.inventarioequipos.service.ClienteEquipoServiceImpl;
import pucmm.inventarioequipos.service.EquipoServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlquilerController {

    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;

    @GetMapping("/alquiler")
    public String alquiler(Model model)
    {
        List<ClienteEquipo> alquileres = new ArrayList<>();
        alquileres = clienteEquipoService.buscarTodosClientesEquipos();
        model.addAttribute("alquileres", alquileres);
        return "alquiler";
    }

    @PostMapping("/alquiler")
    public String agregarAlquiler(ClienteEquipo alquiler, Model model) {

        model.addAttribute("equipos", alquiler);
        return "alquiler";
    }


//    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
//    public String agregarCliente(@RequestParam int id, @RequestParam String nombre){
//        Estudiante estudiante = new Estudiante(matricula);
//        estudiante.setNombre(nombre);
//        return ""+estudiante.getMatricula();
//    }

}
