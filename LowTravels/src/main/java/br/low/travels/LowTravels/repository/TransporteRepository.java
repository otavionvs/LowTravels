package br.low.travels.LowTravels.repository;

import br.low.travels.LowTravels.model.entity.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Integer> {
}
