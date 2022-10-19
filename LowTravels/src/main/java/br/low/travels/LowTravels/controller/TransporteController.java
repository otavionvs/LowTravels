package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.repository.TransporteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class TransporteController {
    private TransporteRepository transporteRepository;
}
