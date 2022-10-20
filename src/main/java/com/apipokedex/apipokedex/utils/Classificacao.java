package com.apipokedex.apipokedex.utils;

public enum Classificacao{
    TP("Treinador pokemon"),
    LG("Líder de ginásio"),
    CPR("Capitão de prova"),
    K("Kahuna"),
    EQ("Elite quatro"),
    CLG("Campeão da liga pokemon"),
    CPK("Coordenador pokemon"),
    CP("Criador pokemon"),
    E("Estilista"),
    P("Performer"),
    EP("Especialista pokemon"),
    SH("Shiny hunter"),
    PA("Patrulheiro"),
    OP("Observador pokemon"),
    C("Caçador");

    private String descricao;
    //alt+ins
    private Classificacao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }
}
