package br.low.travels.LowTravels.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cliente {
    @Id
    @Column(length = 11, nullable = false, unique = true)
    private Long cpf;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 75, nullable = false)
    private String sobrenome;

    @Column(length = 125, nullable = false, unique = true)
    private String email;

    @Column(length = 25, nullable = false)
    private String senha;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Genero genero;
}
