package com.consumption.crud.repositories;

import com.consumption.crud.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
}
