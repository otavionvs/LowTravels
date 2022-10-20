package br.low.travels.LowTravels.controller;

import br.low.travels.LowTravels.model.entity.Localizacao;
import br.low.travels.LowTravels.model.service.ViagemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Controller
@RequestMapping("lowtravels/viagem")
public class ViagemController {
    ViagemService viagemService;


}
