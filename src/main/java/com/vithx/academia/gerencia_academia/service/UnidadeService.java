package com.vithx.academia.gerencia_academia.service;


import com.vithx.academia.gerencia_academia.model.Unidade;
import com.vithx.academia.gerencia_academia.repository.UnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadeService {
    private final UnidadeRepository unidadeRepository;

    public List<Unidade> listarTodas(){
        return unidadeRepository.findAll();
    }

    public Unidade buscarPorId(Long id){
        return unidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
    }

    public Unidade criar(Unidade unidade){
        unidade.setId(null); //garante que não vem id setado do cliente
        return unidadeRepository.save(unidade);
    }

    public Unidade atualizar(Long id, Unidade unidade) {
        Unidade existente = unidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));

        existente.setNome(unidade.getNome());
        existente.setTelefone(unidade.getTelefone());
        existente.setCidade(unidade.getCidade());
        existente.setEstado(unidade.getEstado());
        existente.setCep(unidade.getCep());

        return unidadeRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!unidadeRepository.existsById(id)) {
            throw new RuntimeException("Unidade não encontrada");
        }
        unidadeRepository.deleteById(id);
    }
}
