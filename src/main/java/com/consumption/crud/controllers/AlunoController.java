package com.consumption.crud.controllers;

import com.consumption.crud.models.AlunoModel;
import com.consumption.crud.repositories.AlunoRepository;
import com.consumption.crud.services.AlunoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("⁎")
@AllArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;
    private  final AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<AlunoModel>> getAluno(){
        return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlunoModel> postAluno(@RequestBody @Valid AlunoModel alunoModel){
        alunoModel.setId(null);
        return new ResponseEntity<>(alunoService.salvarAluno(alunoModel), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> putAluno(@PathVariable Integer id, @RequestBody @Valid AlunoModel alunoModel) {
        alunoModel.setId(id);
        return ResponseEntity.ok(alunoService.salvarAluno(alunoModel));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAluno(@PathVariable Integer id){
        alunoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
