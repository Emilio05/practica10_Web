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
import pucmm.topograpp.service.MailServiceImpl;
import pucmm.topograpp.service.PeticionServiceImpl;
import pucmm.topograpp.service.PracticaServiceImpl;
import pucmm.topograpp.service.UsuarioServiceImpl;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/practicas")
public class PracticaController {



    @Autowired
    private PracticaServiceImpl practicaService;

    @Autowired
    private PeticionServiceImpl peticionService;


    @Autowired
    private UsuarioServiceImpl usuarioService;


    @Autowired
    private MailServiceImpl mailService;

    @GetMapping("/")
    public String indexPracticas(Model model)
    {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        List<BigInteger> practicasint = practicaService.BuscarTodasDeUser(usuarioService.findByUsername(userDetails.getUsername()).getId());
        List<Practica> practicas = new ArrayList<>();



        for(int i=0;i<practicasint.size();i++){
            Practica temp = practicaService.Buscar(Long.parseLong(practicasint.get(i).toString()));
            practicas.add(temp);
        }
        model.addAttribute("practicas", practicas);
        return "practicas";
    }


    @GetMapping("/ver/{id}")
    public String verPractica(Model model, @PathVariable("id") String id)
    {



        Practica practica = practicaService.Buscar(Long.parseLong(id));
        List<Medida> medidas = practica.getLevantamiento().getMedidas();
        List<Medida> angulos = new ArrayList<>();
        List<Medida> distancias = new ArrayList<>();
        for(Medida m : medidas){
            if(m.getNombre().equals("Angulo")){
                angulos.add(m);
            }

            else if(m.getNombre().equals("Distancia")){
                distancias.add(m);
            }


        }
        int maxi = Math.max(distancias.size(),angulos.size());
        model.addAttribute("practica",practica);
        model.addAttribute("angulos",angulos);
        model.addAttribute("distancias",distancias);
        model.addAttribute("maxi",maxi);
        model.addAttribute("practica", practica);
        return "practica";
    }

    @PostMapping("/subirplano/{id}")
    public String subirPlano(@RequestParam("subirplano") MultipartFile foto, @PathVariable("id") String id,
                              RedirectAttributes redirectAttributes) {



        Practica p = new Practica();
        p = practicaService.Buscar(Long.parseLong(id));
        try {

            // Get the file and save it somewhere
            byte[] bytes = foto.getBytes();
            p.setPlano(bytes);


            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + foto.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

            practicaService.Actualizar(p);
        return "redirect:/practicas/ver/"+id;
    }

    @PostMapping("/subirconclusion/{id}")
    public String subirPlano(@RequestParam("conclusiones_text") String conclusion, @PathVariable("id") String id,
                             RedirectAttributes redirectAttributes) {



        Practica p = new Practica();
        p = practicaService.Buscar(Long.parseLong(id));
        p.setConclusion(conclusion);
        practicaService.Actualizar(p);



        return "redirect:/practicas/ver/"+id;
    }


    @RequestMapping(value = "/eliminarPlano/{id}", method = RequestMethod.GET)
    public String eliminarPlano(@PathVariable String id) {
        Practica practica = practicaService.Buscar(Long.parseLong(id));

        practica.setPlano(null);
        practicaService.Actualizar(practica);

        return "redirect:/practicas/ver/"+id;

    }

    @RequestMapping(value = "/eliminarIntegrante/{id}/{username}/", method = RequestMethod.POST)
    public String eliminarIntegrante(@PathVariable String id, @PathVariable String username) {
        Practica practica = practicaService.Buscar(Long.parseLong(id));

        practica.getIntegrantes().remove(usuarioService.findByUsername(username));
        practicaService.Actualizar(practica);

        return "redirect:/practicas/ver/"+id;

    }

    @PostMapping(value = "/invitar/{id}/")
    public String invitarPersona(@RequestParam("invitar") String username, @PathVariable("id") String id){

        Peticion p = new Peticion();
        p.setEstado("Pendiente");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        p.setFromUser(userDetails.getUsername());

        Practica pr = practicaService.Buscar(Long.parseLong(id));
        if(usuarioService.findByEmail(username) != null){
        p.setToUser(usuarioService.findByEmail(username).getUsername());
            mailService.sendSimpleMessage(username, "Tienes una nueva invitacion", "El usuario "+userDetails.getUsername()+" te ha invitado a la practica: "+pr.getName());

        }
        else{
            p.setToUser(username);
            mailService.sendSimpleMessage(usuarioService.findByUsername(username).getEmail(), "Tienes una nueva invitacion", "El usuario "+userDetails.getUsername()+" te ha invitado a la practica: "+pr.getName());

        }
        p.setPractica(pr);
        peticionService.Crear(p);
        return "redirect:/practicas/ver/"+id;

    }


    @RequestMapping(value = "/eliminarConclusion/{id}", method = RequestMethod.GET)
    public String eliminarConclusion(@PathVariable String id) {
        Practica practica = practicaService.Buscar(Long.parseLong(id));

        practica.setPlano(null);
        practicaService.Actualizar(practica);

        return "redirect:/practicas/ver/"+id;

    }
//
//
//    @RequestMapping(value = "/nodevueltos/", method = RequestMethod.GET)
//    public String listadonodevueltos(Model model) {
//
//        List<Object[]> nodevueltos = clienteEquipoService.equiposAlquiladosNoDevueltos();
//        model.addAttribute("objetos",nodevueltos);
//        return "nodevueltos";
//
//    }

//    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
//    public String agregarCliente(@RequestParam int id, @RequestParam String nombre){
//        Estudiante estudiante = new Estudiante(matricula);
//        estudiante.setNombre(nombre);
//        return ""+estudiante.getMatricula();
//    }

}
