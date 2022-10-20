package br.low.travels.LowTravels.repository;

import br.low.travels.LowTravels.model.entity.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagemRepository extends JpaRepository<Passagem, Integer> {
}
