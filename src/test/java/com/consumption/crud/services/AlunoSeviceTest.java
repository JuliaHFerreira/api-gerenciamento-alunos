package com.consumption.crud.services;

import com.consumption.crud.repositories.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp() {
        // Simula que o CPF já existe no banco de dados
        when(alunoRepository.existsByCpf("65485232100")).thenReturn(true);
    }
}