package com.api.pipa.services;


import com.api.pipa.dtos.SalaRecordDto;
import com.api.pipa.entities.Salas;
import com.api.pipa.repositories.AlunosRepository;
import com.api.pipa.repositories.ProfessoresRepository;
import com.api.pipa.repositories.SalasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {

    @Autowired
    private SalasRepository salasRepository;
    @Autowired
    private AlunosRepository alunosRepository;
    @Autowired
    private ProfessoresRepository professoresRepository;

    @Transactional
    public Salas saveSala(SalaRecordDto salaRecordDto) {

        Salas sala = new Salas();

        sala.setNome(salaRecordDto.nome());
        sala.setAlunos(alunosRepository.findAllById(salaRecordDto.id_aluno()).stream().collect(Collectors.toSet()));
        sala.setProfessores(professoresRepository.findAllById(salaRecordDto.id_professor()).stream().collect(Collectors.toSet()));

        return salasRepository.save(sala);
    }

    @Transactional
    public void deleteSala(Long id){
        salasRepository.deleteById(id);
    }

    public List<Salas> getAllSala() {
        return salasRepository.findAll();
    }

}
