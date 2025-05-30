package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.documentos.Alumno;
import com.tecsup.demo.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService servicio;
    @GetMapping({"/alumnos", "/alumnos/listar"})
    public String listar(@RequestParam(name = "nombre", required = false) String nombre, Model model) {
        model.addAttribute("titulo", "Listado de alumnos");
        if (nombre != null && !nombre.trim().isEmpty()) {
            model.addAttribute("alumnos", servicio.buscarPorNombre(nombre.trim()));
            model.addAttribute("nombre", nombre.trim());
        } else {         model.addAttribute("alumnos", servicio.listar());        }

        return "alumnos/listarView";
    }

    @GetMapping("/alumnos/form")
    public String crear(Map<String, Object> modelo) {
        Alumno alumno = new Alumno();
        alumno.setId(null);
        modelo.put("alumno", alumno);
        modelo.put("titulo", "Crear Alumno");
        return "alumnos/formView";
    }

    @GetMapping("/alumnos/form/{id}")
    public String editar(@PathVariable String id, Model model) {
        Alumno alumno = servicio.buscar(id);
        if (alumno == null) {
            return "redirect:/alumnos/listar";       }
        model.addAttribute("alumno", alumno);
        model.addAttribute("titulo", "Editar Alumno");
        return "alumnos/formView";    }

    @PostMapping("/alumnos/form")
    public String guardar(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", (alumno.getId() != null && !alumno.getId().isEmpty()) ? "Editar Alumno" : "Crear Alumno");
            return "alumnos/formView";
        }
        if (alumno.getId() != null && alumno.getId().trim().isEmpty()) {
            alumno.setId(null);
        }

        servicio.grabar(alumno);  // Guarda o actualiza según id (null => inserta nuevo)
        status.setComplete();      // Limpia el objeto "alumno" de la sesión

        return "redirect:/alumnos/listar";
    }

    // Eliminar alumno por id
    @GetMapping("/alumnos/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        if (id != null && !id.isEmpty()) {
            servicio.eliminar(id);
        }
        return "redirect:/alumnos/listar";
    }
}

