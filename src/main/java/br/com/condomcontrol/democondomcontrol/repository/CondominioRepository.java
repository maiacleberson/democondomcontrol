package br.com.condomcontrol.democondomcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condomcontrol.democondomcontrol.model.Condominio;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {
    
}
