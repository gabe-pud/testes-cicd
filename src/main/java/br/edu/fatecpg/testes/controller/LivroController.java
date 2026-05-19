package br.edu.fatecpg.testes.controller;

import br.edu.fatecpg.testes.dto.LivroDTO;
import br.edu.fatecpg.testes.model.Livro;
import br.edu.fatecpg.testes.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody LivroDTO req){
        Livro novoLivro = new Livro();
        novoLivro.setTitulo(req.titulo());
        novoLivro.setAutor(req.autor());

        try {
            Livro livroSalvo = repository.save(novoLivro);
            LivroDTO resp = new LivroDTO(livroSalvo.getTitulo(), livroSalvo.getAutor());

            return ResponseEntity.ok().body(resp);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar livro!");
        }
    }
}
