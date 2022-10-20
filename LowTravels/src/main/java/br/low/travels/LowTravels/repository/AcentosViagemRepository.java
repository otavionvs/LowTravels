package br.low.travels.LowTravels.repository;

import br.low.travels.LowTravels.model.entity.AcentosViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcentosViagemRepository extends JpaRepository<AcentosViagem, Integer> {
}
