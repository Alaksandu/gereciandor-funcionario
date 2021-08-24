package tech.funcionario.funcionariogerenciador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.funcionario.funcionariogerenciador.exception.UserNotFoundException;
import tech.funcionario.funcionariogerenciador.model.Funcionario;
import tech.funcionario.funcionariogerenciador.repo.FuncionaroRepo;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {
    private final FuncionaroRepo funcionaroRepo;

    @Autowired
    public FuncionarioService(FuncionaroRepo funcionaroRepo) {
        this.funcionaroRepo = funcionaroRepo;
    }

    public Funcionario addFuncionario(Funcionario funcionario) {
        funcionario.setCodigoFuncionario(UUID.randomUUID().toString());
        return funcionaroRepo.save(funcionario);
    }

    public List<Funcionario> findAllFuncionarios() {
        return funcionaroRepo.findAll();
    }

    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcionaroRepo.save(funcionario);
    }

    public Funcionario findFuncionarioById(Long id) {
        return funcionaroRepo.findFuncionarioById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario de id " + id + "não encontrado" ));
    }

    public void deleteFuncionario(Long id) {
        funcionaroRepo.deleteFuncionarioById(id);
    }
}
