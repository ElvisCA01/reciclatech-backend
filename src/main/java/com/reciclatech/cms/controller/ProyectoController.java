package com.reciclatech.cms.controller;

import com.reciclatech.cms.entity.Proyecto;
import com.reciclatech.cms.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "/*")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> getAllProyectos() {
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/{id}")
    public Proyecto getProyectoById(@PathVariable Long id) {
        return proyectoService.getProyectoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
    }
}
