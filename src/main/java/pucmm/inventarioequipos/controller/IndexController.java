package pucmm.inventarioequipos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pucmm.inventarioequipos.service.ClienteEquipoServiceImpl;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;

    @RequestMapping(value = "/")
    public String index(Model model)
    {
        List<Object[]> promediosFamilia = clienteEquipoService.promedioAlquilerPorFamilia();
        model.addAttribute("promediosFamilia",promediosFamilia);
        return "index";
    }
}
