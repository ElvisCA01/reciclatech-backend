package com.reciclatech.cms.service;

import com.reciclatech.cms.entity.Noticia;
import com.reciclatech.cms.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    // Obtener todas las noticias
    public List<Noticia> getAllNoticias() {
        return noticiaRepository.findAll();
    }

    public Noticia createNoticia(Noticia noticia) {
        if (noticia.getImagen() == null || noticia.getImagen().length == 0) {
            // Opcionalmente, puedes establecer una imagen por defecto
            // noticia.setImagen(getDefaultImage());
        }
        return noticiaRepository.save(noticia);
    }

    // Recuperar una noticia por su ID
    public Noticia getNoticiaById(Long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    public void deleteNoticia(Long id) {
        noticiaRepository.deleteById(id);
    }
}
