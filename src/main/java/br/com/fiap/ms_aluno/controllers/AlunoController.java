package br.com.fiap.ms_aluno.controllers;

import br.com.fiap.ms_aluno.dto.AlunoDTO;
import br.com.fiap.ms_aluno.model.Aluno;
import br.com.fiap.ms_aluno.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTO> createAluno(@RequestBody AlunoDTO alunoDTO) {
        return new ResponseEntity<>(alunoService.createAluno(alunoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(alunoService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<AlunoDTO> findAll() {
        return alunoService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> updateAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        return new ResponseEntity<>(alunoService.updateAluno(id, alunoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
