package tech.funcionario.funcionariogerenciador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.funcionario.funcionariogerenciador.model.Funcionario;
import tech.funcionario.funcionariogerenciador.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {
    private final FuncionarioService funcionarioService;

    public FuncionarioResource(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Funcionario>> getAllFuncionarios () {
        List<Funcionario> funcionarios = funcionarioService.findAllFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById (@PathVariable("id") Long id) {
        Funcionario funcionario = funcionarioService.findFuncionarioById(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.addFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Funcionario> updateFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario updateFuncionario = funcionarioService.updateFuncionario(funcionario);
        return new ResponseEntity<>(updateFuncionario, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable("id") Long id) {
        funcionarioService.deleteFuncionario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
