package com.api.pipa.services;

import com.api.pipa.dtos.ControleDiarioRecordDto;
import com.api.pipa.entities.Categorias;
import com.api.pipa.entities.ControlesDiarios;
import com.api.pipa.repositories.ControlesDiariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControleDiarioService {

    private final ControlesDiariosRepository controlesDiariosRepository;

    public ControleDiarioService(ControlesDiariosRepository controlesDiariosRepository) {
        this.controlesDiariosRepository = controlesDiariosRepository;
    }

    @Transactional
    public ControlesDiarios save (ControleDiarioRecordDto controleDiarioRecordDto) {

        ControlesDiarios controlesDiario = new ControlesDiarios();

        controlesDiario.setData(controleDiarioRecordDto.data());
        controlesDiario.setLanche(controleDiarioRecordDto.lanche());
        controlesDiario.setAlmoco(controleDiarioRecordDto.almoco());
        controlesDiario.setLanche_tarde(controleDiarioRecordDto.lancheTarde());
        controlesDiario.setJantar(controleDiarioRecordDto.jantar());
        controlesDiario.setMamadeira(controleDiarioRecordDto.mamadeira());
        controlesDiario.setMamadeira2(controleDiarioRecordDto.mamadeira2());
        controlesDiario.setMamadeira3(controleDiarioRecordDto.mamadeira3());
        controlesDiario.setEvacuacao(controleDiarioRecordDto.evacuacao());
        controlesDiario.setXixi(controleDiarioRecordDto.xixi());
        controlesDiario.setBanho(controleDiarioRecordDto.banho());
        controlesDiario.setHorario(controleDiarioRecordDto.horario());
        controlesDiario.setDose(controleDiarioRecordDto.dose());
        controlesDiario.setFebre(controleDiarioRecordDto.febre());
        controlesDiario.setAluno(controleDiarioRecordDto.aluno());

        return controlesDiariosRepository.save(controlesDiario);
    }

    @Transactional
    public void deleteControleDiario(Long id){
        controlesDiariosRepository.deleteById(id);
    }

    public List<ControlesDiarios> getAllControleDiario() {
        return controlesDiariosRepository.findAll();
    }
}
