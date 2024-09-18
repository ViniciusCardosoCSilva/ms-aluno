package br.com.fiap.ms_aluno.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends RuntimeException{

    public AlunoNotFoundException(Long id) {
        super("Aluno não encontrado: " + id);
    }
}
