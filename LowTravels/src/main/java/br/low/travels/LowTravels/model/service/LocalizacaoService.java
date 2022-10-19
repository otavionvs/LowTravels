package br.low.travels.LowTravels.model.service;

import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.repository.LocalizacaoRepository;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class LocalizacaoService {
    LocalizacaoRepository localizacaoRepository;

    public List<Localizacao> findAll() {
        return localizacaoRepository.findAll();
    }

    public <S extends Localizacao> S save(S entity) {
        return localizacaoRepository.save(entity);
    }

    public void deleteById(Integer integer) {
        localizacaoRepository.deleteById(integer);
    }

    public <S extends Localizacao> boolean exists(Example<S> example) {
        return localizacaoRepository.exists(example);
    }
}
