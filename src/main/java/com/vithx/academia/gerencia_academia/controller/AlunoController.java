package com.vithx.academia.gerencia_academia.controller;

import com.vithx.academia.gerencia_academia.dto.AlunoRequestDTO;
import com.vithx.academia.gerencia_academia.dto.AlunoResponseDTO;
import com.vithx.academia.gerencia_academia.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listar(){
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.buscarPorId(id));

    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> criar(@RequestBody AlunoRequestDTO dto){
        AlunoResponseDTO criado = alunoService.criar(dto);
        return ResponseEntity.created(URI.create("/alunos/" + criado.id())).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizar(@PathVariable Long id, @RequestBody AlunoRequestDTO dto) {
        return ResponseEntity.ok(alunoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
