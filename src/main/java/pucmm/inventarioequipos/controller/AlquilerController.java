package pucmm.inventarioequipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.inventarioequipos.model.Cliente;
import pucmm.inventarioequipos.model.ClienteEquipo;
import pucmm.inventarioequipos.model.Equipo;
import pucmm.inventarioequipos.service.ClienteEquipoServiceImpl;
import pucmm.inventarioequipos.service.ClienteServiceImpl;
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
        List<ClienteEquipo> alquiler = new ArrayList<>();
        alquiler = clienteEquipoService.buscarTodosClientesEquipos();
        model.addAttribute("alquiler", alquiler);
        return "alquiler";
    }


}
