package com.reciclatech.cms.controller;

import com.reciclatech.cms.entity.UneteANosotros;
import com.reciclatech.cms.service.UneteANosotrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unete-a-nosotros")
@CrossOrigin(origins = "/*")
public class UneteANosotrosController {
    @Autowired
    private UneteANosotrosService uneteANosotrosService;

    @GetMapping
    public List<UneteANosotros> getAllUneteANosotros() {
        return uneteANosotrosService.getAllUneteANosotros();
    }

    @PostMapping
    public UneteANosotros createUneteANosotros(@RequestBody UneteANosotros uneteANosotros) {
        return uneteANosotrosService.createUneteANosotros(uneteANosotros);
    }
}

