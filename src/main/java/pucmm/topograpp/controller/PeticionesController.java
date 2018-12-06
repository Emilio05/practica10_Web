package pucmm.topograpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pucmm.topograpp.model.Medida;
import pucmm.topograpp.model.Peticion;
import pucmm.topograpp.model.Practica;
import pucmm.topograpp.model.Usuario;
import pucmm.topograpp.service.PeticionServiceImpl;
import pucmm.topograpp.service.PracticaServiceImpl;
import pucmm.topograpp.service.UsuarioServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/peticiones")
public class PeticionesController {


    @Autowired
    private PracticaServiceImpl practicaService;


    @Autowired
    private UsuarioServiceImpl usuarioService;


    @Autowired
    private PeticionServiceImpl peticionService;



    @GetMapping("/")
    public String indexPeticiones(Model model)
    {


        List<Peticion> peticionesgeneral = peticionService.BuscarTodos();
        List<Peticion> peticiones = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        for(Peticion peti : peticionesgeneral){
            if(peti.getToUser().equals(userDetails.getUsername()) && peti.getEstado().equals("Pendiente") ){
                peticiones.add(peti);
            }
        }


        model.addAttribute("peticiones", peticiones);
        return "peticiones";
    }


    @PostMapping(value = "/aceptar/{id}/")
    public String aceptarPeticion(@PathVariable("id") String id){

        Peticion p = peticionService.Buscar(Long.parseLong(id));
        p.setEstado("Completada");
        Practica practi = p.getPractica();
        Usuario u = usuarioService.findByUsername(p.getToUser());
        practi.getIntegrantes().add(u);
        practicaService.Actualizar(practi);
        peticionService.Actualizar(p);
        return "redirect:/peticiones/";

    }



    @PostMapping(value = "/borrar/{id}/")
    public String borrarPeticion(@PathVariable("id") String id){

        Peticion p = peticionService.Buscar(Long.parseLong(id));


        peticionService.Borrar(p);
        return "redirect:/peticiones";

    }






}
