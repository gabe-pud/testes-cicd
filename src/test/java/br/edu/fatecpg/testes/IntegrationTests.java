package br.edu.fatecpg.testes;

import br.edu.fatecpg.testes.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IntegrationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private LivroRepository repo;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    void postCreatesLivro() throws Exception {
        repo.deleteAll();

        String json = "{\"titulo\":\"ITitle\",\"autor\":\"IAuthor\"}";

        mockMvc.perform(post("/livros/cadastrar").contentType("application/json").content(json))
                .andExpect(status().isOk());

        assertEquals(1, repo.count());
    }
}
