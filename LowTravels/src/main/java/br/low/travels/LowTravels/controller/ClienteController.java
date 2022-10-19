package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.dto.ClienteDTO;
import br.low.travels.LowTravels.model.entity.Cliente;
import br.low.travels.LowTravels.model.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/editoralivros/cliente")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ClienteDTO clienteDTO) {
        Optional<Cliente> pessoaOptional =
                clienteService.findById(clienteDTO.getCpf());

        if (pessoaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Este CPF já esta cadastrado!");
        }
        pessoaOptional = clienteService.findByEmail(clienteDTO.getEmail());
        if (pessoaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Este E-mail já esta cadastrado!");
        }
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteService.save(cliente));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> findById(@PathVariable(value = "cpf") Long cpf) {
        Optional<Cliente> pessoaOptional = clienteService.findById(cpf);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhuma pessoa com este CPF");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaOptional.get());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "cpf") Long cpf) {
        Optional<Cliente> pessoaOptional = clienteService.findById(cpf);
        if(pessoaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhuma pessoa com este CPF");
        }
        clienteService.deleteById(cpf);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Pessoa Deletada!");
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> findByEmail(@PathVariable(value = "email") String email) {
        Optional<Cliente> pessoaOptional = clienteService.findByEmail(email);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhuma pessoa com este E-mail");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaOptional.get());
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid ClienteDTO clienteDTO) {
        if (!clienteService.existsById(clienteDTO.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este CPF não está cadastrado.");
        }
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }
}
