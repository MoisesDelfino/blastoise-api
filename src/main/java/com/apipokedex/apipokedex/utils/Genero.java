package com.apipokedex.apipokedex.utils;

public enum Genero {
    M("Masculino"),
    F("Feminino"),
    O("Outro");

    private String descricao;
    //alt+ins
    private Genero(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }
}