package br.low.travels.LowTravels.model.entity;

public enum Status {
    AGUARDANDO_REVISAO("Aguardando revisão"),
    EM_REVISAO("Em revisão"),
    APROVADO("Aprovado");

    private String nome;

    Status(String nome) {
        this.nome = nome;
    }

}
