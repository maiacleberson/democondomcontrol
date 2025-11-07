package br.com.condomcontrol.democondomcontrol.service;

import br.com.condomcontrol.democondomcontrol.model.Morador;
import br.com.condomcontrol.democondomcontrol.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public List<Morador> findAll() {
        return moradorRepository.findAll();
    }

    public Morador findById(Long id) {
        return moradorRepository.findById(id).orElse(null);
    }

    public Morador save(Morador morador) {
        return moradorRepository.save(morador);
    }

    public void deleteById(Long id) {
        moradorRepository.deleteById(id);
    }
}
