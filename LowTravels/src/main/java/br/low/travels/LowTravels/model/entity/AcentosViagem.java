package br.low.travels.LowTravels.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "acentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AcentosViagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column(nullable = false)
    private Boolean ocupado;
    @ManyToOne
    @JoinColumn(name = "codigo_trasporte", nullable = false)
    private Transporte transporte;
    @ManyToOne
    @JoinColumn(name = "codigo_viagem", nullable = false)
    private Viagem viagem;
}
