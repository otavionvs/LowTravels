package br.low.travels.LowTravels.repository;

import br.low.travels.LowTravels.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
