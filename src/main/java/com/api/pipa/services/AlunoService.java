package com.api.pipa.services;

import com.api.pipa.dtos.AlunoRecordDto;
import com.api.pipa.entities.Alunos;
import com.api.pipa.repositories.AlunosRepository;
import com.api.pipa.repositories.ResponsaveisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {

    @Autowired
    private AlunosRepository alunosRepository;

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Transactional
    public Alunos saveAluno(AlunoRecordDto alunoRecordDto) {

        Alunos aluno = new Alunos();

        aluno.setNome(alunoRecordDto.nome());
        aluno.setCpf(alunoRecordDto.cpf());
        aluno.setResponsavel(responsaveisRepository.findById(alunoRecordDto.responsavel_id()).get());

        return alunosRepository.save(aluno);

    }
}
