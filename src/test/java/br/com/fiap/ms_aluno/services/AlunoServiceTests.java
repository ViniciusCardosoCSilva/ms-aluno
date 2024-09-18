package br.com.fiap.ms_aluno.services;

import br.com.fiap.ms_aluno.dto.AlunoDTO;
import br.com.fiap.ms_aluno.model.Aluno;
import br.com.fiap.ms_aluno.repositories.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AlunoServiceTests {

    @Autowired
    private AlunoService alunoService;

    @MockBean
    private AlunoRepository alunoRepository;

    @Test
    public void testCreateAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.setEmail("joao@example.com");

        Mockito.when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno created = alunoService.createAluno(AlunoDTO.fromEntity(aluno)).toEntity();
        assertEquals(aluno.getNome(), created.getNome());
    }

}
