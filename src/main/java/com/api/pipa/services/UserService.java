package com.api.pipa.services;

import com.api.pipa.dtos.UserRecordDto;
import com.api.pipa.entities.*;
import com.api.pipa.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ResponsaveisRepository responsaveisRepository;
    @Autowired
    private ProfessoresRepository professoresRepository;
    @Autowired
    private AdminsRepository adminsRepository;

    @Transactional
    public Users saveUser(UserRecordDto userRecordDto) throws Exception {

        Users user = new Users();
        user.setSenha(userRecordDto.senha());
        user.setEmail(userRecordDto.email());
        user.setNome(userRecordDto.nome());
        usersRepository.save(user);

        if (userRecordDto.isAdmin()){

            Admins admin = new Admins();
            admin.setEmail(userRecordDto.email());
            admin.setNome(userRecordDto.nome());
            admin.setSenha(userRecordDto.senha());
            admin.setUser(user);

            adminsRepository.save(admin);

            user.setAdmin(true);
        } else if (userRecordDto.isProfessor()){

            Professores professor = new Professores();
            professor.setEmail(userRecordDto.email());
            professor.setNome(userRecordDto.nome());
            professor.setSenha(userRecordDto.senha());
            professor.setUser(user);

            professoresRepository.save(professor);

            user.setProfessor(true);
        } else if (userRecordDto.isResponsavel()) {
            Responsaveis responsavel = new Responsaveis();
            responsavel.setNome(userRecordDto.nome());
            responsavel.setCpf(userRecordDto.cpf());
            responsavel.setEmail(userRecordDto.email());
            responsavel.setSenha(userRecordDto.senha());
            responsavel.setUser(user);

            Enderecos endereco = new Enderecos();
            endereco.setLogradouro(userRecordDto.endereco().getLogradouro());
            endereco.setNumero(userRecordDto.endereco().getNumero());
            endereco.setBairro(userRecordDto.endereco().getBairro());
            endereco.setCidade(userRecordDto.endereco().getCidade());
            endereco.setEstado(userRecordDto.endereco().getEstado());

            responsavel.setEndereco(endereco);
            responsaveisRepository.save(responsavel);

            user.setResponsavel(true);
        } else {

            throw new Exception("Nenhum tipo de usuario marcado");
        }

        return usersRepository.save(user);

    }

    @Transactional
    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

    public List<Users> getAllUser() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }
}
