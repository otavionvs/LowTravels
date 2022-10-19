package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.model.service.LocalizacaoService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LocalizacaoController {
    LocalizacaoService localizacaoService;


    public List<Localizacao> findAll() {
        return localizacaoService.findAll();
    }

    public <S extends Localizacao> S save(S entity) {
        return localizacaoService.save(entity);
    }

    public void deleteById(Integer integer) {
        localizacaoService.deleteById(integer);
    }

    public <S extends Localizacao> boolean exists(Example<S> example) {
        return localizacaoService.exists(example);
    }
}
