package pucmm.inventarioequipos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.inventarioequipos.model.Cliente;
import pucmm.inventarioequipos.service.ClienteService;
import pucmm.inventarioequipos.service.ClienteServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

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

    @PostMapping("/clientes")
    public String agregarCliente(Cliente cliente, Model model) {
        model.addAttribute("clientes", cliente);
        return "clientes";
    }
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
