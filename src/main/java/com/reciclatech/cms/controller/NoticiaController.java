package com.reciclatech.cms.controller;

import com.reciclatech.cms.entity.Noticia;
import com.reciclatech.cms.service.NoticiaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticia")
@CrossOrigin(origins = "/*")
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public List<Noticia> getAllNoticias() {
        return noticiaService.getAllNoticias();
    }


    @GetMapping("/{id}")
    public Noticia getNoticiaById(@PathVariable Long id) {
        return noticiaService.getNoticiaById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNoticia(@PathVariable Long id) {
        noticiaService.deleteNoticia(id);
    }
}

