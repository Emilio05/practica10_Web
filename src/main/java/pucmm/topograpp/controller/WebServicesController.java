package pucmm.topograpp.controller;


import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pucmm.topograpp.model.Levantamiento;
import pucmm.topograpp.model.Medida;
import pucmm.topograpp.model.Practica;
import pucmm.topograpp.model.Textos;
import pucmm.topograpp.service.*;

@RestController
public class WebServicesController {

    @Autowired
    PracticaServiceImpl practicaService;

    @Autowired
    TextosServiceImpl greetingService;


    @Autowired
    MedidaServiceImpl medidaService;


    @Autowired
    LevantamientoServiceImpl levantamientoService;


    @Autowired
    UsuarioServiceImpl usuarioService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/listadoPracticas/{username}")
    @ResponseBody
    public List<Practica> practicas(@PathVariable String username) {
        List<Practica> practicas=  new ArrayList<>();
        for(BigInteger bg : practicaService.BuscarTodasDeUser(usuarioService.findByUsername(username).getId())){
            Practica p = practicaService.Buscar(bg.longValue());
            practicas.add(p);
        }
        return practicas;

    }


    @RequestMapping("/guardarMedida/{id}/{valor}/{nombre}")
    @ResponseBody
    public void guardarMedida(@PathVariable String id, @PathVariable Float valor, @PathVariable String nombre) {
        Practica p = practicaService.Buscar(Long.parseLong(id));
        Levantamiento l = p.getLevantamiento();
        Medida m = new Medida();
        m.setNombre(nombre);
        m.setValor(valor);
        medidaService.Crear(m);
        l.getMedidas().add(m);
        levantamientoService.Actualizar(l);


    }


    @RequestMapping(value = "/guardarProyecto/", method=RequestMethod.POST)
    @ResponseBody
    public void guardarProyecto(@RequestBody Map<String, Object> payload) {

        Levantamiento l = new Levantamiento();
        l.setTipo((String)payload.get("tipolevantamiento"));

        Practica p = new Practica();
        l.setPractica(p);
        p.setName((String)payload.get("nombre"));
        p.setEstado("Pendiente");
        p.setOwner((String)payload.get("username"));
        p.setFechaCreacion(LocalDate.now());
        p.getIntegrantes().add(usuarioService.findByUsername(p.getOwner()));
        practicaService.Crear(p);
        levantamientoService.Crear(l);

    }


    @RequestMapping(value = "/guardarPuntos", method = RequestMethod.POST)
    public void testpost(@RequestBody Map<String, Object> payload){
        System.out.println(payload.get("x"));
        payload.get("y");
        payload.get("idmedida");


    }

    @RequestMapping(value = "/dibujarTexto/{id}", method = RequestMethod.GET)
    public Textos dibujarTexto(@PathVariable String id){

        System.out.println(id);
        if(greetingService.findByUid(id) != null)
        System.out.println(greetingService.findByUid(id).getContent());
        return greetingService.findByUid(id);

    }

    @RequestMapping(value = "/guardarTexto", method = RequestMethod.POST)
    public void guardarTexto(@RequestBody Map<String, String> payload){

        Textos g = new Textos();
        g.setContent(payload.get("value"));
        g.setUid(payload.get("id"));
        greetingService.Crear(g);
    }








}
