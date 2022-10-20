package br.low.travels.LowTravels.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viagem")
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @ManyToMany
    @JoinTable(name = "viagem_localizacao", joinColumns =
    @JoinColumn(name = "id_viagem", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_localizacao", nullable = false))
    private List<Localizacao> localizacoes;

}
