package br.low.travels.LowTravels.dto;

import br.low.travels.LowTravels.model.entity.Genero;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ClienteDTO {
    //    @NotNull
    private Long cpf;
    //    @NotNull
    private String nome;
    //    @NotNull
    private String sobrenome;
    //    @NotNull
    private String email;
    //    @NotNull
    private String senha;
    //    @NotNull
    private Genero genero;

}
