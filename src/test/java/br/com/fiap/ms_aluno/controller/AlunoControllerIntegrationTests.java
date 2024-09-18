package br.com.fiap.ms_aluno.controller;

import br.com.fiap.ms_aluno.model.Aluno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlunoControllerIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAlunoIntegration() {
        Aluno aluno = new Aluno();
        aluno.setNome("Maria");
        aluno.setEmail("maria@example.com");

        ResponseEntity<Aluno> response = restTemplate.postForEntity("/api/alunos", aluno, Aluno.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
