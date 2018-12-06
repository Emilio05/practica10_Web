package pucmm.topograpp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pucmm.topograpp.model.*;
import pucmm.topograpp.service.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

@Controller
public class IndexController {

    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private RolServiceImpl rolService;
    @Autowired
    private PracticaServiceImpl practicaService;

    @Autowired
    private MedidaServiceImpl medidaService;


    @Autowired
    private PuntoServiceImpl puntoService;
    @Autowired
    private LevantamientoServiceImpl levantamientoService;
    @Autowired
    private MessageSource messageSource;



    @RequestMapping(value = "/")
    public String index(Model model)
    {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        if(practicaService.BuscarTodos().size() == 0){
        Practica p = new Practica();
        p.setArea(4f);
        p.setConclusion("Tendran");
        p.setName("Practica#1");
        Levantamiento l = new Levantamiento();
        l.setTipo("Cinta");
        l.setPractica(p);
        p.setFechaCreacion(LocalDate.now());
        p.setOwner("admin");
        p.getIntegrantes().add(usuarioService.findByUsername("admin"));
        practicaService.Crear(p);
        levantamientoService.Crear(l);
            Medida m = new Medida();
            m.setUser("admin");
            m.setValor(5.5f);
            m.setNombre("Distancia");
            m.setLevantamiento(l);
            medidaService.Crear(m);
            Punto p1 = new Punto();
            p1.setX(5);
            p1.setY(5);
            p1.setMedida(m);
            puntoService.Crear(p1);
            Punto p2 = new Punto();
            p2.setX(2);
            p2.setX(5);
            p2.setMedida(m);
            puntoService.Crear(p2);
            Medida m2 = new Medida();
            m2.setUser("admin");
            m2.setValor(10.5f);
            m2.setNombre("Distancia");
            m2.setLevantamiento(l);
            medidaService.Crear(m2);
            Punto p3 = new Punto();
            p3.setX(5);
            p3.setY(2);
            p3.setMedida(m2);
            puntoService.Crear(p3);
            Punto p4 = new Punto();
            p4.setX(2);
            p4.setY(2);
            p4.setMedida(m2);
            puntoService.Crear(p4);
        }

        List<BigInteger> practicasint = practicaService.BuscarTodasDeUser(usuarioService.findByUsername(userDetails.getUsername()).getId());
        List<Practica> practicas = new ArrayList<>();



        for(int i=0;i<practicasint.size();i++){
            Practica temp = practicaService.Buscar(Long.parseLong(practicasint.get(i).toString()));
            practicas.add(temp);
        }
        model.addAttribute("practicas",practicas);

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Model model) {


        if(usuarioService.buscarTodosUsuarios().size() == 0) {
            Set<Rol> roles = new HashSet<>();
            Rol rol = new Rol();
            rol.setNombreRol("ADMIN");
            rolService.crearRol(rol);
            Rol rol2 = new Rol();
            rol2.setNombreRol("ESTUDIANTE");
            rolService.crearRol(rol2);

            Rol rol3 = new Rol();
            rol3.setNombreRol("PROFESOR");
            rolService.crearRol(rol3);

            usuarioService.crearUsuario(new Usuario(1, "admin", "admin","Administrador","admin@gmail.com", rol));
        }
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password
    ) {

        System.out.println("HOLA");
        if(usuarioService.findByUsername(username) != null) {
            usuarioService.autoLogin(username, password);
        }
        else{
            usuarioService.autoLogin(usuarioService.findByEmail(username).getUsername(),password);
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            @RequestParam(value = "username2", required = false) String username,
            @RequestParam(value = "password2", required = false) String password,
            @RequestParam(value = "name2", required = false) String name,
            @RequestParam(value = "email2", required = false) String email
    ) {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setNombre(name);
        u.setPassword(password);
        u.setActive(1);
        u.setUsername(username);
        u.setRol(rolService.findByNombreRol("ESTUDIANTE"));
        usuarioService.crearUsuario(u);
        return "redirect:/";
    }


    @GetMapping("/puntos/{id}")
    @ResponseBody
    public List<Punto> getPuntos(@PathVariable("id") String id) {

        Practica practica = practicaService.Buscar(Long.parseLong(id));
        List<Medida> medidas = practica.getLevantamiento().getMedidas();
        List<Punto>puntos = new ArrayList<>();
        for(Medida m : medidas){
            for(Punto p: m.getPuntos()){
                puntos.add(p);
            }

        }
        System.out.println(puntos);
        return puntos;
    }

    @GetMapping("/practica/{id}")
    @ResponseBody
    public Practica getPractica(@PathVariable("id") String id) {

        Practica practica = practicaService.Buscar(Long.parseLong(id));

        return practica;
    }


    @GetMapping("/frecuencia/{id}")
    @ResponseBody
    public Map<String, Integer> getFrecuencia(@PathVariable("id") String id) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        Practica practica = practicaService.Buscar(Long.parseLong(id));
        List<Medida> list = practica.getLevantamiento().getMedidas();
        for(int i=0; i<list.size(); i++){
            if(map.get(list.get(i).getUser()) != null) {
                map.put(list.get(i).getUser(), map.get(list.get(i).getUser()) + 1);
            }
            else{
                map.put(list.get(i).getUser(),1);
            }
            }
        return map;
    }


    @GetMapping("/nombres/{id}")
    @ResponseBody
    public Object[] getNombres(@PathVariable("id") String id) {
        Set<String> ls = new HashSet<>();

        Practica practica = practicaService.Buscar(Long.parseLong(id));
        List<Medida> list = practica.getLevantamiento().getMedidas();
        for(int i=0; i<list.size(); i++){
            ls.add(list.get(i).getUser());

        }
        return ls.toArray();
    }






//    @ResponseBody
//    @PostMapping(value = "/graficar")
//    public List<Object[]> graficar(@RequestParam("categoria") String categoria, Model model)
//    {
//        Categoria categoria1 = categoriaService.findByNombreCategoria(categoria);
//        List<Object[]> result = clienteEquipoService.promedioAlquilerPorFamilia(categoriaService.findByNombreCategoria(categoria).getId());
//        model.addAttribute("categoria", categoria1);
//        model.addAttribute("result", result);
//        return result;
//
//    }
}
