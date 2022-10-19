package br.low.travels.LowTravels.repository;

import br.low.travels.LowTravels.model.entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {
}
