package com.consumption.crud.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alunos") //criando tabela alunos
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //parar gerar o id automativamente
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "O nome não pode estar em branco")
    private String nomeAluno;

    @Column(nullable = false)
    @NotBlank(message = "O Sobrenome não pode estar em branco")
    private String sobrenomeAluno;

    @Column(nullable = false)
    @Email(message = "O e-mail deve ser válido")
    private String email;

    @Column(nullable = false)
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos")
    private String cpf;

    @Column(nullable = false)
    private String rg;
}
