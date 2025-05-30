package com.tecsup.demo.controladores;

import com.tecsup.demo.modelo.documentos.Curso;
import com.tecsup.demo.servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("curso")
public class CursoController {

    @Autowired
    private CursoService servicio;

    @GetMapping({"/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de cursos");
        model.addAttribute("cursos", servicio.listar());
        return "listarView";
    }

    @GetMapping("/buscar/{id}")
    public String buscar(@PathVariable String id, Model model) {
        Curso curso = servicio.buscar(id);
        if (curso == null) {
            return "redirect:/listar";
        }
        model.addAttribute("titulo", "Detalle del curso");
        model.addAttribute("curso", curso);
        return "buscarView";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> modelo) {
        modelo.put("curso", new Curso()); // sin ID para crear nuevo
        modelo.put("titulo", "Crear Curso");
        return "formView";  // nombre de la vista formulario unificado
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable String id, Model model) {
        Curso curso = servicio.buscar(id);
        if (curso == null) {
            return "redirect:/listar";
        }
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Editar Curso");
        return "formView";  // usar la misma vista "form"
    }

    @PostMapping("/form")
    public String guardar(@Valid @ModelAttribute("curso") Curso curso, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", (curso.getId() != null) ? "Editar Curso" : "Crear Curso");
            return "formView";  // misma vista
        }
        servicio.grabar(curso);
        status.setComplete();
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        if (id != null && !id.isEmpty()) {
            servicio.eliminar(id);
        }
        return "redirect:/listar";
    }
}
