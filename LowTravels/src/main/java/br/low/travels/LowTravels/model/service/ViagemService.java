package br.low.travels.LowTravels.model.service;

import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.repository.ViagemRepository;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@NoArgsConstructor
@Service
public class ViagemService {
    ViagemRepository viagemRepository;

    public List<Localizacao> findAll() {
        return viagemRepository.findAll();
    }

    public <S extends Localizacao> S save(S entity) {
        return viagemRepository.save(entity);
    }

    public boolean existsById(Integer integer) {
        return viagemRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        viagemRepository.deleteById(integer);
    }

    public <S extends Localizacao> Optional<S> findOne(Example<S> example) {
        return viagemRepository.findOne(example);
    }
}
