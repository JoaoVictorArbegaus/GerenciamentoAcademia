package com.vithx.academia.gerencia_academia.controller;

import com.vithx.academia.gerencia_academia.model.Unidade;
import com.vithx.academia.gerencia_academia.service.UnidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/unidades")
@RequiredArgsConstructor
public class UnidadeController {

    private final UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<List<Unidade>> listarTodas(){
        return ResponseEntity.ok(unidadeService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(unidadeService.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<Unidade> criar(@RequestBody Unidade unidade){
        Unidade criada = unidadeService.criar(unidade);
        return ResponseEntity.created(URI.create("/unidades/" + criada.getId())).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> atualizar(@PathVariable Long id, @RequestBody Unidade unidade){
        Unidade atualizada = unidadeService.atualizar(id,unidade);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
