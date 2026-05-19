package br.edu.fatecpg.testes.repository;

import br.edu.fatecpg.testes.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    private LivroRepository repository;

    @Test
    void saveAndFind() {
        Livro l = new Livro("My Title");
        l.setAutor("Author");

        Livro saved = repository.save(l);

        assertNotNull(saved);
        assertNotEquals(0L, saved.getId());

        var opt = repository.findById(saved.getId());
        assertTrue(opt.isPresent());
        assertEquals("My Title", opt.get().getTitulo());
    }
}
