package com.vithx.academia.gerencia_academia.controller;


import com.vithx.academia.gerencia_academia.model.Equipamento;
import com.vithx.academia.gerencia_academia.model.Funcionario;
import com.vithx.academia.gerencia_academia.service.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @GetMapping
    public ResponseEntity<List<Equipamento>>listarTodos(){
        return ResponseEntity.ok(equipamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento>listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(equipamentoService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Equipamento>criar(@RequestBody Equipamento equipamento){
        Equipamento criado = equipamentoService.criar(equipamento);
        return ResponseEntity.created(URI.create("/equipamentos/" + criado.getId())).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizar(@PathVariable Long id, @RequestBody Equipamento equipamento){
        Equipamento atualizado = equipamentoService.atualizar(id,equipamento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        equipamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
