package br.low.travels.LowTravels.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "localizacao")
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Integer id;
    @Column(nullable = false)
    Integer tipo;
    @Column(nullable = false, length = 50)
    Integer nome;

}
