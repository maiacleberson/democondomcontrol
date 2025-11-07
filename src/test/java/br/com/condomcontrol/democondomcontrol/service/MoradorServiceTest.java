package br.com.condomcontrol.democondomcontrol.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.condomcontrol.democondomcontrol.model.Morador;
import br.com.condomcontrol.democondomcontrol.repository.MoradorRepository;

@SpringBootTest
public class MoradorServiceTest {

    @Mock
    private MoradorRepository moradorRepository;

    @InjectMocks
    private MoradorService moradorService;

    private Morador morador;

    @BeforeEach
    void setUp() {
        morador = new Morador();
        morador.setId(1L);
        morador.setNome("Test Morador");
        morador.setApartamento("101");
        morador.setBloco("A");
        morador.setEmail("test@test.com");
    }

    @Test
    void testFindAll() {
        when(moradorRepository.findAll()).thenReturn(Arrays.asList(morador));
        
        List<Morador> moradores = moradorService.findAll();
        
        assertNotNull(moradores);
        assertEquals(1, moradores.size());
        assertEquals("Test Morador", moradores.get(0).getNome());
    }

    @Test
    void testFindById() {
        when(moradorRepository.findById(1L)).thenReturn(Optional.of(morador));
        
        Morador found = moradorService.findById(1L);
        
        assertNotNull(found);
        assertEquals("Test Morador", found.getNome());
    }

    @Test
    void testSave() {
        when(moradorRepository.save(any(Morador.class))).thenReturn(morador);
        
        Morador saved = moradorService.save(morador);
        
        assertNotNull(saved);
        assertEquals("Test Morador", saved.getNome());
    }
}