package br.com.fiap.ms_aluno.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nome;
    private String password;

    @Column(unique = true)
    private String rm;

    @Enumerated(EnumType.STRING)
    private String status;
    private String turma;

    public Aluno(String nome, String email, String rm, String password, Status status, String turma) {
    }
}
