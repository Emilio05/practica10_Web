package pucmm.inventarioequipos.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pucmm.inventarioequipos.model.Cliente;
import pucmm.inventarioequipos.model.Historial;
import pucmm.inventarioequipos.service.ClienteEquipoServiceImpl;
import pucmm.inventarioequipos.service.ClienteService;
import pucmm.inventarioequipos.service.ClienteServiceImpl;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private static String UPLOADED_FOLDER = "C://Users//EmilioFerreiras//Desktop//";


    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;

    @RequestMapping(value = "/")
    public String clientes(Model model)
    {
        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteService.buscarTodosClientes();
        model.addAttribute("clientes",clientes);
        return "clientes";
    }
    @RequestMapping(value = "/historial/{id}", method = RequestMethod.GET)
    public String historial(Model model, @PathVariable String id)
    {
       Cliente cliente = clienteService.buscarPorId(Long.parseLong(id));
       List<Object[]> historial = clienteEquipoService.historialCliente(Long.parseLong(id));
       historial.forEach(objects -> {
           objects[2] = objects[2].toString().split(" ")[0];
           objects[3] = objects[3].toString().split(" ")[0];
       });

        model.addAttribute("cliente", cliente);
        model.addAttribute("historial", historial);
        return "historial";
    }

    @PostMapping(value = "/")
    public String crearCliente(@RequestParam("foto") MultipartFile foto, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("cedula") String cedula,
                               @RequestParam("fechaNacimiento") String fechaNacimiento,
                               RedirectAttributes redirectAttributes) {

        Cliente cliente = new Cliente();

        try {

            // Get the file and save it somewhere
            byte[] bytes = foto.getBytes();
            cliente.setImagen(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + foto.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd");
        LocalDate date = LocalDate.parse(fechaNacimiento);
        System.out.println( nombre + " " + cedula + " " + date);

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        cliente.setFechaNacimiento(date);
        clienteService.crearCliente(cliente);
        return "redirect:/clientes/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String borrarCliente(@PathVariable String id) {
        Cliente cliente = clienteService.buscarPorId(Long.parseLong(id));
        clienteService.borrarClientePorId(cliente);
        return "redirect:/clientes/";

    }

//    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
//    public String agregarCliente(@RequestParam int id, @RequestParam String nombre){
//        Estudiante estudiante = new Estudiante(matricula);
//        estudiante.setNombre(nombre);
//        return ""+estudiante.getMatricula();
//    }

}
