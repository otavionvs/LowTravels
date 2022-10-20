package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.dto.ViagemDTO;
import br.low.travels.LowTravels.model.entity.AcentosViagem;
import br.low.travels.LowTravels.model.entity.Viagem;
import br.low.travels.LowTravels.model.service.AcentosViagemService;
import br.low.travels.LowTravels.model.service.TransporteService;
import br.low.travels.LowTravels.model.service.ViagemService;
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
@RequestMapping("/viagem")
public class ViagemController {
    private ViagemService viagemService;
    private AcentosViagemService acentosViagemService;
    private TransporteService transporteService;

    @GetMapping
    public ResponseEntity<List<Viagem>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(viagemService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional viagemOptional = viagemService.findById(id);
        if (viagemOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "Viagem: " + id + " não encontrada!"
            );
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(viagemOptional);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ViagemDTO viagemDTO) {
        if (transporteService.existsById(viagemDTO.getTransporte_id())) {
            Viagem viagem = new Viagem();
            BeanUtils.copyProperties(viagemDTO, viagem);
            viagem = viagemService.save(viagem);

            for (int i = 0; i < viagemDTO.getQtd_acentos(); i++) {
                AcentosViagem acentosViagem = new AcentosViagem(false, viagemDTO.getTransporte_id(), viagem.getId());
                acentosViagemService.save(acentosViagem);
            }
            return ResponseEntity.status(HttpStatus.OK).body(viagem);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse transporte não foi encontrado!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if(viagemService.existsById(id)){
            viagemService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Viagem removida");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada!");
    }
}
