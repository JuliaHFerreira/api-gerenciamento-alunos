package com.consumption.crud.services;

import com.consumption.crud.exceptions.DocumentoInvalidoException;
import com.consumption.crud.exceptions.DadoJaCadastradoException;
import com.consumption.crud.models.AlunoModel;
import com.consumption.crud.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Transactional //verficando se CPF e Rg não está cadastrado
    public AlunoModel salvarAluno(AlunoModel alunoModel){
        if (alunoModel.getCpf().length() != 11) {
            throw new DocumentoInvalidoException("CPF deve ter exatamente 11 dígitos numéricos.");
        }
        if (alunoModel.getRg().length() <8 || alunoModel.getRg().length() >11) {
            throw new DocumentoInvalidoException("O RG precisa ter no min 8 e no maximo 14 caracteres.");
        }
        if(alunoRepository.existsByCpf(alunoModel.getCpf())) {
            throw new DadoJaCadastradoException("CPF já cadastrado!");
        }
        if(alunoRepository.existsByRg(alunoModel.getRg())) {
            throw new DadoJaCadastradoException("RG já cadastrado!");
        }
        return alunoRepository.save(alunoModel);
    }
}
