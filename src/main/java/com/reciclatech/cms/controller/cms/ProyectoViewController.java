package com.reciclatech.cms.controller.cms;

import com.reciclatech.cms.entity.Proyecto;
import com.reciclatech.cms.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/proyectos")
public class ProyectoViewController {

    @Autowired
    private ProyectoService proyectoService;

    // Método para mostrar el formulario de creación de proyecto
    @GetMapping("/nuevo")
    public String createProyectoForm(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "nuevo-proyecto";  // Nombre del formulario HTML
    }

    @PostMapping("/nuevo")
    public String saveProyecto(@ModelAttribute Proyecto proyecto,
                               @RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                proyecto.setImagen(file.getBytes());
            }
            proyectoService.createProyecto(proyecto);
            return "redirect:/proyectos";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    // Método para servir imágenes desde la base de datos
    @GetMapping("/imagen/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.getProyectoById(id);
        if (proyecto != null && proyecto.getImagen() != null) {
            ByteArrayResource resource = new ByteArrayResource(proyecto.getImagen());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .body(resource);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public String listProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.getAllProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos";  // Nombre de la vista HTML para la lista de proyectos
    }

    // ProyectoViewController.java
    @PostMapping("/eliminar/{id}")
    public String deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
        return "redirect:/proyectos";
    }

}
