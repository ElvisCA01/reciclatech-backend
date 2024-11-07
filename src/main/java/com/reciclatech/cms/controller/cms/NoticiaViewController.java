package com.reciclatech.cms.controller.cms;

import com.reciclatech.cms.Utils.ImageUtil;
import com.reciclatech.cms.entity.Noticia;
import com.reciclatech.cms.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/noticias")
public class NoticiaViewController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public String getAllNoticias(Model model) {
        List<Noticia> noticias = noticiaService.getAllNoticias();
        model.addAttribute("noticias", noticias);
        model.addAttribute("imageUtil", new ImageUtil());
        return "noticias";
    }

    // Mostrar el formulario para crear una nueva noticia
    @GetMapping("/nuevo")
    public String createNoticiaForm(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "nueva-noticia";  // Vista "nueva-noticia.html"
    }

    @PostMapping("/nuevo")
    public String saveNoticia(@ModelAttribute Noticia noticia,
                              @RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                noticia.setImagen(file.getBytes());
            }
            noticiaService.createNoticia(noticia);
            return "redirect:/noticias";
        } catch (IOException e) {
            // Manejar el error apropiadamente
            e.printStackTrace();
            return "redirect:/error";
        }
    }

    // Ver una noticia específica (si lo necesitas)
    @GetMapping("/{id}")
    public String getNoticiaById(@PathVariable Long id, Model model) {
        Noticia noticia = noticiaService.getNoticiaById(id);
        model.addAttribute("noticia", noticia);
        return "ver-noticia";  // Vista "ver-noticia.html"
    }


    // NoticiaViewController.java
    @PostMapping("/eliminar/{id}")
    public String deleteNoticia(@PathVariable Long id) {
        noticiaService.deleteNoticia(id);
        return "redirect:/noticias";
    }

}
