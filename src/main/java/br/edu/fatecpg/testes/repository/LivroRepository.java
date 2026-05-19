package br.edu.fatecpg.testes.repository;

import br.edu.fatecpg.testes.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
