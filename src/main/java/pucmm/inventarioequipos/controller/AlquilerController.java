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
@RequestMapping("/alquiler")
public class AlquilerController {


    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;

    @GetMapping(value = "/")
    public String alquiler(Model model)
    {
        return "alquiler";
    }


}
