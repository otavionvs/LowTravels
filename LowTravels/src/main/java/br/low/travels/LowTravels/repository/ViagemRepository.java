package br.low.travels.LowTravels.repository;

import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.model.entity.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository  extends JpaRepository<Viagem, Integer> {
}
