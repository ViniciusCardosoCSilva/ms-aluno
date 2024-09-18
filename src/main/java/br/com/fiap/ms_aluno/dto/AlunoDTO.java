package br.com.fiap.ms_aluno.dto;

import br.com.fiap.ms_aluno.model.Aluno;
import br.com.fiap.ms_aluno.model.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AlunoDTO {

    @NotBlank(message = "O nome deve ser obrigatório")
    private String nome;

    @Email(message = "O email deve ser válido")
    private String email;

    @NotBlank(message = "O RM é obrigatório")
    private String rm;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    private Status status;

    @NotBlank(message = "A turma é obrigatória")
    private String turma;

    public AlunoDTO(String nome, String email, String rm, String password, String status, String turma) {
    }


    public Aluno toEntity() {
        return new Aluno(nome, email, rm, password, status, turma);
    }

    public static AlunoDTO fromEntity(Aluno aluno) {
        return new AlunoDTO(
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getRm(),
                aluno.getPassword(),
                aluno.getStatus(),
                aluno.getTurma()
        );
    }
}

