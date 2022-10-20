package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.model.entity.Transporte;
import br.low.travels.LowTravels.model.service.TransporteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/transporte")
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

    public Transporte save(Transporte transporte) {
        return transporteService.save(transporte);
    }

    public void deleteById(Integer id) {
        transporteService.deleteById(id);
    }
}
