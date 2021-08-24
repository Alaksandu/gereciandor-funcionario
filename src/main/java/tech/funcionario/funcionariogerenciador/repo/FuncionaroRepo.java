package tech.funcionario.funcionariogerenciador.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.funcionario.funcionariogerenciador.model.Funcionario;

import java.util.Optional;

public interface FuncionaroRepo extends JpaRepository<Funcionario, Long> {

    void deleteFuncionarioById(Long id);
    Optional<Funcionario> findFuncionarioById(Long id);
}


