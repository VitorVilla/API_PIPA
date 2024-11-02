package com.api.pipa.services;

import com.api.pipa.dtos.AlunoRecordDto;
import com.api.pipa.entities.Alunos;
import com.api.pipa.repositories.AlunosRepository;
import com.api.pipa.repositories.ResponsaveisRepository;
import com.api.pipa.repositories.SalasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunosRepository alunosRepository;

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private SalasRepository salasRepository;

    @Transactional
    public Alunos saveAluno(AlunoRecordDto alunoRecordDto) {

        Alunos aluno = new Alunos();

        aluno.setNome(alunoRecordDto.nome());
        aluno.setCpf(alunoRecordDto.cpf());
        aluno.setSala(salasRepository.findById(alunoRecordDto.sala_id()).get());
        aluno.setResponsavel(responsaveisRepository.findById(alunoRecordDto.responsavel_id()).get());

        return alunosRepository.save(aluno);

    }

    @Transactional
    public Alunos updateAluno(Long id, AlunoRecordDto alunoRecordDto) {
        Alunos aluno = alunosRepository.findById(id).get();

        if (aluno != null) {
            aluno.setNome(alunoRecordDto.nome());
            aluno.setCpf(alunoRecordDto.cpf());
            aluno.setResponsavel(responsaveisRepository.findById(alunoRecordDto.responsavel_id()).get());
        }
        return alunosRepository.save(aluno);
    }

    @Transactional
    public void deleteAluno(Long id){
        alunosRepository.deleteById(id);
    }

    public List<Alunos> getAllAlunos() {
        return alunosRepository.findAll();
    }

    public Alunos getAluno(Long id) {
        return alunosRepository.findById(id).get();
    }



}
