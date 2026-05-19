package br.edu.fatecpg.testes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Livros")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String titulo;
    private String autor;
}
