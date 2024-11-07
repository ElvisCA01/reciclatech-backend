package com.reciclatech.cms.controller.cms;

import com.reciclatech.cms.entity.UneteANosotros;
import com.reciclatech.cms.service.UneteANosotrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/unete-a-nosotros")
public class UneteANosotrosViewController {

    @Autowired
    private UneteANosotrosService uneteANosotrosService;

    // Mostrar todos los registros de "Únete a Nosotros"
    @GetMapping
    public String getAllUneteANosotros(Model model) {
        model.addAttribute("uneteANosotros", uneteANosotrosService.getAllUneteANosotros());
        return "unete-a-nosotros";  // Vista "unete-a-nosotros.html"
    }

    // Crear un nuevo registro de "Únete a Nosotros"
    @GetMapping("/nuevo")
    public String createUneteANosotrosForm(Model model) {
        model.addAttribute("uneteANosotros", new UneteANosotros());
        return "nuevo-unete-a-nosotros";  // Vista "nuevo-unete-a-nosotros.html"
    }

    // Guardar un nuevo registro de "Únete a Nosotros"
    @PostMapping("/nuevo")
    public String saveUneteANosotros(@ModelAttribute UneteANosotros uneteANosotros) {
        uneteANosotrosService.createUneteANosotros(uneteANosotros);
        return "redirect:/unete-a-nosotros";  // Redirigir a la lista
    }
}
