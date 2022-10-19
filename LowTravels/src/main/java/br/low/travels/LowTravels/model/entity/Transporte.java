package br.low.travels.LowTravels.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "transporte")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column(length = 20, nullable = false, unique = true)
    private String nome;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TipoTransporte tipoTransporte;
    @Column(length = 3, nullable = false)
    private Integer qtdAcentos;

}
