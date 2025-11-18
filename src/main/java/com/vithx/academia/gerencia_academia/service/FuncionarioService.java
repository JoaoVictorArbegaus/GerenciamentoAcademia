package com.vithx.academia.gerencia_academia.service;

import com.vithx.academia.gerencia_academia.model.Funcionario;
import com.vithx.academia.gerencia_academia.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
    }

    public Funcionario criar (Funcionario funcionario){
        funcionario.setId(null);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario){
        Funcionario existente = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        existente.setNome(funcionario.getNome());
        existente.setCpf(funcionario.getCpf());
        existente.setSalario(funcionario.getSalario());
        existente.setCargo(funcionario.getCargo());
        existente.setUnidade(funcionario.getUnidade());

        return funcionarioRepository.save(existente);
    }

    public void deletar(Long id){
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Unidade não encontrada");
        }
        funcionarioRepository.deleteById(id);
    }
}
