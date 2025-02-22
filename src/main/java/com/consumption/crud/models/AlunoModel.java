package com.consumption.crud.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull (message = "Erro: O CPF é obrigatório. Não pode ser nulo")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 caracteres.")
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @NotNull (message = "Erro: O Nome é obrigatório. Não pode ser nulo")
    @Column(nullable = false)
    private String nomeAluno;

    @NotNull (message = "Erro: O Sobrenome é obrigatório. Não pode ser nulo")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Column(nullable = false)
    private String sobrenomeAluno;

    @NotNull (message = "Erro: O Email é obrigatório. Não pode ser nulo")
    @Email(message = "Erro: O e-mail deve ser válido")
    @Column(nullable = false)
    private String email;

    @NotNull (message = "Erro: O RG é obrigatório. Não pode ser nulo")
    @Size(min = 8, max = 11, message = "O RG deve ter no min 8 e no maximo 11 caracteres.")
    @Column(nullable = false, unique = true, length = 11)
    private String rg;
}
