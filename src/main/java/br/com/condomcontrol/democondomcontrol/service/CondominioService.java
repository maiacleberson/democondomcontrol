package br.com.condomcontrol.democondomcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condomcontrol.democondomcontrol.model.Condominio;
import br.com.condomcontrol.democondomcontrol.repository.CondominioRepository;

@Service
public class CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    public List<Condominio> findAll() {
        return condominioRepository.findAll();
    }

    public Condominio findById(Long id) {
        return condominioRepository.findById(id).orElse(null);
    }

    public Condominio save(Condominio condominio) {
        return condominioRepository.save(condominio);
    }

    public void deleteById(Long id) {
        condominioRepository.deleteById(id);
    }
}
