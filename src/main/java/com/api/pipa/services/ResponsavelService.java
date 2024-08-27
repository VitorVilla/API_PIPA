package com.api.pipa.services;

import com.api.pipa.dtos.ResponsavelRecordDto;
import com.api.pipa.entities.Enderecos;
import com.api.pipa.entities.Responsaveis;
import com.api.pipa.repositories.EnderecoRepository;
import com.api.pipa.repositories.ResponsaveisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Responsaveis saveResposavel(ResponsavelRecordDto responsavelRecordDto) {

        Responsaveis responsavel = new Responsaveis();

        responsavel.setNome(responsavelRecordDto.nome());
        responsavel.setCpf(responsavelRecordDto.cpf());

        Enderecos endereco =  new Enderecos();

        endereco.setLogradouro(responsavelRecordDto.endereco().getLogradouro());
        endereco.setNumero(responsavelRecordDto.endereco().getNumero());
        endereco.setBairro(responsavelRecordDto.endereco().getBairro());
        endereco.setCidade(responsavelRecordDto.endereco().getCidade());
        endereco.setEstado(responsavelRecordDto.endereco().getEstado());

        responsavel.setEndereco(endereco);


        return responsaveisRepository.save(responsavel);

    }

    @Transactional
    public void deleteResponsavel(Long id){
        responsaveisRepository.deleteById(id);
    }

    public List<Responsaveis> getAllResponsavel() {
        return responsaveisRepository.findAll();
    }
}
