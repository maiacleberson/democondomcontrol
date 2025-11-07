package br.com.condomcontrol.democondomcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.condomcontrol.democondomcontrol.model.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
}