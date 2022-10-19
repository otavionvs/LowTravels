package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.model.service.ViagemService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
@Controller
public class ViagemController {
    ViagemService viagemService;

    public List<Localizacao> findAll() {
        return viagemService.findAll();
    }

    public <S extends Localizacao> S save(S entity) {
        return viagemService.save(entity);
    }

    public boolean existsById(Integer integer) {
        return viagemService.existsById(integer);
    }

    public void deleteById(Integer integer) {
        viagemService.deleteById(integer);
    }

    public <S extends Localizacao> Optional<S> findOne(Example<S> example) {
        return viagemService.findOne(example);
    }
}
