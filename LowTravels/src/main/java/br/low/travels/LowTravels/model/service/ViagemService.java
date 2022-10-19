package br.low.travels.LowTravels.model.service;

import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.model.entity.Viagem;
import br.low.travels.LowTravels.repository.ViagemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ViagemService {
    private ViagemRepository viagemRepository;

    public List<Viagem> findAll() {
        return viagemRepository.findAll();
    }

    public Viagem save(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public Optional<Viagem> findById(Integer id) {
        return viagemRepository.findById(id);
    }

    public boolean existsById(Integer id) {
        return viagemRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        viagemRepository.deleteById(id);
    }
}
