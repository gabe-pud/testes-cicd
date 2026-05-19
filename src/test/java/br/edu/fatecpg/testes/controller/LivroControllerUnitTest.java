package br.edu.fatecpg.testes.controller;

import br.edu.fatecpg.testes.dto.LivroDTO;
import br.edu.fatecpg.testes.model.Livro;
import br.edu.fatecpg.testes.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LivroControllerUnitTest {
    @Mock
    LivroRepository repository;

    @InjectMocks
    LivroController controller;

    @Test
    void cadastrarSuccess() {
        LivroDTO dto = new LivroDTO("Titulo", "Autor");

        Livro saved = new Livro();
        saved.setTitulo("Titulo");
        saved.setAutor("Autor");

        when(repository.save(any(Livro.class))).thenReturn(saved);

        ResponseEntity<?> resp = controller.cadastrar(dto);

        assertEquals(200, resp.getStatusCode().value());
        assertInstanceOf(LivroDTO.class, resp.getBody());
        LivroDTO body = (LivroDTO) resp.getBody();
        assertEquals("Titulo", body.titulo());
    }

    @Test
    void cadastrarException() {
        LivroDTO dto = new LivroDTO("Titulo", "Autor");
        when(repository.save(any(Livro.class))).thenThrow(new RuntimeException("fail"));

        ResponseEntity<?> resp = controller.cadastrar(dto);
        assertEquals(400, resp.getStatusCode().value());
    }
}
