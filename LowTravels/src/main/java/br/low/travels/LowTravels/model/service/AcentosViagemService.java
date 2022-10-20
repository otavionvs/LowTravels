package br.low.travels.LowTravels.model.service;


import br.low.travels.LowTravels.model.entity.AcentosViagem;
import br.low.travels.LowTravels.repository.AcentosViagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AcentosViagemService {
    private AcentosViagemRepository acentosViagemRepository;

    public List<AcentosViagem> findAll() {
        return acentosViagemRepository.findAll();
    }

    public AcentosViagem save(AcentosViagem acentosViagem) {
        return acentosViagemRepository.save(acentosViagem);
    }

    public Optional<AcentosViagem> findById(Integer id) {
        return acentosViagemRepository.findById(id);
    }

    public boolean existsById(Integer id) {
        return acentosViagemRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        acentosViagemRepository.deleteById(id);
    }
}
