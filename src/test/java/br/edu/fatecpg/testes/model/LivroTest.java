package br.edu.fatecpg.testes.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void constructorsAndAccessors() {
        Livro l1 = new Livro();
        l1.setTitulo("A");
        l1.setAutor("B");

        assertEquals("A", l1.getTitulo());
        assertEquals("B", l1.getAutor());

        Livro l2 = new Livro("C");
        assertEquals("C", l2.getTitulo());
    }
}

