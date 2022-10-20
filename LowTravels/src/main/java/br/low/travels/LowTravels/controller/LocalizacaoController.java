package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.dto.LocalizacaoDTO;
import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.model.service.LocalizacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class LocalizacaoController {
    LocalizacaoService localizacaoService;

    @GetMapping
    public ResponseEntity<List<Localizacao>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.findAll());
    }

    @GetMapping("/loc/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Integer id) {
        Optional<Localizacao> localizacaoOptional = localizacaoService.findById(id);
        if(localizacaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(localizacaoOptional.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid LocalizacaoDTO localizacaoDTO) {
        Localizacao localizacao = new Localizacao();
        BeanUtils.copyProperties(localizacaoDTO, localizacao);
        return ResponseEntity.status(HttpStatus.OK).body(
                localizacaoService.save(localizacao));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid LocalizacaoDTO localizacaoDTO) {
        Optional<Localizacao> livroOptional = localizacaoService.findById(localizacaoDTO.getId());
        if(livroOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }else{
            Localizacao localizacaoModel = new Localizacao();
            BeanUtils.copyProperties(livroOptional, localizacaoModel);
            return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.save(localizacaoModel000000000000000000));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer integer) {
        localizacaoService.deleteById(integer);
        return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso");
    }

}
