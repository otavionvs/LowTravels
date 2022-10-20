package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.dto.ClienteDTO;
import br.low.travels.LowTravels.dto.TransporteDTO;
import br.low.travels.LowTravels.model.entity.Cliente;
import br.low.travels.LowTravels.model.entity.Transporte;
import br.low.travels.LowTravels.model.service.TransporteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("lowtravels/transporte")

public class TransporteController {
    private TransporteService transporteService;

    @GetMapping
    public ResponseEntity<List<Transporte>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transporteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional transOptional = transporteService.findById(id);
        if(transOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
              "Veiculo de transporte: " + id + " não encontrado!"
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(transOptional);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TransporteDTO transporteDTO) {
       //Falta verificação se "tipo" vai até 3
        Transporte transporte = new Transporte();
        BeanUtils.copyProperties(transporteDTO, transporte);
        return ResponseEntity.status(HttpStatus.OK)
                .body(transporteService.save(transporte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        Optional<Transporte> transOptional = transporteService.findById(id);
        if(transOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não Encontrado \n ID: " + id);
        }
        transporteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Deletado com Sucesso");
    }
}
