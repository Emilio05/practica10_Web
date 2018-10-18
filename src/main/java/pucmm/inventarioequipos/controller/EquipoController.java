package pucmm.inventarioequipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pucmm.inventarioequipos.model.Categoria;
import pucmm.inventarioequipos.model.Equipo;
import pucmm.inventarioequipos.service.CategoriaServiceImpl;
import pucmm.inventarioequipos.service.ClienteEquipoServiceImpl;
import pucmm.inventarioequipos.service.EquipoServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    private static String UPLOADED_FOLDER = "C://Users//EmilioFerreiras//Desktop//";


    @Autowired
    private EquipoServiceImpl equipoService;
    @Autowired
    private CategoriaServiceImpl categoriaService;

    @Autowired
    private ClienteEquipoServiceImpl clienteEquipoService;

    @GetMapping("/")
    public String equipos(Model model)
    {
        List<Equipo> equipos = new ArrayList<>();
        equipos = equipoService.buscarTodosEquipos();
        List<Categoria> categories = categoriaService.buscarTodasCategorias();
        model.addAttribute("categorias", categories);
        model.addAttribute("equipos", equipos);
        return "equipos";
    }

    @PostMapping("/")
    public String crearEquipo(@RequestParam("foto") MultipartFile foto, @RequestParam("nombre") String nombre, @RequestParam("precio") String precio, @RequestParam("existencia") String existencia,
                              @RequestParam("categoria") String categoria,
                              RedirectAttributes redirectAttributes) {



        Equipo equipo = new Equipo();

        try {

            // Get the file and save it somewhere
            byte[] bytes = foto.getBytes();
            equipo.setImagen(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + foto.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        equipo.setNombreEquipo(nombre);
        equipo.setPrecio(Float.parseFloat(precio));
        equipo.setExistencia(Integer.parseInt(existencia));
        System.out.println(categoria);
        Categoria categoria1 = categoriaService.findByNombreCategoria(categoria);
        equipo.setCategoria(categoria1);
        equipoService.crearEquipo(equipo);
        return "redirect:/equipos/";
    }

    @RequestMapping(value = "/ver/{id}", method = RequestMethod.GET)
    public String ver(Model model, @PathVariable String id)
    {
        Equipo equipo = equipoService.buscarPorId(Long.parseLong(id));

        model.addAttribute("equipo", equipo);
        return "verequipo";
    }

    @PostMapping("/modificar/")
    public String modificarEquipo(@RequestParam("nombre2") String nombre, @RequestParam("id2") String id,@RequestParam("precio2") String precio,
                               @RequestParam("existencia2") String existencia, @RequestParam("categoria2") String categoria,
                               @RequestParam("foto2") MultipartFile foto,  RedirectAttributes redirectAttributes){

        Equipo equipo = equipoService.buscarPorId(Long.parseLong(id));
        equipo.setNombreEquipo(nombre);
        equipo.setPrecio(Float.parseFloat(precio));
        equipo.setExistencia(Integer.parseInt(existencia));
        equipo.setCategoria(categoriaService.findByNombreCategoria(categoria));
        try {

            // Get the file and save it somewhere
            byte[] bytes = foto.getBytes();
            equipo.setImagen(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + foto.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + foto.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        equipoService.actualizarEquipo(equipo);
        return "redirect:/equipos/";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String borrarEquipo(@PathVariable String id) {
        Equipo equipo = equipoService.buscarPorId(Long.parseLong(id));
        equipoService.borrarEquipoPorId(equipo);
        return "redirect:/equipos/";

    }


    @RequestMapping(value = "/nodevueltos/", method = RequestMethod.GET)
    public String listadonodevueltos(Model model) {

        List<Object[]> nodevueltos = clienteEquipoService.equiposAlquiladosNoDevueltos();
        model.addAttribute("objetos",nodevueltos);
        return "nodevueltos";

    }

//    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
//    public String agregarCliente(@RequestParam int id, @RequestParam String nombre){
//        Estudiante estudiante = new Estudiante(matricula);
//        estudiante.setNombre(nombre);
//        return ""+estudiante.getMatricula();
//    }

}
