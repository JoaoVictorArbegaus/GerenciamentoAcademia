package com.vithx.academia.gerencia_academia.service;

import com.vithx.academia.gerencia_academia.model.Equipamento;
import com.vithx.academia.gerencia_academia.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listarTodos(){
        return equipamentoRepository.findAll();
    }

    public Equipamento listarPorId(Long id){
        return equipamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }

    public Equipamento criar(Equipamento equipamento){
        equipamento.setId(null);
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizar(Long id, Equipamento equipamento){
        Equipamento existente = equipamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        existente.setNome(equipamento.getNome());
        existente.setCategoria(equipamento.getCategoria());
        existente.setMarca(equipamento.getMarca());
        existente.setUnidade(equipamento.getUnidade());

        return equipamentoRepository.save(existente);
    }

    public void deletar(Long id){
        if (!equipamentoRepository.existsById(id)) {
            throw new RuntimeException("Equipamento não encontrado");
        }
        equipamentoRepository.deleteById(id);
    }
}
