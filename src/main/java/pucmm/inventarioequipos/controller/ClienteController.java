package pucmm.inventarioequipos.controller;


import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pucmm.inventarioequipos.model.Cliente;
import pucmm.inventarioequipos.service.ClienteService;
import pucmm.inventarioequipos.service.ClienteServiceImpl;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ClienteController {

    private static String UPLOADED_FOLDER = "C://Users//EmilioFerreiras//Desktop//";


    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/clientes")
    public String clientes(Model model)
    {
        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteService.buscarTodosClientes();
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @PostMapping("clientes")
    public String crearCliente(@RequestParam("foto") MultipartFile foto, @RequestParam("nombre") String nombre, @RequestParam("cedula") String cedula
                               , @RequestParam("fechaNacimiento") Date fechaNacimiento,
                               RedirectAttributes redirectAttributes) {
        Cliente cliente = null;

        if (foto.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:clientes";
        }
        try {

            // Get the file and save it somewhere
            byte[] bytes = foto.getBytes();
          //  cliente.setImagen(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + foto.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(nombre);

        clienteService.crearCliente(nombre, cedula, fechaNacimiento);
        return "redirect:/clientes";    }


    @RequestMapping("/cliente/{id}")
    public Cliente obtenerCliente(@PathVariable int id){
        return clienteService.buscarPorId(id);
    }

    @DeleteMapping("/cliente/{id}")
    public void borrarCliente(@PathVariable long id) {
        clienteService.borrarClientePorId(id);
    }

//    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
//    public String agregarCliente(@RequestParam int id, @RequestParam String nombre){
//        Estudiante estudiante = new Estudiante(matricula);
//        estudiante.setNombre(nombre);
//        return ""+estudiante.getMatricula();
//    }

}
