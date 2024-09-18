package br.com.fiap.ms_aluno.services;

import br.com.fiap.ms_aluno.dto.AlunoDTO;
import br.com.fiap.ms_aluno.model.Aluno;
import br.com.fiap.ms_aluno.repositories.AlunoRepository;
import br.com.fiap.ms_aluno.services.exception.AlunoNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDTO createAluno(AlunoDTO alunoDTO) {
        Aluno aluno = alunoDTO.toEntity();
        Aluno savedAluno = alunoRepository.save(aluno);
        return AlunoDTO.fromEntity(savedAluno);
    }

    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(
                () -> new AlunoNotFoundException(id)
        );
        return AlunoDTO.fromEntity(aluno);
    }

    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll().stream().map(AlunoDTO::fromEntity).collect(Collectors.toList());
    }

    public AlunoDTO updateAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(
                () -> new AlunoNotFoundException(id)
        );

        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setPassword(alunoDTO.getPassword());
        aluno.setRm(alunoDTO.getRm());
        aluno.setStatus(String.valueOf(alunoDTO.getStatus()));
        aluno.setTurma(aluno.getTurma());

        Aluno uptadeAluno = alunoRepository.save(aluno);
        return AlunoDTO.fromEntity(uptadeAluno);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

}
