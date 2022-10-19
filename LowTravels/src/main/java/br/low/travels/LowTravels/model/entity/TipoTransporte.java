package br.low.travels.LowTravels.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoTransporte {
    ONIBUS("Onibus"),
    TREM("Trem"),
    AVIAO("Avião");
    String nome;
}
