package com.vithx.academia.gerencia_academia.service;

import com.vithx.academia.gerencia_academia.dto.AlunoRequestDTO;
import com.vithx.academia.gerencia_academia.dto.AlunoResponseDTO;
import com.vithx.academia.gerencia_academia.model.Aluno;
import com.vithx.academia.gerencia_academia.model.Unidade;
import com.vithx.academia.gerencia_academia.repository.AlunoRepository;
import com.vithx.academia.gerencia_academia.repository.UnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final UnidadeRepository unidadeRepository;

    public List<AlunoResponseDTO> listarTodos(){
        return alunoRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public AlunoResponseDTO buscarPorId(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return toResponseDTO(aluno);
    }

    public AlunoResponseDTO criar(AlunoRequestDTO dto){
        //Valida se a unidade existe
        Unidade unidade = unidadeRepository.findById(dto.unidadeId()).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));

        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setCpf(dto.cpf());
        aluno.setTelefone(dto.telefone());
        aluno.setEmail(dto.email());
        aluno.setSenha(dto.senha());
        aluno.setUnidade(unidade);

        alunoRepository.save(aluno);

        return toResponseDTO(aluno); //Não devolve senha
    }

    public AlunoResponseDTO atualizar(Long id, AlunoRequestDTO dto) {
        //Salva no objeto o aluno com o id correspondente
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Unidade unidade = unidadeRepository.findById(dto.unidadeId()).orElseThrow(() -> new RuntimeException("Unidade não encontrada"));

        //Atualiza para os novos dados
        aluno.setNome(dto.nome());
        aluno.setCpf(dto.cpf());
        aluno.setTelefone(dto.telefone());
        aluno.setEmail(dto.email());
        aluno.setSenha(dto.senha());
        aluno.setUnidade(unidade);

        aluno = alunoRepository.save(aluno);
        return toResponseDTO(aluno);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }


    private AlunoResponseDTO toResponseDTO(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getTelefone(),
                aluno.getEmail(),
                aluno.getDataCadastro(),
                aluno.getUnidade().getId(),
                aluno.getUnidade().getNome()
        );
    }
}
