package com.reciclatech.cms.repository;

import com.reciclatech.cms.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
}
