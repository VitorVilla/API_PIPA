package com.api.pipa.services;

import com.api.pipa.dtos.ProfessorRecordDto;
import com.api.pipa.entities.Professores;
import com.api.pipa.repositories.ProfessoresRepository;
import com.api.pipa.repositories.SalasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessoresRepository professoresRepository;

    @Autowired
    private SalasRepository salasRepository;


    @Transactional
    public Professores updateProfessor(Long id, ProfessorRecordDto professorRecordDto) {
        Professores professores = professoresRepository.findById(id).orElse(null);

        if (professores != null) {

            if (professorRecordDto.nome() != null)
                professores.setNome(professorRecordDto.nome());
            if (professorRecordDto.email() != null)
                professores.setEmail(professorRecordDto.email());
            if (professorRecordDto.senha() != null)
                professores.setSenha(professorRecordDto.senha());
            if (professorRecordDto.sala_id() != null)
                professores.setSala(salasRepository.findById(professorRecordDto.sala_id()).get());
        }
        return professoresRepository.save(professores);
    }

    @Transactional
    public void deleteAluno(Long id) {
        professoresRepository.deleteById(id);
    }

    public List<Professores> getAllProfessores() {
        return professoresRepository.findAll();
    }

    public Professores getProfessor(Long id) {
        return professoresRepository.findById(id).get();
    }

}
