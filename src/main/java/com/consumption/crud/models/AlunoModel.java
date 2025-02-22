package com.consumption.crud.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
    private Integer id;

    @Column(nullable = false)
    @NotNull (message = "Erro: O Sobrenome não pode estar em branco")
    private String nomeAluno;

    @Column(nullable = false)
    @NotNull (message = "Erro: O Sobrenome não pode estar em branco")
    private String sobrenomeAluno;

    @Column(nullable = false)
    @Email(message = "Erro: O e-mail deve ser válido")
    @NotNull (message = "Erro: O Sobrenome não pode estar em branco")
    private String email;

    @Column(nullable = false, unique = true)
    @NotNull (message = "Erro: O Sobrenome não pode estar em branco")
    @Size(min = 11, max = 11, message = "Erro: O CPF deve ter exatamente 11 dígitos")
    private String cpf;

    @Column(nullable = false, unique = true)
    @NotNull (message = "Erro: O Sobrenome não pode estar em branco")
    @Size(min = 6, max = 14, message = "Erro: O RG precisa ter no min 6 e no maximo 14 caracteres")
    private String rg;
}
