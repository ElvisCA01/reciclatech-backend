package com.reciclatech.cms.service;

import com.reciclatech.cms.entity.UneteANosotros;
import com.reciclatech.cms.repository.UneteANosotrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UneteANosotrosService {
    @Autowired
    private UneteANosotrosRepository uneteANosotrosRepository;

    public List<UneteANosotros> getAllUneteANosotros() {
        return uneteANosotrosRepository.findAll();
    }

    public UneteANosotros createUneteANosotros(UneteANosotros uneteANosotros) {
        return uneteANosotrosRepository.save(uneteANosotros);
    }
}
