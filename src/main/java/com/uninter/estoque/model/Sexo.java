package com.uninter.estoque.model;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String descricao;
    Sexo(String descricao){
        this.descricao = descricao;
    }
}
