package br.low.travels.LowTravels.model.service;

import br.low.travels.LowTravels.dto.ClienteDTO;
import br.low.travels.LowTravels.model.entity.Cliente;
import br.low.travels.LowTravels.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long cpf) {
        return clienteRepository.findById(cpf);
    }

    public void deleteById(Long cpf) {
        clienteRepository.deleteById(cpf);
    }

    public Optional<Cliente> findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public boolean existsById(Long aLong) {
        return clienteRepository.existsById(aLong);
    }

}
