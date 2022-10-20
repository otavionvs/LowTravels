package br.low.travels.LowTravels.dto;

import br.low.travels.LowTravels.model.entity.Localizacao;
import lombok.Getter;

import java.util.List;

@Getter
public class ViagemDTO {
    private String nome;
    private List<Localizacao> localizacoes;
    private Integer transporte_id;
    private Integer qtd_acentos;
}
