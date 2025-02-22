package com.consumption.crud.services;

import com.consumption.crud.exceptions.DadoJaCadastradoException;
import com.consumption.crud.exceptions.DocumentoInvalidoException;
import com.consumption.crud.models.AlunoModel;
import com.consumption.crud.repositories.AlunoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlunoSeviceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @Test
    void cpfExisteJogaExcecão() {
        //simulando cpf
        when(alunoRepository.existsByCpf("65485232100")).thenReturn(true);

        // aluno teste
        AlunoModel alunoModel = new AlunoModel();
        alunoModel.setNomeAluno("Maria");
        alunoModel.setSobrenomeAluno("Ferreira");
        alunoModel.setEmail("mariaferreira@outlook.com");
        alunoModel.setRg("224456587");
        alunoModel.setCpf("65485232100");

        // Verifica se a exceção é lançada corretamente
        Assertions.assertThrows(DadoJaCadastradoException.class, () -> {
            alunoService.salvarAluno(alunoModel);
        });

        // Verificando que o save não foi chamado
        verify(alunoRepository, never()).save(any(AlunoModel.class));
    }

    @Test
    void cpfMenorQueOnzeJogaExcecao(){
        AlunoModel alunoModel = new AlunoModel();
        alunoModel.setNomeAluno("Maria");
        alunoModel.setSobrenomeAluno("Ferreira");
        alunoModel.setEmail("mariaferreira@outlook.com");
        alunoModel.setRg("224406575");
        alunoModel.setCpf("6548521200");

        Assertions.assertThrows(DocumentoInvalidoException.class, () -> {
            alunoService.salvarAluno(alunoModel);
        });

        // Verificando que o save não foi chamado
        verify(alunoRepository, never()).save(any(AlunoModel.class));
    }
}